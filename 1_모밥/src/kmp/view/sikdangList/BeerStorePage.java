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
import kmp.model.vo.Beer;
import kmp.model.vo.Images;
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
public class BeerStorePage extends JPanel{
	private MainFrame mf;
	private JPanel beerStorePage;
	private int price;
	LoginPage lp = new LoginPage();
	Images img = new Images();

	public BeerStorePage() {}

	public BeerStorePage(MainFrame mf) {
		this.mf = mf;
		this.beerStorePage = this;
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
				ChangePanel.changePanel(mf,beerStorePage, new MainPage(mf));
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
				ChangePanel.changePanel(mf, beerStorePage, new MemberInfoPage(mf));
			}
		});

		//         panel1.add(back);
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
				ChangePanel.changePanel(mf,beerStorePage, new SikdangPage(mf));
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
				ChangePanel.changePanel(mf,beerStorePage, new FavoritePage(mf));
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
				ChangePanel.changePanel(mf,beerStorePage, new UsingHistoryPage(mf));
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
				ChangePanel.changePanel(mf,beerStorePage, new ChargePage(mf));
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

		Beer b = new Beer();
		Image beername = new ImageIcon("images/beerName.png").getImage().getScaledInstance(100, 30, 0);
		JPanel panel3 = new JPanel();
		panel3.setSize(350, 65);
		panel3.setLocation(20, 20);
		panel3.setBackground(color);
		JLabel beerLabel = new JLabel(new ImageIcon(beername));
		beerLabel.setSize(100, 30);
		beerLabel.setLocation(120, 5);
		beerLabel.setBackground(color);
		JButton num = new JButton(b.getNumber());
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

		JTextArea address = new JTextArea(b.getLocation());
		address.setSize(120, 20);
		address.setLocation(200, 40);
		//------------------------------------------------
		BufferedReader br = null;
		String fileName = (lp.getId()+".txt");
		File member = new File(fileName);
		imv=img.getStarImg();
		try {
			br = new BufferedReader(new FileReader(member));
			String line = br.readLine();
			String[] info = line.split(", ");
			if(info[2].equals("false")) {
				imv=img.getStarImg();
			}else {
				imv=img.getStar1Img();
			}
		}catch (IOException e1) {
			e1.printStackTrace();
		}

		//------------------------------------------------------------
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
				boolean Gr = false;
				boolean Js = false;
				boolean Nd = false;

				try {
					br = new BufferedReader(new FileReader(member));
					String save ="";
					String line ="";
					while((line = br.readLine()) !=null){
						String[] info = line.split(", ");
						if(info[0].equals(lp.getId())) {
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
								Nd=false;
							}else {
								Nd=true;
							}

							if(info[2].equals("false")) {
								boolean favoriteBeer = true, favoriteGram = Gr, favoriteSandwich = Js, favoriteNoodles = Nd;

								save += lp.getId() +  ", " + info[1] + ", " 
										+ favoriteBeer + ", " + favoriteGram + ", " + favoriteSandwich + ", " + favoriteNoodles + "\n";
								star.setIcon(new ImageIcon(img.getStar1Img()));
							}else {
								boolean favoriteBeer = false, favoriteGram = Gr, favoriteSandwich = Js, favoriteNoodles = Nd;

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

		panel3.add(beerLabel);
		panel3.add(num);
		panel3.add(address);
		panel3.add(star);

		//--------------------------------------------------------------
		JPanel panel4 = new JPanel();
		panel4.setSize(350, 270);
		panel4.setLocation(20, 85);
		panel4.setBackground(Color.WHITE);

		JTextField menu1 = new JTextField(b.getMenu()[0]);
		menu1.setSize(100, 20);
		menu1.setLocation(25, 25);
		menu1.setEditable(false);

		JTextField menu1p = new JTextField(b.getPrice()+"");
		menu1p.setSize(70, 20);
		menu1p.setLocation(160, 25);
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
		listmenu1.setLocation(270,25);
		listmenu1.setSize(50,35);

//		listmenu1.setVisible(true);




		JTextField total = new JTextField("합계");
		total.setSize(110, 20);
		total.setLocation(25,200);


		JTextField price = new JTextField();
		price.setSize(130, 20);
		price.setLocation(160,200);
		price.setText("0");
		Controller ctr = new Controller();
		listmenu1.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				int ea = listmenu1.getSelectedIndex();
				//	            ctr.totalPrice(b.getPrice(), ea);
				price.setText(ctr.totalPrice(b.getPrice(), ea)+"");
			}
		});

		panel4.add(menu1);
		panel4.add(menu1p);
		panel4.add(listmenu1);
		panel4.add(total);      
		panel4.add(price);
		//--------------------------------------- 



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
				ChangePanel.changePanel(mf, beerStorePage, new MapPage(mf, 1));
				Controller ctr = new Controller();
				ctr.map(1);

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
							if (Integer.parseInt(info[10]) - ctr.totalPrice(b.getPrice(),

								listmenu1.getSelectedIndex()) >= 0) {								
								pu.CheckPay(price.getText(),mf,beerStorePage,"beerStore");

							} else {

								pu.lackOfMoney(mf,beerStorePage);
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}


//

