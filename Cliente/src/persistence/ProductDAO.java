/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import domain.Product;
import java.util.LinkedList;

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
        LinkedList<String> prodData = this.appClient.AskForProductsList();
        
        return products;
    }
}
