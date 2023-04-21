/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Network;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author JIK
 */
public class DBManager {
    private static final String DB_DRIVER_CLASS = "org.mariadb.jdbc.Driver";
    private static final String DB_URL = "jdbc:mariadb://210.210.210.210:3306/mydatabase";
    private static final String DB_USERNAME = "***";
    private static final String DB_PASSWORD = "***";
    ResultSet rs = null;
    String sql = "SELECT * FROM rank";
    
    public ArrayList<String> username = new ArrayList<String>();
    public ArrayList<String> userscore = new ArrayList<String>();
    
    public void DBInsert(String userdata){
        String data = userdata;
        String ary[] = data.split("#");
        String name = ary[0];
        String score = ary[1];
        try{
            Class.forName(DB_DRIVER_CLASS);
            Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            String sql = "INSERT INTO rank VALUES(?,?)";
            PreparedStatement pstmt = null;
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2,score);
            int result = pstmt.executeUpdate();
            System.out.println(result+"YES!!!!!!!!!");
            pstmt.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void DBData(){
        String name = null;
        String score = null;
        username.clear();
        userscore.clear();
        try{
            Class.forName(DB_DRIVER_CLASS);
            Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            PreparedStatement pstmt = null;
            String sql = "SELECT * FROM rank ORDER BY user_score DESC LIMIT 5";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            
            while(rs.next()){
                name = rs.getString("user_name");
                score = rs.getString("user_score");
                username.add(name);
                userscore.add(score);
//                System.out.println("name: "+ name +"score: "+score);
            }
        }catch(ClassNotFoundException e){
            System.out.println("System File loading Fail");
        }catch(SQLException e){
            System.out.println("DBconnect Fail");
        }
    }
    
    //=============================================================//
    private static class SingleTonHolder{
		private static final DBManager instance = new DBManager();
	}
    public static DBManager getInstance() {
            return SingleTonHolder.instance;
    }
    //=============================================================//
    
    public ArrayList returnUsername(){
        return username;
    }
    public ArrayList<String> returnUserscore(){
        return (userscore);
    }
    
}
