/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.Date;
import persistence.AdvertDAO;

/**
 *
 * @author erome
 */
public class Advert {
    private int idadvert;
    private int iduser;
    private String username;
    private Date date;
    private String message;
    
    private AdvertDAO dao;
    
    public Advert(){
        this.dao = new AdvertDAO();
    }

    public Advert(int idadvert, int iduser, Date date, String message) {
        this();
        this.idadvert = idadvert;
        this.iduser = iduser;
        this.date = date;
        this.message = message;
    }

    public Advert(int iduser, Date date, String message) {
        this();
        this.iduser = iduser;
        this.date = date;
        this.message = message;
    }
    
    public Advert(int idadvert, String username, Date date, String message) {
        this();
        this.idadvert = idadvert;
        this.username = username;
        this.date = date;
        this.message = message;
    }

    public int getIdadvert() {
        return idadvert;
    }

    public int getIduser() {
        return iduser;
    }

    public Date getDate() {
        return date;
    }
    
    public String getUsername(){
        return username;
    }

    public String getMessage() {
        return message;
    }

    public AdvertDAO getDao() {
        return dao;
    }
    
    
    
    
    
    
}
