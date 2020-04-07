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
    public static final int LOGOUT = 0;
    public static final int ROLEINFO = 1;
    public static final int RECEIVED_MAIL = 2;
    public static final int SENT_MAIL = 3;
    public static final int COMMUNICATE_READED_MAIL = 4;
    public static final String END_INFO_TRANSFER = "END";
}
