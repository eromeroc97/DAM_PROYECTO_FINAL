/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author erome
 */
public class ReportCreator {
    public static final int USERS_REPORT = 1;
    public static final int FULL_ORDERS_REPORT = 2;
    public static final int DAILY_ORDERS_REPORT = 3;
    public static final int FULL_EXPESES_BENEFITS_REPORT = 4;
    public static final int DAILY_EXPENSES_BENEFITS_REPORT = 5;
    public static final int FULL_SALES_REPORT = 6;
    public static final int DAILY_SALES_REPORT = 7;
    public static final int PRODUCTS_REPORT = 8;
    public static final int DELETED_PRODUCTS_REPORT = 9;
    public static final int TICKET_REPORT = 10;
    
    private static final String ROOT_REPORT_FOLDER = "./serverfiles/reports/";
    
    
    private int type;
    private Date daydate;
    private String filename;
    
    private SQLiteManager man;
    
    public ReportCreator(int type) throws SQLException{
        this.man = SQLiteManager.getSingletonInstance();
        this.type = type;
        this.daydate = null;
        try {
            createReport();
        } catch (FileNotFoundException | DocumentException ex) {
            Logger.getLogger(ReportCreator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ReportCreator(int type, Date daydate) throws SQLException{
        this.man = SQLiteManager.getSingletonInstance();
        this.type = type;
        this.daydate = daydate;
        try {
            createReport();
        } catch (FileNotFoundException | DocumentException ex) {
            Logger.getLogger(ReportCreator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void createReport() throws SQLException, FileNotFoundException, DocumentException{
        String date = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss").format(new Date()), day = null;
        if(type == TICKET_REPORT && daydate != null)
            day = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(daydate);
        else if(daydate != null)
            day = new SimpleDateFormat("dd-MM-yyyy").format(daydate);
        
        switch(this.type){
            case 1:
                this.filename = "UsersReport_"+date+".pdf";
                UsersReport();
                break;

            case 2:
                this.filename = "FullOrdersReport_"+date+".pdf";
                FullOrdersReport();
                break;
            case 3:
                this.filename = "DailyOrdersReport_"+date+"_"+day+".pdf";
                DailyOrdersReport(day);
                break;
            case 4:
                this.filename = "FullExpensesBenefitsReport_"+date+".pdf";
                FullExpensesBenefitsReport();
                break;
            case 5:
                this.filename = "DailyExpensesBenefitsReport_"+date+"_"+day+".pdf";
                DailyExpensesBenefitsReport(day);
                break;
            case 6:
                this.filename = "FullSalesReport_"+date+".pdf";
                FullSalesReport();
                break;
            case 7:
                this.filename = "DailySalesReport_"+date+"_"+day+".pdf";
                DailySalesReport(day);
                break;
            case 8:
                this.filename = "ProductsReport_"+date+".pdf";
                ProductsReport();
                break;

            case 9:
                this.filename = "DeletedProductsReport_"+date+".pdf";
                DeletedProductsReport();
                break;
            case 10:
                this.filename = "Ticket_"+date+".pdf";
                TicketReport(day);
                break;
        }
    }
    
    public String getFilename(){
        return this.filename;
    }
    
    private void UsersReport() throws SQLException, FileNotFoundException, DocumentException{
        String[] header = new String[]{"ID USER", "USER NAME", "ROLE NAME", "LAST CONNECTION"};
        LinkedList<String[]> list = new LinkedList<>();
        String sql = "SELECT U.IDUSER, U.USERNAME, R.ROLENAME, U.LASTCONNECTION FROM USERS U, ROLES R WHERE U.IDROLE = R.IDROLE;";
        ResultSet rs = man.executeQuery(sql);
        while(rs.next()){
            String[] data = new String[header.length]; 
            data[0] = Integer.toString(rs.getInt(1)); //id
            data[1] = rs.getString(2); //name
            data[2] = rs.getString(3); //role
            data[3] = rs.getString(4); //lastconnection
            list.add(data);
        }
        createPDF("USERS REPORT", header, list);
    }
    
    private void FullOrdersReport() throws SQLException, FileNotFoundException, DocumentException{
        String[] header = new String[]{"ID ORDER", "PRODUCT", "ORDER DATE", "UNITS", "CONFIRMED", "ORDER COST"};
        LinkedList<String[]> list = new LinkedList<>();
        String sql = "SELECT O.IDORDER, P.PRODUCTNAME, O.ORDERDATE, O.UNITS, O.CONFIRMED, O.UNITS*P.PRICE FROM ORDERS O, PRODUCTS P WHERE O.IDPRODUCT = P.IDPRODUCT;";
        ResultSet rs = man.executeQuery(sql);
        while(rs.next()){
            String[] data = new String[header.length]; 
            data[0] = Integer.toString(rs.getInt(1)); //id
            data[1] = rs.getString(2); //product
            data[2] = rs.getString(3); //date
            data[3] = Integer.toString(rs.getInt(4)); //units
            data[4] = Integer.toString(rs.getInt(5)); //confirmed
            data[5] = Double.toString(rs.getDouble(6));
            
            list.add(data);
        }
        createPDF("FULL ORDERS REPORT", header, list);
    }
    
    private void DailyOrdersReport(String day) throws SQLException, FileNotFoundException, DocumentException{
        String[] header = new String[]{"ID ORDER", "PRODUCT", "ORDER DATE", "UNITS", "CONFIRMED", "ORDER COST"};
        LinkedList<String[]> list = new LinkedList<>();
        String sql = "SELECT O.IDORDER, P.PRODUCTNAME, O.ORDERDATE, O.UNITS, O.CONFIRMED, O.UNITS*P.PRICE "
                + "FROM ORDERS O, PRODUCTS P "
                + "WHERE O.IDPRODUCT = P.IDPRODUCT AND O.ORDERDATE BETWEEN ('"+day.replaceAll("-", "/")+"'-1) AND '"+day.replaceAll("-", "/")+"';";
        ResultSet rs = man.executeQuery(sql);
        while(rs.next()){
            String[] data = new String[header.length]; 
            data[0] = Integer.toString(rs.getInt(1)); //id
            data[1] = rs.getString(2); //product
            data[2] = rs.getString(3); //date
            data[3] = Integer.toString(rs.getInt(4)); //units
            data[4] = Integer.toString(rs.getInt(5)); //confirmed
            data[5] = Double.toString(rs.getDouble(6)); //total cost
            
            list.add(data);
        }
        createPDF("DAILY ORDERS REPORT "+day.replaceAll("-", "/"), header, list);
    }
    
    private void FullExpensesBenefitsReport() throws SQLException, FileNotFoundException, DocumentException{
        String[] header = new String[]{"EXPENSES", "BENEFITS", "BALANCE"};
        LinkedList<String[]> list = new LinkedList<>();
        String[] data = new String[header.length]; 
        //expenses
        String sql = "SELECT SUM(O.UNITS*P.PRICE) AS 'EXPENSES' FROM ORDERS O, PRODUCTS P WHERE P.IDPRODUCT = O.IDPRODUCT;";
        ResultSet rs = man.executeQuery(sql);
        if(rs.next()){
            data[0] = Double.toString(rs.getDouble(1));
        }
        //benefits
        sql = "SELECT SUM(S.UNITS*P.PRICE) AS 'BENEFITS' FROM SALES S, PRODUCTS P WHERE P.IDPRODUCT = S.IDPRODUCT;";
        rs = man.executeQuery(sql);
        if(rs.next()){
            data[1] = Double.toString(rs.getDouble(1));
        }
        //balance
        data[2] = Double.toString(Double.parseDouble(data[1])-Double.parseDouble(data[0]));
        
        list.add(data);
        createPDF("FULL EXPENSES-BENEFITS REPORT", header, list);
    }
    
    private void DailyExpensesBenefitsReport(String day) throws SQLException, FileNotFoundException, DocumentException{
        String[] header = new String[]{"EXPENSES", "BENEFITS", "BALANCE"};
        LinkedList<String[]> list = new LinkedList<>();
        String[] data = new String[header.length]; 
        //expenses
        String sql = "SELECT SUM(O.UNITS*P.PRICE) AS 'EXPENSES' "
                + "FROM ORDERS O, PRODUCTS P "
                + "WHERE P.IDPRODUCT = O.IDPRODUCT AND O.ORDERDATE BETWEEN ('"+day.replaceAll("-", "/")+"'-1) AND '"+day.replaceAll("-", "/")+"';";
        ResultSet rs = man.executeQuery(sql);
        if(rs.next()){
            data[0] = Double.toString(rs.getDouble(1));
        }
        //benefits
        sql = "SELECT SUM(S.UNITS*P.PRICE) AS 'BENEFITS' FROM SALES S, PRODUCTS P WHERE P.IDPRODUCT = S.IDPRODUCT AND S.SALEDATE='"+day+"';";
        rs = man.executeQuery(sql);
        if(rs.next()){
            data[1] = Double.toString(rs.getDouble(1));
        }
        //balance
        data[2] = Double.toString(Double.parseDouble(data[1])-Double.parseDouble(data[0]));
        
        list.add(data);
        createPDF("DAILY EXPENSES-BENEFITS REPORT "+day.replaceAll("-", "/"), header, list);
    }
    
    private void FullSalesReport() throws SQLException, FileNotFoundException, DocumentException{
        String[] header = new String[]{"ID SALE", "PRODUCT", "SELLER", "SALE PRICE", "UNITS", "SALE DATE", "TOTAL VALUE"};
        LinkedList<String[]> list = new LinkedList<>();
        String sql = "SELECT S.IDSALE, P.PRODUCTNAME, U.USERNAME, S.SALEPRICE, S.UNITS, S.SALEDATE, S.UNITS*S.SALEPRICE "
                + "FROM SALES S, PRODUCTS P, USERS U WHERE S.IDPRODUCT=P.IDPRODUCT AND U.IDUSER=S.IDUSER;";
        ResultSet rs = man.executeQuery(sql);
        while(rs.next()){
            String[] data = new String[header.length]; 
            data[0] = Integer.toString(rs.getInt(1)); //id
            data[1] = rs.getString(2); //product
            data[2] = rs.getString(3); //user
            data[3] = Double.toString(rs.getDouble(4)); //saleprice
            data[4] = Integer.toString(rs.getInt(5)); //units
            data[5] = rs.getString(6); //saledate
            data[6] = Double.toString(rs.getDouble(7)); //total value
            
            list.add(data);
        }
        createPDF("FULL SALES REPORT ", header, list);
    }
    
    private void DailySalesReport(String day) throws SQLException, FileNotFoundException, DocumentException{
        String[] header = new String[]{"ID SALE", "PRODUCT", "SELLER", "SALE PRICE", "UNITS", "SALE DATE", "TOTAL VALUE"};
        LinkedList<String[]> list = new LinkedList<>();        
        String sql = "SELECT S.IDSALE, P.PRODUCTNAME, U.USERNAME, S.SALEPRICE, S.UNITS, S.SALEDATE, S.UNITS*S.SALEPRICE "
                + "FROM SALES S, PRODUCTS P, USERS U "
                + "WHERE S.IDPRODUCT=P.IDPRODUCT AND U.IDUSER=S.IDUSER AND S.SALEDATE BETWEEN ('"+day.replaceAll("-", "/")+"'-1) AND '"+day.replaceAll("-", "/")+"';";
        ResultSet rs = man.executeQuery(sql);
        while(rs.next()){
            String[] data = new String[header.length]; 
            data[0] = Integer.toString(rs.getInt(1)); //id
            data[1] = rs.getString(2); //product
            data[2] = rs.getString(3); //user
            data[3] = Double.toString(rs.getDouble(4)); //saleprice
            data[4] = Integer.toString(rs.getInt(5)); //units
            data[5] = rs.getString(6); //saledate
            data[6] = Double.toString(rs.getDouble(7)); //total value
            
            list.add(data);
        }
        createPDF("DAILY SALES REPORT "+day.replaceAll("-","/"), header, list);
    }
    
    private void ProductsReport() throws SQLException, FileNotFoundException, DocumentException{
        String[] header = new String[]{"ID PRODUCT", "PRODUCT NAME", "PRICE", "STOCK", "SECURITY STOCK", "MIN. STOCK", "DEFAULT ORDER AMOUNT"};
        LinkedList<String[]> list = new LinkedList<>();
        String sql = "SELECT IDPRODUCT, PRODUCTNAME, PRICE, STOCK, SECURITYSTOCK, MINIMUMSTOCK, DEFAULTORDERAMOUNT FROM PRODUCTS WHERE DELETED=FALSE;";
        ResultSet rs = man.executeQuery(sql);
        while(rs.next()){
            String[] data = new String[header.length];
            data[0] = Integer.toString(rs.getInt(1)); //id
            data[1] = rs.getString(2); //name
            data[2] = Double.toString(rs.getDouble(3)); //price
            data[3] = Integer.toString(rs.getInt(4)); //stock
            data[4] = Integer.toString(rs.getInt(5)); //security stock
            data[5] = Integer.toString(rs.getInt(6)); //min stock
            data[6] = Integer.toString(rs.getInt(7)); //default order amount
            list.add(data);
        }
        createPDF("PRODUCTS REPORT", header, list);
    }
    
    private void DeletedProductsReport() throws SQLException, FileNotFoundException, DocumentException{
        String[] header = new String[]{"ID PRODUCT", "PRODUCT NAME", "PRICE", "STOCK", "SECURITY STOCK", "MIN. STOCK", "DEFAULT ORDER AMOUNT"};
        LinkedList<String[]> list = new LinkedList<>();
        String sql = "SELECT IDPRODUCT, PRODUCTNAME, PRICE, STOCK, SECURITYSTOCK, MINIMUMSTOCK, DEFAULTORDERAMOUNT FROM PRODUCTS WHERE DELETED=TRUE;";
        ResultSet rs = man.executeQuery(sql);
        while(rs.next()){
            String[] data = new String[header.length];
            data[0] = Integer.toString(rs.getInt(1)); //id
            data[1] = rs.getString(2); //name
            data[2] = Double.toString(rs.getDouble(3)); //price
            data[3] = Integer.toString(rs.getInt(4)); //stock
            data[4] = Integer.toString(rs.getInt(5)); //security stock
            data[5] = Integer.toString(rs.getInt(6)); //min stock
            data[6] = Integer.toString(rs.getInt(7)); //default order amount
            list.add(data);
        }
        createPDF("DELETED PRODUCTS REPORT", header, list);
    }
    
    private void TicketReport(String day) throws SQLException, FileNotFoundException, DocumentException{
        String[] header = new String[]{"PRODUCT", "UNITS", "PRICE"};
        LinkedList<String[]> list = new LinkedList<>();
        String sql = "SELECT P.PRODUCTNAME, S.UNITS, S.SALEPRICE FROM PRODUCTS P, SALES S WHERE S.IDPRODUCT = P.IDPRODUCT AND S.SALEDATE='"+day+"';";
        ResultSet rs = man.executeQuery(sql);
        while(rs.next()){
            String[] data = new String[header.length];
            data[0] = rs.getString(1); //name
            data[1] = Integer.toString(rs.getInt(2)); //units
            data[2] = Double.toString(rs.getDouble(3)); //price
            list.add(data);
        }
        String seller = null;
        sql = "SELECT U.USERNAME FROM USERS U, SALES S WHERE S.IDUSER = U.IDUSER AND S.SALEDATE ='"+day+"';";
        rs = man.executeQuery(sql);
        if(rs.next())
            seller = rs.getString(1);
        
        double total = 0;
        sql = "SELECT SUM(UNITS*SALEPRICE) FROM SALES WHERE SALEDATE='"+day+"' AND IDUSER=(SELECT IDUSER FROM USERS WHERE USERNAME='"+seller+"');";
        rs = man.executeQuery(sql);
        if(rs.next())
            total = rs.getDouble(1);
            
        createTicketPDF("TICKET "+day.replaceAll("-","/"), header, list, seller, total);
    }

    private void createPDF(String title, String[] header, LinkedList<String[]> data) throws FileNotFoundException, DocumentException{
        //Creamos el directorio que guardará los PDFs
        File dir = new File(ROOT_REPORT_FOLDER);
        if(!dir.exists()){
            dir.mkdir();
        }
        
        //Documento
        Document doc = new Document(PageSize.A4); 
        //Output Stream
        FileOutputStream ficheroPDF = new FileOutputStream(new File(ROOT_REPORT_FOLDER+filename));
        //Asociamos el document al output stream
        PdfWriter.getInstance(doc, ficheroPDF);
        //Apertura del documento
        doc.open();
        
        //Creamos el titulo y lo añadimos
        Paragraph pTitle = new Paragraph(title+"\n\n",
        FontFactory.getFont("arial", 22, Font.BOLD, new BaseColor(239,96,0))
        );
        
        doc.add(pTitle);
        
        //Creamos la tabla de datos
        Paragraph pTable = new Paragraph();
        PdfPTable table = new PdfPTable(header.length);
        table.setTotalWidth(PageSize.A4.getWidth()-20);
        table.setLockedWidth(true);
        
        for(String h : header)
            table.addCell(h);
        
        for(int i = 0; i < data.size(); i++){
            for(String s : data.get(i))
                table.addCell(s);
        }
        
        pTable.add(table);
        
        //añado la tabla al documento
        doc.add(pTable);

        //Cerramos el documento
        doc.close();
    }
    
    private void createTicketPDF(String title, String[] header, LinkedList<String[]> data, String seller, double total) throws FileNotFoundException, DocumentException{
        //Creamos el directorio que guardará los PDFs
        File dir = new File(ROOT_REPORT_FOLDER+"ticket/");
        if(!dir.exists()){
            dir.mkdirs();
        }
        
        //Documento
        Document doc = new Document(PageSize.A4); 
        //Output Stream
        FileOutputStream ficheroPDF = new FileOutputStream(new File(ROOT_REPORT_FOLDER+"ticket/"+filename));
        //Asociamos el document al output stream
        PdfWriter.getInstance(doc, ficheroPDF);
        //Apertura del documento
        doc.open();
        
        //Creamos el titulo y lo añadimos
        Paragraph pTitle = new Paragraph(title+"\n",
        FontFactory.getFont("courier new", 16, Font.BOLD, new BaseColor(0,0,0))
        );
        
        Paragraph pSeller = new Paragraph("SELLER: "+seller+"\n\n",
        FontFactory.getFont("courier new", 12, Font.NORMAL, new BaseColor(0,0,0))
        );
        
        doc.add(pTitle);
        doc.add(pSeller);
        
        //Creamos la tabla de datos
        Paragraph pTable = new Paragraph();
        PdfPTable table = new PdfPTable(header.length);
        table.setTotalWidth(PageSize.A4.getWidth()-60);
        table.setLockedWidth(true);
        table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
        
        //No añadimos la cabecera de las columnas como texto,
        // se utilizan de manera orientativa para generar el numero de columnas de la tabla
        
        for(int i = 0; i < data.size(); i++){
            for(String s : data.get(i))
                table.addCell(s);
        }
        
        pTable.add(table);
        
        //añado la tabla al documento
        doc.add(pTable);

        Paragraph pTotal = new Paragraph("TOTAL: "+total+" €\n\n",
        FontFactory.getFont("courier new", 12, Font.BOLDITALIC, new BaseColor(0,0,0))
        );
        
        doc.add(pTotal);
        
        //Cerramos el documento
        doc.close();
    }
}
