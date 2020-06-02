/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import domain.Profile;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author erome
 */
public class ProfileDAO {
    private static ProfileDAO instance;
    private ApplicationClient appClient;
    
    private ProfileDAO(){
        this.appClient = ApplicationClient.getClient();
    }
    
    public static ProfileDAO getInstance(){
        if(instance == null)
            instance = new ProfileDAO();
        
        return instance;
    }
    
    public Profile getProfileData(int idUser){
        String linea = null;
        try {
            linea = appClient.AskForUserProfile(idUser);
        } catch (IOException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(linea != null){
            String[] datos = linea.split(";");
            Profile p = new Profile(Integer.parseInt(datos[0]), datos[1], datos[2], datos[3], datos[4]);
            return p;
        }else
            return new Profile(); //Si no existe un perfil, devuelvo uno vacío
        
    }
    
    public void setProfileData(Profile p, int idUser){
        String valores = p.getName()+";"+p.getSurname()+";"+p.getEmail()+";"+p.getTelegramUser();
        try {
            this.appClient.AskForSetProfile(idUser, valores);
        } catch (IOException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
