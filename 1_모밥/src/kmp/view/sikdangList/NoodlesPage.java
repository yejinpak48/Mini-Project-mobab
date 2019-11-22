package kmp.view.sikdangList;

import java.awt.Color;
import java.awt.Image;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import kmp.controller.Controller;
import kmp.model.vo.Images;
import kmp.model.vo.Noodle;
import kmp.view.ChangePanel;
import kmp.view.ChargePage;
import kmp.view.FavoritePage;
import kmp.view.LoginPage;
import kmp.view.MainFrame;
import kmp.view.MainPage;
import kmp.view.MapPage;
import kmp.view.MemberInfoPage;
import kmp.view.PopUp;
import kmp.view.SikdangPage;
import kmp.view.UsingHistoryPage;

public class NoodlesPage extends JPanel {
	private MainFrame mf;
	private JPanel noodlesPage;
	LoginPage lp = new LoginPage();
	private int sum;
	private int sum1;
	private int sum2;
	private int sum3;
	private int sum4;
	Images img = new Images();

	public NoodlesPage(MainFrame mf) {
		this.mf = mf;
		this.noodlesPage = this;
		this.setSize(400, 700);
		this.setLayout(null);
		Color color = new Color(35,212,177);
		Color backgcolor = new Color(234,255,236);
		Image imv;

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
				ChangePanel.changePanel(mf, noodlesPage, new MainPage(mf));
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
				ChangePanel.changePanel(mf, noodlesPage, new MemberInfoPage(mf));
			}        

		});

		//panel1.add(back);
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
				ChangePanel.changePanel(mf, noodlesPage, new SikdangPage(mf));
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
				// TODO Auto-generated method stub
				ChangePanel.changePanel(mf, noodlesPage, new FavoritePage(mf));
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
				// TODO Auto-generated method stub
				ChangePanel.changePanel(mf, noodlesPage, new UsingHistoryPage(mf));
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
				// TODO Auto-generated method stub
				ChangePanel.changePanel(mf, noodlesPage, new ChargePage(mf));
			}

		});
		panel1.add(sik);
		panel1.add(fav);
		panel1.add(hist);
		panel1.add(charg);

		this.add(panel1);
		mf.add(this);

		JPanel panel2 = new JPanel();
		panel2.setSize(400, 560);
		panel2.setLocation(0, 140);
		panel2.setBackground(backgcolor);


		//----------------------
		Noodle n = new Noodle();
		Image noodlesname = new ImageIcon("images/noodlesName.png").getImage().getScaledInstance(100, 25, 0);
		JPanel panel3 = new JPanel();
		panel3.setSize(350, 65);
		panel3.setLocation(20, 20);
		panel3.setBackground(color);
		JLabel noodlesLabel = new JLabel(new ImageIcon(noodlesname));
		noodlesLabel.setSize(100, 20);
		noodlesLabel.setLocation(120, 0);
		noodlesLabel.setBackground(color);

		JButton num = new JButton(n.getNumber());
		num.setSize(120, 20);
		num.setLocation(30, 40);
		num.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] buttons= {"확인"};
				JOptionPane a = new JOptionPane();
				int result=a.showOptionDialog(null,"전화 연결하시겠습니까?", "전화연결",a.YES_NO_OPTION,a.PLAIN_MESSAGE,null,buttons,"OK");

				if(result==a.YES_OPTION) {
					PopUp pu = new PopUp();
					pu.callPopUp();

				}

			}

		});

		JTextArea address = new JTextArea(n.getLocation());
		address.setSize(120, 20);
		address.setLocation(215, 35);

//--------------------------
		BufferedReader br = null;
		String fileName = (lp.getId()+".txt");
		File member = new File(fileName);
		imv=img.getStarImg();
		try {
			br = new BufferedReader(new FileReader(member));
			String line = br.readLine();
			String[] info = line.split(", ");
			if(info[5].equals("false")) {
				imv=img.getStarImg();
			}else {
				imv=img.getStar1Img();
			}
		}catch (IOException e1) {
			e1.printStackTrace();
		}

		
//--------------------------
		JButton star = new JButton(new ImageIcon(imv));


		star.setSize(25, 25);
		star.setLocation(5, 5);
		star.setBorderPainted(false);
		star.setContentAreaFilled(false);

		star.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				BufferedWriter wr = null;
				BufferedReader br = null;
				String fileName = (lp.getId()+".txt");
				File member = new File(fileName);
				boolean Bs = false;
				boolean Gr = false;
				boolean Js = false;

				try {
					br = new BufferedReader(new FileReader(member));
					String save ="";
					String line ="";
					while((line = br.readLine()) !=null){
						String[] info = line.split(", ");
						if(info[0].equals(lp.getId())) {
							if(info[2].equals("false")) {
								Bs=false;
							}else {
								Bs=true;
							}
							if(info[3].equals("false")) {
								Gr=false;
							}else {
								Gr=true;
							}
							if(info[4].equals("false")) {
								Js=false;
							}else {
								Js=true;
							}
					
							if(info[5].equals("false")) {
								boolean favoriteBeer = Bs, favoriteGram = Gr, favoriteSandwich = Js, favoriteNoodles = true;
										
								save += lp.getId() +  ", " + info[1] + ", " 
										+ favoriteBeer + ", " + favoriteGram + ", " + favoriteSandwich + ", " + favoriteNoodles + "\n";
								star.setIcon(new ImageIcon(img.getStar1Img()));
							}else {
								boolean favoriteBeer = Bs, favoriteGram = Gr, favoriteSandwich = Js, favoriteNoodles = false;
								
								save += lp.getId() +  ", " + info[1] + ", " 
										+ favoriteBeer + ", " + favoriteGram + ", " + favoriteSandwich + ", " + favoriteNoodles + "\n";
								star.setIcon(new ImageIcon(img.getStarImg()));

							}
						}else {
							if(line.equals("0")) {
								break;
							}
							if(!info[0].equals("sandwich")) {
							save += info[0] + ", " + info[1] +"\n"; 
							}else {
								save += info[0] + ", " + info[1];	
							}
						}
						
						wr = new BufferedWriter(new FileWriter(lp.getId() + ".txt"));
						wr.write(save);
						wr.flush();
					}
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
			}
		});


		panel3.add(noodlesLabel);
		panel3.add(num);
		panel3.add(address);
		panel3.add(star);

		//--------------------------------------------------------------

		String [] count = {"1","2","3","4","5"};

		JPanel panel4 = new JPanel();
		panel4.setSize(350, 270);
		panel4.setLocation(20, 85);
		panel4.setBackground(Color.WHITE);


		JTextField menu1 = new JTextField();
		menu1.setText(n.getMenu()[0][0]);
		menu1.setSize(100, 20);
		menu1.setLocation(25, 30);
		menu1.setEditable(false);


		JTextField menu1p = new JTextField("가격");
		menu1p.setText(n.getPrice()[0]+"");
		menu1p.setSize(70, 20);
		menu1p.setLocation(160, 30);
		menu1p.setEditable(false);

		List listmenu1 = new List(3, false);

		listmenu1.add("0");
		listmenu1.add("1");
		listmenu1.add("2");
		listmenu1.add("3");
		listmenu1.add("4");
		listmenu1.add("5");
		listmenu1.add("6");
		listmenu1.add("7");
		listmenu1.add("8");
		listmenu1.add("9");
		listmenu1.add("10");
		listmenu1.setLocation(270,20);
		listmenu1.setSize(50,35);

//		listmenu1.setVisible(true);



		JTextField menu2 = new JTextField("메뉴2");
		menu2.setText(n.getMenu()[1][0]);
		menu2.setSize(100, 20);
		menu2.setLocation(25, 70);
		menu2.setEditable(false);


		JTextField menu2p = new JTextField("가격");
		menu2p.setText(n.getPrice()[1]+"");
		menu2p.setSize(70, 20);
		menu2p.setLocation(160, 70);
		menu2p.setEditable(false);

		List listmenu2 = new List(3, false);

		listmenu2.add("0");
		listmenu2.add("1");
		listmenu2.add("2");
		listmenu2.add("3");
		listmenu2.add("4");
		listmenu2.add("5");
		listmenu2.add("6");
		listmenu2.add("7");
		listmenu2.add("8");
		listmenu2.add("9");
		listmenu2.add("10");
		listmenu2.setLocation(270,60);
		listmenu2.setSize(50,35);

//		listmenu2.setVisible(true);


		JTextField menu3 = new JTextField("메뉴3");
		menu3.setText(n.getMenu()[2][0]);
		menu3.setSize(100, 20);
		menu3.setLocation(25, 110);
		menu3.setEditable(false);


		JTextField menu3p = new JTextField("가격");
		menu3p.setText(n.getPrice()[2]+"");
		menu3p.setSize(70, 20);
		menu3p.setLocation(160, 110);
		menu3p.setEditable(false);

		List listmenu3 = new List(3, false);
		listmenu3.add("0");
		listmenu3.add("1");
		listmenu3.add("2");
		listmenu3.add("3");
		listmenu3.add("4");
		listmenu3.add("5");
		listmenu3.add("6");
		listmenu3.add("7");
		listmenu3.add("8");
		listmenu3.add("9");
		listmenu3.add("10");
		listmenu3.setLocation(270,100);
		listmenu3.setSize(50,35);

//		listmenu3.setVisible(true);

		JTextField menu4 = new JTextField("메뉴4");
		menu4.setText(n.getMenu()[3][0]);
		menu4.setSize(100, 20);
		menu4.setLocation(25, 150);
		menu4.setEditable(false);


		JTextField menu4p = new JTextField("가격");
		menu4p.setText(n.getPrice()[3]+"");
		menu4p.setSize(70, 20);
		menu4p.setLocation(160, 150);
		menu4p.setEditable(false);


		List listmenu4 = new List(3, false);

		listmenu4.add("0");
		listmenu4.add("1");
		listmenu4.add("2");
		listmenu4.add("3");
		listmenu4.add("4");
		listmenu4.add("5");
		listmenu4.add("6");
		listmenu4.add("7");
		listmenu4.add("8");
		listmenu4.add("9");
		listmenu4.add("10");
		listmenu4.setLocation(270,140);
		listmenu4.setSize(50,35);

//		listmenu4.setVisible(true);


		JTextField total = new JTextField("합계");
		total.setSize(110, 20);
		total.setLocation(25,210);


		JTextField price = new JTextField();
		price.setSize(130, 20);
		price.setLocation(160,210);
		price.setText("0");
		Controller ctr = new Controller();
		listmenu1.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				int ea1 = listmenu1.getSelectedIndex();
				sum1 = ctr.totalPrice(n.getPrice()[0], ea1);
				sum=sum1+sum2+sum3+sum4;
				price.setText(sum+"");

			}
		});
		listmenu2.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				int ea2 = listmenu2.getSelectedIndex();
				sum2 = ctr.totalPrice(n.getPrice()[1], ea2);
				sum=sum1+sum2+sum3+sum4;
				price.setText(sum+"");

			}
		});
		listmenu3.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				int ea3 = listmenu3.getSelectedIndex();
				sum3 = ctr.totalPrice(n.getPrice()[0], ea3);
				sum=sum1+sum2+sum3+sum4;
				price.setText(sum+"");
				

			}
		});
		listmenu4.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				int ea4 = listmenu4.getSelectedIndex();
				sum4 = ctr.totalPrice(n.getPrice()[0], ea4);
				sum=sum1+sum2+sum3+sum4;
				price.setText(sum+"");
			}
		});

		panel4.add(menu1);
		panel4.add(menu1p);
		panel4.add(listmenu1);

		panel4.add(menu2);
		panel4.add(menu2p);
		panel4.add(listmenu2);

		panel4.add(menu3);
		panel4.add(menu3p);
		panel4.add(listmenu3);


		panel4.add(menu4);
		panel4.add(menu4p);
		panel4.add(listmenu4);


		panel4.add(total);  
		panel4.add(price);

		//---------------------------------------

		/*JTextArea ta = new JTextArea("000-000-0000");
		      ta.setSize(100, 50);
		      ta.setLocation(20, 20);
		      ta.setBackground(Color.pink);
		      ta.setEditable(false);*/

		JPanel panel5 = new JPanel();
		panel5.setSize(350, 120);
		panel5.setLocation(20, 335);
		panel5.setBackground(Color.GRAY);


		JButton map = new JButton("위치보기");
		map.setSize(100 ,30 );
		map.setLocation(35,50);
		panel5.add(map);
		map.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ChangePanel.changePanel(mf, noodlesPage, new MapPage(mf, 3));
				Controller ctr = new Controller();
				ctr.map(3);

			}
		});


		JButton pay = new JButton("결제");
		pay.setSize(100 ,30 );
		pay.setLocation(215,50);
		panel5.add(pay);

		pay.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				LoginPage lp = new LoginPage();
				try {
					File memberList = new File("MemberList.txt");
					BufferedReader br = new BufferedReader(new FileReader(memberList));
					String line = "";
					PopUp pu = new PopUp();
					while ((line = br.readLine()) != null) {
						String[] info = line.split(", ");
						if (lp.getId().equals(info[0])) {
							if (Integer.parseInt(info[10]) - sum >= 0) {
								
								pu.CheckPay(price.getText(),mf,noodlesPage,"noodles");
							} else {
								
								pu.lackOfMoney(mf,noodlesPage);
							}
						}
					}
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}

		});




		panel2.add(panel3);
		panel2.add(panel4);
		panel2.add(panel5);


		this.add(panel1);
		this.add(panel2);

		mf.add(this);

	}
}

