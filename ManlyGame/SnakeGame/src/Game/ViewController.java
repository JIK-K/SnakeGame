package Game;
import java.awt.*;
public class ViewController {
	GameFrame gameFrame;
	MainPanel mainPanel;
	GamePanel gamePanel;
	Container contentPane;
	public ViewController(GameFrame gameFrame) {
		this.gameFrame = gameFrame;
		init();
	}
	
	private void init() {
		mainPanel = new MainPanel();
		gameFrame.getContentPane().add(mainPanel);
	}
}