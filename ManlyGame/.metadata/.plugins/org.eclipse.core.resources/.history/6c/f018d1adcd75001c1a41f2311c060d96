package Game;

import java.awt.*;

import javax.swing.JFrame;

public class GameFrame extends JFrame{
	static final int SCREEN_WIDTH = 600;
    static final int SCREEN_HEIGHT = 600;
	ViewController controller;
	public GameFrame() {
		this.setTitle("Snake");
		this.setVisible(true);
		this.getRootPane().setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		this.add(new GamePanel());
		controller = new ViewController(this);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }
}
