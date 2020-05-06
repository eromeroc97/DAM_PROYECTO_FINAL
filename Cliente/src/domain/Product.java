/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import persistence.ProductDAO;

/**
 *
 * @author erome
 */
public class Product {
    private int idproduct;
    private String productname;
    private double price;
    private int stock;
    private int securitystock;
    private int minimumstock;
    private int degaultorderamount;
    private boolean deleted;
    private ProductDAO dao;

    public Product() {
        this.dao = ProductDAO.getInstance();
    }

    public Product(int idproduct, String productname, double price, int stock, int securitystock, int minimumstock, int degaultorderamount, boolean deleted) {
        this();
        this.idproduct = idproduct;
        this.productname = productname;
        this.price = price;
        this.stock = stock;
        this.securitystock = securitystock;
        this.minimumstock = minimumstock;
        this.degaultorderamount = degaultorderamount;
        this.deleted = deleted;
    }

    public Product(String productname, double price, int stock, int securitystock, int minimumstock, int degaultorderamount) {
        this();
        this.productname = productname;
        this.price = price;
        this.stock = stock;
        this.securitystock = securitystock;
        this.minimumstock = minimumstock;
        this.degaultorderamount = degaultorderamount;
    }

    public int getIdproduct() {
        return idproduct;
    }

    public String getProductname() {
        return productname;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public int getSecuritystock() {
        return securitystock;
    }

    public int getMinimumstock() {
        return minimumstock;
    }

    public int getDegaultorderamount() {
        return degaultorderamount;
    }

    public ProductDAO getDao() {
        return dao;
    }
    
}
