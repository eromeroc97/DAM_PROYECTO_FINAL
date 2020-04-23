/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.Date;
import persistence.InMailDAO;

/**
 *
 * @author erome
 */
public class InMail {
    private int idInMail;
    private String source;
    private String destination;
    private String subject;
    private String content;
    private Date send_date;
    private boolean readed;
    
    private InMailDAO dao;
    
    public InMail(){
        this.dao = InMailDAO.getInstance();
    }
    
    public InMail(int idInMail, String source, String destination, String subject, String content, Date send_date, boolean readed) {
        this();
        this.idInMail = idInMail;
        this.source = source;
        this.destination = destination;
        this.subject = subject;
        this.content = content;
        this.send_date = send_date;
        this.readed = readed;
    }
    
    public InMail(String source, String destination, String subject, String content) {
        this();
        this.source = source;
        this.destination = destination;
        this.subject = subject;
        this.content = content;
        this.readed = false;
    }

    public int getIdInMail() {
        return idInMail;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public String getSubject() {
        return subject;
    }

    public String getContent() {
        return content;
    }

    public Date getSend_date() {
        return send_date;
    }

    public boolean isReaded() {
        return readed;
    }

    public InMailDAO getDao() {
        return dao;
    }
    
    
}
