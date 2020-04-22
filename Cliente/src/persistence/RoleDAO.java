/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import domain.Permission;
import domain.Role;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author erome
 */
public class RoleDAO {
    private static RoleDAO instance;
    private ApplicationClient appClient;
    
    private RoleDAO(){
        this.appClient = ApplicationClient.getClient();
    }
    
    public static RoleDAO getInstance(){
        if(instance == null)
            instance = new RoleDAO();
        
        return instance;
    }
    
    public LinkedList<domain.Permission> getPermissionList(String rolename){
        LinkedList<domain.Permission> perms = new LinkedList<>();
        try {
            LinkedList<String> resultado = this.appClient.AskForRolePermissions(rolename);
            for(int i = 0; i < resultado.size(); i++){
                String[] datos = resultado.get(i).split(";");
                domain.Permission p = new domain.Permission(Integer.parseInt(datos[0]), datos[1]);
                perms.add(p);
            }
        } catch (IOException ex) {
            Logger.getLogger(RoleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return perms;
    }
    
    public void endConnection(){
        this.appClient = null;
        instance = null;
    }

    public LinkedList<Role> getRoleList() {
        LinkedList<Role> list = new LinkedList<>();
        try {    
            LinkedList<String> roles = this.appClient.AskForRoleList();
            
            for(int i = 0 ; i < roles.size(); i++){
                String[] datos = roles.get(i).split(";");
                Role r = new Role(Integer.parseInt(datos[0]), datos[1]);
                list.add(r);
            }
        } catch (IOException ex) {
            Logger.getLogger(RoleDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return list;
        }
    }

    public void deleteRole(int roleid) {
        try {
            this.appClient.AskForDeleteRole(roleid);
        } catch (IOException ex) {
            Logger.getLogger(RoleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void createNewRole(String rolename, LinkedList<Permission> perms) {
        try {
            this.appClient.AskForCreateRole(rolename, perms);
        } catch (IOException ex) {
            Logger.getLogger(RoleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
