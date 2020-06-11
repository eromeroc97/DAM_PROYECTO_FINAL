/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import domain.Permission;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author erome
 */
public class PermissionDAO {
    private static PermissionDAO instance;
    private ApplicationClient appClient;
    
    private PermissionDAO(){
        this.appClient = ApplicationClient.getClient();
    }
    
    public static PermissionDAO getInstance(){
        if(instance == null)
            instance = new PermissionDAO();
        
        return instance;
    }
    
    public void endConnection(){
        this.appClient = null;
        instance = null;
    }
    
    public LinkedList<Permission> getAllPermissions(){
        LinkedList<Permission> perms = new LinkedList<>();
        LinkedList<String> datos = new LinkedList<>();
        try {
            datos = this.appClient.AskForPermList();
        } catch (IOException ex) {
            Logger.getLogger(PermissionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(int i = 0; i < datos.size(); i++){
            String[] dat = datos.get(i).split(";");
            Permission p = new Permission(Integer.parseInt(dat[0]), dat[1]);
            perms.add(p);
        }
        
        return perms;
    }
}
