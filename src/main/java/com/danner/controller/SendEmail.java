package com.danner.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Properties;

// JavaMail libraries. Download the JavaMail API
// from https://javaee.github.io/javamail/
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

// AWS SDK libraries. Download the AWS SDK for Java
// from https://aws.amazon.com/sdk-for-java
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import com.amazonaws.services.simpleemail.model.RawMessage;
import com.amazonaws.services.simpleemail.model.SendRawEmailRequest;
import com.danner.utility.PropertiesLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The type Send email.
 * @author jdanner/AWS
 */
public class SendEmail implements PropertiesLoader {

    /**
     * Generates email using AWS SES, configured to meet the needs and credentials in place here.
     *
     * @param filePath the file path
     * @param email    the email
     * @return boolean
     * @throws MessagingException the messaging exception
     * @throws IOException        the io exception
     */
    public Boolean sendEmail(String filePath, String email) throws MessagingException, IOException {
        final Logger logger = LogManager.getLogger(this.getClass());
        final String host = "us-east-1";
        String propertyPath = "/properties.properties";
        String sender = "Advanced Text Vocalizer <jdanner1@madisoncollege.edu>";
        String recipient;
        String subject = "Vocalization File";
        String attachment;
        String bodyText = "Hello,\r\n"
                + "Please see the attached vocalization.";
        String bodyHtml = "<html>"
                + "<head></head>"
                + "<body>"
                + "<h1>Hello!</h1>"
                + "<p>Please see the attached vocalization.</p>"
                + "</body>"
                + "</html>";

        Boolean result;
        Session session = Session.getDefaultInstance(new Properties());
        recipient = email;
        attachment = filePath;
        Properties properties = null;
        try {
            properties = loadProperties(propertyPath);
        } catch (Exception e) {
            logger.error("Exception: " + e);
        }

        // Create a new MimeMessage object.
        MimeMessage message = new MimeMessage(session);

        // Add subject, from and to lines.
        message.setSubject(subject, "UTF-8");
        message.setFrom(new InternetAddress(sender));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));

        // Create a multipart/alternative child container.
        MimeMultipart msgBody = new MimeMultipart("alternative");

        // Create a wrapper for the HTML and text parts.
        MimeBodyPart wrap = new MimeBodyPart();

        // Define the text part.
        MimeBodyPart textPart = new MimeBodyPart();
        textPart.setContent(bodyText, "text/plain; charset=UTF-8");

        // Define the HTML part.
        MimeBodyPart htmlPart = new MimeBodyPart();
        htmlPart.setContent(bodyHtml,"text/html; charset=UTF-8");

        // Add the text and HTML parts to the child container.
        msgBody.addBodyPart(textPart);
        msgBody.addBodyPart(htmlPart);

        // Add the child container to the wrapper object.
        wrap.setContent(msgBody);

        // Create a multipart/mixed parent container.
        MimeMultipart msg = new MimeMultipart("mixed");

        // Add the parent container to the message.
        message.setContent(msg);

        // Add the multipart/alternative part to the message.
        msg.addBodyPart(wrap);

        // Define the attachment
        MimeBodyPart att = new MimeBodyPart();
        DataSource fds = new FileDataSource(attachment);
        att.setDataHandler(new DataHandler(fds));
        att.setFileName(fds.getName());

        // Add the attachment to the message.
        msg.addBodyPart(att);

        // Try to send the email.
        try {
            logger.info("Attempting to send an email through Amazon SES "
                    +"using the AWS SDK for Java...");

            AmazonSimpleEmailService client = AmazonSimpleEmailServiceClientBuilder.standard()
                    .withRegion(host)
                    .withCredentials(new AWSStaticCredentialsProvider((new BasicAWSCredentials(properties.getProperty("key_id"), properties.getProperty("key")))))
                    .build();

            // Send the email.
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            message.writeTo(outputStream);
            RawMessage rawMessage =
                    new RawMessage(ByteBuffer.wrap(outputStream.toByteArray()));

            SendRawEmailRequest rawEmailRequest =
                    new SendRawEmailRequest(rawMessage);

            client.sendRawEmail(rawEmailRequest);
            logger.info("Email sent!");
            result = true;
            // Display an error if something goes wrong.
        } catch (Exception ex) {
            logger.error("Email Failed: " + ex);
            result = false;
        }
        return result;
    }
}






