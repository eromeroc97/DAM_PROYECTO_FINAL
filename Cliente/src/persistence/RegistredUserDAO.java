/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import domain.RegistredUser;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilities.Encrypt;
import utilities.Utilidades;

/**
 *
 * @author erome
 */
public class RegistredUserDAO {
    private static RegistredUserDAO instance;
    private ApplicationClient appClient;
    
    private RegistredUserDAO(){
        this.appClient = ApplicationClient.getClient();
    }
    
    private RegistredUserDAO(String username, int port){
        this.appClient = ApplicationClient.getClient(username, port);
    }
    
    public static RegistredUserDAO getInstance(){
        if(instance == null)
            instance = new RegistredUserDAO();
        
        return instance;
    }
    
    public static RegistredUserDAO getInstance(String username, int port){
        if(instance == null)
            instance = new RegistredUserDAO(username, port);
        
        return instance;
    }
    
    public void endConnection(){
        this.appClient = null;
        instance = null;
    }
    
    public LinkedList<domain.RegistredUser> getUsersList(){
        LinkedList<domain.RegistredUser> list = new LinkedList<>();
        
        LinkedList<String> dataList = new LinkedList<>();
        try {
            dataList = this.appClient.AskForUsersList();
        } catch (IOException ex) {
            Logger.getLogger(RegistredUserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(int i = 0; i < dataList.size(); i++){
            String[] data = dataList.get(i).split(";");
            int id = Integer.parseInt(data[0]);
            String username = data[1];
            boolean online = Integer.parseInt(data[2]) == 1;
            String role = data[3];
            Date lastConnection = null;
            try {
                lastConnection = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(data[4]);
            } catch (ParseException ex) {
                Logger.getLogger(RegistredUserDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            domain.RegistredUser ru = new domain.RegistredUser(id, username, online, role, lastConnection);
            list.add(ru);
        }
        
        return list;
    }
    
    public RegistredUser getUserInfo(String username){
        return null;
    }
    
    public void LogOut(){
        try {
            this.appClient.AskForLogout();
            endConnection();
        } catch (IOException ex) {
            Logger.getLogger(RegistredUserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean createNewUser(String username, String email){
        try {
            String password = Utilidades.generateRandomKey(5);
            boolean result = this.appClient.AskForCreateUser(username, Encrypt.encriptar_DESede(password), email);
            return result;
        } catch (Exception ex) {
            Logger.getLogger(RegistredUserDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public void deleteUser(int idUser){
        try {
            this.appClient.AskForDeleteUser(idUser);
        } catch (IOException ex) {
            Logger.getLogger(RegistredUserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void changePassword(int idUser, String pass) {
        try {
            this.appClient.AskForChangePassword(idUser, pass);
        } catch (IOException ex) {
            Logger.getLogger(RegistredUserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setRole(int userid, int roleid) {
        try {
            this.appClient.AskForSetRole(userid, roleid);
        } catch (IOException ex) {
            Logger.getLogger(RegistredUserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
