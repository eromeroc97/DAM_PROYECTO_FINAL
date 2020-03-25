/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import utilities.Utilidades;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author erome
 */
public class ConnectionClient {
    private static final String ServerIP = "127.0.0.1";
    private static int ServerPORT;
    
    private int CONNECTION_RESULT;
    private String ROLENAME_RESPONSE;
    
    private void getConnectionPort(){
        FileReader fr = null;
        try {
            String clientConfPath = "./clientfiles/client.cconf";
            File f = new File(clientConfPath);
            fr = new FileReader(f);
            char[] cbuf = new char[4];
            fr.read(cbuf);
            ServerPORT = Integer.parseInt(new String(cbuf));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ConnectionClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConnectionClient.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                Logger.getLogger(ConnectionClient.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public ConnectionClient(String name, String pass) throws IOException{
        getConnectionPort();
        Socket conexion;
        InetSocketAddress direccionServidor;
        direccionServidor=
           new InetSocketAddress(ServerIP, ServerPORT);
        conexion=new Socket();
        //Sending HandShake
        conexion.connect(direccionServidor);
        
        //Getting streams
        PrintWriter pw=Utilidades.getPrintWriter(conexion.getOutputStream());
        BufferedReader bfr=Utilidades.getBufferedReader(conexion.getInputStream());
        
        //Sending connection messages
        pw.println(name);
        pw.println(pass);
        pw.flush();
        
        //Getting a response
        String response = bfr.readLine();
        this.CONNECTION_RESULT = Integer.parseInt(response);
        if(CONNECTION_RESULT != -1){
            this.ROLENAME_RESPONSE = bfr.readLine();
        }
        
        //Closing connection with login server
        bfr.close();
        pw.close();
        conexion.close();
    }
    
    public int getConnectionResult(){
        return this.CONNECTION_RESULT;
    }
    
    public String getConnectionResultMessage(){
        if(CONNECTION_RESULT == -1)
            return "CONNECTION REFUSED: BAD LOGIN DATA";
        else
            return "CONNECTION ACCEPTED";
    }

    public String getRolename() {
        return this.ROLENAME_RESPONSE;
    }
}
