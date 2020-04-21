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
import java.net.SocketException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import presentation.ServerConfigGUI;
import utilities.Encrypt;
import utilities.Utilidades;
import utilities.IServerProtocol;

/**
 *
 * @author erome
 */
public class ApplicationServer implements Runnable{
    
    private int PORT;
    private String username;
    private ServerSocket socketServidor;
    private boolean exit = false;
    private SQLiteManager man;
    private ServerConfigGUI gui;

    public ApplicationServer(int PORT, String username, ServerConfigGUI gui) {
        this.PORT = PORT;
        this.username = username;
        this.gui = gui;
        this.man = SQLiteManager.getSingletonInstance();
    }
    
    public void stop(){
        exit = true;
        man.executeNonQuery("UPDATE USERS "
                + "SET ONLINE=FALSE, LASTCONNECTION='"+new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date())+"' "
                + "WHERE USERNAME='"+username+"';");
        gui.loadOnlineUsers(); //actualiza la lista cuando un usuario se desconecta
        try {
            socketServidor.close();
        } catch (IOException ex) {
            
        }
    }
    
    @Override
    public void run() {
        try {
            socketServidor=
                    new ServerSocket(this.PORT);
            while (!exit){
                /*1. Esperar que llegue una petición*/
                Socket socketConCliente;
                socketConCliente=socketServidor.accept();
                ApplicationServer.PetitionResolver p=new ApplicationServer.PetitionResolver(socketConCliente, this);
                Thread hiloAsociado=new Thread(p);
                if(!exit)            
                    hiloAsociado.start();
            }
        }catch (SocketException ex){
            System.out.println("Connection Interrupted by user");
        } catch (IOException ex) {
            Logger.getLogger(ApplicationServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private class PetitionResolver implements Runnable{
        private Socket socket;
        private ApplicationServer stoppable;
        
        public PetitionResolver(Socket socket, ApplicationServer stoppable){
            this.socket = socket;
            this.stoppable = stoppable;
        }
        
        @Override
        public void run(){
            try {
                resolvePetition();
            } catch (IOException ex) {
                Logger.getLogger(ApplicationServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        private void resolvePetition() throws IOException{
            BufferedReader bfr = Utilidades.getBufferedReader(socket.getInputStream());
            PrintWriter pw = Utilidades.getPrintWriter(socket.getOutputStream());
            
            //Checking username is correct for this server port
            String user = bfr.readLine();
            if(user.equals(username))
                pw.println("1");
            else
                pw.println("-1");
            pw.flush();
            
            //Getting petition code
            int code = Integer.parseInt(bfr.readLine());
            switch(code){
                case IServerProtocol.LOGOUT:
                {
                    LogOutPetition();
                    break;
                }
                case IServerProtocol.ROLEINFO:
                {
                    try {
                        RoleInfoPetition(bfr, pw);
                    } catch (SQLException ex) {
                        Logger.getLogger(ApplicationServer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                }
                case IServerProtocol.RECEIVED_MAIL:
                {
                    try {
                        ReceivedMailPetition(bfr, pw);
                    } catch (SQLException ex) {
                        Logger.getLogger(ApplicationServer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                }
                case IServerProtocol.GET_USERS_LIST:{
                    try {
                        GetUsersListPetition(bfr, pw);
                    } catch (SQLException ex) {
                        Logger.getLogger(ApplicationServer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                }
                case IServerProtocol.CREATE_NEW_USER:{
                    try {
                        CreateNewUserPetition(bfr, pw);
                    } catch (SQLException ex) {
                        Logger.getLogger(ApplicationServer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                }
                case IServerProtocol.DELETE_USER:{
                    DeleteUserPetition(bfr, pw);
                    break;
                }
                case IServerProtocol.GET_PROFILE:{
                    try {
                        GetUserProfile(bfr, pw);
                    } catch (SQLException ex) {
                        Logger.getLogger(ApplicationServer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                }
                case IServerProtocol.SET_PROFILE:{
                    try {
                        SetUserProfile(bfr, pw);
                    } catch (SQLException ex) {
                        Logger.getLogger(ApplicationServer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;                    
                }
                case IServerProtocol.CHANGE_PASSWORD:{
                    ChangeUserPassword(bfr, pw);
                    break;
                }
                case IServerProtocol.GET_ROLES_LIST:{
                    try {
                        GetRolesList(bfr, pw);
                    } catch (SQLException ex) {
                        Logger.getLogger(ApplicationServer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                }
                case IServerProtocol.SET_USER_ROLE:{
                    SetUserRole(bfr,pw);
                    break;
                }
                case IServerProtocol.DELETE_ROLE:{
                    DeleteRole(bfr, pw);
                    break;
                }
                
            }
        }
        
        private void LogOutPetition(){
            stoppable.stop();
        }
        
        private void RoleInfoPetition(BufferedReader bfr, PrintWriter pw) throws IOException, SQLException{
            String rolename = bfr.readLine();
            String sql = "SELECT PERM.IDPERM, PERM.PERMNAME FROM PERM, ROLES_PERM, ROLES WHERE ROLES.ROLENAME = '"+rolename+"' AND ROLES.IDROLE=ROLES_PERM.IDROLE AND ROLES_PERM.IDPERM=PERM.IDPERM;";
            ResultSet rs = man.executeQuery(sql);
            while(rs.next()){
                pw.println(rs.getInt(1)+";"+rs.getString(2));
                pw.flush();
            }
            pw.println(IServerProtocol.END_INFO_TRANSFER);
            pw.flush();
        }
        
        private void ReceivedMailPetition(BufferedReader bfr, PrintWriter pw) throws IOException, SQLException{
            String destination = bfr.readLine();
            String sql = "SELECT I.IDINMAIL, U1.USERNAME, U2.USERNAME, I.SUBJECT, I.CONTENT, I.SEND_DATE, I.READED"
                    + "FROM INMAIL I, USERS U1, USERS U2 "
                    + "WHERE I.SOURCE = U1.IDUSER AND I.DESTINATION = U2.IDUSER AND U2.USERNAME = '"+username+"' "
                    + "ORDER BY I.SEND_DATE DESC;";
            ResultSet rs = man.executeQuery(sql);
            while(rs.next()){
                pw.println(rs.getInt(1)+';'+rs.getString(2)+';'+rs.getString(3)+';'+rs.getString(4)+';'+rs.getString(5)+';'+rs.getDate(6)+';'+rs.getBoolean(7));
                pw.flush();
            }
            
            pw.println(IServerProtocol.END_INFO_TRANSFER);
            pw.flush();
        }

        private void GetUsersListPetition(BufferedReader bfr, PrintWriter pw) throws IOException, SQLException {
            String sql = "SELECT U.IDUSER, U.USERNAME, U.ONLINE, R.ROLENAME, U.LASTCONNECTION "
                    + "FROM USERS U, ROLES R "
                    + "WHERE U.IDROLE = R.IDROLE AND U.DELETED=FALSE "
                    + "ORDER BY IDUSER ASC;";
            ResultSet rs = man.executeQuery(sql);
            while(rs.next()){
                pw.println(rs.getInt(1)+";"+rs.getString(2)+";"+rs.getInt(3)+";"+rs.getString(4)+";"+rs.getString(5));
                pw.flush();
            }
            pw.println(IServerProtocol.END_INFO_TRANSFER);
            pw.flush();
        }

        private void CreateNewUserPetition(BufferedReader bfr, PrintWriter pw) throws SQLException, IOException {
            String username = bfr.readLine();
            String password = bfr.readLine();
            String email = bfr.readLine();
            String sql = "SELECT IDUSER FROM USERS WHERE USERNAME='"+username+"';";
            ResultSet rs = man.executeQuery(sql);
            if(rs.next()){
                pw.println("false");
                pw.flush();
            }else{
                sql = "INSERT INTO USERS(USERNAME, PASSWORD) VALUES ('"+username+"','"+password+"')";
                man.executeNonQuery(sql);
                sql = "SELECT IDUSER FROM USERS WHERE USERNAME='"+username+"';";
                rs = man.executeQuery(sql);
                rs.next();
                int id = rs.getInt(1);
                sql = "INSERT INTO PROFILES(IDUSER, EMAIL) VALUES ("+id+",'"+email+"');";
                man.executeNonQuery(sql);
                
                try { //Envio del email de contraseña
                    MailSender ms = new MailSender();
                    ms.sendMail(username, Encrypt.desencriptar_DESede(password), email);
                } catch (Exception ex) {
                    Logger.getLogger(ApplicationServer.class.getName()).log(Level.SEVERE, null, ex);
                }
                pw.println("true");
                pw.flush();
            }
            pw.println(IServerProtocol.END_INFO_TRANSFER);
            pw.flush();
        }
        
        public void DeleteUserPetition(BufferedReader bfr, PrintWriter pw) throws IOException{
            int iduser = Integer.parseInt(bfr.readLine());
            String sql = "UPDATE USERS SET DELETED=TRUE WHERE IDUSER="+iduser+" AND ONLINE=FALSE;";
            man.executeNonQuery(sql);
        }

        private void GetUserProfile(BufferedReader bfr, PrintWriter pw) throws IOException, SQLException {
            int iduser = Integer.parseInt(bfr.readLine());
            String sql = "SELECT IDUSER, NAME, SURNAME, EMAIL, PHONE FROM PROFILES WHERE IDUSER = "+iduser+";";
            if((man.executeQuery(sql)).next()){
                String name = (man.executeQuery(sql)).getString(2);
                String surname = (man.executeQuery(sql)).getString(3);
                String email = (man.executeQuery(sql)).getString(4);
                Long phone = (man.executeQuery(sql)).getLong(5);
                
                if(name == null)
                    name = " ";
                if(surname == null)
                    surname = " ";
                if(email == null)
                    email = " ";
                
                pw.println((man.executeQuery(sql)).getInt(1)+";"+name+";"+surname+";"+email+";"+phone);
                pw.flush();
            }
            pw.println(IServerProtocol.END_INFO_TRANSFER);
            pw.flush();
        }

        private void SetUserProfile(BufferedReader bfr, PrintWriter pw) throws IOException, SQLException {
            int iduser = Integer.parseInt(bfr.readLine());
            String linea = bfr.readLine();
            String[] datos = linea.split(";");
            String name = datos[0], surname = datos[1], email = datos[2];
            Long phone = Long.parseLong(datos[3]);
            String sql = "SELECT IDUSER FROM PROFILES WHERE IDUSER = "+iduser+";";
            if((man.executeQuery(sql)).next()){ //Ya existe el perfil
                sql = "UPDATE PROFILES SET NAME = '"+name+"', SURNAME = '"+surname+"', EMAIL = '"+email+"', PHONE = "+phone+" WHERE IDUSER = "+iduser+";";
                man.executeNonQuery(sql);
            }else{ //No existe el perfil
                sql = "INSERT INTO PROFILES VALUES("+iduser+", '"+name+"', '"+surname+"', '"+email+"', "+phone+")";
                man.executeNonQuery(sql);
            }
        }

        private void ChangeUserPassword(BufferedReader bfr, PrintWriter pw) throws IOException {
             int iduser = Integer.parseInt(bfr.readLine());
             String pass = bfr.readLine();
             String sql = "UPDATE USERS SET PASSWORD='"+pass+"', LASTCONNECTION='"+new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date())+"' WHERE IDUSER = "+iduser+";";
             man.executeNonQuery(sql);
        }

        private void GetRolesList(BufferedReader bfr, PrintWriter pw) throws SQLException {
            String sql = "SELECT IDROLE, ROLENAME FROM ROLES ORDER BY IDROLE ASC;";
            ResultSet rs = man.executeQuery(sql);
            while(rs.next()){
                pw.println(rs.getInt(1)+";"+rs.getString(2));
                pw.flush();
            }
            pw.println(IServerProtocol.END_INFO_TRANSFER);
            pw.flush();
        }

        private void SetUserRole(BufferedReader bfr, PrintWriter pw) throws IOException {
            int userid = Integer.parseInt(bfr.readLine());
            int roleid = Integer.parseInt(bfr.readLine());
            String sql = "UPDATE USERS SET IDROLE="+roleid+" WHERE IDUSER="+userid+";";
            man.executeNonQuery(sql);
        }

        private void DeleteRole(BufferedReader bfr, PrintWriter pw) throws IOException {
            int roleid = Integer.parseInt(bfr.readLine());
            String sql = "DELETE FROM ROLES_PERM WHERE IDROLE="+roleid+";";
            man.executeNonQuery(sql);
            sql = "DELETE FROM ROLES WHERE IDROLE="+roleid+";";
            man.executeNonQuery(sql);
        }
        
    }
}
