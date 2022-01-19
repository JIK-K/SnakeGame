package Game;
import java.awt.*;
public class ViewController {
	MainFrame gameFrame; //���� ������
	MainPanel mainPanel; //���� �г�
	GamePanel gamePanel; //���� �г�
	Container contentPane;
	public ViewController(MainFrame gameFrame) {
		this.gameFrame = gameFrame;
		init();
	}
	
	public void init() {
		mainPanel = new MainPanel(this);
		gamePanel = new GamePanel(this);
		contentPane = gameFrame.getContentPane();
		contentPane.add(mainPanel);
		mainPanel.requestFocus();
	}
	
	public void showGamePanel() {
		contentPane.remove(mainPanel);
		contentPane.add(gamePanel);
		gameFrame.setVisible(false);
		gameFrame.setVisible(true);
	}
	
	public void showRankPanel() {
		contentPane.remove(gamePanel);
		contentPane.add(new RankPanel());
		gameFrame.setVisible(false);
		gameFrame.setVisible(true);
	}
}
