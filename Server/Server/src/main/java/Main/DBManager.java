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
    
    
    ResultSet rs = null;
    String sql = "SELECT * FROM rank";
    
    public void DBConnect(){
        Connection conn;
        PreparedStatement pstmt = null;
        try{
            
            Class.forName(DB_DRIVER_CLASS);
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            System.out.println("Connect Success");
            
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while(rs.next()){
                String name = rs.getString("user_name");
                String score = rs.getString("user_score");
                System.out.println("name: "+ name +"score: "+score);
            }
//            DBInsert();
            
        }catch(ClassNotFoundException e){
            System.out.println("System File loading Fail");
        }catch(SQLException e){
            System.out.println("DBconnect Fail");
        }
    }
    
    public void DBInsert(){
        try{
            Class.forName(DB_DRIVER_CLASS);
            Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            String sql = "INSERT INTO rank VALUES(?,?)";
            PreparedStatement pstmt = null;
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "test2");
            pstmt.setString(2,"3");
            int result = pstmt.executeUpdate();
            System.out.println(result+"YES!!!!!!!!!");
            pstmt.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
