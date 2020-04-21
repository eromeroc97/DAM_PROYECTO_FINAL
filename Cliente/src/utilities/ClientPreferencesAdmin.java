/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.util.Locale;
import java.util.prefs.Preferences;

/**
 *
 * @author erome
 */
public class ClientPreferencesAdmin {
    private static ClientPreferencesAdmin instance = null;
    
    private ClientPreferencesAdmin(){
        //solo necesito marcarlo privado
    }
    public static ClientPreferencesAdmin getInstance() {
        if(instance == null){
            instance = new ClientPreferencesAdmin();
        }
        
        return instance;
    }
    Preferences preferences = 
         Preferences.userNodeForPackage(ClientPreferencesAdmin.class);
    
    public void setDBPassword(String password) {
       preferences.put("dbPassword", password);
    }
    
    public String getDBPassword() {
       return preferences.get("dbPassword", null);
    }
    
    public void setClientKeyPath(String randomKeyPath){
        preferences.put("clientKeyPath", randomKeyPath);
    }
    
    public String getClientKeyPath() {
       return preferences.get("clientKeyPath", null);
    }
    
    public void setLocale(String locale){
        preferences.put("locale", locale);
    }
    
    public Locale getLocale(){
        String loc = preferences.get("locale", null);
        if(loc.equals("es_ES"))
            return new Locale("es","ES");
        else //default language: english
            return Locale.ENGLISH;
    }
    
}
