package Controller;
import java.awt.*;

import Frame.MainFrame;
import Frame.ScoreFrame;
import Panel.GamePanel;
import Panel.MainPanel;
import Panel.RankPanel;
public class ViewController {
    MainFrame gameFrame; 
    MainPanel mainPanel; 
    GamePanel gamePanel; 
    RankPanel rankPanel;
    MusicController musicController;
    Container contentPane;
    public int userScore;

    public ViewController(MainFrame gameFrame) {
        this.gameFrame = gameFrame;
        init();
    }

    public void init() {
        musicController = MusicController.getInstance();
        mainPanel = new MainPanel(this);
        musicController = new MusicController();
        //gamePanel = new GamePanel(this);
        //rankPanel = new RankPanel(this);
        contentPane = gameFrame.getContentPane();
        contentPane.add(mainPanel);
        mainPanel.requestFocus();
        musicController.backgroundMusic();
    }
    
    //MainPanel Repaint
    public void restartGame() {
        musicController.backgroundMusic();
        
        mainPanel = new MainPanel(this);

        contentPane.removeAll();
        contentPane.add(mainPanel);
        gameFrame.setVisible(false);
        gameFrame.setVisible(true);
        
    }

    //MainPanel -> GamePanel
    public void showGamePanel(){
        gamePanel = new GamePanel(this);
        
        contentPane.remove(mainPanel);
        contentPane.add(gamePanel);
        gameFrame.setVisible(false);
        gameFrame.setVisible(true);
        
        musicController.stopMusic();
    }

    //GamePanel -> RankPanel
    public void showRankPanel() {
        rankPanel = new RankPanel(this);

        contentPane.remove(gamePanel);
//		contentPane.removeAll();
        contentPane.add(rankPanel);
        gameFrame.setVisible(false);
        gameFrame.setVisible(true);
    }

    //MainPanel -> RankPanel
    public void change() {
        rankPanel = new RankPanel(this);

        contentPane.remove(mainPanel);
        contentPane.add(rankPanel);
        gameFrame.setVisible(false);
        gameFrame.setVisible(true);
        
        musicController.stopMusic();
    }

    public void saveScore() {
        userScore = gamePanel.applesEaten;
    }
    
    public void showFrame() {
        musicController.stopMusic();
        new ScoreFrame(this);
    }
}
