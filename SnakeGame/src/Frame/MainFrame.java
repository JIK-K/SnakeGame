package Frame;

import java.awt.*;

import javax.swing.JFrame;

import Controller.*;

public class MainFrame extends JFrame{
    static final int SCREEN_WIDTH = 1000;
    static final int SCREEN_HEIGHT = 1000;
    ViewController controller;
    MusicController musicController;
    public MainFrame() {
        this.setTitle("Snake");
        this.setVisible(true);
        this.getRootPane().setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        controller = new ViewController(this);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }
}
