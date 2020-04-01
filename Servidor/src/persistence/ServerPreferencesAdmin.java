/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.util.prefs.Preferences;

/**
 *
 * @author erome
 */
public class ServerPreferencesAdmin {
    private static ServerPreferencesAdmin instance = null;
    
    private ServerPreferencesAdmin(){
        //solo necesito marcarlo privado
    }
    public static ServerPreferencesAdmin getInstance() {
        if(instance == null){
            instance = new ServerPreferencesAdmin();
        }
        
        return instance;
    }
    Preferences preferences = 
         Preferences.userNodeForPackage(ServerPreferencesAdmin.class);
    
    public void setCredentials(String password) {
       preferences.put("encrypt_password", password);
    }
    
    public String getPassword() {
       return preferences.get("encrypt_password", null);
    }
}
