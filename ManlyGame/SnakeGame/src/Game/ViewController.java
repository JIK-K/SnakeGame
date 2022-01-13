package Game;
import java.awt.*;
public class ViewController {
	GameFrame gameFrame; //게임 프레임
	MainPanel mainPanel; //메인 패널
	GamePanel gamePanel; //게임 패널
	Container contentPane;
	public ViewController(GameFrame gameFrame) {
		this.gameFrame = gameFrame;
		init();
	}
	
	public void init() {
		mainPanel = new MainPanel(this);
		contentPane = gameFrame.getContentPane();
		contentPane.add(mainPanel);
		mainPanel.requestFocus();
	}
	
	public void showGamePanel() {
		contentPane.remove(mainPanel);
		contentPane.add(new GamePanel());
		gameFrame.setVisible(false);
		gameFrame.setVisible(true);
	}
}
