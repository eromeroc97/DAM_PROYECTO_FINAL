/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.util.logging.Level;
import java.util.logging.Logger;
import utilities.Encrypt;

/**
 *
 * @author erome
 */
public class SysAdminDAO {
    private SQLiteManager man;
    
    public SysAdminDAO(){
        man = SQLiteManager.getSingletonInstance();
    }
    
    public void setSysAdminPassword(String password){
        String sql;
        try {
            sql = "INSERT INTO USERS (USERNAME, PASSWORD, IDROLE) VALUES ('SYSADMIN', '"+Encrypt.encriptar_DESede(password)+"', (SELECT IDROLE FROM ROLES WHERE ROLENAME='SYSADMIN'));";
            man.executeNonQuery(sql);
        } catch (Exception ex) {
            Logger.getLogger(SysAdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
