package persistence;

import java.util.Locale;
import java.util.ResourceBundle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author erome
 */
public class LanguageController {
    private static Locale[] locales = 
        {
            Locale.ENGLISH,
            new Locale("es", "ES") //El español no existe por defecto
        };
    
    public static String getLangValue(String key){
        ClientPreferencesAdmin prefs = ClientPreferencesAdmin.getInstance();        
        ResourceBundle lang = ResourceBundle.getBundle("resources/lang", prefs.getLocale());
        return lang.getString(key);
    }
}
