/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import utilities.Utilidades;

/**
 *
 * @author erome
 */
public class LoginServer implements Runnable{
    
    private final int PORT;
    private final static int REFUSED = -1;
    
    private JTextArea txtLog;
    private boolean exit = false;
    
    private SQLiteManager man;
    
    public LoginServer(int port, JTextArea txtLog){
        this.txtLog = txtLog;
        this.PORT = port;
        this.man = SQLiteManager.getSingletonInstance();
    }
    
    private ServerSocket socketServidor;
    private void servir() throws IOException{
        
        socketServidor=
                new ServerSocket(this.PORT);
        txtLog.setText("SERVER RUNNING ON PORT: "+this.PORT+"\n\n");
        while (!exit){
            /*1. Esperar que llegue una petición*/
            Socket socketConCliente;
            socketConCliente=socketServidor.accept();
            ConnectionResolver p=new ConnectionResolver(socketConCliente);
            Thread hiloAsociado=new Thread(p);
            if(!exit)
                hiloAsociado.start();            
        }
    }

    @Override
    public void run() {
        try {
            this.servir();
        } catch (IOException ex) {
        }
    }
    
    public void stop(){
        exit = true;
        man.executeNonQuery("UPDATE USERS SET ONLINE=FALSE;");
        try {
            socketServidor.close();
        } catch (IOException ex) {
            txtLog.append("SERVER PORT COULD NOT BE CLOSED, PLEASE RESTART SERVER");
        }
    }
    
    
    private class ConnectionResolver implements Runnable{
        private Socket connection;
        
        public ConnectionResolver(Socket connection){
            this.connection = connection;
        }
        
        @Override
        public void run() {
            try {
                txtLog.append("Connection Received From: "+connection.getRemoteSocketAddress().toString()+"\n");
                answer();
            } catch (IOException ex) {
                Logger.getLogger(LoginServer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(LoginServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        private void answer() throws IOException, SQLException{
            BufferedReader bfr = Utilidades.getBufferedReader(connection.getInputStream());
            PrintWriter pw = Utilidades.getPrintWriter(connection.getOutputStream());
            
            String name = bfr.readLine();
            String pass = bfr.readLine();
            
            txtLog.append("Checking user login...\n");
            
            //check if user exists
            boolean check = false;
            User checking = new User(name, pass);
            String sql = "SELECT USERNAME FROM USERS WHERE USERNAME='"+name+"' AND PASSWORD='"+pass+"' AND ONLINE=FALSE;";           
            if((man.executeQuery(sql).next()))
                    check = true;

            if(check){
                //Set online status TRUE
                sql = "UPDATE USERS SET ONLINE=TRUE WHERE USERNAME='"+name+"' AND PASSWORD='"+pass+"';";
                man.executeNonQuery(sql);
                //Creates a new random port
                Random rand = new Random();
                int NEWPORT = rand.nextInt(40000) + 10000;
                pw.println(NEWPORT);
                pw.flush();
                
                sql = "SELECT ROLENAME FROM ROLES, USERS WHERE ROLES.IDROLE = USERS.IDROLE AND USERS.USERNAME='"+name+"';";
                String rolename = (man.executeQuery(sql)).getString(1);
                pw.println(rolename);
                pw.flush();
                
                txtLog.append("User login correct\nCreating Private Server on "+NEWPORT+"\n\n");
                //starting internal server on new port
                ApplicationServer aps = new ApplicationServer(NEWPORT, name);
                Thread t = new Thread(aps);
                t.start();
            }else{
                txtLog.append("User login failure\nConnection Refused\n\n");
                pw.println(REFUSED);
                pw.flush();
            }
            
            bfr.close();
            pw.close();
            connection.close();
        }
    }
    
    public class User{
        private String uName;
        private String uPassword;
        
        public User(String uName, String uPassword){
            this.uName = uName;
            this.uPassword = uPassword;
        }

        public String getuName() {
            return uName;
        }

        public String getuPassword() {
            return uPassword;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 73 * hash + Objects.hashCode(this.uName);
            hash = 73 * hash + Objects.hashCode(this.uPassword);
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final User other = (User) obj;
            if (!Objects.equals(this.uName, other.uName)) {
                return false;
            }
            if (!Objects.equals(this.uPassword, other.uPassword)) {
                return false;
            }
            return true;
        }
        
    }
    
}
