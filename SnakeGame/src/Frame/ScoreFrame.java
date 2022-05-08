package Frame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Controller.ViewController;
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
	DBManager dm = DBManager.getInstance();
        
	public String userName;
	public String data;
        public int userscore;
        
	public ScoreFrame(ViewController controller) {
		this.controller = controller;
		this.setTitle("♥");
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
		
                userscore = controller.userScore;
                
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
                        makeData();
			System.out.println(userName + "" + userscore);
                        System.out.println(data);
                        dm.DBInsert(data);
			dispose();
		}
	}
	
}