package kmp.view;


import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import kmp.model.vo.Images;

import kmp.view.MainFrame;


public class MainPage extends JPanel {
	private MainFrame mf;
	private JPanel mainPage;
	Images img = new Images();
	
	public MainPage(MainFrame mf) {
		this.mf = mf;
		this.mainPage = this;
		this.setSize(400, 700);
		this.setLayout(null);
		Color color = new Color(35,212,177);
		Color backgcolor = new Color(234,255,236);
		

		//상단패널
		JPanel panel1 = new JPanel();
		panel1.setSize(400, 140);
		panel1.setLocation(0, 0);
		
		JButton back = new JButton(new ImageIcon(img.getBackImg()));
		back.setSize(80,50);
		back.setLocation(0,5);
		back.setBorderPainted(false);
		back.setContentAreaFilled(false);

		JButton home = new JButton(new ImageIcon(img.getHomeImg()));
		home.setSize(240,50);
		home.setLocation(80,5);
		home.setBorderPainted(false);
		home.setContentAreaFilled(false);
		home.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ChangePanel.changePanel(mf,mainPage, new MainPage(mf));
			}
			
		});
		
		JButton infor = new JButton(new ImageIcon(img.getUserinfoImg()));
		infor.setSize(80,50);
		infor.setLocation(320,5);
		infor.setBorderPainted(false);
		infor.setContentAreaFilled(false);
		infor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ChangePanel.changePanel(mf, mainPage, new MemberInfoPage(mf));
			}
			
		});
		
//		panel1.add(back);
		panel1.add(home);
		panel1.add(infor);
		panel1.setBackground(color);
		
		JButton sik = new JButton(new ImageIcon(img.getSikImg()));
		sik.setSize(100,100);
		sik.setLocation(0,55);
		sik.setBorderPainted(false);
		sik.setContentAreaFilled(false);
		
		sik.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ChangePanel.changePanel(mf,mainPage, new SikdangPage(mf));
			}
			
		});
		
		JButton fav = new JButton(new ImageIcon(img.getFavoriteImg()));
		fav.setBorderPainted(false);
		fav.setContentAreaFilled(false);
		fav.setSize(100,100);
		fav.setLocation(100,55);
		
		fav.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ChangePanel.changePanel(mf, mainPage, new FavoritePage(mf));
			}
		});
		
		
		JButton hist = new JButton(new ImageIcon(img.getChartImg()));
		hist.setSize(100,100);
		hist.setLocation(200,55);
		hist.setBorderPainted(false);
		hist.setContentAreaFilled(false);
		hist.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ChangePanel.changePanel(mf, mainPage, new UsingHistoryPage(mf));

			}
		});
		
		JButton charge = new JButton(new ImageIcon(img.getChargeImg()));
		charge.setSize(100,100);
		charge.setLocation(300,55);
		charge.setBorderPainted(false);
		charge.setContentAreaFilled(false);
    charge.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ChangePanel.changePanel(mf, mainPage, new ChargePage(mf));
				
			}
		});

		
		panel1.add(sik);
		panel1.add(fav);
		panel1.add(hist);
		panel1.add(charge);
		

		//하단패널
		JPanel panel2 = new JPanel();
		panel2.setSize(400, 560);
		panel2.setLocation(0, 140);
		panel2.setBackground(backgcolor);
		

		JLabel todaymenu = new JLabel("< 오늘의 메뉴 >");
		todaymenu.setSize(200, 25);
		todaymenu.setLocation(50, 25);
		JLabel menuImg = new JLabel(new ImageIcon(img.getTodayMenuImg()));
		menuImg.setSize(300, 200);
		menuImg.setLocation(50, 50);
		

		JLabel todaynews = new JLabel("< 오늘의 소식 >");
		todaynews.setSize(200, 25);
		todaynews.setLocation(50, 270);
		JLabel banner = new JLabel(new ImageIcon(img.getBannerImg()));
		banner.setSize(300, 200);
		banner.setLocation(50, 300);
		panel2.add(todaymenu);
		panel2.add(menuImg);
		panel2.add(todaynews);
		panel2.add(banner);
		
		
		this.add(panel1);
		this.add(panel2);
		mf.add(this);

		
	}
}

