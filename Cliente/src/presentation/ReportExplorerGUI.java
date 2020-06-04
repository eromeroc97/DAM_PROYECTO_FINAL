/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import domain.Report;
import java.util.LinkedList;
import javax.swing.table.DefaultTableModel;
import utilities.PropertiesController;

/**
 *
 * @author erome
 */
public class ReportExplorerGUI extends javax.swing.JDialog {

    private String selectedFilename = null;
    
    public ReportExplorerGUI(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
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
        lblSelectReport = new RSMaterialComponent.RSLabelTextIcon();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblReports = new RSMaterialComponent.RSTableMetroCustom();
        btnSelect = new RSMaterialComponent.RSButtonMaterialOne();
        btnCancel = new RSMaterialComponent.RSButtonMaterialOne();

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

        lblSelectReport.setForeground(new java.awt.Color(239, 96, 0));
        lblSelectReport.setText("Select Report");
        lblSelectReport.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.FILE_DOWNLOAD);

        tblReports.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblReports.setBackgoundHead(new java.awt.Color(239, 96, 0));
        tblReports.setBackgoundHover(new java.awt.Color(239, 96, 0));
        tblReports.setColorPrimaryText(new java.awt.Color(0, 0, 0));
        tblReports.setColorSecundaryText(new java.awt.Color(0, 0, 0));
        tblReports.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblReportsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblReports);

        btnSelect.setBackground(new java.awt.Color(239, 96, 0));
        btnSelect.setText("Select");
        btnSelect.setBackgroundHover(new java.awt.Color(255, 137, 25));
        btnSelect.setEnabled(false);
        btnSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectActionPerformed(evt);
            }
        });

        btnCancel.setBackground(new java.awt.Color(239, 96, 0));
        btnCancel.setText("Cancel");
        btnCancel.setBackgroundHover(new java.awt.Color(255, 137, 25));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblSelectReport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSelectReport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectActionPerformed
        if(((String)tblReports.getValueAt(tblReports.getSelectedRow(), 2)).isBlank())
            this.selectedFilename = (String)tblReports.getValueAt(tblReports.getSelectedRow(), 0)+"_"+(String)tblReports.getValueAt(tblReports.getSelectedRow(), 1)+".pdf";
        else
            this.selectedFilename = (String)tblReports.getValueAt(tblReports.getSelectedRow(), 0)+"_"+(String)tblReports.getValueAt(tblReports.getSelectedRow(), 1)+"_"+(String)tblReports.getValueAt(tblReports.getSelectedRow(), 2)+".pdf";
        this.dispose();
    }//GEN-LAST:event_btnSelectActionPerformed

    private void tblReportsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblReportsMouseClicked
        if(tblReports.getSelectedRow() != -1){
            btnSelect.setEnabled(true);
        }
    }//GEN-LAST:event_tblReportsMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        setLanguageUI();
        fillReportsTable(createReportTableModel());
    }//GEN-LAST:event_formWindowOpened

    private void setLanguageUI(){
        this.lblSelectReport.setText(PropertiesController.getLangValue("selectreport"));
        this.btnCancel.setText(PropertiesController.getLangValue("cancel"));
        this.btnSelect.setText(PropertiesController.getLangValue("select"));
    }
    
    public String getSelectedFilename(){
        return this.selectedFilename;
    }
    
    private DefaultTableModel createReportTableModel(){
        DefaultTableModel model = new DefaultTableModel();
        
        model.addColumn(PropertiesController.getLangValue("type"));
        model.addColumn(PropertiesController.getLangValue("creationdate"));
        model.addColumn(PropertiesController.getLangValue("applicationdate"));
        
        return model;
    }
    
    private void fillReportsTable(DefaultTableModel model){
        Report r = new Report();
        LinkedList<String[]> reps = r.getDao().getReportsList();
        for(int i = 0; i < reps.size(); i++){
            Object[] row = new Object[]{reps.get(i)[0],reps.get(i)[1],reps.get(i)[2]};
            model.addRow(row);
        }
        tblReports.setModel(model);
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
            java.util.logging.Logger.getLogger(ReportExplorerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReportExplorerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReportExplorerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReportExplorerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ReportExplorerGUI dialog = new ReportExplorerGUI(new javax.swing.JFrame(), true);
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
    private RSMaterialComponent.RSButtonMaterialOne btnCancel;
    private RSMaterialComponent.RSButtonMaterialOne btnSelect;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private RSMaterialComponent.RSLabelTextIcon lblSelectReport;
    private RSMaterialComponent.RSTableMetroCustom tblReports;
    // End of variables declaration//GEN-END:variables
}
