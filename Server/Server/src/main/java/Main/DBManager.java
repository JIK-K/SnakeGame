/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;
//https://blog.naver.com/lghlove0509/221031017994
import java.sql.*;
/**
 *
 * @author JIK
 */
public class DBManager {
    private static final String DB_DRIVER_CLASS = "org.mariadb.jdbc.Driver";
    private static final String DB_URL = "jdbc:mariadb://211.199.81.93:3306/mydatabase";
    private static final String DB_USERNAME = "kddnswlr";
    private static final String DB_PASSWORD = "kdkd4813";
    private static Connection conn;
    PreparedStatement pstmt = null;

    public void connectDB(){
        try{
            
            Class.forName(DB_DRIVER_CLASS);
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            System.out.println("Connect Success");
            
        }catch(ClassNotFoundException e){
            System.out.println("System File loading Fail");
        }catch(SQLException e){
            System.out.println("DBconnect Fail");
        }
    }
}
