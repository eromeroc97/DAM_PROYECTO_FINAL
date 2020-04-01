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
    private static String ServerIP;
    private static int ServerPORT;
    
    private int CONNECTION_RESULT;
    private String ROLENAME_RESPONSE;
    
    private void getConnectionPort(){
        try {
            String clientConfPath = "./clientfiles/client.cconf";
            File f = new File(clientConfPath);
            BufferedReader bfr = new BufferedReader(new FileReader(f));
            String direc = bfr.readLine();
            String[] direc_partida = direc.split(":");
            ServerIP = direc_partida[0];
            ServerPORT = Integer.parseInt(direc_partida[1]);
            bfr.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ConnectionClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConnectionClient.class.getName()).log(Level.SEVERE, null, ex);
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
