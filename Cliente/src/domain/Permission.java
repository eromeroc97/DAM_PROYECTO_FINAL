/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import persistence.PermissionDAO;

/**
 *
 * @author erome
 */
public class Permission{
        private int idPermission;
        private String permname;
        private PermissionDAO dao;

        public Permission(int idPermission, String permname) {
            this.idPermission = idPermission;
            this.permname = permname;
            this.dao = PermissionDAO.getInstance();
        }

        public Permission() {
            this.dao = PermissionDAO.getInstance();
        }

        public int getIdPermission() {
            return idPermission;
        }

        public String getPermname() {
            return permname;
        }

        public PermissionDAO getDao() {
            return this.dao;
        }
        
    }
