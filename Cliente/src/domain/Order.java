/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.Date;
import persistence.OrderDAO;

/**
 *
 * @author erome
 */
public class Order {
    private int idorder;
    private String product;
    private Date orderdate;
    private int units;
    private boolean confirmed;
    
    private OrderDAO dao;

    public Order(){
        this.dao = new OrderDAO();
    }

    public Order(String product, int units) {
        this();
        this.product = product;
        this.orderdate = new Date();
        this.units = units;
        this.confirmed = false;
    }
    
    public Order(int idorder, String product, Date orderdate, int units, boolean confirmed) {
        this();
        this.idorder = idorder;
        this.product = product;
        this.orderdate = orderdate;
        this.units = units;
        this.confirmed = confirmed;
    }

    public int getIdorder() {
        return idorder;
    }

    public String getProduct() {
        return product;
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public int getUnits() {
        return units;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public OrderDAO getDao() {
        return dao;
    }
    
    
    
    
}
