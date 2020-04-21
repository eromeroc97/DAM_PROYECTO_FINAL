/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.Date;
import persistence.RegistredUserDAO;

/**
 *
 * @author erome
 */
public class RegistredUser {
    private int idUser;
    private String username;
    private boolean online;
    private String role;
    private Date lastConnection;

    private RegistredUserDAO dao;
    
    public RegistredUser(){
        this.dao = RegistredUserDAO.getInstance();
    }
    
    public RegistredUser(String username, int port){
        this.dao = RegistredUserDAO.getInstance(username, port);
    }
    
    public RegistredUser(int idUser, String username, boolean online, String role, Date lastConnection) {
        this.idUser = idUser;
        this.username = username;
        this.online = online;
        this.role = role;
        this.lastConnection = lastConnection;       
    }

    public int getIdUser() {
        return idUser;
    }

    public String getUsername() {
        return username;
    }

    public boolean isOnline() {
        return online;
    }

    public String getRole() {
        return role;
    }

    public Date getLastConnection() {
        return lastConnection;
    }
    
    public RegistredUserDAO getDao() {
        this.dao = RegistredUserDAO.getInstance();
        return dao;
    }
}
