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
    private int defaultorderamount;
    private boolean deleted;
    private ProductDAO dao;

    public Product() {
        this.dao = ProductDAO.getInstance();
    }

    public Product(int idproduct, String productname, double price, int stock, int securitystock, int minimumstock, int defaultorderamount, boolean deleted) {
        this();
        this.idproduct = idproduct;
        this.productname = productname;
        this.price = price;
        this.stock = stock;
        this.securitystock = securitystock;
        this.minimumstock = minimumstock;
        this.defaultorderamount = defaultorderamount;
        this.deleted = deleted;
    }

    public Product(String productname, double price, int stock, int securitystock, int minimumstock, int defaultorderamount) {
        this();
        this.productname = productname;
        this.price = price;
        this.stock = stock;
        this.securitystock = securitystock;
        this.minimumstock = minimumstock;
        this.defaultorderamount = defaultorderamount;
    }

    public Product(int idproduct, String productname, double price, int stock, int securitystock, int minimumstock, int defaultorderamount) {
        this();
        this.idproduct = idproduct;
        this.productname = productname;
        this.price = price;
        this.stock = stock;
        this.securitystock = securitystock;
        this.minimumstock = minimumstock;
        this.defaultorderamount = defaultorderamount;
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

    public int getDefaultorderamount() {
        return defaultorderamount;
    }
    
    public boolean isDeleted(){
        return deleted;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setSecuritystock(int securitystock) {
        this.securitystock = securitystock;
    }

    public void setMinimumstock(int minimumstock) {
        this.minimumstock = minimumstock;
    }

    public void setDefaultorderamount(int defaultorderamount) {
        this.defaultorderamount = defaultorderamount;
    }

    public ProductDAO getDao() {
        return dao;
    }
    
}
