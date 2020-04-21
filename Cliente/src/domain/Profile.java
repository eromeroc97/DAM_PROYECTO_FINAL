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
    private long phone;
    
    private ProfileDAO dao;

    public Profile(int idUser, String name, String surname, String email, long phone) {
        this.idUser = idUser;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.dao = ProfileDAO.getInstance();
    }
    
    public Profile(){
        this.dao = ProfileDAO.getInstance();
        this.name = "";
        this.surname = "";
        this.email = "";
        this.phone = 0;
    }
    
    public Profile(String name, String surname, String email, long phone){
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
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

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public ProfileDAO getDao() {
        return dao;
    }
    
}
