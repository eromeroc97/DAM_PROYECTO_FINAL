/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import domain.Product;
import java.awt.event.KeyEvent;
import utilities.PropertiesController;
import utilities.Utilidades;

/**
 *
 * @author erome
 */
public class ProductEditorGUI extends javax.swing.JDialog {

    private Product product;
    private boolean editionmode;
    
    public ProductEditorGUI(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        editionmode = false;
    }
    
    public ProductEditorGUI(java.awt.Frame parent, boolean modal, Product product) {
        this(parent, modal);
        this.product = product;
        editionmode = true;
        this.txtName.setText(product.getProductname());
        this.txtPrice.setText(Double.toString(product.getPrice()));
        this.txtStock.setText(Integer.toString(product.getStock()));
        this.txtSecStock.setText(Integer.toString(product.getSecuritystock()));
        this.txtMinStock.setText(Integer.toString(product.getMinimumstock()));
        this.txtOrderAmount.setText(Integer.toString(product.getDefaultorderamount()));
        if(product.getDefaultorderamount() == 0){
            this.chkOrderAmount.setSelected(false);
            this.txtOrderAmount.setEnabled(false);
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

        mainPanel = new javax.swing.JPanel();
        lblProductEditor = new RSMaterialComponent.RSLabelTextIcon();
        txtName = new RSMaterialComponent.RSTextFieldMaterialIcon();
        txtPrice = new RSMaterialComponent.RSTextFieldMaterialIcon();
        lblStock = new javax.swing.JLabel();
        lblSegurityStock = new javax.swing.JLabel();
        lblMinimumStock = new javax.swing.JLabel();
        lblOrderAmount = new javax.swing.JLabel();
        chkOrderAmount = new RSMaterialComponent.RSCheckBoxMaterial();
        btnCancel = new RSMaterialComponent.RSButtonIconOne();
        btnDone = new RSMaterialComponent.RSButtonIconOne();
        txtStock = new RSMaterialComponent.RSTextFieldTwo();
        txtSecStock = new RSMaterialComponent.RSTextFieldTwo();
        txtMinStock = new RSMaterialComponent.RSTextFieldTwo();
        txtOrderAmount = new RSMaterialComponent.RSTextFieldTwo();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        mainPanel.setBackground(new java.awt.Color(50, 51, 52));
        mainPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 96, 0), 2));

        lblProductEditor.setForeground(new java.awt.Color(239, 96, 0));
        lblProductEditor.setText("Product Editor");
        lblProductEditor.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SHOPPING_BASKET);

        txtName.setForeground(new java.awt.Color(239, 96, 0));
        txtName.setColorIcon(new java.awt.Color(239, 96, 0));
        txtName.setColorMaterial(new java.awt.Color(239, 96, 0));
        txtName.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.INPUT);
        txtName.setPhColor(new java.awt.Color(239, 96, 0));
        txtName.setPlaceholder("Product Name");

        txtPrice.setForeground(new java.awt.Color(239, 96, 0));
        txtPrice.setColorIcon(new java.awt.Color(239, 96, 0));
        txtPrice.setColorMaterial(new java.awt.Color(239, 96, 0));
        txtPrice.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EURO_SYMBOL);
        txtPrice.setPhColor(new java.awt.Color(239, 96, 0));
        txtPrice.setPlaceholder("Product Price");
        txtPrice.setPositionIcon(rojeru_san.efectos.ValoresEnum.POSITIONICON.RIGHT);
        txtPrice.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPriceFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPriceFocusLost(evt);
            }
        });
        txtPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPriceKeyTyped(evt);
            }
        });

        lblStock.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblStock.setForeground(new java.awt.Color(255, 255, 255));
        lblStock.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStock.setText("Actual Stock");

        lblSegurityStock.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblSegurityStock.setForeground(new java.awt.Color(255, 255, 255));
        lblSegurityStock.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSegurityStock.setText("Security Stock");

        lblMinimumStock.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblMinimumStock.setForeground(new java.awt.Color(255, 255, 255));
        lblMinimumStock.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMinimumStock.setText("Minimum Stock");

        lblOrderAmount.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblOrderAmount.setForeground(new java.awt.Color(255, 255, 255));
        lblOrderAmount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblOrderAmount.setText("Order Amount");

        chkOrderAmount.setForeground(new java.awt.Color(239, 96, 0));
        chkOrderAmount.setText("Activate Auto Order");
        chkOrderAmount.setColorCheck(new java.awt.Color(255, 137, 25));
        chkOrderAmount.setColorUnCheck(new java.awt.Color(239, 96, 0));
        chkOrderAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkOrderAmountActionPerformed(evt);
            }
        });

        btnCancel.setBackground(new java.awt.Color(255, 0, 0));
        btnCancel.setBackgroundHover(new java.awt.Color(204, 0, 0));
        btnCancel.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CLOSE);
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnDone.setBackground(new java.awt.Color(0, 204, 0));
        btnDone.setBackgroundHover(new java.awt.Color(0, 153, 0));
        btnDone.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DONE);
        btnDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoneActionPerformed(evt);
            }
        });

        txtStock.setForeground(new java.awt.Color(239, 96, 0));
        txtStock.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtStock.setText("0");
        txtStock.setBorderColor(new java.awt.Color(239, 96, 0));
        txtStock.setPhColor(new java.awt.Color(239, 96, 0));
        txtStock.setPlaceholder("");
        txtStock.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtStockFocusGained(evt);
            }
        });
        txtStock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtStockKeyTyped(evt);
            }
        });

        txtSecStock.setForeground(new java.awt.Color(239, 96, 0));
        txtSecStock.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSecStock.setText("0");
        txtSecStock.setBorderColor(new java.awt.Color(239, 96, 0));
        txtSecStock.setPhColor(new java.awt.Color(239, 96, 0));
        txtSecStock.setPlaceholder("");
        txtSecStock.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSecStockFocusGained(evt);
            }
        });
        txtSecStock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSecStockKeyTyped(evt);
            }
        });

        txtMinStock.setForeground(new java.awt.Color(239, 96, 0));
        txtMinStock.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMinStock.setText("0");
        txtMinStock.setBorderColor(new java.awt.Color(239, 96, 0));
        txtMinStock.setPhColor(new java.awt.Color(239, 96, 0));
        txtMinStock.setPlaceholder("");
        txtMinStock.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMinStockFocusGained(evt);
            }
        });
        txtMinStock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMinStockKeyTyped(evt);
            }
        });

        txtOrderAmount.setForeground(new java.awt.Color(239, 96, 0));
        txtOrderAmount.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtOrderAmount.setText("0");
        txtOrderAmount.setBorderColor(new java.awt.Color(239, 96, 0));
        txtOrderAmount.setEnabled(false);
        txtOrderAmount.setPhColor(new java.awt.Color(239, 96, 0));
        txtOrderAmount.setPlaceholder("");
        txtOrderAmount.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtOrderAmountFocusGained(evt);
            }
        });
        txtOrderAmount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtOrderAmountKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblProductEditor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(chkOrderAmount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18))
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblOrderAmount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtOrderAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtPrice, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, mainPanelLayout.createSequentialGroup()
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                    .addComponent(lblStock, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSecStock, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                    .addComponent(lblSegurityStock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(txtName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMinStock, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(lblMinimumStock, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))))
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblProductEditor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStock)
                    .addComponent(lblSegurityStock)
                    .addComponent(lblMinimumStock))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSecStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMinStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(lblOrderAmount)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkOrderAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtOrderAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void chkOrderAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkOrderAmountActionPerformed
        if(chkOrderAmount.isSelected())
            txtOrderAmount.setEnabled(true);
        else{
            txtOrderAmount.setText("0");
            txtOrderAmount.setEnabled(false);
        }
    }//GEN-LAST:event_chkOrderAmountActionPerformed
 
    private void txtPriceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPriceKeyTyped
        char c = evt.getKeyChar();
        if (!((c >= '0') && (c <= '9') ||
           (c == KeyEvent.VK_BACK_SPACE) ||
           (c == KeyEvent.VK_DELETE) ||
                (c == '.') || (c == ','))) {
          getToolkit().beep();
          evt.consume();
        }
        boolean dot = txtPrice.getText().contains("."); //Si existe un '.' previamente
        if(c == ','){
            evt.setKeyChar('.');
            c = evt.getKeyChar();
        }
        if(c == '.' && dot){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtPriceKeyTyped

    private void txtStockKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStockKeyTyped
        char c = evt.getKeyChar();
        if (!((c >= '0') && (c <= '9') ||
           (c == KeyEvent.VK_BACK_SPACE) ||
           (c == KeyEvent.VK_DELETE))) {
          getToolkit().beep();
          evt.consume();
        }
    }//GEN-LAST:event_txtStockKeyTyped

    private void txtSecStockKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSecStockKeyTyped
        char c = evt.getKeyChar();
        if (!((c >= '0') && (c <= '9') ||
           (c == KeyEvent.VK_BACK_SPACE) ||
           (c == KeyEvent.VK_DELETE))) {
          getToolkit().beep();
          evt.consume();
        }
    }//GEN-LAST:event_txtSecStockKeyTyped

    private void txtMinStockKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMinStockKeyTyped
        char c = evt.getKeyChar();
        if (!((c >= '0') && (c <= '9') ||
           (c == KeyEvent.VK_BACK_SPACE) ||
           (c == KeyEvent.VK_DELETE))) {
          getToolkit().beep();
          evt.consume();
        }
    }//GEN-LAST:event_txtMinStockKeyTyped

    private void txtOrderAmountKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtOrderAmountKeyTyped
        char c = evt.getKeyChar();
        if (!((c >= '0') && (c <= '9') ||
           (c == KeyEvent.VK_BACK_SPACE) ||
           (c == KeyEvent.VK_DELETE))) {
          getToolkit().beep();
          evt.consume();
        }
    }//GEN-LAST:event_txtOrderAmountKeyTyped

    private void txtPriceFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPriceFocusLost
        String price = txtPrice.getText();
        double parser = Double.parseDouble(price);
        parser = Utilidades.round(parser, 2);
        txtPrice.setText(Double.toString(parser));
    }//GEN-LAST:event_txtPriceFocusLost
    
    private void btnDoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoneActionPerformed
        if(editionmode){ //editar
            product.setProductname(txtName.getText());
            product.setPrice(Double.parseDouble(txtPrice.getText()));
            product.setStock(Integer.parseInt(txtStock.getText()));
            product.setSecuritystock(Integer.parseInt(txtSecStock.getText()));
            product.setMinimumstock(Integer.parseInt(txtMinStock.getText()));
            product.setDefaultorderamount(Integer.parseInt(txtOrderAmount.getText()));
            
            product.getDao().editProduct(product);
        }else{ //crear
            Product prod = new Product(txtName.getText(),
            Double.parseDouble(txtPrice.getText()),
            Integer.parseInt(txtStock.getText()),
            Integer.parseInt(txtSecStock.getText()),
            Integer.parseInt(txtMinStock.getText()),
            Integer.parseInt(txtOrderAmount.getText()));
            
            prod.getDao().createProduct(prod);
        }
        
        this.dispose();
    }//GEN-LAST:event_btnDoneActionPerformed

    private void txtPriceFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPriceFocusGained
        txtPrice.selectAll();
    }//GEN-LAST:event_txtPriceFocusGained

    private void txtStockFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtStockFocusGained
        txtStock.selectAll();
    }//GEN-LAST:event_txtStockFocusGained

    private void txtSecStockFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSecStockFocusGained
        txtSecStock.selectAll();
    }//GEN-LAST:event_txtSecStockFocusGained

    private void txtMinStockFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMinStockFocusGained
        txtMinStock.selectAll();
    }//GEN-LAST:event_txtMinStockFocusGained

    private void txtOrderAmountFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtOrderAmountFocusGained
        if(txtOrderAmount.isEnabled())
            txtOrderAmount.selectAll();
    }//GEN-LAST:event_txtOrderAmountFocusGained

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        setLanguageUI();
    }//GEN-LAST:event_formWindowOpened

    private void setLanguageUI(){
        this.lblProductEditor.setText(PropertiesController.getLangValue("producteditor"));
        this.lblMinimumStock.setText(PropertiesController.getLangValue("minimumstock"));
        this.lblOrderAmount.setText(PropertiesController.getLangValue("defaultorderamount"));
        this.lblSegurityStock.setText(PropertiesController.getLangValue("securitystock"));
        this.lblStock.setText(PropertiesController.getLangValue("stock"));
        this.txtPrice.setPlaceholder(PropertiesController.getLangValue("providerprice"));
        this.txtName.setPlaceholder(PropertiesController.getLangValue("productname"));
        this.chkOrderAmount.setText(PropertiesController.getLangValue("activateautoorder"));
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
            java.util.logging.Logger.getLogger(ProductEditorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductEditorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductEditorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductEditorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ProductEditorGUI dialog = new ProductEditorGUI(new javax.swing.JFrame(), true);
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
    private RSMaterialComponent.RSButtonIconOne btnCancel;
    private RSMaterialComponent.RSButtonIconOne btnDone;
    private RSMaterialComponent.RSCheckBoxMaterial chkOrderAmount;
    private javax.swing.JLabel lblMinimumStock;
    private javax.swing.JLabel lblOrderAmount;
    private RSMaterialComponent.RSLabelTextIcon lblProductEditor;
    private javax.swing.JLabel lblSegurityStock;
    private javax.swing.JLabel lblStock;
    private javax.swing.JPanel mainPanel;
    private RSMaterialComponent.RSTextFieldTwo txtMinStock;
    private RSMaterialComponent.RSTextFieldMaterialIcon txtName;
    private RSMaterialComponent.RSTextFieldTwo txtOrderAmount;
    private RSMaterialComponent.RSTextFieldMaterialIcon txtPrice;
    private RSMaterialComponent.RSTextFieldTwo txtSecStock;
    private RSMaterialComponent.RSTextFieldTwo txtStock;
    // End of variables declaration//GEN-END:variables
}
