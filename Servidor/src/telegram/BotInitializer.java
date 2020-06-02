/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telegram;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

/**
 *
 * @author erome
 */
public class BotInitializer {
    Bot myBot;
    public BotInitializer(JTextArea serverLog){
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotApi = new TelegramBotsApi();
        
        myBot = new Bot(serverLog);
        
        try{
            telegramBotApi.registerBot(myBot);
            serverLog.append("TELEGRAM BOT INITIALIZED\n");
        } catch (TelegramApiRequestException ex) {
            serverLog.append("TELEGRAM BOT INITIALIZATION FAILED\n");
        }
    }
}
