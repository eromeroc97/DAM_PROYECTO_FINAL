/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import domain.InMail;
import domain.Permission;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Date;
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
    
    public static ApplicationClient getClient(){       
        return myClient;
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
        pw.println(this.username);
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
    
    public LinkedList<String> AskForRolePermissions(String rolename) throws IOException{
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
        pw.println(this.username);
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
                if(!linea.equals(IServerProtocol.END_INFO_TRANSFER)){
                    resultado.add(linea);
                }
            }
        }

        
        //Closing connection with login server
        bfr.close();
        pw.close();
        
        return resultado;
    }
    
    public LinkedList<InMail> AskForInMail_Received() throws IOException{
        LinkedList<InMail> resultado = new LinkedList<>();
        
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
        
        pw.println(IServerProtocol.RECEIVED_MAIL);
        pw.flush();
        
        int confirmation = Integer.parseInt(bfr.readLine());
        if(confirmation == 1){
            pw.println(this.username);
            pw.flush();

            String linea = "";
            while(!linea.equals(IServerProtocol.END_INFO_TRANSFER)){
                linea = bfr.readLine();
                if(!linea.equals(IServerProtocol.END_INFO_TRANSFER)){
                    String[] datos = linea.split(";");
                    int id = Integer.parseInt(datos[0]);
                    String source = datos[1];
                    String destination = datos[2];
                    String subject = datos[3];
                    String content = datos[4];
                    Date send_date = new Date(datos[5]);
                    boolean readed = datos[6].equals("true");
                    resultado.add(new InMail(id, source, destination, subject, content, send_date, readed));
                }
            }
        }

        
        //Closing connection with login server
        bfr.close();
        pw.close();
        
        return resultado;
    }

    public LinkedList<String> AskForUsersList() throws IOException {
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
        pw.println(this.username);
        pw.flush();
        
        pw.println(IServerProtocol.GET_USERS_LIST);
        pw.flush();
        
        int confirmation = Integer.parseInt(bfr.readLine());
        if(confirmation == 1){
            String linea = "";
            while(!linea.equals(IServerProtocol.END_INFO_TRANSFER)){
                linea = bfr.readLine();
                if(!linea.equals(IServerProtocol.END_INFO_TRANSFER)){
                    resultado.add(linea);
                }
            }
        }

        
        //Closing connection with login server
        bfr.close();
        pw.close();
        
        return resultado;
    }

    public boolean AskForCreateUser(String username, String password, String email) throws IOException, IOException {
        boolean resultado = false;
        
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
        pw.println(this.username);
        pw.flush();
        
        pw.println(IServerProtocol.CREATE_NEW_USER);
        pw.flush();
        
        int confirmation = Integer.parseInt(bfr.readLine());
        if(confirmation == 1){
            pw.println(username);
            pw.println(password);
            pw.println(email);
            pw.flush();
            String linea = "";{
            linea = bfr.readLine();
                if(!linea.equals(IServerProtocol.END_INFO_TRANSFER)){
                    resultado = linea.equals("true");
                }
            }
        }

        
        //Closing connection with login server
        bfr.close();
        pw.close();
        
        
        return resultado;
    }
    
    public void AskForDeleteUser(int idUser) throws IOException{
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
        pw.println(this.username);
        pw.flush();
        
        pw.println(IServerProtocol.DELETE_USER);
        pw.flush();
        
        int confirmation = Integer.parseInt(bfr.readLine());
        if(confirmation == 1){
            pw.println(idUser);
            pw.flush();
        }
    }
    
    public String AskForUserProfile(int idUser) throws IOException{
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
        pw.println(this.username);
        pw.flush();
        
        pw.println(IServerProtocol.GET_PROFILE);
        pw.flush();
        
        int confirmation = Integer.parseInt(bfr.readLine());
        if(confirmation == 1){
            pw.println(idUser);
            pw.flush();
            
            String linea = bfr.readLine();
            if(!linea.equals(IServerProtocol.END_INFO_TRANSFER))
                return linea;
        }
        return null;
    }
    
    public void AskForSetProfile(int idUser, String valores) throws IOException{
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
        pw.println(this.username);
        pw.flush();
        
        pw.println(IServerProtocol.SET_PROFILE);
        pw.flush();
        
        int confirmation = Integer.parseInt(bfr.readLine());
        if(confirmation == 1){
            pw.println(idUser);
            pw.println(valores);
            pw.flush();
        }
    }

    public void AskForChangePassword(int idUser, String pass) throws IOException {
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
        pw.println(this.username);
        pw.flush();
        
        pw.println(IServerProtocol.CHANGE_PASSWORD);
        pw.flush();
        
        int confirmation = Integer.parseInt(bfr.readLine());
        if(confirmation == 1){
            pw.println(idUser);
            pw.println(pass);
            pw.flush();
        }
    }

    public LinkedList<String> AskForRoleList() throws IOException {
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
        pw.println(this.username);
        pw.flush();
        
        pw.println(IServerProtocol.GET_ROLES_LIST);
        pw.flush();
        
        LinkedList<String> roles = new LinkedList<>();
        int confirmation = Integer.parseInt(bfr.readLine());
        if(confirmation == 1){
            String linea = "";
            while(!linea.equals(IServerProtocol.END_INFO_TRANSFER)){
                linea = bfr.readLine();
                roles.add(linea);
            }
        }
        
        return roles;
    }

    public void AskForSetRole(int userid, int roleid) throws IOException {
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
        pw.println(this.username);
        pw.flush();
        
        pw.println(IServerProtocol.SET_USER_ROLE);
        pw.flush();
        
        int confirmation = Integer.parseInt(bfr.readLine());
        if(confirmation == 1){
            pw.println(userid);
            pw.println(roleid);
            pw.flush();
        }
    }

    public void AskForDeleteRole(int roleid) throws IOException {
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
        pw.println(this.username);
        pw.flush();
        
        pw.println(IServerProtocol.DELETE_ROLE);
        pw.flush();
        
        int confirmation = Integer.parseInt(bfr.readLine());
        if(confirmation == 1){
            pw.println(roleid);
            pw.flush();
        }
    }

    public LinkedList<String> AskForPermList() throws IOException {
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
        pw.println(this.username);
        pw.flush();
        
        pw.println(IServerProtocol.GET_PERMS_LIST);
        pw.flush();
        
        int confirmation = Integer.parseInt(bfr.readLine());
        if(confirmation == 1){
            String linea = "";
            while(!linea.equals(IServerProtocol.END_INFO_TRANSFER)){
                linea = bfr.readLine();
                if(!linea.equals(IServerProtocol.END_INFO_TRANSFER)){
                    resultado.add(linea);
                }
            }
        }

        
        //Closing connection with login server
        bfr.close();
        pw.close();
        
        return resultado;
    }

    public void AskForCreateRole(String rolename, LinkedList<Permission> perms) throws IOException {
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
        pw.println(this.username);
        pw.flush();
        
        pw.println(IServerProtocol.CREATE_NEW_ROLE);
        pw.flush();
        
        int confirmation = Integer.parseInt(bfr.readLine());
        if(confirmation == 1){
            pw.println(rolename);
            pw.flush();
            for(int i = 0; i < perms.size(); i++){
                pw.println(perms.get(i).getIdPermission()+";"+perms.get(i).getPermname());
            }
            pw.println(IServerProtocol.END_INFO_TRANSFER);
            pw.flush();
        }
    }

    public void AskForNewPassword(int iduser) throws IOException {
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
        pw.println(this.username);
        pw.flush();
        
        pw.println(IServerProtocol.NEW_PASSWORD);
        pw.flush();
        
        int confirmation = Integer.parseInt(bfr.readLine());
        if(confirmation == 1){
            pw.println(iduser);
            pw.flush();
        }
    }
}
