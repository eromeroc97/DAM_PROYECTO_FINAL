/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.LinkedList;
import persistence.RoleDAO;

/**
 *
 * @author erome
 */
public class Role {
    private int idRole;
    private String rolename;
    private LinkedList<Permission> perms;
    
    private RoleDAO dao;

    public Role(){
        this.dao = RoleDAO.getInstance();
    }
    
    public Role(int idRole, String rolename) {
        this();
        this.idRole = idRole;
        this.rolename = rolename;
        this.perms = dao.getPermissionList(rolename);
    }

    public int getIdRole() {
        return idRole;
    }

    public String getRolename() {
        return rolename;
    }

    public LinkedList<Permission> getPerms() {
        return perms;
    }

    public RoleDAO getDao() {
        return dao;
    }
}
