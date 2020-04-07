/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import persistence.ServerPreferencesAdmin;

/**
 *
 * @author erome
 */
public class Encrypt {
    
    public static String encriptar_DESede(String texto) throws Exception {
        ServerPreferencesAdmin prefs = ServerPreferencesAdmin.getInstance();
        String secretKey = desencriptar_DESede(readKey(), prefs.getPassword());
        String base64EncryptedString = "";

        try {

            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] digestOfPassword = md.digest(secretKey.getBytes("utf-8"));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);

            SecretKey key = new SecretKeySpec(keyBytes, "DESede");
            Cipher cipher = Cipher.getInstance("DESede");
            cipher.init(Cipher.ENCRYPT_MODE, key);

            byte[] plainTextBytes = texto.getBytes("utf-8");
            byte[] buf = cipher.doFinal(plainTextBytes);
            byte[] base64Bytes = Base64.getEncoder().encode(buf);
            base64EncryptedString = new String(base64Bytes);

        } catch (Exception ex) {
            System.out.println("Error durante la encriptación");
            System.out.println(ex.getMessage());
        }
        return base64EncryptedString;
    }
    
    public static String desencriptar_DESede(String textoEncriptado) throws Exception {
        ServerPreferencesAdmin prefs = ServerPreferencesAdmin.getInstance();
        String secretKey = desencriptar_DESede(readKey(), prefs.getPassword());
        String base64EncryptedString = "";

        try {
            byte[] message = Base64.getDecoder().decode(textoEncriptado.getBytes("utf-8"));
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] digestOfPassword = md.digest(secretKey.getBytes("utf-8"));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
            SecretKey key = new SecretKeySpec(keyBytes, "DESede");

            Cipher decipher = Cipher.getInstance("DESede");
            decipher.init(Cipher.DECRYPT_MODE, key);

            byte[] plainText = decipher.doFinal(message);

            base64EncryptedString = new String(plainText, "UTF-8");

        } catch (Exception ex) {
        }
        return base64EncryptedString;
    }   
    
    public static String encriptar_DESede(String texto, String secretKey) {
        ServerPreferencesAdmin spa = ServerPreferencesAdmin.getInstance();
        String base64EncryptedString = "";

        try {

            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] digestOfPassword = md.digest(secretKey.getBytes("utf-8"));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);

            SecretKey key = new SecretKeySpec(keyBytes, "DESede");
            Cipher cipher = Cipher.getInstance("DESede");
            cipher.init(Cipher.ENCRYPT_MODE, key);

            byte[] plainTextBytes = texto.getBytes("utf-8");
            byte[] buf = cipher.doFinal(plainTextBytes);
            byte[] base64Bytes = Base64.getEncoder().encode(buf);
            base64EncryptedString = new String(base64Bytes);

        } catch (Exception ex) {
            System.out.println("Error durante la encriptación");
            System.out.println(ex.getMessage());
        }
        return base64EncryptedString;
    }
    
    public static String desencriptar_DESede(String textoEncriptado, String secretKey) throws Exception {
        ServerPreferencesAdmin spa = ServerPreferencesAdmin.getInstance();
        String base64EncryptedString = "";

        try {
            byte[] message = Base64.getDecoder().decode(textoEncriptado.getBytes("utf-8"));
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] digestOfPassword = md.digest(secretKey.getBytes("utf-8"));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
            SecretKey key = new SecretKeySpec(keyBytes, "DESede");

            Cipher decipher = Cipher.getInstance("DESede");
            decipher.init(Cipher.DECRYPT_MODE, key);

            byte[] plainText = decipher.doFinal(message);

            base64EncryptedString = new String(plainText, "UTF-8");

        } catch (Exception ex) {
        }
        return base64EncryptedString;
    }   
    
    
    private static void generateRandomKey() {
        BufferedWriter bfw = null;
        try {
            final String keyPath = "./serverfiles/randomkey.key";
            
            //Genero un String aleatorio de 100 caracteres
            int leftLimit = 48; // numeral '0'
            int rightLimit = 122; // letter 'z'
            int targetStringLength = 100; //tamaño final del string
            Random random = new Random();
            String generatedString = random.ints(leftLimit, rightLimit + 1)
                    .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                    .limit(targetStringLength)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();
            File f = new File(keyPath);
            bfw = new BufferedWriter(new FileWriter(f));
            bfw.write(generatedString);
            bfw.flush();
                       
            bfw.close();
            
            f.setReadOnly();
            
            ServerPreferencesAdmin prefs = ServerPreferencesAdmin.getInstance();
            prefs.setRandomKeyPath(keyPath);
            
        } catch (IOException ex) {
            Logger.getLogger(Encrypt.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                bfw.close();
            } catch (IOException ex) {
                Logger.getLogger(Encrypt.class.getName()).log(Level.SEVERE, null, ex);
            }
        }   
    }
    
    public static String readKey(){
        if(!(new File("./serverfiles/randomkey.key")).exists()) //si no existe una clave la genero
            generateRandomKey();
        
        BufferedReader bfr = null;
        try {
            ServerPreferencesAdmin prefs = ServerPreferencesAdmin.getInstance();
            bfr = new BufferedReader(new FileReader(new File(prefs.getRandomKeyPath())));
            return bfr.readLine();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Encrypt.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Encrypt.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                bfr.close();
            } catch (IOException ex) {
                Logger.getLogger(Encrypt.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
}
