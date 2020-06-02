/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telegram;

import java.io.File;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import persistence.BotDAO;
import persistence.ReportCreator;

/**
 *
 * @author erome
 */
public class Bot extends TelegramLongPollingBot {
    private String botToken = "1151594228:AAGmecZE-yuYDmieNP2Tm8ErZdByMZ5pCXk";
    private String botUsername = "BusinessControlSystem_bot";
    private JTextArea serverLog;
    BotDAO dao;
    
    public Bot(JTextArea serverLog){
        super();
        this.serverLog = serverLog;
        this.dao = new BotDAO();
    }
    
    
    @Override
    public String getBotToken() {
        return this.botToken;
    }

    @Override
    public void onUpdateReceived(Update update) {
        
        serverLog.append(String.format("TELEGRAM BOT (Message Received): %s\n\n", update.getMessage().getFrom().getUserName()));
        String msg = update.getMessage().getText();
        SendMessage sendMessage = new SendMessage().setChatId(update.getMessage().getChatId());
        SendDocument sendDocument = new SendDocument().setChatId(update.getMessage().getChatId());
        ReportCreator rc;
                
        switch(msg){
            case "/start":
                sendMessage.setText("Use /help to know all available commands or /info for BCS & Telegram requirements");
                break;
            case "/help":
                sendMessage.setText("/help -> Get this message.\n"
                        + "/info -> Connection to Telegram with BCS.\n"
                        + "/usersreport -> Get A New Users Report.\n"
                        + "/productsreport -> Get New Product Report.\n"
                        + "/todaysales -> Get Today Sales Report.\n"
                        + "/todayorders -> Get Today Orders Report.\n"
                        + "/todaybalance -> Get Today Expenses - Benefits Report.\n");
                break;
            case "/info":
                sendMessage.setText("You must introduce your Telegram Username into BCS and have permissions to Print Reports.\n");
                break;
            case "/usersreport":
            {
                try {
                    if(dao.checkTelegramUsername(update.getMessage().getFrom().getUserName())){
                        rc = new ReportCreator(ReportCreator.USERS_REPORT);
                        sendMessage.setText("SENDING A NEW USERS REPORT.\n");
                        System.out.println(rc.getFilename());
                        sendDocument.setDocument(new File("./serverfiles/reports/"+rc.getFilename()));
                    }else{
                        sendMessage.setText("You can't do this, check if you have permission to Print Reports or if your Telegram User is registred into BCS.\n");
                    }
                        
                } catch (SQLException ex) {
                    System.out.println("Could Not Send Message");
                }
                break;
            }
            case "/productsreport":
                {
                try {
                    if(dao.checkTelegramUsername(update.getMessage().getFrom().getUserName())){
                        rc = new ReportCreator(ReportCreator.PRODUCTS_REPORT);
                        sendMessage.setText("SENDING NEW PRODUCTS REPORT.\n");
                        System.out.println(rc.getFilename());
                        sendDocument.setDocument(new File("./serverfiles/reports/"+rc.getFilename()));
                    }else{
                        sendMessage.setText("You can't do this, check if you have permission to Print Reports or if your Telegram User is registred into BCS.\n");
                    }
                        
                } catch (SQLException ex) {
                    System.out.println("Could Not Send Message");
                }
                break;
            }
            case "/todaysales":
            {
                try {
                    if(dao.checkTelegramUsername(update.getMessage().getFrom().getUserName())){
                        rc = new ReportCreator(ReportCreator.DAILY_SALES_REPORT, new Date());
                        sendMessage.setText("SENDING TODAY SALES REPORT.\n");
                        System.out.println(rc.getFilename());
                        sendDocument.setDocument(new File("./serverfiles/reports/"+rc.getFilename()));
                    }else{
                        sendMessage.setText("You can't do this, check if you have permission to Print Reports or if your Telegram User is registred into BCS.\n");
                    }
                        
                } catch (SQLException ex) {
                    System.out.println("Could Not Send Message");
                }
                break;
            }
            case "/todayorders":
            {
                try {
                    if(dao.checkTelegramUsername(update.getMessage().getFrom().getUserName())){
                        rc = new ReportCreator(ReportCreator.DAILY_ORDERS_REPORT, new Date());
                        sendMessage.setText("SENDING TODAY ORDERS REPORT REPORT.\n");
                        System.out.println(rc.getFilename());
                        sendDocument.setDocument(new File("./serverfiles/reports/"+rc.getFilename()));
                    }else{
                        sendMessage.setText("You can't do this, check if you have permission to Print Reports or if your Telegram User is registred into BCS.\n");
                    }
                        
                } catch (SQLException ex) {
                    System.out.println("Could Not Send Message");
                }
                break;
            }
            case "/todaybalance":
            {
                try {
                    if(dao.checkTelegramUsername(update.getMessage().getFrom().getUserName())){
                        rc = new ReportCreator(ReportCreator.DAILY_EXPENSES_BENEFITS_REPORT, new Date());
                        sendMessage.setText("SENDING TODAY EXPENSES-BENTEFITS REPORT.\n");
                        System.out.println(rc.getFilename());
                        sendDocument.setDocument(new File("./serverfiles/reports/"+rc.getFilename()));
                    }else{
                        sendMessage.setText("You can't do this, check if you have permission to Print Reports or if your Telegram User is registred into BCS.\n");
                    }
                        
                } catch (SQLException ex) {
                    System.out.println("Could Not Send Message");
                }
                break;
            }
            default:
                sendMessage.setText("Unknown Command, use /help.\n");

        }

        try{ //Enviamos la respuesta
            execute(sendMessage);
        }catch(TelegramApiException ex){}

        try{ //Enviamos documento (si debe enviarse)
                            execute(sendDocument);
                        } catch (TelegramApiException ex) {}
    }

    @Override
    public String getBotUsername() {
        return this.botUsername;
    }
    
}
