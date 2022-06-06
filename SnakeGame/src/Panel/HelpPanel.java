/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Panel;

import Controller.ViewController;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author JIK
 */
public class HelpPanel extends JPanel {
    static final int SCREEN_WIDTH = 1000;
    static final int SCREEN_HEIGHT = 1000;
    ViewController controller;
    
    public HelpPanel(ViewController controller){
        this.controller = controller;
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener((new MyKeyListener()));
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }
    
    public void draw(Graphics g){
        g.setColor(Color.red);
        g.fillOval(80, 150, 25, 25);
        g.setColor(Color.white);
        g.setFont(new Font("Ink Free", Font.BOLD, 40));
        g.drawString("SCORE 1UP ", 200, 170);
        
        g.setColor(Color.orange);
        g.fillOval(80, 270, 25, 25);
        g.setColor(Color.white);
        g.setFont(new Font("Ink Free", Font.BOLD, 40));
        g.drawString("BODY LENGTH TWICE OR HALF", 200, 290);
        
        g.setColor(Color.yellow);
        g.fillOval(80, 390, 25, 25);
        g.setColor(Color.white);
        g.setFont(new Font("Ink Free", Font.BOLD, 40));
        g.drawString("SCORE TWICE OR HALF ", 200, 410);
        
        g.setColor(Color.blue);
        g.fillOval(80, 510, 25, 25);
        g.setColor(Color.white);
        g.setFont(new Font("Ink Free", Font.BOLD, 40));
        g.drawString("BODY LENGTH TWICE OR HALF", 200, 530);
        
        g.setColor(Color.white);
        g.fillOval(80, 630, 25, 25);
        g.setColor(Color.white);
        g.setFont(new Font("Ink Free", Font.BOLD, 40));
        g.drawString("¹®ÀÚ ±úÁü Å×½ºÆ®", 200, 650);
        
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
