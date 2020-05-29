/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

/**
 *
 * @author erome
 */
public class Prueba {
    public static void main(String[] args){
        
        String filename = "./serverfiles/reports/ProductsReport_28-05-2020-01-42-48.pdf";
        String email = "e.romerociudad@outlook.com";
        MailSender ms = new MailSender();
        String filetype = filename.split("_")[0];
        ms.sendFileMail(filetype, email, filename);

    }
}
