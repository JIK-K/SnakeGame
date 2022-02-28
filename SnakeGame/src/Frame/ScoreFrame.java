package Frame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Game.ViewController;
import NetWork.ClientSocket;
import Network.DBManager;


public class ScoreFrame extends JFrame implements ActionListener{
	static final int SCREEN_WIDTH = 200;
	static final int SCRREN_HEIGHT = 100;
	JLabel name;
	JLabel score;
	JTextField inputName;
	Container contentPane;
	JButton button;
	ViewController controller;
	ClientSocket cs = ClientSocket.getInstance();
	DBManager dm = DBManager.getInstance();
        
	String userName;
	String data;
	public ScoreFrame(ViewController controller) {
		this.controller = controller;
		this.setTitle("SCORE");
		this.setVisible(true);
		this.getRootPane().setPreferredSize(new Dimension(SCREEN_WIDTH, SCRREN_HEIGHT));
		this.pack();
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		init();
	}
	
	public void makeData() {
		data = userName + "#" + controller.userScore;
	}
	
	public void init() {
		name = new JLabel("NAME");
		inputName = new JTextField(10);
		score = new JLabel("Your Score      =>  =>  =>       " + controller.userScore); // AppleEaten
		button = new JButton("SEND");
		
		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		contentPane.add(name);
		contentPane.add(inputName);
		contentPane.add(score);
		contentPane.add(button);
		
		button.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button) {
			userName = inputName.getText();
			System.out.println(userName);
			makeData();
			cs.sendData(data);
                        dm.DBInsert();
			dispose();
		}
	}
	
}