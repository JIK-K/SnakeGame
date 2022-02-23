/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author JIK
 */
public class SocketManager extends Thread{
    ServerSocket serverSocket;
    int port;

    String name;
    String score;
    //=============================================================//
    public SocketManager(){
        try{

            serverSocket = new ServerSocket(4242);
            go();

        }catch(IOException ex){
            ex.printStackTrace();
        }
        
    }
    public SocketManager(int port){
        try{

            this.port = port;
            serverSocket = new ServerSocket(port);
            go();

        }catch(IOException ex){
            ex.printStackTrace();
        }
        
    }
    //=============================================================//
    // ClientHandler 내부클래스
    //=============================================================//
    public class ClientHandler implements Runnable{
        BufferedReader reader;
        Socket socket;
        public ClientHandler(Socket clientSocket){
            try{
                socket = clientSocket;
                InputStreamReader isReader = new InputStreamReader(socket.getInputStream());
                reader = new BufferedReader(isReader);
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        @Override
        public void run(){
            String data;
            try{
                while((data = reader.readLine()) != null){
                    //이름이랑 점수 나눠서 DB넣는거 가능? 하겠지~
                    System.out.println(data);
                    String ary[] = data.split("#");
                    name = ary[0];
                    score = ary[1];
                    System.out.println("이름 : " + name);
                    System.out.println("점수 : " + score);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    //=============================================================//

    public void go(){
        BufferedReader reader = null;
        PrintWriter writer = null;
        try{
            System.out.println("접속 대기중...");
            while(true){
                Socket socket = serverSocket.accept();
                System.out.println("사용자 접속...");
                System.out.println("Client ip : " + socket.getInetAddress());
                
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                writer = new PrintWriter(socket.getOutputStream());
                writer.println("hello MotherFucker");
                writer.flush();
                
                Thread t = new Thread(new ClientHandler(socket));
                t.start();
            }
            
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
