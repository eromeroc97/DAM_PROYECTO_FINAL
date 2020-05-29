/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.text.ParseException;
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
                case IServerProtocol.SENT_MAIL:{
                    try {
                        SentMailPetition(bfr, pw);
                    } catch (SQLException ex) {
                        Logger.getLogger(ApplicationServer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                }
                case IServerProtocol.SEND_INMAIL:{
                    SendInMailPetition(bfr, pw);
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
                        GetUserProfilePetition(bfr, pw);
                    } catch (SQLException ex) {
                        Logger.getLogger(ApplicationServer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                }
                case IServerProtocol.SET_PROFILE:{
                    try {
                        SetUserProfilePetition(bfr, pw);
                    } catch (SQLException ex) {
                        Logger.getLogger(ApplicationServer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;                    
                }
                case IServerProtocol.CHANGE_PASSWORD:{
                    ChangeUserPasswordPetition(bfr, pw);
                    break;
                }
                case IServerProtocol.GET_ROLES_LIST:{
                    try {
                        GetRolesListPetition(bfr, pw);
                    } catch (SQLException ex) {
                        Logger.getLogger(ApplicationServer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                }
                case IServerProtocol.SET_USER_ROLE:{
                    SetUserRolePetition(bfr,pw);
                    break;
                }
                case IServerProtocol.DELETE_ROLE:{
                    DeleteRolePetition(bfr, pw);
                    break;
                }
                case IServerProtocol.GET_PERMS_LIST:{
                    try {
                        GetPermsListPetition(bfr, pw);
                    } catch (SQLException ex) {
                        Logger.getLogger(ApplicationServer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                }
                case IServerProtocol.CREATE_NEW_ROLE:{
                    CreateNewRolePetition(bfr, pw);
                    break;
                }
                case IServerProtocol.NEW_PASSWORD:{
                    try {
                        SetNewPasswordPetition(bfr, pw);
                    } catch (SQLException ex) {
                        Logger.getLogger(ApplicationServer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                }
                case IServerProtocol.COMMUNICATE_READED_MAIL:{
                    CommunicateReadedInMailPetition(bfr, pw);
                    break;
                }
                case IServerProtocol.GET_PRODUCTS_LIST:{
                    try {
                        GetProductsList(bfr, pw);
                    } catch (SQLException ex) {
                        Logger.getLogger(ApplicationServer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                }
                case IServerProtocol.CREATE_NEW_PRODUCT:{
                    CreateNewProduct(bfr,pw);
                    break;
                }
                case IServerProtocol.EDIT_PRODUCT:{
                    EditProduct(bfr,pw);
                    break;
                }
                case IServerProtocol.DELETE_PRODUCT:{
                    DeleteProduct(bfr, pw);
                    break;
                }
                case IServerProtocol.RECOVER_PRODUCT:{
                    RecoverProduct(bfr, pw);
                    break;
                }
                case IServerProtocol.GET_PRODUCT_PRICE:{
                    try {
                        GetProductPrice(bfr, pw);
                    } catch (SQLException ex) {
                        Logger.getLogger(ApplicationServer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                }
                case IServerProtocol.CREATE_SALES:{
                    CreateSales(bfr, pw);
                    break;
                }
                case IServerProtocol.SEND_ADVERT:{
                    SendAdvert(bfr, pw);
                    break;
                }
                case IServerProtocol.GET_ADVERT_LIST:{
                    try {
                        GetAdvertList(bfr, pw);
                    } catch (SQLException ex) {
                        Logger.getLogger(ApplicationServer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                        break;
                }
                case IServerProtocol.GET_SECURITY_STOCK_PRODUCT_LIST:{
                    try {
                        GetSecurityStockProductList(bfr, pw);
                    } catch (SQLException ex) {
                        Logger.getLogger(ApplicationServer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                }
                case IServerProtocol.GET_ZERO_STOCK_PRODUCT_LIST:{
                    try {
                        GetZeroStockProductList(bfr, pw);
                    } catch (SQLException ex) {
                        Logger.getLogger(ApplicationServer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                }
                case IServerProtocol.CREATE_REPORT:{
                    try {
                        CreateReport(bfr, pw);
                    } catch (SQLException ex) {
                        Logger.getLogger(ApplicationServer.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ParseException ex) {
                        Logger.getLogger(ApplicationServer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                }
                case IServerProtocol.GET_REPORT_LIST:{
                    GetReportList(bfr, pw);
                    break;
                }
                case IServerProtocol.GET_REPORT:{
                    try {
                        GetReport(bfr, pw);
                    } catch (SQLException ex) {
                        Logger.getLogger(ApplicationServer.class.getName()).log(Level.SEVERE, null, ex);
                    }
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
            int destination = Integer.parseInt(bfr.readLine());
            String sql = "SELECT I.IDMAIL, U1.USERNAME, U2.USERNAME, I.SUBJECT, I.CONTENT, I.SEND_DATE, I.READED "
                    + "FROM INMAIL I, USERS U1, USERS U2 "
                    + "WHERE I.SOURCE = U1.IDUSER AND I.DESTINATION = U2.IDUSER AND U2.IDUSER="+destination+" "
                    + "ORDER BY I.SEND_DATE DESC;";
            ResultSet rs = man.executeQuery(sql);
            while(rs.next()){
                pw.println(rs.getInt(1)+";"+rs.getString(2)+";"+rs.getString(3)+";"+rs.getString(4)+";"+rs.getString(5)+";"+rs.getString(6)+";"+rs.getInt(7));
                pw.flush();
            }
            
            pw.println(IServerProtocol.END_INFO_TRANSFER);
            pw.flush();
        }
        
        private void SentMailPetition(BufferedReader bfr, PrintWriter pw) throws IOException, SQLException{
            int source = Integer.parseInt(bfr.readLine());
            String sql = "SELECT I.IDMAIL, U1.USERNAME, U2.USERNAME, I.SUBJECT, I.CONTENT, I.SEND_DATE, I.READED "
                    + "FROM INMAIL I, USERS U1, USERS U2 "
                    + "WHERE I.SOURCE = U1.IDUSER AND I.DESTINATION = U2.IDUSER AND U1.IDUSER="+source+" "
                    + "ORDER BY I.SEND_DATE DESC;";
            ResultSet rs = man.executeQuery(sql);
            while(rs.next()){
                pw.println(rs.getInt(1)+";"+rs.getString(2)+";"+rs.getString(3)+";"+rs.getString(4)+";"+rs.getString(5)+";"+rs.getString(6)+";"+rs.getInt(7));
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

        private void GetUserProfilePetition(BufferedReader bfr, PrintWriter pw) throws IOException, SQLException {
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

        private void SetUserProfilePetition(BufferedReader bfr, PrintWriter pw) throws IOException, SQLException {
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

        private void ChangeUserPasswordPetition(BufferedReader bfr, PrintWriter pw) throws IOException {
             int iduser = Integer.parseInt(bfr.readLine());
             String pass = bfr.readLine();
             String sql = "UPDATE USERS SET PASSWORD='"+pass+"', LASTCONNECTION='"+new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date())+"' WHERE IDUSER = "+iduser+";";
             man.executeNonQuery(sql);
        }

        private void GetRolesListPetition(BufferedReader bfr, PrintWriter pw) throws SQLException {
            String sql = "SELECT IDROLE, ROLENAME FROM ROLES ORDER BY IDROLE ASC;";
            ResultSet rs = man.executeQuery(sql);
            while(rs.next()){
                pw.println(rs.getInt(1)+";"+rs.getString(2));
                pw.flush();
            }
            pw.println(IServerProtocol.END_INFO_TRANSFER);
            pw.flush();
        }

        private void SetUserRolePetition(BufferedReader bfr, PrintWriter pw) throws IOException {
            int userid = Integer.parseInt(bfr.readLine());
            int roleid = Integer.parseInt(bfr.readLine());
            String sql = "UPDATE USERS SET IDROLE="+roleid+" WHERE IDUSER="+userid+";";
            man.executeNonQuery(sql);
        }

        private void DeleteRolePetition(BufferedReader bfr, PrintWriter pw) throws IOException {
            int roleid = Integer.parseInt(bfr.readLine());
            //Cambio el rol de los usuarios que lo tengan asignado
            String sql = "UPDATE USERS SET IDROLE=1 WHERE IDROLE="+roleid+";";
            man.executeNonQuery(sql);
            //elimino todas las entradas del rol en Roles_Perm
            sql = "DELETE FROM ROLES_PERM WHERE IDROLE="+roleid+";";
            man.executeNonQuery(sql);
            // elimino el rol
            sql = "DELETE FROM ROLES WHERE IDROLE="+roleid+";";
            man.executeNonQuery(sql);
        }

        private void GetPermsListPetition(BufferedReader bfr, PrintWriter pw) throws SQLException {
            String sql = "SELECT IDPERM, PERMNAME FROM PERM ORDER BY IDPERM ASC;";
            ResultSet rs = man.executeQuery(sql);
            while(rs.next()){
                pw.println(rs.getInt(1)+";"+rs.getString(2));
                pw.flush();
            }
            pw.println(IServerProtocol.END_INFO_TRANSFER);
            pw.flush();
        }

        private void CreateNewRolePetition(BufferedReader bfr, PrintWriter pw) throws IOException {
            String rolename = bfr.readLine();
            String sql = "INSERT INTO ROLES (ROLENAME) VALUES ('"+rolename+"');";
            man.executeNonQuery(sql);
            String linea = "";
            while(!linea.equals(IServerProtocol.END_INFO_TRANSFER)){
                linea = bfr.readLine();
                if(!linea.equals(IServerProtocol.END_INFO_TRANSFER)){
                    String[] dato = linea.split(";");
                    int idperm = Integer.parseInt(dato[0]);
                    
                    sql = "INSERT INTO ROLES_PERM VALUES((SELECT IDROLE FROM ROLES WHERE ROLENAME='"+rolename+"'), "+idperm+");";
                    man.executeNonQuery(sql);
                }
            }
        }

        private void SetNewPasswordPetition(BufferedReader bfr, PrintWriter pw) throws IOException, SQLException {
            int iduser = Integer.parseInt(bfr.readLine());
            String sql = "SELECT EMAIL FROM PROFILES WHERE IDUSER="+iduser+";";
            ResultSet rs = man.executeQuery(sql);
            if(rs.next()){
                String email = rs.getString(1);
                
                try {
                    String encrypted = Encrypt.encriptar_DESede(Utilidades.generateRandomKey(5));
                    
                    try { //Envio del email de contraseña
                        MailSender ms = new MailSender();
                        ms.sendMail(username, Encrypt.desencriptar_DESede(encrypted), email);
                        //Cambio la contraseña solo si he conseguido enviar el mail
                        sql = "UPDATE USERS SET PASSWORD='"+encrypted+"', LASTCONNECTION='01-01-2000 00:00:00' WHERE IDUSER="+iduser+";";
                        man.executeNonQuery(sql);
                    } catch (Exception ex) {
                        Logger.getLogger(ApplicationServer.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } catch (Exception ex) {
                    Logger.getLogger(ApplicationServer.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }

        private void SendInMailPetition(BufferedReader bfr, PrintWriter pw) throws IOException {
            String source = bfr.readLine();
            String destination = bfr.readLine();
            String subject = bfr.readLine();
            String content = bfr.readLine();
            
            String sql = "INSERT INTO INMAIL (SOURCE, DESTINATION, SUBJECT, CONTENT, SEND_DATE, READED) VALUES ("
                    + "(SELECT IDUSER FROM USERS WHERE USERNAME='"+source+"'), "
                    + "(SELECT IDUSER FROM USERS WHERE USERNAME='"+destination+"'), "
                    + "'"+subject+"', '"+content+"', '"+(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()))+"', FALSE);";
            man.executeNonQuery(sql);
        }

        private void CommunicateReadedInMailPetition(BufferedReader bfr, PrintWriter pw) throws IOException {
            int mailid = Integer.parseInt(bfr.readLine());
            //Cambio el rol de los usuarios que lo tengan asignado
            String sql = "UPDATE INMAIL SET READED=TRUE WHERE IDMAIL="+mailid+";";
            man.executeNonQuery(sql);
        }

        private void GetProductsList(BufferedReader bfr, PrintWriter pw) throws SQLException {
            String sql = "SELECT * FROM PRODUCTS ORDER BY IDPRODUCT ASC;";
            ResultSet rs = man.executeQuery(sql);
            
            while(rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                double price = rs.getDouble(3);
                int stock = rs.getInt(4);
                int secStock = rs.getInt(5);
                int minStock = rs.getInt(6);
                int defaultorderamount = rs.getInt(7);
                int deleted = rs.getInt(8);
                String product = id+";"+name+";"+price+";"+stock+";"+secStock+";"+minStock+";"+defaultorderamount+";"+deleted;
                pw.println(product);
                pw.flush();
            }
            pw.println(IServerProtocol.END_INFO_TRANSFER);
            pw.flush();
        }

        private void CreateNewProduct(BufferedReader bfr, PrintWriter pw) throws IOException {
            String pName = bfr.readLine();
            double pPrice = Double.parseDouble(bfr.readLine());
            int pStock = Integer.parseInt(bfr.readLine());
            int pSecStock = Integer.parseInt(bfr.readLine());
            int pMinStock = Integer.parseInt(bfr.readLine());
            int pDefOrdAmount = Integer.parseInt(bfr.readLine());
            
            String sql = "INSERT INTO PRODUCTS (PRODUCTNAME, PRICE, STOCK, SECURITYSTOCK, MINIMUMSTOCK, DEFAULTORDERAMOUNT, DELETED) "
                    + "VALUES('"+pName.toUpperCase()+"', "+pPrice+", "+pStock+", "+pSecStock+", "+pMinStock+", "+pDefOrdAmount+", FALSE);";
            man.executeNonQuery(sql);
        }

        private void EditProduct(BufferedReader bfr, PrintWriter pw) throws IOException {
            int pId = Integer.parseInt(bfr.readLine());
            String pName = bfr.readLine();
            double pPrice = Double.parseDouble(bfr.readLine());
            int pStock = Integer.parseInt(bfr.readLine());
            int pSecStock = Integer.parseInt(bfr.readLine());
            int pMinStock = Integer.parseInt(bfr.readLine());
            int pDefOrdAmount = Integer.parseInt(bfr.readLine());
            
            String sql = "UPDATE PRODUCTS SET PRODUCTNAME = '"+pName.toUpperCase()+"', PRICE = "+pPrice+", STOCK = "+pStock+", SECURITYSTOCK = "+pSecStock+","
                    + " MINIMUMSTOCK = "+pMinStock+", DEFAULTORDERAMOUNT = "+pDefOrdAmount+" WHERE IDPRODUCT="+pId+";";
            man.executeNonQuery(sql);
        }

        private void DeleteProduct(BufferedReader bfr, PrintWriter pw) throws IOException {
            int pId = Integer.parseInt(bfr.readLine());
            String sql = "UPDATE PRODUCTS SET DELETED = TRUE WHERE IDPRODUCT="+pId+";";
            man.executeNonQuery(sql);
        }

        private void RecoverProduct(BufferedReader bfr, PrintWriter pw) throws IOException {
            int pId = Integer.parseInt(bfr.readLine());
            String sql = "UPDATE PRODUCTS SET DELETED = FALSE WHERE IDPRODUCT="+pId+";";
            man.executeNonQuery(sql);
        }

        private void GetProductPrice(BufferedReader bfr, PrintWriter pw) throws IOException, SQLException {
            String pName = bfr.readLine();
            String sql = "SELECT PRICE FROM PRODUCTS WHERE PRODUCTNAME='"+pName+"';";
            ResultSet rs = man.executeQuery(sql);
            if(rs.next())
                pw.println(rs.getDouble(1));
            else
                pw.println("0.0");
            pw.flush();
        }

        private void CreateSales(BufferedReader bfr, PrintWriter pw) throws IOException {
            String uID = bfr.readLine();
            String formatDate = bfr.readLine();
            
            String data = "";
            while(!data.equals(IServerProtocol.END_INFO_TRANSFER)){
                data = bfr.readLine();
                if(!data.equals(IServerProtocol.END_INFO_TRANSFER)){
                    String[] valores = data.split(";");
                    String sql = "INSERT INTO SALES(IDPRODUCT, IDUSER, SALEPRICE, UNITS, SALEDATE) "
                            + "VALUES((SELECT IDPRODUCT FROM PRODUCTS WHERE PRODUCTNAME='"+valores[0]+"'),"+uID+","+valores[2]+","+valores[1]+",'"+formatDate+"');";
                    man.executeNonQuery(sql);
                }
            }
            //Creamos el ticket de venta
            try {
                ReportCreator rc = new ReportCreator(ReportCreator.TICKET_REPORT, new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(formatDate));
            } catch (ParseException | SQLException ex) {
                Logger.getLogger(ApplicationServer.class.getName()).log(Level.SEVERE, null, ex);
            }
            //Devolvemos el ticket de venta al cliente
            
        }

        private void SendAdvert(BufferedReader bfr, PrintWriter pw) throws IOException {
            String uID = bfr.readLine();
            String formatdate = bfr.readLine();
            String msg = bfr.readLine();
            String sql = "INSERT INTO ADVERTS (IDUSER, DATE, MESSAGE) VALUES("+uID+",'"+formatdate+"','"+msg+"');";
            man.executeNonQuery(sql);
        }

        private void GetAdvertList(BufferedReader bfr, PrintWriter pw) throws SQLException {
            String sql = "SELECT A.IDADVERT, U.USERNAME, A.DATE, A.MESSAGE FROM ADVERTS A, USERS U "
                    + "WHERE A.IDUSER = U.IDUSER;";
            ResultSet rs = man.executeQuery(sql);
            while(rs.next()){
                String data = rs.getInt(1)+";"+rs.getString(2)+";"+rs.getString(3)+";"+rs.getString(4);
                pw.println(data);
            }
            pw.println(IServerProtocol.END_INFO_TRANSFER);
            pw.flush();
        }

        private void GetSecurityStockProductList(BufferedReader bfr, PrintWriter pw) throws SQLException {
            String sql = "SELECT * FROM PRODUCTS WHERE STOCK <= SECURITYSTOCK ORDER BY IDPRODUCT ASC;";
            ResultSet rs = man.executeQuery(sql);
            
            while(rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                double price = rs.getDouble(3);
                int stock = rs.getInt(4);
                int secStock = rs.getInt(5);
                int minStock = rs.getInt(6);
                int defaultorderamount = rs.getInt(7);
                int deleted = rs.getInt(8);
                String product = id+";"+name+";"+price+";"+stock+";"+secStock+";"+minStock+";"+defaultorderamount+";"+deleted;
                pw.println(product);
                pw.flush();
            }
            pw.println(IServerProtocol.END_INFO_TRANSFER);
            pw.flush();
        }

        private void GetZeroStockProductList(BufferedReader bfr, PrintWriter pw) throws SQLException {
            String sql = "SELECT * FROM PRODUCTS WHERE STOCK=0 ORDER BY IDPRODUCT ASC;";
            ResultSet rs = man.executeQuery(sql);
            
            while(rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                double price = rs.getDouble(3);
                int stock = rs.getInt(4);
                int secStock = rs.getInt(5);
                int minStock = rs.getInt(6);
                int defaultorderamount = rs.getInt(7);
                int deleted = rs.getInt(8);
                String product = id+";"+name+";"+price+";"+stock+";"+secStock+";"+minStock+";"+defaultorderamount+";"+deleted;
                pw.println(product);
                pw.flush();
            }
            pw.println(IServerProtocol.END_INFO_TRANSFER);
            pw.flush();
        }

        private void CreateReport(BufferedReader bfr, PrintWriter pw) throws IOException, SQLException, ParseException {
            int type = Integer.parseInt(bfr.readLine());
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            Date day = null;
            ReportCreator rc = null;
            switch(type){
                case IServerProtocol.TYPE_USERS_REPORT:
                    rc = new ReportCreator(ReportCreator.USERS_REPORT);
                    break;
                case IServerProtocol.TYPE_FULL_ORDERS_REPORT:
                    rc = new ReportCreator(ReportCreator.FULL_ORDERS_REPORT);
                    break;
                case IServerProtocol.TYPE_DAILY_ORDERS_REPORT:
                    day = sdf.parse(bfr.readLine());
                    rc = new ReportCreator(ReportCreator.DAILY_ORDERS_REPORT, day);
                    break;
                case IServerProtocol.TYPE_FULL_EXPENSES_BENEFITS_REPORT:
                    rc = new ReportCreator(ReportCreator.FULL_EXPESES_BENEFITS_REPORT);
                    break;
                case IServerProtocol.TYPE_DAILY_EXPENSES_BENEFITS_REPORT:
                    day = sdf.parse(bfr.readLine());
                    rc = new ReportCreator(ReportCreator.DAILY_EXPENSES_BENEFITS_REPORT, day);
                    break;
                case IServerProtocol.TYPE_FULL_SALES_REPORT:
                    rc = new ReportCreator(ReportCreator.FULL_SALES_REPORT);
                    break;
                case IServerProtocol.TYPE_DAILY_SALES_REPORT:
                    day = sdf.parse(bfr.readLine());
                    rc = new ReportCreator(ReportCreator.DAILY_SALES_REPORT, day);
                    break;
                case IServerProtocol.TYPE_PRODUCTS_REPORT:
                    rc = new ReportCreator(ReportCreator.PRODUCTS_REPORT);
                    break;
                case IServerProtocol.TYPE_DELETED_PRODUCTS_REPORT:
                    rc = new ReportCreator(ReportCreator.DELETED_PRODUCTS_REPORT);
                    break;
                case IServerProtocol.TYPE_TICKET_REPORT:
                    day = sdf.parse(bfr.readLine());
                    rc = new ReportCreator(ReportCreator.TICKET_REPORT, day);
                    break;
            }
            
            pw.println(rc.getFilename());
            pw.flush();
            
        }

        private void GetReportList(BufferedReader bfr, PrintWriter pw) {            
            File root = new File("./serverfiles/reports/");
            if(!root.exists()){
                root.mkdir();
                pw.println(IServerProtocol.END_INFO_TRANSFER);
                pw.flush();
            }else{
                File[] allFiles = root.listFiles();
                for(File f : allFiles){
                    if(f.getName().endsWith(".pdf"))
                        pw.println(f.getName());
                }
                pw.println(IServerProtocol.END_INFO_TRANSFER);
                pw.flush();
            }
        }

        private void GetReport(BufferedReader bfr, PrintWriter pw) throws IOException, SQLException {
            String filename = bfr.readLine();
            int method = Integer.parseInt(bfr.readLine());
            
            File report = new File("./serverfiles/reports/"+filename);
            if(filename.startsWith("Ticket")){
                report = new File("./serverfiles/reports/ticket/"+filename); //si es un ticket lo buscaremos en la carpeta de tickets
            }
            
            if(method == IServerProtocol.METHOD_MAIL){
                String user = bfr.readLine();
                String sql = "SELECT P.EMAIL FROM PROFILES P, USERS U WHERE P.IDUSER = (SELECT IDUSER FROM USERS WHERE USERNAME='"+user+"');";
                ResultSet rs = man.executeQuery(sql);
                rs.next();
                String email = rs.getString(1);
                MailSender ms = new MailSender();
                String filetype = filename.split("_")[0];
                ms.sendFileMail(filetype, email, report.getAbsolutePath());
            }else if(method == IServerProtocol.METHOD_CLIENT){
                
            }
            
            pw.println(IServerProtocol.END_INFO_TRANSFER);
            pw.flush();            
        }

        
    }
}
