/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import domain.RegistredUser;
import domain.Role;
import java.awt.Toolkit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import utilities.PropertiesController;

/**
 *
 * @author erome
 */
public class MenuGUI extends javax.swing.JFrame {
    LoginGUI parent;   
    RegistredUser myUser;
    
    public MenuGUI(RegistredUser myUser, int port, LoginGUI parent) {
        this();
        RegistredUser appClientCreator = new RegistredUser(myUser.getUsername(), port);
        this.myUser = myUser;
        this.parent = parent;
        this.lblUsername.setText(myUser.getUsername());
        this.lblRolename.setText(myUser.getRole());
    }
    
    public MenuGUI() {
        initComponents();
        this.setLocationRelativeTo(this);
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

        MenuPanel = new javax.swing.JPanel();
        btnProfile = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnPreferences = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnMenu = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnLogOut = new RSMaterialComponent.RSButtonMaterialIconOne();
        MainPanel = new javax.swing.JPanel();
        btnMenuPanel = new rojerusan.RSPanelsSlider();
        lblConnectedAs = new javax.swing.JLabel();
        lblUsername = new RSMaterialComponent.RSLabelTextIcon();
        lblPermissionLevel = new javax.swing.JLabel();
        lblRolename = new RSMaterialComponent.RSLabelTextIcon();
        btnRoleinfo = new RSMaterialComponent.RSButtonIconOne();
        jSeparator1 = new javax.swing.JSeparator();
        ActionScroll = new javax.swing.JScrollPane();
        ActionPanel = new javax.swing.JPanel();
        btnAdminUsers = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnAdminProfiles = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnAdminRoles = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnSendAdverts = new RSMaterialComponent.RSButtonMaterialIconOne();
        OverMainPanel = new javax.swing.JPanel();
        btnNewSale = new newscomponents.RSButtonBigIcon_new();
        btnPrintReport = new newscomponents.RSButtonBigIcon_new();
        btnViewAdverts = new newscomponents.RSButtonBigIcon_new();
        btnConfirmOrders = new newscomponents.RSButtonBigIcon_new();
        btnRegisterProduct = new newscomponents.RSButtonBigIcon_new();
        btnInMail = new newscomponents.RSButtonBigIcon_new();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        MenuPanel.setBackground(new java.awt.Color(239, 96, 0));

        btnProfile.setBackground(new java.awt.Color(239, 96, 0));
        btnProfile.setText("Profile");
        btnProfile.setBackgroundHover(new java.awt.Color(255, 137, 25));
        btnProfile.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.PERSON);
        btnProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfileActionPerformed(evt);
            }
        });

        btnPreferences.setBackground(new java.awt.Color(239, 96, 0));
        btnPreferences.setText("Preferences");
        btnPreferences.setBackgroundHover(new java.awt.Color(255, 137, 25));
        btnPreferences.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SETTINGS);
        btnPreferences.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreferencesActionPerformed(evt);
            }
        });

        btnMenu.setBackground(new java.awt.Color(239, 96, 0));
        btnMenu.setText("Menu");
        btnMenu.setBackgroundHover(new java.awt.Color(255, 137, 25));
        btnMenu.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.MENU);
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });

        btnLogOut.setBackground(new java.awt.Color(239, 96, 0));
        btnLogOut.setText("LogOut");
        btnLogOut.setBackgroundHover(new java.awt.Color(204, 0, 0));
        btnLogOut.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btnLogOut.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnLogOut.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXIT_TO_APP);
        btnLogOut.setPositionIcon(rojeru_san.efectos.ValoresEnum.POSITIONICON.RIGHT);
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MenuPanelLayout = new javax.swing.GroupLayout(MenuPanel);
        MenuPanel.setLayout(MenuPanelLayout);
        MenuPanelLayout.setHorizontalGroup(
            MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuPanelLayout.createSequentialGroup()
                .addComponent(btnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnPreferences, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        MenuPanelLayout.setVerticalGroup(
            MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnProfile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnPreferences, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        MainPanel.setBackground(new java.awt.Color(204, 204, 255));
        MainPanel.setMinimumSize(new java.awt.Dimension(670, 310));
        MainPanel.setPreferredSize(new java.awt.Dimension(435, 317));
        MainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnMenuPanel.setBackground(new java.awt.Color(102, 102, 102));
        btnMenuPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblConnectedAs.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblConnectedAs.setForeground(new java.awt.Color(255, 255, 255));
        lblConnectedAs.setText("Connected as");
        btnMenuPanel.add(lblConnectedAs, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        lblUsername.setForeground(new java.awt.Color(255, 255, 255));
        lblUsername.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblUsername.setText("Username");
        lblUsername.setToolTipText("");
        btnMenuPanel.add(lblUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 32, -1, -1));

        lblPermissionLevel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPermissionLevel.setForeground(new java.awt.Color(255, 255, 255));
        lblPermissionLevel.setText("Permission level");
        btnMenuPanel.add(lblPermissionLevel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 78, -1, -1));

        lblRolename.setForeground(new java.awt.Color(255, 255, 255));
        lblRolename.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblRolename.setText("Rolename");
        lblRolename.setFont(new java.awt.Font("Roboto Bold", 1, 11)); // NOI18N
        lblRolename.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.FINGERPRINT);
        lblRolename.setSizeIcon(25.0F);
        btnMenuPanel.add(lblRolename, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 98, 145, 28));

        btnRoleinfo.setBackground(new java.awt.Color(239, 96, 0));
        btnRoleinfo.setBackgroundHover(new java.awt.Color(255, 137, 25));
        btnRoleinfo.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.INFO_OUTLINE);
        btnRoleinfo.setSizeIcon(18.0F);
        btnRoleinfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRoleinfoActionPerformed(evt);
            }
        });
        btnMenuPanel.add(btnRoleinfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 96, 30, 30));
        btnMenuPanel.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 132, 222, 10));

        ActionScroll.setBackground(new java.awt.Color(0, 0, 51));
        ActionScroll.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 51)));
        ActionScroll.setHorizontalScrollBar(null);

        btnAdminUsers.setBackground(new java.awt.Color(239, 96, 0));
        btnAdminUsers.setText("Admin Users");
        btnAdminUsers.setBackgroundHover(new java.awt.Color(255, 137, 25));
        btnAdminUsers.setEnabled(false);
        btnAdminUsers.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.PEOPLE);
        btnAdminUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminUsersActionPerformed(evt);
            }
        });

        btnAdminProfiles.setBackground(new java.awt.Color(239, 96, 0));
        btnAdminProfiles.setText("Admin Profiles");
        btnAdminProfiles.setBackgroundHover(new java.awt.Color(255, 137, 25));
        btnAdminProfiles.setEnabled(false);
        btnAdminProfiles.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CONTACTS);
        btnAdminProfiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminProfilesActionPerformed(evt);
            }
        });

        btnAdminRoles.setBackground(new java.awt.Color(239, 96, 0));
        btnAdminRoles.setText("Admin Roles");
        btnAdminRoles.setBackgroundHover(new java.awt.Color(255, 137, 25));
        btnAdminRoles.setEnabled(false);
        btnAdminRoles.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.FINGERPRINT);
        btnAdminRoles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminRolesActionPerformed(evt);
            }
        });

        btnSendAdverts.setBackground(new java.awt.Color(239, 96, 0));
        btnSendAdverts.setText("Send Adverts");
        btnSendAdverts.setBackgroundHover(new java.awt.Color(255, 137, 25));
        btnSendAdverts.setEnabled(false);
        btnSendAdverts.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.NEW_RELEASES);
        btnSendAdverts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendAdvertsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ActionPanelLayout = new javax.swing.GroupLayout(ActionPanel);
        ActionPanel.setLayout(ActionPanelLayout);
        ActionPanelLayout.setHorizontalGroup(
            ActionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ActionPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(ActionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdminUsers, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdminProfiles, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdminRoles, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSendAdverts, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        ActionPanelLayout.setVerticalGroup(
            ActionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ActionPanelLayout.createSequentialGroup()
                .addComponent(btnAdminUsers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnAdminProfiles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnAdminRoles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnSendAdverts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        ActionScroll.setViewportView(ActionPanel);

        btnMenuPanel.add(ActionScroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, 158));

        MainPanel.add(btnMenuPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(-220, 0, 220, 317));

        OverMainPanel.setBackground(new java.awt.Color(50, 51, 52));

        btnNewSale.setBackground(new java.awt.Color(239, 96, 0));
        btnNewSale.setText("New Sale");
        btnNewSale.setBgHover(new java.awt.Color(255, 137, 25));
        btnNewSale.setEnabled(false);
        btnNewSale.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.MONETIZATION_ON);
        btnNewSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewSaleActionPerformed(evt);
            }
        });

        btnPrintReport.setBackground(new java.awt.Color(239, 96, 0));
        btnPrintReport.setText("Print Report");
        btnPrintReport.setBgHover(new java.awt.Color(255, 137, 25));
        btnPrintReport.setEnabled(false);
        btnPrintReport.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.PRINT);
        btnPrintReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintReportActionPerformed(evt);
            }
        });

        btnViewAdverts.setBackground(new java.awt.Color(239, 96, 0));
        btnViewAdverts.setText("View Adverts");
        btnViewAdverts.setBgHover(new java.awt.Color(255, 137, 25));
        btnViewAdverts.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.NEW_RELEASES);
        btnViewAdverts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewAdvertsActionPerformed(evt);
            }
        });

        btnConfirmOrders.setBackground(new java.awt.Color(239, 96, 0));
        btnConfirmOrders.setText("Confirm Orders");
        btnConfirmOrders.setBgHover(new java.awt.Color(255, 137, 25));
        btnConfirmOrders.setEnabled(false);
        btnConfirmOrders.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SHOP);
        btnConfirmOrders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmOrdersActionPerformed(evt);
            }
        });

        btnRegisterProduct.setBackground(new java.awt.Color(239, 96, 0));
        btnRegisterProduct.setText("Register Product");
        btnRegisterProduct.setBgHover(new java.awt.Color(255, 137, 25));
        btnRegisterProduct.setEnabled(false);
        btnRegisterProduct.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SHOPPING_CART);
        btnRegisterProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterProductActionPerformed(evt);
            }
        });

        btnInMail.setBackground(new java.awt.Color(239, 96, 0));
        btnInMail.setText("In Mail");
        btnInMail.setBgHover(new java.awt.Color(255, 137, 25));
        btnInMail.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.MAIL_OUTLINE);
        btnInMail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInMailActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout OverMainPanelLayout = new javax.swing.GroupLayout(OverMainPanel);
        OverMainPanel.setLayout(OverMainPanelLayout);
        OverMainPanelLayout.setHorizontalGroup(
            OverMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OverMainPanelLayout.createSequentialGroup()
                .addGroup(OverMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(OverMainPanelLayout.createSequentialGroup()
                        .addComponent(btnRegisterProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnConfirmOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(OverMainPanelLayout.createSequentialGroup()
                        .addComponent(btnNewSale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPrintReport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(OverMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnViewAdverts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        OverMainPanelLayout.setVerticalGroup(
            OverMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OverMainPanelLayout.createSequentialGroup()
                .addGroup(OverMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNewSale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPrintReport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnViewAdverts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(OverMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnConfirmOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegisterProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        MainPanel.add(OverMainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 310));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MenuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(MainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(MenuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(MainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        myUser.getDao().LogOut();
        endConnection(); //Deletes all dao's instances
        parent.setVisible(true);
        parent.setLanguageUI();
        this.dispose();
    }//GEN-LAST:event_btnLogOutActionPerformed

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        showHideMenu();
    }//GEN-LAST:event_btnMenuActionPerformed

    private void btnRoleinfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRoleinfoActionPerformed
        Role role = new Role();
        LinkedList<domain.Permission> perms = role.getDao().getPermissionList(myUser.getRole());
        String texto = "";
        for(int i = 0; i < perms.size(); i++)
            texto+=perms.get(i).getPermname()+"\n";
        utilities.MsgBox.create(this, texto, utilities.MsgBox.INFO_ICON).setVisible(true);
    }//GEN-LAST:event_btnRoleinfoActionPerformed

    private void btnInMailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInMailActionPerformed
        InMailGUI mail = new InMailGUI(this, myUser);
        this.setVisible(false);
        mail.setVisible(true);
    }//GEN-LAST:event_btnInMailActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        setLanguageUI();
        checkUserPermissions();
        showHideMenu();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(MenuGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        showHideMenu();
        isFirstConnection();
    }//GEN-LAST:event_formWindowOpened

    private void btnPreferencesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreferencesActionPerformed
        ClientPreferencesGUI prefgui = new ClientPreferencesGUI(this);
        prefgui.setVisible(true);
    }//GEN-LAST:event_btnPreferencesActionPerformed

    private void btnAdminUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminUsersActionPerformed
        AdminUsersGUI gui = new AdminUsersGUI(this, this.myUser);
        gui.setVisible(true);
    }//GEN-LAST:event_btnAdminUsersActionPerformed

    private void btnProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfileActionPerformed
        ProfileEditorGUI pEditGui = new ProfileEditorGUI(this, true, myUser);
        pEditGui.setVisible(true);
    }//GEN-LAST:event_btnProfileActionPerformed

    private void btnAdminProfilesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminProfilesActionPerformed
        AdminProfilesGUI admProfGui = new AdminProfilesGUI(this, myUser);
        admProfGui.setVisible(true);
    }//GEN-LAST:event_btnAdminProfilesActionPerformed

    private void btnAdminRolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminRolesActionPerformed
        AdminRolesGUI rolGui = new AdminRolesGUI(this, myUser);
        rolGui.setVisible(true);
    }//GEN-LAST:event_btnAdminRolesActionPerformed

    private void btnRegisterProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterProductActionPerformed
        ProductsGUI prod = new ProductsGUI(this, true);
        prod.setVisible(true);
    }//GEN-LAST:event_btnRegisterProductActionPerformed

    private void btnConfirmOrdersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmOrdersActionPerformed
        ConfirmOrdersGUI cogui = new ConfirmOrdersGUI(this, true);
        cogui.setVisible(true);
    }//GEN-LAST:event_btnConfirmOrdersActionPerformed

    private void btnPrintReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintReportActionPerformed
        PrintReportGUI prgui = new PrintReportGUI(this, true);
        prgui.setVisible(true);
    }//GEN-LAST:event_btnPrintReportActionPerformed

    private void btnNewSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewSaleActionPerformed
        NewSaleGUI nsgui = new NewSaleGUI(this, true, myUser);
        nsgui.setVisible(true);
    }//GEN-LAST:event_btnNewSaleActionPerformed

    private void btnViewAdvertsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewAdvertsActionPerformed
        ViewAdvertsGUI vagui = new ViewAdvertsGUI(this, true);
        vagui.setVisible(true);
    }//GEN-LAST:event_btnViewAdvertsActionPerformed

    private void btnSendAdvertsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendAdvertsActionPerformed
        SendAdvertGUI sagui = new SendAdvertGUI(this, true, myUser);
        sagui.setVisible(true);
    }//GEN-LAST:event_btnSendAdvertsActionPerformed
    
    public void setLanguageUI(){
        this.btnMenu.setText(PropertiesController.getLangValue("menu"));
        this.btnProfile.setText(PropertiesController.getLangValue("profile"));
        this.btnPreferences.setText(PropertiesController.getLangValue("preferences"));
        this.btnLogOut.setText(PropertiesController.getLangValue("logout"));
        this.btnNewSale.setText(PropertiesController.getLangValue("newsale"));
        this.btnPrintReport.setText(PropertiesController.getLangValue("printreport"));
        this.btnViewAdverts.setText(PropertiesController.getLangValue("viewadverts"));
        this.btnInMail.setText(PropertiesController.getLangValue("inmail"));
        this.btnConfirmOrders.setText(PropertiesController.getLangValue("confirmorders"));
        this.btnRegisterProduct.setText(PropertiesController.getLangValue("registerproduct"));
        this.lblConnectedAs.setText(PropertiesController.getLangValue("connectedas"));
        this.lblPermissionLevel.setText(PropertiesController.getLangValue("permissionlevel"));
        this.btnAdminUsers.setText(PropertiesController.getLangValue("adminusers"));
        this.btnAdminProfiles.setText(PropertiesController.getLangValue("adminprofiles"));
        this.btnAdminRoles.setText(PropertiesController.getLangValue("adminroles"));
        this.btnSendAdverts.setText(PropertiesController.getLangValue("sendadverts"));
    }
    
    private void checkUserPermissions(){
        LinkedList<domain.Permission> permissions = (new Role()).getDao().getPermissionList(this.myUser.getRole());
        
        LinkedList<String> perms = new LinkedList<>();
        for(int i = 0; i < permissions.size(); i++)
            perms.add(permissions.get(i).getPermname());
            
        if(perms.contains(PropertiesController.getValue("perm_administrate_users")))
            this.btnAdminUsers.setEnabled(true);
        else
            this.btnAdminUsers.setEnabled(false);

        if(perms.contains(PropertiesController.getValue("perm_administrate_profiles")))
            this.btnAdminProfiles.setEnabled(true);
        else
            this.btnAdminProfiles.setEnabled(false);

        if(perms.contains(PropertiesController.getValue("perm_administrate_roles")))
            this.btnAdminRoles.setEnabled(true);
        else
            this.btnAdminRoles.setEnabled(false);

        if(perms.contains(PropertiesController.getValue("perm_send_adverts")))
            this.btnSendAdverts.setEnabled(true);
        else
            this.btnSendAdverts.setEnabled(false);

        if(perms.contains(PropertiesController.getValue("perm_print_reports")))
            this.btnPrintReport.setEnabled(true);
        else
            this.btnPrintReport.setEnabled(false);

        if(perms.contains(PropertiesController.getValue("perm_sell_products")))
            this.btnNewSale.setEnabled(true);
        else
            this.btnNewSale.setEnabled(false);

        if(perms.contains(PropertiesController.getValue("perm_register_products")))
            this.btnRegisterProduct.setEnabled(true);
        else
            this.btnRegisterProduct.setEnabled(false);

        if(perms.contains(PropertiesController.getValue("perm_confirm_orders")))
            this.btnConfirmOrders.setEnabled(true);
        else
            this.btnConfirmOrders.setEnabled(false);
        
    }
    
    private void endConnection(){
        new domain.Role().getDao().endConnection();
        new domain.InMail().getDao().endConnection();
    }
    
    private void showHideMenu(){
        final int MOV = 4;
        final int RET = 2;
        int position = OverMainPanel.getX();
        if(position > 5){
            //Libreria modificada RojeruSan de animaciones
            //PARAMETROS DE LOS METODOS DE ANIMACION: int inicio, int fin, long retardo, int salto, JComponent componente
            Animacion.Animacion.mover_izquierda(220, 0, RET, MOV, OverMainPanel);
            Animacion.Animacion.mover_izquierda(0, -220, RET, MOV, btnMenuPanel);
        }else{
            Animacion.Animacion.mover_derecha(0, 220, RET, MOV, OverMainPanel);
            Animacion.Animacion.mover_derecha(-220, 0, RET, MOV, btnMenuPanel);
        }
    }
    
    private void isFirstConnection(){
        try {
            if(myUser.getLastConnection().equals(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse("01-01-2000 00:00:00"))){
                ChangePasswordGUI cpass = new ChangePasswordGUI(this, true, myUser);
                cpass.setVisible(true);
            }
        } catch (ParseException ex) {
            Logger.getLogger(MenuGUI.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(MenuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ActionPanel;
    private javax.swing.JScrollPane ActionScroll;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JPanel MenuPanel;
    private javax.swing.JPanel OverMainPanel;
    private RSMaterialComponent.RSButtonMaterialIconOne btnAdminProfiles;
    private RSMaterialComponent.RSButtonMaterialIconOne btnAdminRoles;
    private RSMaterialComponent.RSButtonMaterialIconOne btnAdminUsers;
    private newscomponents.RSButtonBigIcon_new btnConfirmOrders;
    private newscomponents.RSButtonBigIcon_new btnInMail;
    private RSMaterialComponent.RSButtonMaterialIconOne btnLogOut;
    private RSMaterialComponent.RSButtonMaterialIconOne btnMenu;
    private rojerusan.RSPanelsSlider btnMenuPanel;
    private newscomponents.RSButtonBigIcon_new btnNewSale;
    private RSMaterialComponent.RSButtonMaterialIconOne btnPreferences;
    private newscomponents.RSButtonBigIcon_new btnPrintReport;
    private RSMaterialComponent.RSButtonMaterialIconOne btnProfile;
    private newscomponents.RSButtonBigIcon_new btnRegisterProduct;
    private RSMaterialComponent.RSButtonIconOne btnRoleinfo;
    private RSMaterialComponent.RSButtonMaterialIconOne btnSendAdverts;
    private newscomponents.RSButtonBigIcon_new btnViewAdverts;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblConnectedAs;
    private javax.swing.JLabel lblPermissionLevel;
    private RSMaterialComponent.RSLabelTextIcon lblRolename;
    private RSMaterialComponent.RSLabelTextIcon lblUsername;
    // End of variables declaration//GEN-END:variables
}
