/*
 * MIT License
 * 
 * Copyright (c) 2019 eromeroc97
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 * 
 */
package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author eromeroc97
 */
public class SQLiteManager {
    private static String db_name = "./serverfiles/server.db"; /* Write here the name of the database */
    private static Connection con;
    private static boolean hasData = false;
    private static SQLiteManager singletonInstance;
    
    private SQLiteManager() throws ClassNotFoundException, SQLException, RuntimeException{
        Class.forName("org.sqlite.JDBC");
        if(!db_name.isEmpty())
            con = DriverManager.getConnection("jdbc:sqlite:"+db_name);
        else
            throw new RuntimeException("Database Name Not Defined");
        initialise();
    }
    
    public static void closeConnection(){
        try {
            con.close();
            singletonInstance = null;
        } catch (SQLException ex) {
            Logger.getLogger(SQLiteManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static SQLiteManager getSingletonInstance(){
        try{
            if(singletonInstance == null){
                singletonInstance = new SQLiteManager();
            }
        }catch (ClassNotFoundException | RuntimeException | SQLException e){
            System.out.println("Error getting singleton instance of SQLiteManager");
            System.out.println(e.getMessage());
        }
        
        return singletonInstance;
    }
    
    
    public ResultSet executeQuery(String sql) {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            return rs;
        } catch (SQLException ex) {
            System.out.println("Error executing query");
            System.out.println(ex.getMessage());
            System.out.println(sql);
            return null;
        }
    }
    
    public void executeNonQuery(String sql){
        try {
            Statement stmt = con.createStatement();
            stmt.execute(sql);
        } catch (SQLException ex) {
            System.out.println("Error executing non query");
            System.out.println(ex.getMessage());
            System.out.println(sql);
        }
    }
        
    private void initialise() throws SQLException {
        if(!hasData){
            hasData = true;
            
            Statement stmt = con.createStatement();
            /*Obtain all created tables name from the database*/
            ResultSet rs = stmt.executeQuery("SELECT name FROM sqlite_master WHERE type='table';");
         
            if(!rs.next()){ /*No tables created*/
                System.out.println("Building tables with prepopulated values.");
                
                Statement stmt2 = con.createStatement();
                //TABLAS
                stmt2.execute(TableCreator.USERS_TABLE);
                stmt2.execute(TableCreator.ROLES_TABLE);
                stmt2.execute(TableCreator.PERM_TABLE);
                stmt2.execute(TableCreator.ROLES_PERM_TABLE);
                stmt2.execute(TableCreator.INMAIL_TABLE);
                stmt2.execute(TableCreator.PROFILES_TABLE);
                stmt2.execute(TableCreator.ADVERTS_TABLE);
                stmt2.execute(TableCreator.PRODUCTS_TABLE);
                stmt2.execute(TableCreator.SALES_TABLE);
                stmt2.execute(TableCreator.ORDERS_TABLE);
                
                //TRIGGERS
                stmt2.execute(TableCreator.VALIDATE_SALE_TRIGGER);
                stmt2.execute(TableCreator.AUTO_ORDER_TRIGGER);
                stmt2.execute(TableCreator.CONFIRMED_ORDER_TRIGGER);
                stmt2.execute(TableCreator.VALIDATE_ORDER_TRIGGER);
                
                //INSERTS POR DEFECTO
                for(String s : (new TableCreator()).INSERTS_PERM)
                    stmt2.execute(s);
                
                for(String s : (new TableCreator()).INSERTS_ROLES)
                    stmt2.execute(s);
                
                for(String s : (new TableCreator()).INSERTS_ROLES_PERM)
                    stmt2.execute(s);
                
            }
        }
    }
    
    private class TableCreator{ /* Write here all table creation SQL queries, then call them from initialise() method*/
        public static final String USERS_TABLE = "CREATE TABLE IF NOT EXISTS USERS("
                + "IDUSER INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "USERNAME TEXT UNIQUE NOT NULL,"
                + "PASSWORD TEXT NOT NULL,"
                + "ONLINE BOOLEAN DEFAULT FALSE,"
                + "IDROLE INTEGER NOT NULL DEFAULT 1,"
                + "LASTCONNECTION DATETIME DEFAULT '01-01-2000 00:00:00',"
                + "DELETED BOOLEAN DEFAULT FALSE,"
                + "FOREIGN KEY (IDROLE) REFERENCES ROLES(IDROLE));";
        
        public static final String ROLES_TABLE = "CREATE TABLE IF NOT EXISTS ROLES("
                + "IDROLE INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "ROLENAME TEXT UNIQUE NOT NULL);";
        
        public static final String PERM_TABLE = "CREATE TABLE IF NOT EXISTS PERM("
                + "IDPERM INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "PERMNAME TEXT UNIQUE NOT NULL);";
        
        public static final String ROLES_PERM_TABLE = "CREATE TABLE IF NOT EXISTS ROLES_PERM("
                + "IDROLE INTEGER,"
                + "IDPERM INTEGER,"
                + "PRIMARY KEY(IDROLE, IDPERM),"
                + "FOREIGN KEY (IDROLE) REFERENCES ROLES(IDROLE),"
                + "FOREIGN KEY (IDPERM) REFERENCES PERM(IDPERM));";
        
        public String[] INSERTS_PERM = new String[]{
            "INSERT INTO PERM (PERMNAME) VALUES('ADMINISTRATE USERS');",
            "INSERT INTO PERM (PERMNAME) VALUES('ADMINISTRATE PROFILES');",
            "INSERT INTO PERM (PERMNAME) VALUES('ADMINISTRATE ROLES');",
            "INSERT INTO PERM (PERMNAME) VALUES('SEND ADVERTS');",
            "INSERT INTO PERM (PERMNAME) VALUES('PRINT REPORTS');",
            "INSERT INTO PERM (PERMNAME) VALUES('SELL PRODUCTS');",
            "INSERT INTO PERM (PERMNAME) VALUES('REGISTER PRODUCTS');",
            "INSERT INTO PERM (PERMNAME) VALUES('CONFIRM ORDERS');",
            "INSERT INTO PERM (PERMNAME) VALUES('CONFIG CONNECTION');"
        };
        
        public String[] INSERTS_ROLES = new String[]{
            "INSERT INTO ROLES (ROLENAME) VALUES('USER');",
            "INSERT INTO ROLES (ROLENAME) VALUES('SYSADMIN');"
        };
        
        public String[] INSERTS_ROLES_PERM = new String[]{
            "INSERT INTO ROLES_PERM VALUES ((SELECT IDROLE FROM ROLES WHERE ROLENAME = 'SYSADMIN'),(SELECT IDPERM FROM PERM WHERE PERMNAME='ADMINISTRATE USERS'));",
            "INSERT INTO ROLES_PERM VALUES ((SELECT IDROLE FROM ROLES WHERE ROLENAME = 'SYSADMIN'),(SELECT IDPERM FROM PERM WHERE PERMNAME='ADMINISTRATE PROFILES'));",
            "INSERT INTO ROLES_PERM VALUES ((SELECT IDROLE FROM ROLES WHERE ROLENAME = 'SYSADMIN'),(SELECT IDPERM FROM PERM WHERE PERMNAME='ADMINISTRATE ROLES'));",
            "INSERT INTO ROLES_PERM VALUES ((SELECT IDROLE FROM ROLES WHERE ROLENAME = 'SYSADMIN'),(SELECT IDPERM FROM PERM WHERE PERMNAME='SEND ADVERTS'));",
            "INSERT INTO ROLES_PERM VALUES ((SELECT IDROLE FROM ROLES WHERE ROLENAME = 'SYSADMIN'),(SELECT IDPERM FROM PERM WHERE PERMNAME='CONFIG CONNECTION'));"
        };
        
        public static final String INMAIL_TABLE = "CREATE TABLE IF NOT EXISTS INMAIL("
                + "IDMAIL INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "SOURCE INTEGER NOT NULL,"
                + "DESTINATION INTEGER NOT NULL,"
                + "SUBJECT TEXT,"
                + "CONTENT TEXT,"
                + "SEND_DATE DATETIME NOT NULL,"
                + "READED BOOLEAN DEFAULT FALSE,"
                + "FOREIGN KEY (SOURCE) REFERENCES USERS(USERNAME),"
                + "FOREIGN KEY (DESTINATION) REFERENCES USERS(USERNAME));";
        
        public static final String PROFILES_TABLE = "CREATE TABLE IF NOT EXISTS PROFILES("
                + "IDUSER INTEGER PRIMARY KEY,"
                + "NAME TEXT,"
                + "SURNAME TEXT,"
                + "EMAIL TEXT,"
                + "PHONE LONG,"
                + "FOREIGN KEY (IDUSER) REFERENCES USERS(IDUSER));";
        
        public static final String ADVERTS_TABLE = "CREATE TABLE IF NOT EXISTS ADVERTS("
                + "IDADVERT INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "IDUSER INTEGER NOT NULL,"
                + "DATE DATETIME NOT NULL,"
                + "MESSAGE TEXT NOT NULL,"
                + "FOREIGN KEY (IDUSER) REFERENCES USERS(IDUSER));";
        
        public static final String PRODUCTS_TABLE = "CREATE TABLE IF NOT EXISTS PRODUCTS("
                + "IDPRODUCT INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "PRODUCTNAME TEXT NOT NULL,"
                + "PRICE DOUBLE NOT NULL,"
                + "STOCK INTEGER NOT NULL,"
                + "SECURITYSTOCK INTEGER NOT NULL,"
                + "MINIMUMSTOCK INTEGER NOT NULL,"
                + "DEFAULTORDERAMOUNT INTEGER NOT NULL,"
                + "DELETED BOOLEAN DEFAULT FALSE);";
        
        public static final String SALES_TABLE = "CREATE TABLE IF NOT EXISTS SALES("
                + "IDSALE INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "IDPRODUCT INTEGER NOT NULL,"
                + "IDUSER INTEGER NOT NULL,"
                + "SALEPRICE DOUBLE NOT NULL,"
                + "UNITS INTEGER NOT NULL DEFAULT 1,"
                + "SALEDATE DATETIME NOT NULL,"
                + "FOREIGN KEY (IDPRODUCT) REFERENCES PRODUCTS(IDPRODUCT),"
                + "FOREIGN KEY (IDUSER) REFERENCES USERS(IDUSER));";
        
        public static final String ORDERS_TABLE = "CREATE TABLE IF NOT EXISTS ORDERS("
                + "IDORDER INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "IDPRODUCT INTEGER NOT NULL,"
                + "ORDERDATE DATETIME NOT NULL,"
                + "UNITS INTEGER NOT NULL,"
                + "CONFIRMED BOOLEAN NOT NULL DEFAULT FALSE,"
                + "FOREIGN KEY (IDPRODUCT) REFERENCES PRODUCTS(IDPRODUCT));";
        
        public static final String VALIDATE_SALE_TRIGGER = "CREATE TRIGGER IF NOT EXISTS VALIDATE_SALE " +
                "BEFORE INSERT ON SALES " +
                "BEGIN " +
                "	SELECT RAISE(ABORT, 'CAN_T SELL MORE THAN AVAILABLE') " +
                "	WHERE EXISTS (SELECT 1 FROM PRODUCTS WHERE NEW.UNITS > PRODUCTS.STOCK AND " +
                "	NEW.IDPRODUCT = PRODUCTS.IDPRODUCT); " +
                "	UPDATE PRODUCTS SET STOCK=(SELECT PRODUCTS.STOCK-NEW.UNITS " +
                "	FROM PRODUCTS WHERE PRODUCTS.IDPRODUCT=NEW.IDPRODUCT); " +
                "END;";
        
        public static final String AUTO_ORDER_TRIGGER = "CREATE TRIGGER IF NOT EXISTS AUTO_ORDER " +
                "AFTER UPDATE OF STOCK ON PRODUCTS " +
                "WHEN NEW.STOCK <= OLD.SECURITYSTOCK AND (SELECT 1 FROM ORDERS WHERE IDPRODUCT=NEW.IDPRODUCT AND CONFIRMED=FALSE) <> 1 " +
                "BEGIN " +
                "	INSERT INTO ORDERS (IDPRODUCT, ORDERDATE, UNITS) " +
                "	VALUES (NEW.IDPRODUCT, date('now'), " +
                "	(SELECT DEFAULTORDERAMOUNT FROM PRODUCTS " +
                "	WHERE PRODUCTS.IDPRODUCT=NEW.IDPRODUCT AND DEFAULTORDERAMOUNT > 0 )); " +
                "END;";
        
        public static final String CONFIRMED_ORDER_TRIGGER = "CREATE TRIGGER IF NOT EXISTS CONFIRMED_ORDER " +
                "AFTER UPDATE OF CONFIRMED ON ORDERS "+
                "BEGIN " +
                "	UPDATE PRODUCTS SET STOCK = STOCK + OLD.UNITS WHERE PRODUCTS.IDPRODUCT = OLD.IDPRODUCT; " +
                "END;";
        
        public static final String VALIDATE_ORDER_TRIGGER = "CREATE TRIGGER IF NOT EXISTS VALIDATE_ORDER\n" +
                "AFTER INSERT ON ORDERS " +
                "BEGIN " +
                "	SELECT RAISE(IGNORE) " +
                "	WHERE EXISTS (SELECT 1 FROM ORDERS WHERE IDPRODUCT=NEW.IDPRODUCT AND CONFIRMED=FALSE); " +
                "END;";
    }
}


