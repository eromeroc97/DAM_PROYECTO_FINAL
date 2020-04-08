/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.awt.Color;
import javax.swing.JFrame;
import rojeru_san.efectos.ValoresEnum;

/**
 *
 * @author erome
 */
public class MsgBox extends javax.swing.JFrame {
    
    public static final int INFO_ICON = 0;
    public static final int WARNING_ICON = 1;
    public static final int ERROR_ICON = 2;
    
    public static MsgBox create(JFrame parent, String msg){
        MsgBox m = new MsgBox(parent, msg);
        return m;
    }
    
    public static MsgBox create(JFrame parent, String msg, int type_icon){
        MsgBox m = new MsgBox(parent, msg, type_icon);
        return m;
    }
    
    private JFrame parent;
    
    private MsgBox() {
        initComponents();
        this.setAlwaysOnTop(true);
    }
    
    private MsgBox(JFrame parent, String msg) {
        this();
        this.parent = parent;
        texto.setText(msg);
        icon.setVisible(false);
        this.parent.setEnabled(false);
    }
    
    private MsgBox(JFrame parent, String msg, int type_icon) {
        this(parent, msg);
        icon.setVisible(true);
        switch(type_icon){
            case INFO_ICON:{
                icon.setIcons(ValoresEnum.ICONS.INFO_OUTLINE);
                icon.setForeground(Color.CYAN);
                break;
            }
            case WARNING_ICON:{
                icon.setIcons(ValoresEnum.ICONS.WARNING);
                icon.setForeground(Color.ORANGE);
                break;
            }
            case ERROR_ICON:{
                icon.setIcons(ValoresEnum.ICONS.ERROR);
                icon.setForeground(Color.RED);
                break;
            }
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainPanel = new javax.swing.JPanel();
        icon = new RSMaterialComponent.RSLabelIcon();
        btnOK = new RSMaterialComponent.RSButtonIconOne();
        jScrollPane1 = new javax.swing.JScrollPane();
        texto = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        MainPanel.setBackground(new java.awt.Color(50, 51, 52));
        MainPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 96, 0), 2));

        icon.setForeground(new java.awt.Color(239, 96, 0));
        icon.setSizeIcon(50.0F);

        btnOK.setBackground(new java.awt.Color(239, 96, 0));
        btnOK.setBackgroundHover(new java.awt.Color(255, 137, 25));
        btnOK.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CHECK);
        btnOK.setTypeBorder(RSMaterialComponent.RSButtonIconOne.TYPEBORDER.CIRCLE);
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        texto.setEditable(false);
        texto.setBackground(new java.awt.Color(50, 51, 52));
        texto.setColumns(20);
        texto.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        texto.setForeground(new java.awt.Color(255, 255, 255));
        texto.setLineWrap(true);
        texto.setRows(5);
        texto.setText("Texto");
        texto.setWrapStyleWord(true);
        jScrollPane1.setViewportView(texto);

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE))
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        MainPanelLayout.setVerticalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        this.parent.setEnabled(true);
        this.dispose();
    }//GEN-LAST:event_btnOKActionPerformed

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
            java.util.logging.Logger.getLogger(MsgBox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MsgBox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MsgBox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MsgBox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MsgBox().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MainPanel;
    private RSMaterialComponent.RSButtonIconOne btnOK;
    private RSMaterialComponent.RSLabelIcon icon;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea texto;
    // End of variables declaration//GEN-END:variables
}
