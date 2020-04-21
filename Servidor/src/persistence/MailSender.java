/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author erome
 */
public class MailSender {
    private final String email = "businesscontrolsystemerp@gmail.com";
    private final String password = "5934277741acDC";
    private Properties props;
    
    public MailSender(){
        props = new Properties();
        props.put("mail.smtp.host", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
    }
    
    public void sendMail(String user, String pass, String emailAddress){
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email, password);
            }
        });
        try {
            // Define message
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(email));
            message.setSubject("Bussines Control System: Connection Data");
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(emailAddress));
            message.setText(String.format("USERNAME: %s\nPASSWORD: %s",user, pass));
            // Envia el mensaje
            Transport.send(message);
      } catch (MessagingException ex) {
            System.out.println("Unable to send message: "+ex.getMessage());
      }
    }
}
