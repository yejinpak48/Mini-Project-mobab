package kmp.view;

import javax.swing.JFrame;


public class MainFrame extends JFrame{
	public MainFrame() {
		this.setTitle("모밥");

		this.setSize(400, 700);
		this.setLayout(null);
		new LoginPage(this);
		
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
