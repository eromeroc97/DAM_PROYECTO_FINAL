/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import utilities.CopyToGUI;
import persistence.LoginServer;
import java.sql.ResultSet;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import persistence.SQLiteManager;
import persistence.ServerPreferencesAdmin;

/**
 *
 * @author erome
 */
public class ServerConfigGUI extends javax.swing.JFrame {

    /**
     * Creates new form ServerConfigGUI
     */
    public ServerConfigGUI() {
        initComponents();
        txtPort.requestFocus();
        checkIfDefaultConfigExists();
        checkIfIsFirstRunning();
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
        rSLabelTextIcon1 = new RSMaterialComponent.RSLabelTextIcon();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtLog = new javax.swing.JTextArea();
        rSLabelTextIcon2 = new RSMaterialComponent.RSLabelTextIcon();
        txtPort = new RSMaterialComponent.RSTextFieldIconOne();
        rSLabelTextIcon3 = new RSMaterialComponent.RSLabelTextIcon();
        btnStartServer = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnStopServer = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnLoadDefaultConfig = new RSMaterialComponent.RSButtonMaterialIconTwo();
        btnSaveConfig = new RSMaterialComponent.RSButtonMaterialIconTwo();
        rSLabelTextIcon4 = new RSMaterialComponent.RSLabelTextIcon();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtOnlineUsers = new javax.swing.JTextArea();
        btnReloadOnlineUsers = new RSMaterialComponent.RSButtonIconTwo();
        btnSaveLog = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnCopyClientKey = new RSMaterialComponent.RSButtonMaterialIconOne();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        MainPanel.setBackground(new java.awt.Color(50, 51, 52));

        rSLabelTextIcon1.setForeground(new java.awt.Color(239, 96, 0));
        rSLabelTextIcon1.setText("Server Log");
        rSLabelTextIcon1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.VIEW_AGENDA);

        txtLog.setEditable(false);
        txtLog.setColumns(20);
        txtLog.setLineWrap(true);
        txtLog.setRows(5);
        txtLog.setFocusable(false);
        jScrollPane1.setViewportView(txtLog);

        rSLabelTextIcon2.setForeground(new java.awt.Color(239, 96, 0));
        rSLabelTextIcon2.setText("Server Config");
        rSLabelTextIcon2.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SETTINGS);

        txtPort.setForeground(new java.awt.Color(239, 96, 0));
        txtPort.setBorderColor(new java.awt.Color(239, 96, 0));
        txtPort.setColorIcon(new java.awt.Color(239, 96, 0));
        txtPort.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.PUBLIC);
        txtPort.setPhColor(new java.awt.Color(239, 96, 0));
        txtPort.setPlaceholder("Server Port");
        txtPort.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPortKeyReleased(evt);
            }
        });

        rSLabelTextIcon3.setForeground(new java.awt.Color(239, 96, 0));
        rSLabelTextIcon3.setText("Server Control");
        rSLabelTextIcon3.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DASHBOARD);

        btnStartServer.setBackground(new java.awt.Color(239, 96, 0));
        btnStartServer.setText("Start Server");
        btnStartServer.setBackgroundHover(new java.awt.Color(255, 137, 25));
        btnStartServer.setEnabled(false);
        btnStartServer.setForegroundIcon(new java.awt.Color(0, 255, 0));
        btnStartServer.setForegroundText(new java.awt.Color(0, 255, 0));
        btnStartServer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnStartServer.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.PLAY_ARROW);
        btnStartServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartServerActionPerformed(evt);
            }
        });

        btnStopServer.setBackground(new java.awt.Color(239, 96, 0));
        btnStopServer.setText("Stop Server");
        btnStopServer.setBackgroundHover(new java.awt.Color(255, 137, 25));
        btnStopServer.setEnabled(false);
        btnStopServer.setForegroundIcon(new java.awt.Color(0, 0, 204));
        btnStopServer.setForegroundText(new java.awt.Color(0, 0, 204));
        btnStopServer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnStopServer.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.STOP);
        btnStopServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopServerActionPerformed(evt);
            }
        });

        btnLoadDefaultConfig.setBackground(new java.awt.Color(239, 96, 0));
        btnLoadDefaultConfig.setText("Default Config");
        btnLoadDefaultConfig.setBackgroundHover(new java.awt.Color(255, 137, 25));
        btnLoadDefaultConfig.setEnabled(false);
        btnLoadDefaultConfig.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnLoadDefaultConfig.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ASSIGNMENT_RETURNED);
        btnLoadDefaultConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadDefaultConfigActionPerformed(evt);
            }
        });

        btnSaveConfig.setBackground(new java.awt.Color(239, 96, 0));
        btnSaveConfig.setText("Save Config");
        btnSaveConfig.setBackgroundHover(new java.awt.Color(255, 137, 25));
        btnSaveConfig.setEnabled(false);
        btnSaveConfig.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSaveConfig.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SAVE);
        btnSaveConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveConfigActionPerformed(evt);
            }
        });

        rSLabelTextIcon4.setForeground(new java.awt.Color(239, 96, 0));
        rSLabelTextIcon4.setText("Online Users");

        txtOnlineUsers.setColumns(20);
        txtOnlineUsers.setRows(5);
        jScrollPane2.setViewportView(txtOnlineUsers);

        btnReloadOnlineUsers.setBackground(new java.awt.Color(239, 96, 0));
        btnReloadOnlineUsers.setBackgroundHover(new java.awt.Color(255, 137, 25));
        btnReloadOnlineUsers.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.AUTORENEW);
        btnReloadOnlineUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReloadOnlineUsersActionPerformed(evt);
            }
        });

        btnSaveLog.setBackground(new java.awt.Color(239, 96, 0));
        btnSaveLog.setText("Save Server Log");
        btnSaveLog.setBackgroundHover(new java.awt.Color(255, 137, 25));
        btnSaveLog.setEnabled(false);
        btnSaveLog.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSaveLog.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SECURITY);
        btnSaveLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveLogActionPerformed(evt);
            }
        });

        btnCopyClientKey.setBackground(new java.awt.Color(239, 96, 0));
        btnCopyClientKey.setText("Copy Client Key");
        btnCopyClientKey.setBackgroundHover(new java.awt.Color(255, 137, 25));
        btnCopyClientKey.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCopyClientKey.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.LOCK);
        btnCopyClientKey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCopyClientKeyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(rSLabelTextIcon1, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)))
                    .addComponent(btnSaveLog, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnStartServer, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(rSLabelTextIcon3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(rSLabelTextIcon2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                    .addComponent(txtPort, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                    .addComponent(btnLoadDefaultConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnSaveConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnStopServer, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addComponent(rSLabelTextIcon4, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnReloadOnlineUsers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnCopyClientKey, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        MainPanelLayout.setVerticalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainPanelLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addComponent(rSLabelTextIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rSLabelTextIcon2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCopyClientKey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(MainPanelLayout.createSequentialGroup()
                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rSLabelTextIcon4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLoadDefaultConfig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSaveConfig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)
                                .addComponent(rSLabelTextIcon3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnStartServer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnStopServer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnSaveLog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(MainPanelLayout.createSequentialGroup()
                                .addComponent(btnReloadOnlineUsers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2)))))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(MainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveConfigActionPerformed
        String DefPortPath = "./serverfiles/defaultport.sconf";
        File f = new File(DefPortPath);

        try {
            try (FileWriter fw = new FileWriter(f)) {
                fw.write(txtPort.getText());
                txtLog.setText("PORT CONFIGURATION SAVED\n");
                btnLoadDefaultConfig.setEnabled(true);
            }
        } catch (IOException ex) {
            txtLog.setText("COULD NOT CREATE CONFIGURATION FILE\n");
        }
        checkPort();
    }//GEN-LAST:event_btnSaveConfigActionPerformed

    private void btnLoadDefaultConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadDefaultConfigActionPerformed
        String DefPortPath = "./serverfiles/defaultport.sconf";
        File f = new File(DefPortPath);
        try {
            char[] port = new char[4];
            try (FileReader fr = new FileReader(f)) {
                fr.read(port);
            }
            txtPort.setText(new String(port));
        } catch (FileNotFoundException ex) {
            txtLog.setText("DEFAULT CONFIG DOESN'T EXISTS\n");
        } catch (IOException ex) {
            txtLog.setText("COULD NOT READ CONFIGURATION FILE\n");
        }
        checkPort();
    }//GEN-LAST:event_btnLoadDefaultConfigActionPerformed

    private void btnStopServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStopServerActionPerformed
        server.stop();
        btnStopServer.setEnabled(false);
        btnStartServer.setEnabled(true);
        btnLoadDefaultConfig.setEnabled(true);
        txtPort.setEditable(true);
        btnSaveConfig.setEnabled(true);
        btnSaveLog.setEnabled(false);
        saveServerLog();
        txtLog.setText("SERVER RUNNING ENDED\n");
    }//GEN-LAST:event_btnStopServerActionPerformed

    private void btnStartServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartServerActionPerformed
        server = new LoginServer(Integer.parseInt(txtPort.getText()), this.txtLog);
        Thread serverThr = new Thread(server);
        serverThr.start();
        btnStartServer.setEnabled(false);
        btnStopServer.setEnabled(true);
        txtPort.setEditable(false);
        btnSaveConfig.setEnabled(false);
        btnSaveLog.setEnabled(true);
        btnLoadDefaultConfig.setEnabled(false);
    }//GEN-LAST:event_btnStartServerActionPerformed

    private void txtPortKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPortKeyReleased
        checkPort();
    }//GEN-LAST:event_txtPortKeyReleased

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if(btnStopServer.isEnabled())
            btnStopServer.doClick();
    }//GEN-LAST:event_formWindowClosing

    private void btnReloadOnlineUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReloadOnlineUsersActionPerformed
        try {
            loadOnlineUsers();
        } catch (SQLException ex) {
            Logger.getLogger(ServerConfigGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnReloadOnlineUsersActionPerformed

    private void btnSaveLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveLogActionPerformed
        saveServerLog();
        txtLog.setText("");
    }//GEN-LAST:event_btnSaveLogActionPerformed

    private void btnCopyClientKeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCopyClientKeyActionPerformed
        CopyToGUI copy = new CopyToGUI(ServerPreferencesAdmin.getInstance().getRandomKeyPath());
        copy.setVisible(true);
    }//GEN-LAST:event_btnCopyClientKeyActionPerformed

    private void loadOnlineUsers() throws SQLException{
        txtOnlineUsers.setText("");
        String sql = "SELECT USERNAME FROM USERS WHERE ONLINE=TRUE;";
        SQLiteManager man = SQLiteManager.getSingletonInstance();
        ResultSet rs = man.executeQuery(sql);
        while(rs.next()){
            txtOnlineUsers.append(rs.getString(1)+"\n");
        }
    }
    
    private void checkPort(){
        try{
            int sPort = Integer.parseInt(txtPort.getText());
            if(sPort >= 7000 && sPort < 10000){
                txtLog.setText("CORRECT PORT FORMAT:\nENABLING SERVER\n");
                btnStartServer.setEnabled(true);
                btnSaveConfig.setEnabled(true);
            }else{
                txtLog.setText("INCORRECT PORT VALUE:\nMUST BE BETWEEN 7000 AND 9999\n");
                btnStartServer.setEnabled(false);
                btnSaveConfig.setEnabled(false);
            }
        }catch(NumberFormatException ex){
            txtLog.setText("UNSUPPORTED PORT FORMAT:\nMUST BE A NUMBER\n");
            btnStartServer.setEnabled(false);
            btnSaveConfig.setEnabled(false);
        }
    }
    
    LoginServer server;
    private void saveServerLog(){
        if(!txtLog.getText().isBlank()){
            Date now = new Date();
            String dateString = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss_S").format(now);
            String ServerLogFile = "./serverfiles/serverlog_"+dateString+".log";
            File f = new File(ServerLogFile);
            try(FileWriter fw = new FileWriter(f)){
                fw.append(txtLog.getText());
                fw.flush();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "LOG COULD NOT BE SAVED IN THIS SESSION");
            }
        }
    }
    
        
    private boolean moveRightClicked = false;
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
            java.util.logging.Logger.getLogger(ServerConfigGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServerConfigGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServerConfigGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServerConfigGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServerConfigGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MainPanel;
    private RSMaterialComponent.RSButtonMaterialIconOne btnCopyClientKey;
    private RSMaterialComponent.RSButtonMaterialIconTwo btnLoadDefaultConfig;
    private RSMaterialComponent.RSButtonIconTwo btnReloadOnlineUsers;
    private RSMaterialComponent.RSButtonMaterialIconTwo btnSaveConfig;
    private RSMaterialComponent.RSButtonMaterialIconOne btnSaveLog;
    private RSMaterialComponent.RSButtonMaterialIconOne btnStartServer;
    private RSMaterialComponent.RSButtonMaterialIconOne btnStopServer;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private RSMaterialComponent.RSLabelTextIcon rSLabelTextIcon1;
    private RSMaterialComponent.RSLabelTextIcon rSLabelTextIcon2;
    private RSMaterialComponent.RSLabelTextIcon rSLabelTextIcon3;
    private RSMaterialComponent.RSLabelTextIcon rSLabelTextIcon4;
    private javax.swing.JTextArea txtLog;
    private javax.swing.JTextArea txtOnlineUsers;
    private RSMaterialComponent.RSTextFieldIconOne txtPort;
    // End of variables declaration//GEN-END:variables

    private void checkIfDefaultConfigExists() {
        String DefPortPath = "./serverfiles/defaultport.sconf";
        File f = new File(DefPortPath);
        if(f.exists()){
            btnLoadDefaultConfig.setEnabled(true);
            btnLoadDefaultConfig.doClick();
        }else{
            f = new File("./serverfiles/");
            if(!f.exists())
                f.mkdir();
        }
    }

    private void checkIfIsFirstRunning() {
        String DefPortPath = "./serverfiles/server.db";
        File f = new File(DefPortPath);
        if(!f.exists()){
            //Si la base de datos no existe debemos configurar el usuario principal y crear una nueva contraseña de encriptacion
            FirstRunningConfigGUI conf = new FirstRunningConfigGUI(this);
            conf.setVisible(true);
            ConfigureEncryptionPasswordGUI encPass = new ConfigureEncryptionPasswordGUI(this);
            encPass.setVisible(true);
        }
    }
    
}