/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package presentation;

import javax.swing.JFrame;
import persistence.SysAdminDAO;

/**
 *
 * @author erome
 */
public class FirstRunningConfigGUI extends javax.swing.JFrame {

    private JFrame parent;
    private SysAdminDAO dao;
    public FirstRunningConfigGUI(JFrame parent) {
        initComponents();
        setLabelsText();
        //crea la bbdd
        dao = new SysAdminDAO();
        this.parent = parent;
        this.parent.setEnabled(false);
        this.setAlwaysOnTop(true);
    }
    
    public FirstRunningConfigGUI() {
        initComponents();
    }
    
    private void setLabelsText(){
        final String html = "<html><body style='width: %1spx'>%1s"; //Se utiliza para hacer el Wrapping del texto por palabras
        
        String engText = "This is the first time that this program is executing, please set a password for SYSADMIN user. Server User Interface uses only English as language.";
        
        lblInfoEng.setText(String.format(html, 260, engText)); //texto ingles
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainPanel = new javax.swing.JPanel();
        lblInfoTitle = new RSMaterialComponent.RSLabelTextIcon();
        lblInfoEng = new javax.swing.JLabel();
        txtPassword = new RSMaterialComponent.RSPasswordIconOne();
        btnConfirm = new RSMaterialComponent.RSButtonMaterialIconOne();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        MainPanel.setBackground(new java.awt.Color(50, 51, 52));
        MainPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 96, 0), 5));

        lblInfoTitle.setForeground(new java.awt.Color(239, 96, 0));
        lblInfoTitle.setText("IMPORTANT");
        lblInfoTitle.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.WARNING);

        lblInfoEng.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblInfoEng.setForeground(new java.awt.Color(255, 255, 255));
        lblInfoEng.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInfoEng.setText("English Text");
        lblInfoEng.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        txtPassword.setForeground(new java.awt.Color(239, 96, 0));
        txtPassword.setBorderColor(new java.awt.Color(239, 96, 0));
        txtPassword.setColorIcon(new java.awt.Color(239, 96, 0));
        txtPassword.setPhColor(new java.awt.Color(239, 96, 0));
        txtPassword.setPlaceholder("Password for SYSADMIN");

        btnConfirm.setBackground(new java.awt.Color(239, 96, 0));
        btnConfirm.setText("End Configuration");
        btnConfirm.setBackgroundHover(new java.awt.Color(255, 137, 25));
        btnConfirm.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SEND);
        btnConfirm.setPositionIcon(rojeru_san.efectos.ValoresEnum.POSITIONICON.RIGHT);
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblInfoTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addComponent(lblInfoEng, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        MainPanelLayout.setVerticalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblInfoTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblInfoEng, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        //inserta el nuevo SYADMIN
        dao.setSysAdminPassword(new String(txtPassword.getPassword()));
        //devuelve el control del parent
        parent.setEnabled(true);
        //cierro configuracion
        this.dispose();
    }//GEN-LAST:event_btnConfirmActionPerformed

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
            java.util.logging.Logger.getLogger(FirstRunningConfigGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FirstRunningConfigGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FirstRunningConfigGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FirstRunningConfigGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FirstRunningConfigGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MainPanel;
    private RSMaterialComponent.RSButtonMaterialIconOne btnConfirm;
    private javax.swing.JLabel lblInfoEng;
    private RSMaterialComponent.RSLabelTextIcon lblInfoTitle;
    private RSMaterialComponent.RSPasswordIconOne txtPassword;
    // End of variables declaration//GEN-END:variables

}