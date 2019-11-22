package kmp.view;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;
import kmp.model.vo.Images;

import kmp.controller.Controller;

public class MemberInfoPage extends JPanel {
	private MainFrame mf;
	private JPanel memberInfoPage;
	LoginPage lp = new LoginPage();
	Controller ctr = new Controller();
	Images img = new Images();
	
	public MemberInfoPage(MainFrame mf) {
		this.mf = mf;
		this.memberInfoPage = this;
		this.setSize(400, 700);
		this.setLayout(null);
		Color color = new Color(35,212,177);
		Color backgcolor = new Color(234,255,236);
		
		
		//상단 패널
		JPanel panel1 = new JPanel();
		panel1.setSize(400, 140);
		panel1.setLocation(0, 0);

		JButton back = new JButton(new ImageIcon(img.getBackImg()));
		back.setSize(80,50);
		back.setLocation(0,5);
		back.setBorderPainted(false);
		back.setContentAreaFilled(false);
		
		JButton logout = new JButton(new ImageIcon(img.getLogoutImg()));
		logout.setSize(50,50);
		logout.setLocation(10,5);
		logout.setBorderPainted(false);
		logout.setContentAreaFilled(false);
		logout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LoginPage lp = new LoginPage();
				lp.setId(null);
				ChangePanel.changePanel(mf,memberInfoPage, new LoginPage(mf));
				
			}
		});
		
		JButton home = new JButton(new ImageIcon(img.getHomeImg()));
		home.setSize(240,50);
		home.setLocation(80,5);
		home.setBorderPainted(false);
		home.setContentAreaFilled(false);
		home.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ChangePanel.changePanel(mf,memberInfoPage, new MainPage(mf));
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
				ChangePanel.changePanel(mf, memberInfoPage, new MemberInfoPage(mf));
			}
			
		});
		
//		panel1.add(back);
		panel1.add(home);
		panel1.add(infor);
		panel1.setBackground(color);
		panel1.add(logout);
		
		JButton sik = new JButton(new ImageIcon(img.getSikImg()));
		sik.setSize(100,100);
		sik.setLocation(0,55);
		sik.setBorderPainted(false);
		sik.setContentAreaFilled(false);
		sik.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ChangePanel.changePanel(mf,memberInfoPage, new SikdangPage(mf));
			}
		});
		JButton fav = new JButton(new ImageIcon(img.getFavoriteImg()));
		fav.setSize(100,100);
		fav.setLocation(100,55);
		fav.setBorderPainted(false);
		fav.setContentAreaFilled(false);
		fav.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ChangePanel.changePanel(mf, memberInfoPage, new FavoritePage(mf));

			}
		});
		
		JButton hist = new JButton(new ImageIcon(img.getChartImg()));
		hist.setSize(100,100);
		hist.setLocation(200,55);
		hist.setBorderPainted(false);
		hist.setContentAreaFilled(false);
		fav.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ChangePanel.changePanel(mf, memberInfoPage, new FavoritePage(mf));

			}
		});
		
		JButton charg = new JButton(new ImageIcon(img.getChargeImg()));
		charg.setSize(100,100);
		charg.setLocation(300,55);
		charg.setBorderPainted(false);
		charg.setContentAreaFilled(false);
		charg.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ChangePanel.changePanel(mf, memberInfoPage, new ChargePage(mf));

			}
		});
		
		panel1.add(sik);
		panel1.add(fav);
		panel1.add(hist);
		panel1.add(charg);
		
		//하단패널
		JPanel panel2 = new JPanel();
		panel2.setSize(400, 560);
		panel2.setLocation(0, 140);
		panel2.setBackground(backgcolor);
		
		JPanel panel3 = new JPanel();
		panel3.setSize(340, 420);
		panel3.setLocation(30, 80);
		panel3.setBackground(color.WHITE);
		
		//회원정보 아이콘 
		JLabel userInfoIcon = new JLabel(new ImageIcon(img.getUserInfo()));
		userInfoIcon.setSize(360, 50);
		userInfoIcon.setLocation(20, 20);
		
		
//		JButton userInfoinfoText = new JButton("회원 정보");
//		infoText.setSize(360, 50);
//		infoText.setLocation(20, 20);
////		infoText.setContentAreaFilled(false);
//		infoText.setBackground(backgcolor);
	
		//id정보
		JLabel idIcon = new JLabel(new ImageIcon(img.getIdImg()));
		JTextField idInfo = new JTextField();
		idIcon.setSize(60,30);
		idInfo.setSize(260,30);
		idIcon.setLocation(5, 20);
		idInfo.setLocation(65, 20);
		idInfo.setText(lp.getId());
		
		//pwd정보
		JLabel pwdIcon = new JLabel(new ImageIcon(img.getPwdImg()));
		JTextField pwdInfo = new JTextField();
		pwdIcon.setSize(60,30);
		pwdInfo.setSize(200,30);
		pwdIcon.setLocation(5, 80);
		pwdInfo.setLocation(65, 80);
		pwdInfo.setText(ctr.outputPwdInfo(lp.getId()));

		//이름정보
		JLabel nameIcon = new JLabel(new ImageIcon(img.getNameImg()));
		JTextField nameInfo = new JTextField(30);
		nameIcon.setSize(60, 30);
		nameInfo.setSize(260, 30);
		nameIcon.setLocation(5, 140);
		nameInfo.setLocation(65, 140);
		nameInfo.setText(ctr.outputNameInfo(lp.getId()));
		
		//이메일 정보
		JLabel emailIcon = new JLabel(new ImageIcon(img.getEmailImg()));
		JTextField emailInfo = new JTextField(30);
		emailIcon.setSize(60, 30);
		emailInfo.setSize(200, 30);
		emailIcon.setLocation(5, 200);
		emailInfo.setLocation(65, 200);
		emailInfo.setText(ctr.outputEmailInfo(lp.getId()));
		
		
		//전화번호 정보
		JLabel phoneNumIcon = new JLabel(new ImageIcon(img.getPhoneNumImg()));
		JTextField phoneNumInfo = new JTextField(30);
		phoneNumIcon.setSize(60, 30);
		phoneNumInfo.setSize(200, 30);
		phoneNumIcon.setLocation(5, 260);
		phoneNumInfo.setLocation(65, 260);
		phoneNumInfo.setText(ctr.outputPhoneNumInfo(lp.getId()));
		
		//학원정보
		JLabel academyIcon = new JLabel(new ImageIcon(img.getAcademyImg()));
		JTextField academyInfo = new JTextField(20);
		academyIcon.setSize(60, 30);
		academyInfo.setSize(120, 30);
		academyIcon.setLocation(5, 320);
		academyInfo.setLocation(65, 320);
		academyInfo.setText(ctr.outputAcademyInfo(lp.getId()));
		
		//반정보
		JLabel classroomIcon = new JLabel(new ImageIcon(img.getClassroomImg()));
		JTextField classroomInfo = new JTextField(20);
		classroomIcon.setSize(40, 30);
		classroomInfo.setSize(80, 30);
		classroomIcon.setLocation(190, 320);
		classroomInfo.setLocation(235, 320);
		classroomInfo.setText(ctr.outputClassroomInfo(lp.getId()));

		//보유금액정보
		JLabel chargedIcon = new JLabel(new ImageIcon(img.getChargedImg()));
		JTextField chargedInfo = new JTextField(20);
		chargedIcon.setSize(60, 30);
		chargedInfo.setSize(120, 30);
		chargedIcon.setLocation(5, 380);
		chargedInfo.setLocation(65, 380);
		chargedInfo.setText(ctr.outputGenderInfo(lp.getId()));
		
		//성별정보
		JLabel genderIcon = new JLabel(new ImageIcon(img.getGenderImg()));
		JTextField genderInfo = new JTextField(20);
		genderIcon.setSize(40, 30);
		genderInfo.setSize(80, 30);
		genderIcon.setLocation(190, 380);
		genderInfo.setLocation(235, 380);
		genderInfo.setText(ctr.outputChargedInfo(lp.getId()));
		
		
		//회원정보 수정
		JButton changePwd = new JButton("수정");
		changePwd.setSize(60,30);
		changePwd.setLocation(265, 80);
		changePwd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = idInfo.getText();
				String pwd = pwdInfo.getText();
				ctr.changePwd(id, pwd);
				
				PopUp pu = new PopUp();
				pu.changeInfo();
				
				
			}
		});
		
		JButton changeEmail = new JButton("수정");
		changeEmail.setSize(60,30);
		changeEmail.setLocation(265,200);
		changeEmail.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = idInfo.getText();
				String email = emailInfo.getText();
				ctr.changeEmail(id, email);
				
				PopUp pu = new PopUp();
				pu.changeInfo();
				
			}
		});
		

		
		JButton changePhoneNum = new JButton("수정");
		changePhoneNum.setSize(60,30);
		changePhoneNum.setLocation(265,260);
		changePhoneNum.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String id = idInfo.getText();
				String mp = phoneNumInfo.getText();
				ctr.changePhoneNum(id, mp);
				
				PopUp pu = new PopUp();
				pu.changeInfo();
				
				
			}
		});

		
		
		panel3.add(idIcon);
		panel3.add(idInfo);
		panel3.add(pwdIcon);
		panel3.add(pwdInfo);
		panel3.add(changePwd);
		panel3.add(nameIcon);
		panel3.add(nameInfo);
		panel3.add(emailIcon);
		panel3.add(emailInfo);
		panel3.add(changeEmail);
		panel3.add(phoneNumIcon);
		panel3.add(phoneNumInfo);
		panel3.add(changePhoneNum);
		panel3.add(academyIcon);
		panel3.add(academyInfo);
		panel3.add(classroomIcon);
		panel3.add(classroomInfo);
		panel3.add(chargedIcon);
		panel3.add(chargedInfo);
		panel3.add(genderIcon);
		panel3.add(genderInfo);
		
		panel2.add(userInfoIcon);
		panel2.add(panel3);
		this.add(panel1);
		this.add(panel2);
		mf.add(this);

		
	}


}
