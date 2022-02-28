package Panel;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Game.ViewController;
import Network.DBManager;
import java.util.ArrayList;


public class RankPanel extends JPanel{
    static final int SCREEN_WIDTH = 600;
    static final int SCREEN_HEIGHT = 600;
    ViewController controller;
    DBManager dm = DBManager.getInstance();
    
    String[] username;

    public RankPanel(ViewController controller) {
        this.controller = controller;
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyListener());
        dm.DBData();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        for(int i = 1 ; i <= 5; i++) {
            if(i == 1) {
                g.setColor(Color.orange);
                g.setFont(new Font("Gothic", Font.BOLD, 50));
                FontMetrics metrics1 = getFontMetrics(g.getFont());
                g.drawString("" + i +".  " + dm.username.get(0) + " ➛ " + dm.userscore.get(0) , (SCREEN_WIDTH - metrics1.stringWidth("1"))/6, SCREEN_HEIGHT/7*i);
            }
            else {
                g.setColor(Color.red);
                g.setFont(new Font("Gothic", Font.BOLD, 30));
                FontMetrics metrics2 = getFontMetrics(g.getFont());
                g.drawString("" + i + ".  " + dm.username.get(i-1) + " ➛ " + dm.userscore.get(i-1), (SCREEN_WIDTH - metrics2.stringWidth("1"))/6, SCREEN_HEIGHT/7*i);
            }
        }
                
        //communication message
        g.setColor(Color.green);
        g.setFont(new Font("Ink Free", Font.BOLD, 30));
        FontMetrics metrics3 = getFontMetrics(g.getFont());
        g.drawString("press 'ENTER' return to 'MainMenu'", (SCREEN_WIDTH - metrics3.stringWidth("press 'ENTER' return to 'MainMenu'"))/2, SCREEN_HEIGHT-50);
    }

    public class MyKeyListener extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                controller.restartGame();
            }
        }	
    }
}