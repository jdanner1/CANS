package com.danner.controller;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import com.amazonaws.services.simpleemail.model.RawMessage;
import com.amazonaws.services.simpleemail.model.SendRawEmailRequest;
import com.amazonaws.services.simpleemail.model.SendRawEmailResult;
import com.danner.utility.PropertiesLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSender  implements PropertiesLoader {
    private final Logger logger = LogManager.getLogger(this.getClass());
    private String FILE_PATH = "/properties.properties";


    // https://docs.aws.amazon.com/ses/latest/DeveloperGuide/send-email-raw.html
    // Attachment info

    // Replace sender@example.com with your "From" address.
    // This address must be verified.
    static final String FROM = "jdanner1@madisoncollege.edu";
    static final String FROMNAME = "John Danner";

    // Replace recipient@example.com with a "To" address. If your account
    // is still in the sandbox, this address must be verified.
    static final String TO = "john.danner@tds.net";

    // Replace smtp_username with your Amazon SES SMTP user name.
    private String SMTP_USERNAME;

    // Replace smtp_password with your Amazon SES SMTP password.
    private String SMTP_PASSWORD;

    // The name of the Configuration Set to use for this message.
    // If you comment out or remove this variable, you will also need to
    // comment out or remove the header below.
    static final String CONFIGSET = "ConfigSet";

    // Amazon SES SMTP host name. This example uses the US West (Oregon) region.
    // See https://docs.aws.amazon.com/ses/latest/DeveloperGuide/regions.html#region-endpoints
    // for more information.
    static final String HOST = "us-east-1";  //original value: email-smtp.us-east-1.amazonaws.com

    // The port you will connect to on the Amazon SES SMTP endpoint.
    static final int PORT = 587;

    static final String SUBJECT = "Amazon SES test (SMTP interface accessed using Java)";

    static final String BODY = String.join(
            System.getProperty("line.separator"),
            "<h1>Amazon SES SMTP Email Test</h1>",
            "<p>This email was sent with Amazon SES using the ",
            "<a href='https://github.com/javaee/javamail'>Javamail Package</a>",
            " for <a href='https://www.java.com'>Java</a>."
    );

    public void generateEmail(String path) throws Exception {

        Properties properties = loadProperties(FILE_PATH);
        SMTP_USERNAME = properties.getProperty("SMTP_USERNAME");
        SMTP_PASSWORD = properties.getProperty("SMTP_PASSWORD");

        // Create a Properties object to contain connection configuration information.
        Properties props = System.getProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.port", PORT);
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");

        // Create a Session object to represent a mail session with the specified properties.
        Session session = Session.getDefaultInstance(props);

        // Create a message with the specified information.
        MimeMessage msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(FROM,FROMNAME));
        msg.setRecipient(Message.RecipientType.TO, new InternetAddress(TO));
        msg.setSubject(SUBJECT);
        msg.setContent(BODY,"text/html");

        // Add a configuration set header. Comment or delete the
        // next line if you are not using a configuration set
        msg.setHeader("X-SES-CONFIGURATION-SET", CONFIGSET);

        // Create a transport.
        Transport transport = session.getTransport();

        // Send the message.
        try
        {
            logger.info("Sending...");

            // Connect to Amazon SES using the SMTP username and password you specified above.
            transport.connect(HOST, SMTP_USERNAME, SMTP_PASSWORD);

            // Send the email.
            transport.sendMessage(msg, msg.getAllRecipients());
            logger.info("Email sent!");
        }
        catch (Exception ex) {
            logger.info("The email was not sent." + ex.getMessage());
        }
        finally
        {
            // Close and terminate the connection.
            transport.close();
        }
    }



    public void createEmail(String filePath) {
        Properties properties = null;
        try {
            properties = loadProperties(FILE_PATH);
        } catch (Exception e) {
            logger.error("Exception: " + e);
        }
        AmazonSimpleEmailService client = AmazonSimpleEmailServiceClientBuilder.standard()
                .withRegion(HOST)
                .withCredentials(new AWSStaticCredentialsProvider((new BasicAWSCredentials(properties.getProperty("key_id"), properties.getProperty("key")))))
                .build();                                              //  "From: jdanner1@madisoncollege.edu\\nTo: john.danner@tds.net\\nSubject: Test email (contains an attachment)\\nMIME-Version: 1.0\\nContent-type: Multipart/Mixed; boundary=\"NextPart\"\\n\\n--NextPart\\nContent-Type: text/plain\\n\\nThis is the message body.\\n\\n--NextPart\\nContent-Type: text/plain;\\nContent-Disposition: attachment; filename=\"filePath\"\\n\\nThis is the text in the attachment.\\n\\n--NextPart--"
        SendRawEmailRequest request = new SendRawEmailRequest()
                //.withSource("")
                .withDestinations(new ArrayList())
                .withRawMessage(
                        new RawMessage().withData(ByteBuffer
                                .wrap("RnJvbTogamRhbm5lcjFAbWFkaXNvbmNvbGxlZ2UuZWR1XFxuVG86IGpvaG4uZGFubmVyQHRkcy5uZXRcXG5TdWJqZWN0OiBUZXN0IGVtYWlsIChjb250YWlucyBhbiBhdHRhY2htZW50KVxcbk1JTUUtVmVyc2lvbjogMS4wXFxuQ29udGVudC10eXBlOiBNdWx0aXBhcnQvTWl4ZWQ7IGJvdW5kYXJ5PVwiTmV4dFBhcnRcIlxcblxcbi0tTmV4dFBhcnRcXG5Db250ZW50LVR5cGU6IHRleHQvcGxhaW5cXG5cXG5UaGlzIGlzIHRoZSBtZXNzYWdlIGJvZHkuXFxuXFxuLS1OZXh0UGFydFxcbkNvbnRlbnQtVHlwZTogdGV4dC9wbGFpbjtcXG5Db250ZW50LURpc3Bvc2l0aW9uOiBhdHRhY2htZW50OyBmaWxlbmFtZT1cImZpbGVQYXRoXCJcXG5cXG5UaGlzIGlzIHRoZSB0ZXh0IGluIHRoZSBhdHRhY2htZW50Llxcblxcbi0tTmV4dFBhcnQtLQ=="
                                        .getBytes()))); //removed from the end of this line: .withFromArn("").withSourceArn("").withReturnPathArn("")
        SendRawEmailResult response = client.sendRawEmail(request);  //  check here https://stackoverflow.com/questions/29524413/amazon-ses-custom-header-list-unsubscribe-isnt-working
    }
}