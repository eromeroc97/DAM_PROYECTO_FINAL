/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import domain.Order;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author erome
 */
public class OrderDAO {
    ApplicationClient appClient;
    
    public OrderDAO(){
        this.appClient = ApplicationClient.getClient();
    }
    
    public void endConnection(){
        this.appClient = null;
    }
    
    public LinkedList<Order> getOrderList(){
        try {
            LinkedList<String> data = appClient.AskForGetOrderList();
            LinkedList<Order> orders = new LinkedList<>();
            for(int i = 0; i < data.size(); i++){
                String[] ord = data.get(i).split(";");
                Order o = new Order(Integer.parseInt(ord[0]),
                ord[1],
                new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(ord[2]),
                Integer.parseInt(ord[3]),
                Integer.parseInt(ord[4])==1);
                
                orders.add(o);
            }
            return orders;            
        } catch (IOException | ParseException ex) {
            System.out.println(ex.getMessage());
            return new LinkedList<>();
        }
    }
    
    public void createOrder(Order order){
        try {
            appClient.AskForCreateOrder(order);
        } catch (IOException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void cancelOrder(int idorder){
        try {
            appClient.AskForCancelOrder(idorder);
        } catch (IOException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void confirmOrder(int idorder){
        try {
            appClient.AskForConfirmOrder(idorder);
        } catch (IOException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
