/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author erome
 */
public class SplashScreenGUI extends javax.swing.JFrame {

    /**
     * Creates new form SplashScreenGUI
     */
    public SplashScreenGUI() {
        initComponents();
        setProgramIcon();
    }
    
    private void setProgramIcon(){
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("resources/client_icon_32.png")));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SplashPanel = new javax.swing.JPanel();
        lblIcon = new javax.swing.JLabel();
        pbLoading = new RSMaterialComponent.RSProgressMaterial();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setAlwaysOnTop(true);
        setUndecorated(true);

        SplashPanel.setBackground(new java.awt.Color(255, 255, 255));
        SplashPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 96, 0), 2));

        lblIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/splash_icon_400x400.png"))); // NOI18N
        lblIcon.setToolTipText("");

        pbLoading.setForeground(new java.awt.Color(239, 96, 0));

        javax.swing.GroupLayout SplashPanelLayout = new javax.swing.GroupLayout(SplashPanel);
        SplashPanel.setLayout(SplashPanelLayout);
        SplashPanelLayout.setHorizontalGroup(
            SplashPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SplashPanelLayout.createSequentialGroup()
                .addGroup(SplashPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SplashPanelLayout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(lblIcon))
                    .addGroup(SplashPanelLayout.createSequentialGroup()
                        .addGap(350, 350, 350)
                        .addComponent(pbLoading, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(196, Short.MAX_VALUE))
        );
        SplashPanelLayout.setVerticalGroup(
            SplashPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SplashPanelLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(lblIcon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pbLoading, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SplashPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SplashPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(SplashScreenGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SplashScreenGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SplashScreenGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SplashScreenGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SplashScreenGUI().setVisible(true);
            }
        });
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel SplashPanel;
    private javax.swing.JLabel lblIcon;
    private RSMaterialComponent.RSProgressMaterial pbLoading;
    // End of variables declaration//GEN-END:variables
}
