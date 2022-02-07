package Game;
import java.awt.*;
public class ViewController {
	MainFrame gameFrame; 
	MainPanel mainPanel; 
	GamePanel gamePanel; 
	RankPanel rankPanel;
	Container contentPane;
	int userScore;
	
	public ViewController(MainFrame gameFrame) {
		this.gameFrame = gameFrame;
		init();
	}
	
	public void init() {
		mainPanel = new MainPanel(this);
		//gamePanel = new GamePanel(this);
		//rankPanel = new RankPanel(this);
		contentPane = gameFrame.getContentPane();
		contentPane.add(mainPanel);
		mainPanel.requestFocus();
	}
	public void restartGame() {
		mainPanel = new MainPanel(this);
		
		contentPane.removeAll();
		contentPane.add(mainPanel);
		gameFrame.setVisible(false);
		gameFrame.setVisible(true);
	}
	
	public void showGamePanel() {
		gamePanel = new GamePanel(this);
		
		contentPane.remove(mainPanel);
		contentPane.add(gamePanel);
		gameFrame.setVisible(false);
		gameFrame.setVisible(true);
	}
	
	public void showRankPanel() {
		rankPanel = new RankPanel(this);
		
		contentPane.remove(gamePanel);
//		contentPane.removeAll();
		contentPane.add(rankPanel);
		gameFrame.setVisible(false);
		gameFrame.setVisible(true);
	}
	
	public void change() {
		rankPanel = new RankPanel(this);
		
		contentPane.remove(mainPanel);
		contentPane.add(rankPanel);
		gameFrame.setVisible(false);
		gameFrame.setVisible(true);
	}
	
	//메서드이름정리 및 정리정
	public void saveScore() {
		userScore = gamePanel.applesEaten;
	}
	public void showFrame() {
		new ScoreFrame(this);
	}
}
