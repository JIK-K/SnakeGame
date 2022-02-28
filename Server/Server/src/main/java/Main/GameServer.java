/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import java.sql.SQLException;

/**
 *
 * @author JIK
 */
public class GameServer {
    public static void main(String[] args) throws SQLException{
        DBManager dm = new DBManager();
//        dm.DBConnect();
        SocketManager sk = new SocketManager();
    }
}
