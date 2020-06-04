/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.File;
import java.util.Date;
import java.util.LinkedList;
import persistence.SalesDAO;

/**
 *
 * @author erome
 */
public class Ticket {
    private LinkedList<String> pNames;
    private LinkedList<Integer> pUnits;
    private LinkedList<Double> pUnitPrices;
    private int idUser;
    private Date saledate;
    
    private SalesDAO dao;
    
    
    public Ticket(){
        this.dao = new SalesDAO();
        this.pNames = new LinkedList<>();
        this.pUnits = new LinkedList<>();
        this.pUnitPrices = new LinkedList<>();
    }
    
    public Ticket(int idUser){
        this();
        this.idUser = idUser;
    }
    
    public void add(String pName, int pUnit, double pUnitPrice){
        pNames.add(pName);
        pUnits.add(pUnit);
        pUnitPrices.add(pUnitPrice);
    }
    
    public int size(){
        return this.pNames.size();
    }
    
    public String getFormattedString(int pos){
        return pNames.get(pos)+";"+pUnits.get(pos)+";"+pUnitPrices.get(pos);
    }
        
    public File confirmTicket(){
        saledate = new Date();
        return this.dao.insertTicket(this);
    }

    public int getIdUser() {
        return idUser;
    }

    public Date getSaledate() {
        return saledate;
    }
    
    
}
