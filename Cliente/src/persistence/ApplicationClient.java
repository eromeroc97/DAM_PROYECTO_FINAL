/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilities.Utilidades;
import utilities.IServerProtocol;

/**
 *
 * @author erome
 */
public class ApplicationClient{
    private String ServerIP;
    private String username;
    private int port;
    private static ApplicationClient myClient = null;
    
    private ApplicationClient(String username, int port){
        this.username = username;
        this.port = port;
        this.ServerIP = getIPfromConfigFile();
    }
    
    public static ApplicationClient getClient(String username, int port){
        if(myClient == null)
            myClient = new ApplicationClient(username, port);
        
        return myClient;
    }
    
    public void AskForLogout() throws IOException{
        Socket conexion;
        InetSocketAddress direccionServidor;
        direccionServidor=
           new InetSocketAddress(ServerIP, port);
        conexion=new Socket();
        //Sending HandShake
        conexion.connect(direccionServidor);
        
        //Getting streams
        PrintWriter pw=Utilidades.getPrintWriter(conexion.getOutputStream());
        BufferedReader bfr=Utilidades.getBufferedReader(conexion.getInputStream());
        
        //Protocol - User checking
        pw.println(username);
        pw.flush();
        
        boolean check = Integer.parseInt(bfr.readLine()) == 1;
        
        if(check){
            pw.println(IServerProtocol.LOGOUT);
            pw.flush();
        }

        
        //Closing connection with login server
        myClient = null;
        bfr.close();
        pw.close();
        conexion.close();
    }
    
    public LinkedList<String> AskForRoleInfo(String rolename) throws IOException{
        LinkedList<String> resultado = new LinkedList<>();
        
        Socket conexion;
        InetSocketAddress direccionServidor;
        direccionServidor=
           new InetSocketAddress(ServerIP, port);
        conexion=new Socket();
        //Sending HandShake
        conexion.connect(direccionServidor);
        
        //Getting streams
        PrintWriter pw=Utilidades.getPrintWriter(conexion.getOutputStream());
        BufferedReader bfr=Utilidades.getBufferedReader(conexion.getInputStream());
        
        //Protocol - User checking        
        pw.println(username);
        pw.flush();
        
        pw.println(IServerProtocol.ROLEINFO);
        pw.flush();
        
        int confirmation = Integer.parseInt(bfr.readLine());
        if(confirmation == 1){
            pw.println(rolename);
            pw.flush();

            String linea = "";
            while(!linea.equals(IServerProtocol.END_INFO_TRANSFER)){
                linea = bfr.readLine();
                if(!linea.equals(IServerProtocol.END_INFO_TRANSFER))
                    resultado.add(linea);
            }
        }

        
        //Closing connection with login server
        bfr.close();
        pw.close();
        
        return resultado;
    }
    
    private String getIPfromConfigFile(){
        try {
            String clientConfPath = "./clientfiles/client.cconf";
            File f = new File(clientConfPath);
            BufferedReader bfr = new BufferedReader(new FileReader(f));
            String direc = bfr.readLine();
            String[] direc_partida = direc.split(":");
            bfr.close();
            return direc_partida[0];
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ConnectionClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConnectionClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
