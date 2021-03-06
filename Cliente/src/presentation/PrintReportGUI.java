/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import domain.Report;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilities.IServerProtocol;
import utilities.PropertiesController;

/**
 *
 * @author erome
 */
public class PrintReportGUI extends javax.swing.JDialog {
    
    private java.awt.Frame parent;
    private String lastFilename;
    
    /**
     * Creates new form PrintReportGUI
     */
    public PrintReportGUI(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.parent = parent;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblPrintReport = new RSMaterialComponent.RSLabelTextIcon();
        btnClose = new RSMaterialComponent.RSButtonIconOne();
        btnUsersReport = new RSMaterialComponent.RSButtonShape();
        btnFullSalesReport = new RSMaterialComponent.RSButtonShape();
        btnSendMailReport = new RSMaterialComponent.RSButtonShapeIcon();
        btnOpenReportHere = new RSMaterialComponent.RSButtonShapeIcon();
        btnFullOrdersReport = new RSMaterialComponent.RSButtonShape();
        btnDailySalesReport = new RSMaterialComponent.RSButtonShape();
        btnDailyOrdersReport = new RSMaterialComponent.RSButtonShape();
        btnProductsReport = new RSMaterialComponent.RSButtonShape();
        btnFullExpensesBenefitsReport = new RSMaterialComponent.RSButtonShape();
        btnDeletedProductsReport = new RSMaterialComponent.RSButtonShape();
        btnDailyExpensesBenefitsReport = new RSMaterialComponent.RSButtonShape();
        btnSelectReport = new RSMaterialComponent.RSButtonShape();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(50, 51, 52));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 96, 0), 2));

        lblPrintReport.setForeground(new java.awt.Color(239, 96, 0));
        lblPrintReport.setText("Print Report");
        lblPrintReport.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.PRINT);

        btnClose.setBackground(new java.awt.Color(204, 0, 0));
        btnClose.setBackgroundHover(new java.awt.Color(255, 0, 0));
        btnClose.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CLOSE);
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        btnUsersReport.setBackground(new java.awt.Color(239, 96, 0));
        btnUsersReport.setText("Users Report");
        btnUsersReport.setBackgroundHover(new java.awt.Color(255, 137, 25));
        btnUsersReport.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnUsersReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsersReportActionPerformed(evt);
            }
        });

        btnFullSalesReport.setBackground(new java.awt.Color(239, 96, 0));
        btnFullSalesReport.setText("Full Sales Report");
        btnFullSalesReport.setBackgroundHover(new java.awt.Color(255, 137, 25));
        btnFullSalesReport.setForma(RSMaterialComponent.RSButtonShape.FORMA.ROUND_LEFT);
        btnFullSalesReport.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnFullSalesReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFullSalesReportActionPerformed(evt);
            }
        });

        btnSendMailReport.setBackground(new java.awt.Color(239, 96, 0));
        btnSendMailReport.setText("Send Report to Mail");
        btnSendMailReport.setBackgroundHover(new java.awt.Color(255, 137, 25));
        btnSendMailReport.setEnabled(false);
        btnSendMailReport.setForma(RSMaterialComponent.RSButtonShapeIcon.FORMA.ROUND_BOTTOM);
        btnSendMailReport.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSendMailReport.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.MAIL_OUTLINE);
        btnSendMailReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendMailReportActionPerformed(evt);
            }
        });

        btnOpenReportHere.setBackground(new java.awt.Color(239, 96, 0));
        btnOpenReportHere.setText("Open Report Here");
        btnOpenReportHere.setBackgroundHover(new java.awt.Color(255, 137, 25));
        btnOpenReportHere.setEnabled(false);
        btnOpenReportHere.setForma(RSMaterialComponent.RSButtonShapeIcon.FORMA.ROUND_TOP);
        btnOpenReportHere.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnOpenReportHere.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.OPEN_IN_NEW);
        btnOpenReportHere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenReportHereActionPerformed(evt);
            }
        });

        btnFullOrdersReport.setBackground(new java.awt.Color(239, 96, 0));
        btnFullOrdersReport.setText("Full Orders Report");
        btnFullOrdersReport.setBackgroundHover(new java.awt.Color(255, 137, 25));
        btnFullOrdersReport.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnFullOrdersReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFullOrdersReportActionPerformed(evt);
            }
        });

        btnDailySalesReport.setBackground(new java.awt.Color(239, 96, 0));
        btnDailySalesReport.setText("Daily Sales Report");
        btnDailySalesReport.setBackgroundHover(new java.awt.Color(255, 137, 25));
        btnDailySalesReport.setForma(RSMaterialComponent.RSButtonShape.FORMA.ROUND_LEFT);
        btnDailySalesReport.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnDailySalesReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDailySalesReportActionPerformed(evt);
            }
        });

        btnDailyOrdersReport.setBackground(new java.awt.Color(239, 96, 0));
        btnDailyOrdersReport.setText("Daily Orders Report");
        btnDailyOrdersReport.setBackgroundHover(new java.awt.Color(255, 137, 25));
        btnDailyOrdersReport.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnDailyOrdersReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDailyOrdersReportActionPerformed(evt);
            }
        });

        btnProductsReport.setBackground(new java.awt.Color(239, 96, 0));
        btnProductsReport.setText("Products Report");
        btnProductsReport.setBackgroundHover(new java.awt.Color(255, 137, 25));
        btnProductsReport.setForma(RSMaterialComponent.RSButtonShape.FORMA.ROUND_LEFT);
        btnProductsReport.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnProductsReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductsReportActionPerformed(evt);
            }
        });

        btnFullExpensesBenefitsReport.setBackground(new java.awt.Color(239, 96, 0));
        btnFullExpensesBenefitsReport.setText("Full Expenses - Benefits Report");
        btnFullExpensesBenefitsReport.setBackgroundHover(new java.awt.Color(255, 137, 25));
        btnFullExpensesBenefitsReport.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnFullExpensesBenefitsReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFullExpensesBenefitsReportActionPerformed(evt);
            }
        });

        btnDeletedProductsReport.setBackground(new java.awt.Color(239, 96, 0));
        btnDeletedProductsReport.setText("Deleted Products Report");
        btnDeletedProductsReport.setBackgroundHover(new java.awt.Color(255, 137, 25));
        btnDeletedProductsReport.setForma(RSMaterialComponent.RSButtonShape.FORMA.ROUND_LEFT);
        btnDeletedProductsReport.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnDeletedProductsReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletedProductsReportActionPerformed(evt);
            }
        });

        btnDailyExpensesBenefitsReport.setBackground(new java.awt.Color(239, 96, 0));
        btnDailyExpensesBenefitsReport.setText("Daily Expenses - Benefits Report");
        btnDailyExpensesBenefitsReport.setBackgroundHover(new java.awt.Color(255, 137, 25));
        btnDailyExpensesBenefitsReport.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnDailyExpensesBenefitsReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDailyExpensesBenefitsReportActionPerformed(evt);
            }
        });

        btnSelectReport.setBackground(new java.awt.Color(255, 255, 255));
        btnSelectReport.setForeground(new java.awt.Color(239, 96, 0));
        btnSelectReport.setText("Select Created Report");
        btnSelectReport.setBackgroundHover(new java.awt.Color(204, 204, 204));
        btnSelectReport.setForegroundHover(new java.awt.Color(239, 96, 0));
        btnSelectReport.setForegroundText(new java.awt.Color(239, 96, 0));
        btnSelectReport.setForma(RSMaterialComponent.RSButtonShape.FORMA.ROUND_LEFT);
        btnSelectReport.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSelectReport.setRippleColor(new java.awt.Color(239, 96, 0));
        btnSelectReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectReportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnUsersReport, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnFullSalesReport, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnFullOrdersReport, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDailySalesReport, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnDailyOrdersReport, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnProductsReport, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnFullExpensesBenefitsReport, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDeletedProductsReport, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnDailyExpensesBenefitsReport, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSelectReport, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(lblPrintReport, javax.swing.GroupLayout.PREFERRED_SIZE, 609, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(225, 225, 225)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnSendMailReport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnOpenReportHere, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblPrintReport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnUsersReport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnFullSalesReport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnFullOrdersReport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDailySalesReport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDailyOrdersReport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProductsReport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFullExpensesBenefitsReport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeletedProductsReport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDailyExpensesBenefitsReport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSelectReport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(btnOpenReportHere, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSendMailReport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        File toDelete = new File("./clientfiles/temp/");
        if(toDelete.exists()){
            String[]entries = toDelete.list();
            for(String s: entries){
                File currentFile = new File(toDelete.getPath(),s);
                currentFile.delete();
            }
            toDelete.delete();
        }
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnUsersReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsersReportActionPerformed
        Report r = new Report();
        lastFilename = r.getDao().createReport(IServerProtocol.TYPE_USERS_REPORT, null);
        checkFile();
    }//GEN-LAST:event_btnUsersReportActionPerformed

    private void btnFullOrdersReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFullOrdersReportActionPerformed
        Report r = new Report();
        lastFilename = r.getDao().createReport(IServerProtocol.TYPE_FULL_ORDERS_REPORT, null);
        checkFile();
    }//GEN-LAST:event_btnFullOrdersReportActionPerformed

    private void btnFullSalesReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFullSalesReportActionPerformed
        Report r = new Report();
        lastFilename = r.getDao().createReport(IServerProtocol.TYPE_FULL_SALES_REPORT, null);
        checkFile();
    }//GEN-LAST:event_btnFullSalesReportActionPerformed

    private void btnProductsReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductsReportActionPerformed
        Report r = new Report();
        lastFilename = r.getDao().createReport(IServerProtocol.TYPE_PRODUCTS_REPORT, null);
        checkFile();
    }//GEN-LAST:event_btnProductsReportActionPerformed

    private void btnDeletedProductsReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletedProductsReportActionPerformed
        Report r = new Report();
        lastFilename = r.getDao().createReport(IServerProtocol.TYPE_DELETED_PRODUCTS_REPORT, null);
        checkFile();
    }//GEN-LAST:event_btnDeletedProductsReportActionPerformed

    private void btnFullExpensesBenefitsReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFullExpensesBenefitsReportActionPerformed
        Report r = new Report();
        lastFilename = r.getDao().createReport(IServerProtocol.TYPE_FULL_EXPENSES_BENEFITS_REPORT, null);
        checkFile();
    }//GEN-LAST:event_btnFullExpensesBenefitsReportActionPerformed

    private void btnSendMailReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendMailReportActionPerformed
        if(lastFilename != null){
            Report r = new Report();
            r.getDao().getReport(lastFilename, IServerProtocol.METHOD_MAIL);

            lastFilename = null;
        }
        checkFile();
    }//GEN-LAST:event_btnSendMailReportActionPerformed

    private void btnDailyOrdersReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDailyOrdersReportActionPerformed
        SelectDateGUI sdgui = new SelectDateGUI(this.parent, true);
        sdgui.setVisible(true);
        Date date = sdgui.getDate();
        if(date != null){
            Report r = new Report();
            lastFilename = r.getDao().createReport(IServerProtocol.TYPE_DAILY_ORDERS_REPORT, date);
        }
        checkFile();
    }//GEN-LAST:event_btnDailyOrdersReportActionPerformed

    private void btnDailySalesReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDailySalesReportActionPerformed
        SelectDateGUI sdgui = new SelectDateGUI(this.parent, true);
        sdgui.setVisible(true);
        Date date = sdgui.getDate();
        if(date != null){
            Report r = new Report();
            lastFilename = r.getDao().createReport(IServerProtocol.TYPE_DAILY_SALES_REPORT, date);
        }
        checkFile();
    }//GEN-LAST:event_btnDailySalesReportActionPerformed

    private void btnDailyExpensesBenefitsReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDailyExpensesBenefitsReportActionPerformed
        SelectDateGUI sdgui = new SelectDateGUI(this.parent, true);
        sdgui.setVisible(true);
        Date date = sdgui.getDate();
        if(date != null){
            Report r = new Report();
            lastFilename = r.getDao().createReport(IServerProtocol.TYPE_DAILY_EXPENSES_BENEFITS_REPORT, date);
        }
        checkFile();
    }//GEN-LAST:event_btnDailyExpensesBenefitsReportActionPerformed

    private void btnOpenReportHereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenReportHereActionPerformed
        if(lastFilename != null){
            Report r = new Report();
            File rec = r.getDao().getReport(lastFilename, IServerProtocol.METHOD_CLIENT);

            lastFilename = null;
            
            try {
                Desktop.getDesktop().open(rec);
            } catch (IOException ex) {
                Logger.getLogger(PrintReportGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            checkFile();
        }
    }//GEN-LAST:event_btnOpenReportHereActionPerformed

    private void btnSelectReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectReportActionPerformed
        ReportExplorerGUI regui = new ReportExplorerGUI(null, true);
        regui.setVisible(true);
        if(regui.getSelectedFilename()!=null)
            this.lastFilename = regui.getSelectedFilename();
        checkFile();
    }//GEN-LAST:event_btnSelectReportActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        setLanguageUI();
    }//GEN-LAST:event_formWindowOpened

    private void setLanguageUI(){
        this.lblPrintReport.setText(PropertiesController.getLangValue("printreport"));
        this.btnDailyExpensesBenefitsReport.setText(PropertiesController.getLangValue("dailyexpesesbenefitsreport"));
        this.btnDailySalesReport.setText(PropertiesController.getLangValue("dailysalesreport"));
        this.btnDailyOrdersReport.setText(PropertiesController.getLangValue("dailyordersreport"));
        this.btnDeletedProductsReport.setText(PropertiesController.getLangValue("deletedproductsreport"));
        this.btnFullExpensesBenefitsReport.setText(PropertiesController.getLangValue("fullexpensesbenefitsreport"));
        this.btnFullOrdersReport.setText(PropertiesController.getLangValue("fullordersreport"));
        this.btnFullSalesReport.setText(PropertiesController.getLangValue("fullsalesreport"));
        this.btnOpenReportHere.setText(PropertiesController.getLangValue("openreporthere"));
        this.btnProductsReport.setText(PropertiesController.getLangValue("productsreport"));
        this.btnSelectReport.setText(PropertiesController.getLangValue("selectreport"));
        this.btnSendMailReport.setText(PropertiesController.getLangValue("sendmailreport"));
        this.btnUsersReport.setText(PropertiesController.getLangValue("usersreport"));
    }
    
    private void checkFile(){
        if(lastFilename == null){
            btnSendMailReport.setEnabled(false);
            btnOpenReportHere.setEnabled(false);
        }else{
            btnSendMailReport.setEnabled(true);
            btnOpenReportHere.setEnabled(true);
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PrintReportGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrintReportGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrintReportGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrintReportGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PrintReportGUI dialog = new PrintReportGUI(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSButtonIconOne btnClose;
    private RSMaterialComponent.RSButtonShape btnDailyExpensesBenefitsReport;
    private RSMaterialComponent.RSButtonShape btnDailyOrdersReport;
    private RSMaterialComponent.RSButtonShape btnDailySalesReport;
    private RSMaterialComponent.RSButtonShape btnDeletedProductsReport;
    private RSMaterialComponent.RSButtonShape btnFullExpensesBenefitsReport;
    private RSMaterialComponent.RSButtonShape btnFullOrdersReport;
    private RSMaterialComponent.RSButtonShape btnFullSalesReport;
    private RSMaterialComponent.RSButtonShapeIcon btnOpenReportHere;
    private RSMaterialComponent.RSButtonShape btnProductsReport;
    private RSMaterialComponent.RSButtonShape btnSelectReport;
    private RSMaterialComponent.RSButtonShapeIcon btnSendMailReport;
    private RSMaterialComponent.RSButtonShape btnUsersReport;
    private javax.swing.JPanel jPanel1;
    private RSMaterialComponent.RSLabelTextIcon lblPrintReport;
    // End of variables declaration//GEN-END:variables
}
