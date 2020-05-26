/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

/**
 *
 * @author erome
 */
public interface IServerProtocol {
    public static final String END_INFO_TRANSFER = "END";
    
    public static final int LOGOUT = 0;
    public static final int ROLEINFO = 1;
    public static final int RECEIVED_MAIL = 2;
    public static final int SENT_MAIL = 3;
    public static final int COMMUNICATE_READED_MAIL = 4;
    public static final int GET_USERS_LIST = 5;
    public static final int CREATE_NEW_USER = 6;
    public static final int DELETE_USER = 7;
    public static final int GET_PROFILE = 8;
    public static final int SET_PROFILE = 9;
    public static final int CHANGE_PASSWORD = 10;   
    public static final int GET_ROLES_LIST = 11;
    public static final int SET_USER_ROLE = 12;
    public static final int DELETE_ROLE = 13;
    public static final int GET_PERMS_LIST = 14;
    public static final int CREATE_NEW_ROLE = 15;
    public static final int NEW_PASSWORD = 16;
    public static final int SEND_INMAIL = 17;
    public static final int GET_PRODUCTS_LIST = 18;
    public static final int CREATE_NEW_PRODUCT = 19;
    public static final int EDIT_PRODUCT = 20;
    public static final int DELETE_PRODUCT = 21;
    public static final int RECOVER_PRODUCT = 22;
    public static final int GET_PRODUCT_PRICE = 23;
    public static final int CREATE_SALES = 24;
}
