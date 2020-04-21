/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.net.ConnectException;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistence.UnregistredUserDAO;
import utilities.Encrypt;

/**
 *
 * @author erome
 */
public class UnregistredUser {
    private String username;
    private String password;
    
    private UnregistredUserDAO dao;

    public UnregistredUser(String username, String password) {
        this.username = username;
        try {
            this.password = Encrypt.encriptar_DESede(password);
        } catch (Exception ex) {
            Logger.getLogger(UnregistredUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    
    public UnregistredUserDAO getDao(){
        if(this.dao == null)
            this.dao = new UnregistredUserDAO(this);
        return dao;
    }    
}
