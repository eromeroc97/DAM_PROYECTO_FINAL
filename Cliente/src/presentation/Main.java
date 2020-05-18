/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

/**
 *
 * @author erome
 */
public class Main {
    public static void main(String[] args){
        MyPDFViewerGUI pdfv = new MyPDFViewerGUI(null, true, "./TeamDev.pdf");
        pdfv.setVisible(true);
    }
}
