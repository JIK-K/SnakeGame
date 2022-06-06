package Controller;
import java.awt.*;

import Frame.MainFrame;
import Frame.ScoreFrame;
import Panel.*;
public class ViewController {
    MainFrame gameFrame; 
    MainPanel mainPanel; 
    GamePanel gamePanel; 
    RankPanel rankPanel;
    HelpPanel helpPanel;
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
//        musicController.backgroundMusic();
    }
    
    //MainPanel Repaint
    public void restartGame() {
        mainPanel = new MainPanel(this);

        contentPane.removeAll();
        contentPane.add(mainPanel);
        gameFrame.setVisible(false);
        gameFrame.setVisible(true);
        
    }

    //MainPanel -> GamePanel
    public void showGamePanel(){
        musicController.backgroundMusic();
        gamePanel = new GamePanel(this);
        
        contentPane.remove(mainPanel);
        contentPane.add(gamePanel);
        gameFrame.setVisible(false);
        gameFrame.setVisible(true);
    }

    //GamePanel -> RankPanel
    public void showRankPanel() {
        musicController.stopMusic();
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
        
//        musicController.stopMusic();
    }
    public void showHelpPanel(){
        helpPanel = new HelpPanel(this);
        
        contentPane.remove(mainPanel);
        contentPane.add(helpPanel);
        gameFrame.setVisible(false);
        gameFrame.setVisible(true);
    }

    public void saveScore() {
        userScore = gamePanel.applesEaten;
    }
    
    public void showFrame() {
        musicController.stopMusic();
        new ScoreFrame(this);
    }
}
