/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import domain.RegistredUser;
import domain.UnregistredUser;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author erome
 */
public class UnregistredUserDAO {
    private ConnectionClient conClient;
    
    public UnregistredUserDAO(UnregistredUser unUser){
        try {
            conClient = new ConnectionClient(unUser.getUsername(), unUser.getPassword()); //la contraseña ya esta encriptada
        } catch (IOException ex) {
            Logger.getLogger(UnregistredUserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int getConnectionResult(){
        return this.conClient.getConnectionResult();
    }
    
    public String getConnectionResultMessage(){
        return this.conClient.getConnectionResultMessage();
    }
    
    public RegistredUser getRegistredUser(){
        String[] data = this.conClient.getRegistredUserData().split(";");
        int userid = Integer.parseInt(data[0]);
        String username = data[1];
        boolean connected = data[2].equals("true");
        String rolename = data[3];
        Date lastConnection = null;
        try {
            lastConnection = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(data[4]);
        } catch (ParseException ex) {
            Logger.getLogger(UnregistredUserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return new RegistredUser(userid, username, connected, rolename, lastConnection);
    }
}
