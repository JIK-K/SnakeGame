package Game;

import javax.swing.JFrame;

public class GameFrame extends JFrame{
	ViewController controller;
	public GameFrame() {
		this.add(new MainPanel());
        this.setTitle("Snake");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        
        controller = new ViewController(this);
    }
}
