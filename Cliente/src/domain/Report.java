/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import persistence.ReportDAO;

/**
 *
 * @author erome
 */
public class Report {
    private ReportDAO dao;
    
    public Report(){
        dao = new ReportDAO();
    }
    
    public ReportDAO getDao(){
        return this.dao;
    }
}
