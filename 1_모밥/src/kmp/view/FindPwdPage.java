
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
import kmp.controller.Controller;
import kmp.model.vo.Images;

public class FindPwdPage extends JPanel{
	private MainFrame mf;
	private JPanel findPwdPage;
	Controller ctr = new Controller();

	
	public FindPwdPage(MainFrame mf) {
		this.mf = mf;
		this.findPwdPage = this;
		this.setSize(400, 700);
		this.setLayout(null);
		Color color = new Color(35,212,177);
		Color backgcolor = new Color(234,255,236);
		Images img = new Images();
			
		//상단 패널
		JPanel panel1 = new JPanel();
		panel1.setSize(400, 150);
		panel1.setLocation(0, 0);
		panel1.setBackground(new Color(35,212,177));

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
				ChangePanel.changePanel(mf,findPwdPage, new LoginPage(mf));
			}
			
		});
		JButton fid = new JButton(new ImageIcon(img.getFidImg()));
		fid.setBorderPainted(false);
		fid.setContentAreaFilled(false);
		fid.setSize(200,100);
		fid.setLocation(0,55);
		fid.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ChangePanel.changePanel(mf, findPwdPage, new FindIdPage(mf));
				
			}
		});
		
		JButton fpw = new JButton(new ImageIcon(img.getFpw_cImg()));
		fpw.setBorderPainted(false);
		fpw.setContentAreaFilled(false);
		fpw.setSize(200,100);
		fpw.setLocation(200, 55);
		panel1.add(fid);
		panel1.add(fpw);
		panel1.add(back);
		panel1.add(home);
		
		
		//하단 패널
		JPanel panel2 = new JPanel();
		panel2.setSize(400, 550);
		panel2.setLocation(0, 150);
		panel2.setBackground(backgcolor);
		
		JTextField tId = new JTextField();
		JTextField tName = new JTextField();
		JTextField tEmail = new JTextField();
		tId.setSize(220, 40);
		tName.setSize(220, 40);
		tEmail.setSize(220, 40);
		tId.setLocation(120, 50);
		tName.setLocation(120, 105);
		tEmail.setLocation(120, 160);
		panel2.add(tId);
		panel2.add(tName);
		panel2.add(tEmail);

		JLabel id = new JLabel("ID");
		JLabel name = new JLabel("이름");
		JLabel email = new JLabel("E-MAIL");
		id.setSize(60, 40);
		name.setSize(60, 40);
		email.setSize(60, 40);
		id.setLocation(60, 50);
		name.setLocation(60, 105);
		email.setLocation(60, 160);
		JLabel mobobMainIcon = new JLabel(new ImageIcon(img.getMobobMain()));
		mobobMainIcon.setSize(260, 260);
		mobobMainIcon.setLocation(70, 280);
		panel2.add(id);
		panel2.add(name);
		panel2.add(email);
		panel2.add(mobobMainIcon);
		
		JButton button1 = new JButton("확인");
		button1.setSize(280,60);
		button1.setLocation(60, 240);
		panel2.add(button1);
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String inputId = tId.getText();
				String inputName = tName.getText();
				String inputEmail = tEmail.getText();
				if (ctr.findPwd(inputId, inputName, inputEmail)) {
					String[] buttons= {"확인"};
					JOptionPane a = new JOptionPane();
					int result=a.showOptionDialog(null,"등록된 이메일로 비밀번호 정보 발송했습니다.", "Pwd찾기 성공",a.OK_OPTION,a.PLAIN_MESSAGE,null,buttons,"OK");

					if(result==a.OK_OPTION) {
						ChangePanel.changePanel(mf,findPwdPage, new LoginPage(mf));
					}
				} else {
					PopUp popup = new PopUp();
					popup.findPwdFailPopup();
				}

			}
		});
		
		
		this.add(panel1);
		this.add(panel2);
		
	}
	
}
