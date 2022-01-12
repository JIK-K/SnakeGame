package Game;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class MainPanel extends JPanel{
	static final int SCREEN_WIDTH = 600;
    static final int SCREEN_HEIGHT = 600;
    Random random;
    boolean status = false;
    public MainPanel(){
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
        g.setColor(Color.red);
        g.setFont(new Font("Ink Free", Font.BOLD, 30));
        FontMetrics metrics2 = getFontMetrics(g.getFont());
        g.drawString("press 'ENTER' to Start", (SCREEN_WIDTH - metrics2.stringWidth("press 'ENTER' to Start"))/2, SCREEN_HEIGHT-200);
    }
    
	public class MyKeyListener extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			}
		}
	}
}
	
