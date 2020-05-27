/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import domain.Advert;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author erome
 */
public class AdvertDAO {
    private ApplicationClient appClient;
    
    public AdvertDAO(){
        this.appClient = ApplicationClient.getClient();
    }

    public void sendAdvert(Advert a) {
        try {
            this.appClient.AskForSendAdvert(a);
        } catch (IOException ex) {
            Logger.getLogger(AdvertDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public LinkedList<Advert> getAdvertList() {
        LinkedList<Advert> ads = new LinkedList<>();
        try {
            LinkedList<String> data = this.appClient.AskForGetAdvertList();
            for(String s : data){
                String[] splitted = s.split(";");
                Advert a = new Advert(Integer.parseInt(splitted[0]),
                        splitted[1],
                        new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(splitted[2]),
                        splitted[3]);
                ads.add(a);
            }
        } catch (IOException ex) {
            Logger.getLogger(AdvertDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(AdvertDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ads;
    }
}
