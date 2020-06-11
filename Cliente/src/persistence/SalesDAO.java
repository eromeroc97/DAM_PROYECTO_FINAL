/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import domain.Ticket;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilities.IServerProtocol;


/**
 *
 * @author erome
 */
public class SalesDAO {
    private ApplicationClient appClient;
    
    public SalesDAO(){
        this.appClient = ApplicationClient.getClient();
    }
    
    public File insertTicket(Ticket ticket){
        try {
            String filename = this.appClient.AskForCreateSales(ticket);
            return this.appClient.AskForGetReport(filename, IServerProtocol.METHOD_CLIENT);
        } catch (IOException ex) {
            Logger.getLogger(SalesDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public void endConnection(){
        this.appClient = null;
    }
}
