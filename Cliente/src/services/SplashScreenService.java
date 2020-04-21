/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.logging.Level;
import java.util.logging.Logger;
import presentation.MenuGUI;
import presentation.SplashScreenGUI;

/**
 *
 * @author erome
 */
public class SplashScreenService implements Runnable{
    
    MenuGUI menu;
    public SplashScreenService(MenuGUI menu) {
        this.menu = menu;
    }

        @Override
        public void run() {
            int time = 6; //seconds
            SplashScreenGUI ss = new SplashScreenGUI();
            ss.setAlwaysOnTop(true);
            ss.setVisible(true);
            this.menu.setVisible(true);
            for(int i = 0; i < time; i++){
                try {
                    Thread.sleep(1000); //1 sec
                } catch (InterruptedException ex) {
                    Logger.getLogger(SplashScreenGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                       
            }
            ss.dispose();            
        }
        
    }
