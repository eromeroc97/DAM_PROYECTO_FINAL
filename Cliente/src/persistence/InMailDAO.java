/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.io.IOException;
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
    
    public LinkedList<domain.InMail> getReceivedMail(){
        try {
            return this.appClient.AskForInMail_Received();
        } catch (IOException ex) {
            Logger.getLogger(InMailDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            return null;
        }
    }
    
    public LinkedList<domain.InMail> getSentMail(){
        return null;
    }
    
    public void sendEmail(domain.InMail mail){
        
    }
    
    public void endConnection(){
        this.appClient = null;
        instance = null;
    }
    
}
