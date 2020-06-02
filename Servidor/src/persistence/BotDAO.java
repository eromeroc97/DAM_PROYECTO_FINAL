/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author erome
 */
public class BotDAO {
    SQLiteManager man = SQLiteManager.getSingletonInstance();
    
    public boolean checkTelegramUsername(String tUser) throws SQLException{
        String sql = "SELECT P.TELEGRAMUSER FROM ROLES R, ROLES_PERM RP, USERS U, PROFILES P WHERE RP.IDPERM = 5 AND RP.IDROLE=R.IDROLE AND R.IDROLE=U.IDROLE AND U.IDUSER=P.IDUSER;";
        ResultSet rs = man.executeQuery(sql);
        while(rs.next()){
            if(rs.getString(1).trim().equals(tUser.trim()))
                return true;
        }
        return false;
    }
}
