/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import domain.Ticket;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author erome
 */
public class SalesDAO {
    private ApplicationClient appClient;
    
    public SalesDAO(){
        this.appClient = ApplicationClient.getClient();
    }
    
    public void insertTicket(Ticket ticket){
        try {
            this.appClient.AskForCreateSales(ticket);
        } catch (IOException ex) {
            Logger.getLogger(SalesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
