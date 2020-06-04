/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author erome
 */
public class ReportDAO {
    private ApplicationClient appClient;
    
    public ReportDAO(){
        appClient = ApplicationClient.getClient();
    }
    
    public String createReport(int type, Date day){
        try {
            return this.appClient.AskForCreateReport(type, day);
        } catch (IOException ex) {
            Logger.getLogger(ReportDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public File getReport(String filename, int method){
        try {
            return this.appClient.AskForGetReport(filename, method);
        } catch (IOException ex) {
            Logger.getLogger(ReportDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public LinkedList<String[]> getReportsList() {
        LinkedList<String> files = new LinkedList<>();
        try {
            files = appClient.AskForGetReportList();
        } catch (IOException ex) {
            Logger.getLogger(ReportDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        LinkedList<String[]> reps = new LinkedList<>();
        
        for(int i = 0; i < files.size(); i++){
            String[] r = files.get(i).split("_");
            r[r.length-1] = r[r.length-1].replaceAll(".pdf", "");
            if(r.length == 2){
                String[] r2 = new String[]{r[0], r[1], ""};
                reps.add(r2);
            }else
                reps.add(r);
        }       
        
        return reps;
    }
}
