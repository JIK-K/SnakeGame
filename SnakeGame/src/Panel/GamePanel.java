package Panel;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Controller.*;

import java.util.Random;

public class GamePanel extends JPanel implements ActionListener{
    static final int SCREEN_WIDTH = 1000;
    static final int SCREEN_HEIGHT = 1000;
    static final int UNIT_SIZE = 25;
    static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT)/UNIT_SIZE;
    static final int DELAY = 75;
    final int x[] = new int[GAME_UNITS];
    final int y[] = new int[GAME_UNITS];
    int bodyParts = 5;
    public int applesEaten = 0;
    int appleX;
    int appleY;
    char direction = 'R';
    boolean running = false;
    boolean start = true;
    Timer timer;
    Random random;
    ViewController controller;
    MusicController musicController;
    
    public GamePanel(ViewController controller){
        musicController = MusicController.getInstance();
    	this.controller = controller;
        random = new Random();
        timer = new Timer(DELAY, this);
        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        startGame();
    }
    
    public void startGame(){
        newApple();
        running = true;
//        timer = new Timer(DELAY, this);
//        timer.start();
    }
    
    public void startTimer() {
//    	timer = new Timer(DELAY, this);
    	timer.start();
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }
    
    public void draw(Graphics g){
        if(running){
//        	DebugLine
//            for(int i = 0; i < SCREEN_HEIGHT/UNIT_SIZE; i++){
//                g.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, SCREEN_HEIGHT);
//                g.drawLine(0, i*UNIT_SIZE, SCREEN_HEIGHT, i*UNIT_SIZE);
//            }
            if(applesEaten == 15){
                g.setColor(Color.orange);
                g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);
            }
            else if(applesEaten == 30){
                g.setColor(Color.yellow);
                g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);
            }
            else if(applesEaten == 50){
                g.setColor(Color.blue);
                g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);
            }
            else if(applesEaten == 100){
                g.setColor(Color.white);
                g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);
            }
            else{
                g.setColor(Color.red);
                g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);
            }
            
            for(int i = 0; i < bodyParts; i++){
                if(i == 0){
                    g.setColor(Color.green);
                    g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                }
                else{
                    g.setColor(new Color(45, 180, 0)); //basic color
                    if(applesEaten > 100)
                        g.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255))); //holymoly color
                    g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                }
            }
            g.setColor(Color.red);
            g.setFont(new Font("Ink Free", Font.BOLD, 40));
            FontMetrics metrics = getFontMetrics(g.getFont());
            g.drawString("Score : "+applesEaten, (SCREEN_WIDTH - metrics.stringWidth("Score :"+applesEaten))/2, g.getFont().getSize());
        }
        else if(!start){
            controller.saveScore();
            gameOver(g);
        }
    }
    
    public void newApple(){
        appleX = random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
        appleY = random.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE))*UNIT_SIZE;
    }
    
    public void move(){
        for(int i = bodyParts; i > 0; i--){
            x[i] = x[i-1];
            y[i] = y[i-1];
        }
        
        switch(direction){
            case 'U':
                y[0] = y[0] - UNIT_SIZE;
                break;
            case 'D':
                y[0] = y[0] + UNIT_SIZE;
                break;
            case 'L':
                x[0] = x[0] - UNIT_SIZE;
                break;
            case 'R':
                x[0] = x[0] + UNIT_SIZE;
                break;
        }
    }
    
    public void checkApple(){
        if((x[0] == appleX) && (y[0] == appleY)){
            if(applesEaten == 15){
                int percent = random.nextInt(10);
                if(percent > 5)
                    bodyParts = (bodyParts/2);
                else
                    bodyParts = (bodyParts*2);
                applesEaten++;
                musicController.eatAppleMusic();
                newApple();
            }
            else if(applesEaten == 30){
                int percent = random.nextInt(10);
                if(percent < 5)
                    applesEaten = (applesEaten*2);
                else
                    applesEaten = (applesEaten/2);
                bodyParts++;
                musicController.eatAppleMusic();
                newApple();
            }
            else if(applesEaten == 50){
                int percent = random.nextInt(10);
                if(percent > 5)
                    bodyParts = (bodyParts/2);
                else
                    bodyParts = (bodyParts*2);
                applesEaten++;
                musicController.eatAppleMusic();
                newApple();
            }
            else{
                bodyParts++;
                applesEaten++;
                musicController.eatAppleMusic();
                newApple();
            }
        }
    }
    public void checkCollisions(){
        //checks if head collides with body
        for(int i = bodyParts; i > 0; i--){
            if((x[0] == x[i]) && (y[0] == y[i])){
            	start = false;
                running = false;
            }
        }
        //check if head touches left boreder
        if(x[0] < 0){
            start = false;
            running = false;
        }
        //check if head touches right boreder
        if(x[0] >= SCREEN_WIDTH){
            start = false;
            running = false;
        }
        //check if head touches top boreder
        if(y[0] < 0){
            start = false;
            running = false;
        }
        //check if head touches bottom boreder
        if(y[0] >= SCREEN_HEIGHT){
            start = false;
            running = false;
        }
        
        if(!(running && start)){
            timer.stop();
        }
    }
    
    public void gameOver(Graphics g){
        //Score
        g.setColor(Color.red);
        g.setFont(new Font("Ink Free", Font.BOLD, 40));
        FontMetrics metrics1 = getFontMetrics(g.getFont());
        g.drawString("Score : "+applesEaten, (SCREEN_WIDTH - metrics1.stringWidth("Score :"+applesEaten))/2, g.getFont().getSize());
        //Game Over Text
        g.setColor(Color.red);
        g.setFont(new Font("Ink Free", Font.BOLD, 75));
        FontMetrics metrics2 = getFontMetrics(g.getFont());
        g.drawString("GAME OVER", (SCREEN_WIDTH - metrics2.stringWidth("GAME OVER"))/2, SCREEN_HEIGHT/2);
        //communication message
        g.setColor(Color.green);
        g.setFont(new Font("Ink Free", Font.BOLD, 30));
        FontMetrics metrics3 = getFontMetrics(g.getFont());
        g.drawString("press 'ENTER' to view Rank", (SCREEN_WIDTH - metrics3.stringWidth("press 'ENTER' to view Rank"))/2, SCREEN_HEIGHT-50);
        
        if(applesEaten != 0) {
        	controller.showFrame();
        }
    }
    
    //=================Override==================//
    @Override
    public void actionPerformed(ActionEvent e) {
        if(running){
            move();
            checkApple();
            checkCollisions();
        }
        repaint();
    }
    
    public class MyKeyAdapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            switch(e.getKeyCode()){
            case KeyEvent.VK_LEFT:
                if(direction != 'R'){
                    direction = 'L';
                }
                break;
            case KeyEvent.VK_RIGHT:
                if(direction != 'L'){
                    direction = 'R';
                }
                break;
            case KeyEvent.VK_UP:
                if(direction != 'D'){
                    direction = 'U';
                }
                break;
            case KeyEvent.VK_DOWN:
                if(direction != 'U'){
                    direction = 'D';
                }
                break;
            case KeyEvent.VK_ENTER:
                if(!(start && running)) {
                    controller.showRankPanel();
                }
                else {
                    startTimer();
                }		
            }
        }  
    }
}