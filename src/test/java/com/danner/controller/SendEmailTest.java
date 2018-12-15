package com.danner.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.mail.MessagingException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SendEmailTest {
    @BeforeEach
    void setUp() {
    }

    @Test
    void sendEmail() {
        final Logger logger = LogManager.getLogger(this.getClass());
        SendEmail sender = new SendEmail();
        String filePath = "/home/student/IdeaProjects/individualproject/src/test/resources/output.wav";
        String testEmail = "jdanner1@madisoncollege.edu";
        boolean result = false;

        try {
            result = sender.sendEmail(filePath, testEmail);
        } catch (MessagingException e) {
            logger.error("Messaging Exception: " + e);
        } catch (IOException e) {
            logger.error("IO Exception: " + e);
        }
        assertEquals(true, result);
    }
}