package kmp.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import kmp.model.vo.Images;
import kmp.view.sikdangList.BeerStorePage;
import kmp.view.sikdangList.GramPage;
import kmp.view.sikdangList.NoodlesPage;
import kmp.view.sikdangList.SandwichPage;

public class SikdangPage extends JPanel {
	private MainFrame mf;
	private JPanel sikdangPage;
	private Font font;
	Images img = new Images();
	
	public SikdangPage(MainFrame mf) {
		this.mf = mf;
		this.sikdangPage = this;
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
		JButton home = new JButton(new ImageIcon(img.getHomeImg()));
		home.setSize(240,50);
		home.setLocation(80,5);
		home.setBorderPainted(false);
		home.setContentAreaFilled(false);
		home.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ChangePanel.changePanel(mf,sikdangPage, new MainPage(mf));
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
				ChangePanel.changePanel(mf, sikdangPage, new MemberInfoPage(mf));
			}
			
		});
//		panel1.add(back);
		panel1.add(home);
		panel1.add(infor);
		panel1.setBackground(color);
		
		JButton sik = new JButton(new ImageIcon(img.getSik_cImg()));
		sik.setSize(100,100);
		sik.setLocation(0,55);
		sik.setBorderPainted(false);
		sik.setContentAreaFilled(false);
		sik.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ChangePanel.changePanel(mf,sikdangPage, new SikdangPage(mf));
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
				ChangePanel.changePanel(mf, sikdangPage, new FavoritePage(mf));

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
				ChangePanel.changePanel(mf, sikdangPage, new UsingHistoryPage(mf));

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
				ChangePanel.changePanel(mf, sikdangPage, new ChargePage(mf));

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
		
		JButton beerStore = new JButton();
		beerStore.setSize(300, 100);
		beerStore.setLocation(50, 30);
		beerStore.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ChangePanel.changePanel(mf, sikdangPage, new BeerStorePage(mf));
			}
			
		});

		JLabel beerLabel = new JLabel(new ImageIcon(img.getBeerStoreImg()));
		beerLabel.setSize(100, 100);
		beerLabel.setLocation(0, 0);
		JTextArea beerTextArea = new JTextArea("매일 다른 메뉴~\n맛있으니까 오세요\n");
//		font = new Font("궁서", Font.PLAIN, 15);
//		beerTextArea.setLayout();
		beerTextArea.setSize(200, 125);
		beerTextArea.setLocation(100, 0);
//		beerTextArea.setFont(font);
		
		beerStore.add(beerLabel);
		beerStore.add(beerTextArea);
		
		JButton gram = new JButton();
		gram.setSize(300, 100);
		gram.setLocation(50, 150);
		gram.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ChangePanel.changePanel(mf, sikdangPage, new GramPage(mf));
			}
			
		});

		JLabel gramLabel = new JLabel(new ImageIcon(img.getGramImg()));
		gramLabel.setSize(100, 100);
		gramLabel.setLocation(0, 0);
		JTextArea gramTextArea = new JTextArea("아메리카노~\n쬬아~쬬아~쬬아~");
		gramTextArea.setSize(200, 100);
		gramTextArea.setLocation(100, 0);
		gram.add(gramLabel);
		gram.add(gramTextArea);
		
		JButton sandwich = new JButton();
		sandwich.setSize(300, 100);
		sandwich.setLocation(50, 270);
		sandwich.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ChangePanel.changePanel(mf, sikdangPage, new SandwichPage(mf));
			}
			
		});

		JLabel sandwichLabel = new JLabel(new ImageIcon(img.getSandwichImg()));
		sandwichLabel.setSize(100, 100);
		sandwichLabel.setLocation(0, 0);
		JTextArea sandwichTextArea = new JTextArea("샌드위치\n빵을 포개서 만든\n샌드위치");
		sandwichTextArea.setSize(200, 100);
		sandwichTextArea.setLocation(100, 0);
		sandwich.add(sandwichLabel);
		sandwich.add(sandwichTextArea);
		
		JButton noodles = new JButton();
		noodles.setSize(300, 100);
		noodles.setLocation(50, 390);
		noodles.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ChangePanel.changePanel(mf, sikdangPage, new NoodlesPage(mf));
			}
			
		});

		JLabel noodlesLabel = new JLabel(new ImageIcon(img.getNoodlesImg()));
		noodlesLabel.setSize(100, 100);
		noodlesLabel.setLocation(0, 0);
		JTextArea noodlesTextArea = new JTextArea("짜장면\n길고 검은\n자장면");
		noodlesTextArea.setSize(200, 100);
		noodlesTextArea.setLocation(100, 0);
		noodles.add(noodlesLabel);
		noodles.add(noodlesTextArea);
		
		panel2.add(beerStore);
		panel2.add(gram);
		panel2.add(sandwich);
		panel2.add(noodles);
		
		
		this.add(panel1);
		this.add(panel2);
		mf.add(this);

		
	}
}

