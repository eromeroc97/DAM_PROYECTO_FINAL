/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import domain.InMail;
import domain.RegistredUser;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author erome
 */
public class InMailDAO {
    private static InMailDAO instance;
    private ApplicationClient appClient;
    private InMailDAO(){
        this.appClient = ApplicationClient.getClient();
    }
    
    public static InMailDAO getInstance(){
        if(instance == null)
            instance = new InMailDAO();
        
        return instance;
    }
    
    public void endConnection(){
        this.appClient = null;
        instance = null;
    }
        
    public void sendEmail(domain.InMail mail){
        try {
            this.appClient.AskForSendInMail(mail);
        } catch (IOException ex) {
            Logger.getLogger(InMailDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public LinkedList<InMail> getReceivedMail(RegistredUser myUser) {
        LinkedList<InMail> mailList = new LinkedList<>();
        LinkedList<String> maildata = new LinkedList<>();
        try {
            maildata = this.appClient.AskForInMail_Received(myUser.getIdUser());
        } catch (IOException ex) {
            Logger.getLogger(InMailDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(int i = 0; i < maildata.size(); i++){
            String[] datos = maildata.get(i).split(";");
            int id = Integer.parseInt(datos[0]);
            String source = datos[1];
            String destination = datos[2];
            String subject = datos[3];
            String content = datos[4];
            Date send_date = null;
            try {
                send_date = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(datos[5]);
            } catch (ParseException ex) {
                Logger.getLogger(InMailDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            boolean readed = false;
            if(Integer.parseInt(datos[6]) == 1)
                readed = true;

            mailList.add(new InMail(id, source, destination, subject, content, send_date, readed));
        }
        return mailList;
    }
    
    public LinkedList<InMail> getSentMail(RegistredUser myUser){
        LinkedList<InMail> mailList = new LinkedList<>();
        LinkedList<String> maildata = new LinkedList<>();
        try {
            maildata = this.appClient.AskForInMail_Sent(myUser.getIdUser());
        } catch (IOException ex) {
            Logger.getLogger(InMailDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(int i = 0; i < maildata.size(); i++){
            String[] datos = maildata.get(i).split(";");
            int id = Integer.parseInt(datos[0]);
            String source = datos[1];
            String destination = datos[2];
            String subject = datos[3];
            String content = datos[4];
            Date send_date = null;
            try {
                send_date = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(datos[5]);
            } catch (ParseException ex) {
                Logger.getLogger(InMailDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            boolean readed = false;
            if(Integer.parseInt(datos[6]) == 1)
                readed = true;

            mailList.add(new InMail(id, source, destination, subject, content, send_date, readed));
        }
        return mailList;
    }

    public void communicateReaded(InMail mail) {
        try {
            this.appClient.AskForCommunicateReadedMail(mail.getIdInMail());
        } catch (IOException ex) {
            Logger.getLogger(InMailDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
