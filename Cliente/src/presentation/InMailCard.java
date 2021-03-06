/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import domain.InMail;
import domain.RegistredUser;
import java.awt.Color;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author erome
 */
public class InMailCard extends javax.swing.JPanel {
    
    private static final Color NOT_READED = new Color(50,51,52);
    private static final Color READED = new Color(102, 102, 102);
    
    private String source, destination, subject, content;
    private boolean readed;
    private Date date;
    private JPanel readingpanel;
    private RegistredUser myUser;
    private InMail mail;
    public InMailCard(InMail mail, JPanel readingpanel, RegistredUser myUser) {
        this();
        this.myUser = myUser;
        this.mail = mail;
        
        this.source = mail.getSource();
        this.subject = mail.getSubject();
        this.destination = mail.getDestination();
        this.content = mail.getContent();
        this.readed = mail.isReaded();
        this.date = mail.getSend_date();
        this.readingpanel = readingpanel;
        
        this.lblSource.setText(source);
        this.lblSubject.setText(subject);
        this.lblDate.setText(date.toString());
        this.lblDate.setToolTipText(date.toString());
        
        if(readed){
            this.MailPanel.setBackground(READED);
        }else{
            this.MailPanel.setBackground(NOT_READED);
        }
    }
    
    public InMailCard() {
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

        MailPanel = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        lblSource = new javax.swing.JLabel();
        lblSubject = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        MailPanel.setBackground(new java.awt.Color(50, 51, 52));
        MailPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 96, 0), 2));

        lblSource.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblSource.setForeground(new java.awt.Color(255, 255, 255));
        lblSource.setText("Source");

        lblSubject.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblSubject.setForeground(new java.awt.Color(255, 255, 255));
        lblSubject.setText("Subject");

        lblDate.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblDate.setForeground(new java.awt.Color(255, 255, 255));
        lblDate.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblDate.setText("Date");

        javax.swing.GroupLayout MailPanelLayout = new javax.swing.GroupLayout(MailPanel);
        MailPanel.setLayout(MailPanelLayout);
        MailPanelLayout.setHorizontalGroup(
            MailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MailPanelLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jSeparator1))
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(MailPanelLayout.createSequentialGroup()
                .addGroup(MailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MailPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblSource, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MailPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(MailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(MailPanelLayout.createSequentialGroup()
                                .addComponent(lblSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MailPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        MailPanelLayout.setVerticalGroup(
            MailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MailPanelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(lblSource)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(lblDate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MailPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MailPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private static final String html = "<html><body style='width: %1spx'>%1s"; //Se utiliza para hacer el Wrapping del texto por palabras
    
    //convierto el formulario en un "boton" con el contenido personalizado
    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        JLabel lblSource_ = new JLabel(), lblDestination_ = new JLabel(), lblSubject_ = new JLabel(), lblContent_ = new JLabel(), lblDate_ = new JLabel();
        lblSource_.setText("From: "+source);
        lblDestination_.setText("To: "+destination);
        lblSubject_.setText(String.format(html, this.readingpanel.getWidth()-100, subject));
        lblContent_.setText(String.format(html, this.readingpanel.getWidth()-100, content));
        lblDate_.setText(date.toString());
        
        
        JSeparator sep = new JSeparator();
        
        this.readingpanel.removeAll();
        this.readingpanel.setBorder(new EmptyBorder(15, 15, 15, 15));
        this.readingpanel.add(lblDate_);
        this.readingpanel.add(lblSource_);
        this.readingpanel.add(lblDestination_);
        this.readingpanel.add(lblSubject_);
        this.readingpanel.add(sep);
        this.readingpanel.add(lblContent_);
        this.readingpanel.revalidate();
        this.readingpanel.repaint();
        
        if(!readed && !source.equals(myUser.getUsername())){
            readed = true;
            //comunicar la lectura al servidor (solo se hara una vez)
            mail.getDao().communicateReaded(mail);
        }
        
        if(readed){
            this.MailPanel.setBackground(READED);
        }
        
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MailPanel;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblSource;
    private javax.swing.JLabel lblSubject;
    // End of variables declaration//GEN-END:variables
}
