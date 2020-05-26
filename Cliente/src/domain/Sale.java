/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import persistence.SalesDAO;
import java.util.Date;

/**
 *
 * @author erome
 */
public class Sale {
    private int idsale;
    private int idproduct;
    private int iduser;
    private double saleprice;
    private int units;
    private Date saledate;
    
    private SalesDAO dao;
    
    public Sale(){
        this.dao = new SalesDAO();
    }
    
    
    
}
