package kmp.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import kmp.controller.Controller;
import kmp.model.vo.Images;

public class UsingHistoryPage extends JPanel{
	private MainFrame mf;
	private JPanel usinghistorypage;
	Images img = new Images();

	public UsingHistoryPage(MainFrame mf) {
		this.mf = mf;
		this.usinghistorypage = this;
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
				ChangePanel.changePanel(mf,usinghistorypage, new MainPage(mf));
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
				ChangePanel.changePanel(mf, usinghistorypage, new MemberInfoPage(mf));
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
				ChangePanel.changePanel(mf,usinghistorypage, new SikdangPage(mf));
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
				ChangePanel.changePanel(mf, usinghistorypage, new FavoritePage(mf));

			}
		});

		JButton hist = new JButton(new ImageIcon(img.getChart_cImg()));
		hist.setSize(100,100);
		hist.setLocation(200,55);

		hist.setBorderPainted(false);
		hist.setContentAreaFilled(false);
		JButton charge = new JButton(new ImageIcon(img.getChargeImg()));
		charge.setSize(100,100);
		charge.setLocation(300,55);
		charge.setBorderPainted(false);
		charge.setContentAreaFilled(false);
		charge.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ChangePanel.changePanel(mf, usinghistorypage, new ChargePage(mf));

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

		Controller c = new Controller();

		String info [] = {"식당","결제금액"};
		String data[][];

		data = new String[8][2];
		data[0][0]="맥주창고";
		data[0][1]=c.outputstore("beerStore");

		data[1][0]="7gram";
		data[1][1]=c.outputstore("7gram");

		data[2][0]="Joe's sandwich";
		data[2][1]=c.outputstore("sandwich");

		data[3][0]="중리";
		data[3][1]=c.outputstore("noodles");
		
		data[4][0]="";
		data[4][1]="";
		
		data[5][0]="";
		data[5][1]="";
		
		data[6][0]="";
		data[6][1]="";
		
		data[7][0]="누적금액";
		data[7][1]=Integer.parseInt(data[0][1])+Integer.parseInt(data[1][1])+Integer.parseInt(data[2][1])+Integer.parseInt(data[3][1])+"";


		DefaultTableModel model = new DefaultTableModel(data, info);


		JTable table = new JTable(model);
		JScrollPane scrollpane = new JScrollPane(table);

		JPanel panel = new JPanel();
		JTextField store = new JTextField();
		JTextField pay = new JTextField();
		scrollpane.add(store);
		scrollpane.add(pay);



		scrollpane.setSize(350,300);
		scrollpane.setLocation(20,50);
		panel2.add(scrollpane);


		JPanel infopanel = new JPanel();
		JTextField tfstore = new JTextField();
		JTextField tfpay = new JTextField();

		panel2.add(infopanel);
		infopanel.setSize(350,300);
		infopanel.setLocation(20,50);

		//		infopanel.add()


		this.add(panel1);
		this.add(panel2);
		mf.add(this);





	}
}