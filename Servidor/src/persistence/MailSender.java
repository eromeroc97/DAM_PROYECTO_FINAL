/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

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
    
    public void sendFileMail(String filetype, String emailAddress, String filename){
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email, password);
            }
        });
        try {
            // Define message
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(email));
            message.setSubject("Bussines Control System: Report Received");
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(emailAddress));
            
            //Creamos el cuerpo del mensaje
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText(String.format("REPORT: %s",filetype));
            
            Multipart multipart = new MimeMultipart();
            
            multipart.addBodyPart(messageBodyPart);
            
            //Adjuntamos el fichero
            messageBodyPart = new MimeBodyPart();
            DataSource source = new FileDataSource(filename);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(filename.substring(filename.lastIndexOf('\\'))); //Solo el nombre del archivo
            
            multipart.addBodyPart(messageBodyPart);

            // Send the complete message parts
            message.setContent(multipart);
            
            // Envia el mensaje
            Transport.send(message);
        } catch (MessagingException ex) {
              System.out.println("Unable to send message: "+ex.getMessage());
        }
    }
    
    
}
