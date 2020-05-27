/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import domain.Product;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author erome
 */
public class ProductDAO {
    private static ProductDAO instance;
    private ApplicationClient appClient;
    
    private ProductDAO(){
        this.appClient = ApplicationClient.getClient();
    }
    
    public static ProductDAO getInstance(){
        if(instance == null)
            instance = new ProductDAO();
        
        return instance;
    }
    
    public LinkedList<Product> getProductsList(){
        LinkedList<Product> products = new LinkedList<>();
        LinkedList<String> prodData = new LinkedList<>();
        try {
            prodData = this.appClient.AskForProductsList();
        } catch (IOException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(int i = 0; i < prodData.size(); i++){
            String[] data = prodData.get(i).split(";");
            Product p = new Product(Integer.parseInt(data[0]),
                    data[1],
                Double.parseDouble(data[2]),
                Integer.parseInt(data[3]),
                Integer.parseInt(data[4]),
                Integer.parseInt(data[5]),
                Integer.parseInt(data[6]),
                data[7].equals("1"));
            products.add(p);
        }
        
        
        return products;
    }

    public void createProduct(Product product) {
        try {
            this.appClient.AskForCreateProduct(product);
        } catch (IOException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editProduct(Product product) {
        try {
            this.appClient.AskForEditProduct(product);
        } catch (IOException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteProduct(int idprod){
        try {
            this.appClient.AskForDeleteProduct(idprod);
        } catch (IOException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void recoverProduct(int idprod){
        try {
            this.appClient.AskForRecoverProduct(idprod);
        } catch (IOException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public double getProductPrice(String productname) {
        try {
            return this.appClient.AskForProductPrice(productname);
        } catch (IOException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0.0;
    }

    public LinkedList<Product> getSecurityStockProductsList() {
        LinkedList<Product> products = new LinkedList<>();
        LinkedList<String> prodData = new LinkedList<>();
        try {
            prodData = this.appClient.AskForSecurityStockProductsList();
        } catch (IOException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(int i = 0; i < prodData.size(); i++){
            String[] data = prodData.get(i).split(";");
            Product p = new Product(Integer.parseInt(data[0]),
                    data[1],
                Double.parseDouble(data[2]),
                Integer.parseInt(data[3]),
                Integer.parseInt(data[4]),
                Integer.parseInt(data[5]),
                Integer.parseInt(data[6]),
                data[7].equals("1"));
            products.add(p);
        }
        
        
        return products;
    }

    public LinkedList<Product> getZeroProductsList() {
        LinkedList<Product> products = new LinkedList<>();
        LinkedList<String> prodData = new LinkedList<>();
        try {
            prodData = this.appClient.AskForZeroProductsList();
        } catch (IOException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(int i = 0; i < prodData.size(); i++){
            String[] data = prodData.get(i).split(";");
            Product p = new Product(Integer.parseInt(data[0]),
                    data[1],
                Double.parseDouble(data[2]),
                Integer.parseInt(data[3]),
                Integer.parseInt(data[4]),
                Integer.parseInt(data[5]),
                Integer.parseInt(data[6]),
                data[7].equals("1"));
            products.add(p);
        }
        
        
        return products;
    }
}
