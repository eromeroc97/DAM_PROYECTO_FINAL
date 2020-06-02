/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import persistence.ProfileDAO;

/**
 *
 * @author erome
 */
public class Profile {
    private int idUser;
    private String name;
    private String surname;
    private String email;
    private String telegramUser;
    
    private ProfileDAO dao;

    public Profile(int idUser, String name, String surname, String email, String telegramUser) {
        this.idUser = idUser;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.telegramUser = telegramUser;
        this.dao = ProfileDAO.getInstance();
    }
    
    public Profile(){
        this.dao = ProfileDAO.getInstance();
        this.name = "";
        this.surname = "";
        this.email = "";
        this.telegramUser = "";
    }
    
    public Profile(String name, String surname, String email, String telegramUser){
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.telegramUser = telegramUser;
        this.dao = ProfileDAO.getInstance();
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelegramUser() {
        return telegramUser;
    }

    public void setTelegramUser(String telegramUser) {
        this.telegramUser = telegramUser;
    }

    public ProfileDAO getDao() {
        return dao;
    }
    
}
