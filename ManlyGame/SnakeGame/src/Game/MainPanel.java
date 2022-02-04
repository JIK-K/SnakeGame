package Game;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class MainPanel extends JPanel{
	static final int SCREEN_WIDTH = 600;
    static final int SCREEN_HEIGHT = 600;
    Random random;
    ViewController controller;
    public MainPanel(ViewController controller){
    	this.controller = controller;
    	random = new Random();
    	this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyListener());
    }
    
    @Override
    public void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	draw(g);
    }
    
    public void draw(Graphics g) {
    	//Main Text
    	g.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
        g.setFont(new Font("Ink Free", Font.BOLD, 75));
        FontMetrics metrics1 = getFontMetrics(g.getFont());
        g.drawString("Snake Game", (SCREEN_WIDTH - metrics1.stringWidth("Snake Game"))/2, SCREEN_HEIGHT/5);
        
        //Start Text
        g.setColor(Color.green);
        g.setFont(new Font("Ink Free", Font.BOLD, 30));
        FontMetrics metrics2 = getFontMetrics(g.getFont());
        g.drawString("press 'Number' to Start", (SCREEN_WIDTH - metrics2.stringWidth("press 'Number' to Start"))/2, SCREEN_HEIGHT-50);
        
        //select Action
        g.setColor(Color.red);
        g.setFont(new Font("Ink Free", Font.BOLD, 30));
        FontMetrics metrics3 = getFontMetrics(g.getFont());
        g.drawString("1. Start Game", (SCREEN_WIDTH - metrics3.stringWidth("1. Start Game"))/2, SCREEN_HEIGHT-250);
        g.setColor(Color.red);
        g.setFont(new Font("Ink Free", Font.BOLD, 30));
        FontMetrics metrics4 = getFontMetrics(g.getFont());
        g.drawString("2. View Rank", (SCREEN_WIDTH - metrics4.stringWidth("2. View Rank"))/2, SCREEN_HEIGHT-200);
    }
    
	public class MyKeyListener extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
			switch(e.getKeyCode()) {
			case KeyEvent.VK_1:
				controller.showGamePanel();
			case KeyEvent.VK_2:
				controller.change();
			}
		}
	}
}
	

