/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author erome
 */
public class Permission{
        private int idPermission;
        private String permname;

        public Permission(int idPermission, String permname) {
            this.idPermission = idPermission;
            this.permname = permname;
        }

        public int getIdPermission() {
            return idPermission;
        }

        public String getPermname() {
            return permname;
        }
        
    }
