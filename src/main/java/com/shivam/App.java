
 package com.shivam;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class App {
    public static void main(String[] args) {
        System.out.println("Preparing to send message...");
        String message = "Hello, Dear, this is a message for security check.";
        String subject = "CodesArea : Confirmation";
        String to = "shivamjha22948@gmail.com";
        String from = "shivamjha57649@gmail.com";

        sendEmail(message, subject, to, from);
    }

    private static void sendEmail(String message, String subject, String to, String from) {
        // SMTP server info
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();
        System.out.println("PROPERTIES " + properties);

        // Set up the SMTP properties for STARTTLS (port 587)
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Create the session with authentication
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                // Replace with your app password from Gmail
                return new PasswordAuthentication("jibrankumari@gmail.com", "zdef ylmo yeps bqca");
            }
        });

        session.setDebug(true);

        // Compose the message
        MimeMessage m = new MimeMessage(session);

        try {
            // Set from
            m.setFrom(from);

            // Add recipient
            m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set subject
            m.setSubject(subject);

            // Set message
            m.setText(message);

            // Send the message
            Transport.send(m);

            System.out.println("Sent successfully...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}   