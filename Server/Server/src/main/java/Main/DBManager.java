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
//    private final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
//    private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    
//    private final String DB_URL = "jdbc:mariadb://211.199.81.93::3306/mydatabase";
    private final String DB_URL = "jdbc:mysql://localhost/mydatabase?useSSL=false";
    private final String USER_NAME = "root";
    private final String PASSWORD = "kdkd4813";
    
    public DBManager(){
        Connection conn = null;
        Statement state = null;
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            System.out.println("[ MySQL Connection ] \n");
            state = conn.createStatement();
            
            String sql;
//            sql = "SELECT * FROM rank";
            sql = "SELECT * FROM gamerank";
            ResultSet rs = state.executeQuery(sql);
            
            while(rs.next()){
                String user_name = rs.getString("user_name");
                String user_score = rs.getString("user_score");
                System.out.println("Name: "+ user_name);
                System.out.println("Score:"+ user_score);
                System.out.println("================\n");
            }
            rs.close();
            state.close();
            conn.close();
        }catch(Exception e){
        }finally{
            try{
                if(state != null)
                    state.close();
            }catch(SQLException ex1){
                
            }
            
            try{
                if(conn != null)
                    conn.close();
            }catch(SQLException ex1){
                
            }
        }
    }
}
