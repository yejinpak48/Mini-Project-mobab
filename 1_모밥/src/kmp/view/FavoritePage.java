package kmp.view;

import java.awt.Color;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

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

public class FavoritePage extends JPanel{
	private static final LayoutManager GridLayout = null;
	private MainFrame mf;
	private JPanel favoritepage;
	LoginPage lp = new LoginPage();
	Images img = new Images();


	public FavoritePage(MainFrame mf) {
		this.mf = mf;
		this.favoritepage = this;
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
				ChangePanel.changePanel(mf,favoritepage, new MainPage(mf));
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
				ChangePanel.changePanel(mf, favoritepage, new MemberInfoPage(mf));
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
				ChangePanel.changePanel(mf,favoritepage, new SikdangPage(mf));
			}

		});

		JButton fav = new JButton(new ImageIcon(img.getFavorite_cImg()));
		fav.setBorderPainted(false);
		fav.setContentAreaFilled(false);
		fav.setSize(100,100);
		fav.setLocation(100,55);

		JButton hist = new JButton(new ImageIcon(img.getChartImg()));
		hist.setSize(100,100);
		hist.setLocation(200,55);
		hist.setBorderPainted(false);
		hist.setContentAreaFilled(false);
		hist.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ChangePanel.changePanel(mf, favoritepage, new UsingHistoryPage(mf));

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
				ChangePanel.changePanel(mf, favoritepage, new ChargePage(mf));

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


		BufferedReader br = null;
		String fileName = (lp.getId()+".txt");
		File member = new File(fileName);
		//맥주창고
		try {
			br = new BufferedReader(new FileReader(member));
			String line = br.readLine();
			String[] info = line.split(", ");
			if(info[2].equals("true")) {
				JButton beerStore = new JButton();
				beerStore.setSize(300, 100);
				beerStore.setLocation(50, 30);
				beerStore.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						ChangePanel.changePanel(mf, favoritepage, new BeerStorePage(mf));
					}
				});
				JLabel beerLabel = new JLabel(new ImageIcon(img.getBeerStoreImg()));
				beerLabel.setSize(100, 100);
				beerLabel.setLocation(0, 0);
				JTextArea beerTextArea = new JTextArea("매일 다른 메뉴~\n맛있으니까 오세요");
				beerTextArea.setSize(200, 100);
				beerTextArea.setLocation(100, 0);

				beerStore.add(beerLabel);
				beerStore.add(beerTextArea);
				panel2.add(beerStore);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//7Gram
		try {
			br = new BufferedReader(new FileReader(member));
			String line = br.readLine();
			String[] info = line.split(", ");
			if(info[3].equals("true")&&info[2].equals("true")) {
				JButton gram = new JButton();
				gram.setSize(300, 100);
				gram.setLocation(50, 150);
				gram.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						ChangePanel.changePanel(mf, favoritepage, new GramPage(mf));

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
				panel2.add(gram);
			}else if(info[3].equals("true")) {
				JButton gram = new JButton();
				gram.setSize(300, 100);
				gram.setLocation(50, 30);
				gram.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						ChangePanel.changePanel(mf, favoritepage, new GramPage(mf));

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
				panel2.add(gram);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		//JOS샌드위치
		try {
			br = new BufferedReader(new FileReader(member));
			String line = br.readLine();
			String[] info = line.split(", ");
			if(info[3].equals("true")&&info[2].equals("true")&&info[4].equals("true")) {
				JButton sandwich = new JButton();
				sandwich.setSize(300, 100);
				sandwich.setLocation(50, 270);
				sandwich.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						ChangePanel.changePanel(mf, favoritepage, new SandwichPage(mf));

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
				panel2.add(sandwich);
			}else if((info[3].equals("true")&&info[4].equals("true"))||(info[2].equals("true")&&info[4].equals("true"))) {
				JButton sandwich = new JButton();
				sandwich.setSize(300, 100);
				sandwich.setLocation(50, 150);
				sandwich.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						ChangePanel.changePanel(mf, favoritepage, new SandwichPage(mf));

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
				panel2.add(sandwich);
			}else if(info[4].equals("true")) {
				JButton sandwich = new JButton();
				sandwich.setSize(300, 100);
				sandwich.setLocation(50, 30);
				sandwich.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						ChangePanel.changePanel(mf, favoritepage, new SandwichPage(mf));

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
				panel2.add(sandwich);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

		//중리
		try {
			br = new BufferedReader(new FileReader(member));
			String line = br.readLine();
			String[] info = line.split(", ");
			if(info[2].equals("true")&&info[3].equals("true")&&info[4].equals("true")&&info[5].equals("true")) {
				JButton noodles = new JButton();
				noodles.setSize(300, 100);
				noodles.setLocation(50, 390);
				noodles.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						ChangePanel.changePanel(mf, favoritepage, new NoodlesPage(mf));

					}
				});
				JLabel  noodlesLabel = new JLabel(new ImageIcon(img.getNoodlesImg()));
				noodlesLabel.setSize(100, 100);
				noodlesLabel.setLocation(0, 0);
				JTextArea noodlesTextArea = new JTextArea("짜장면\n길고 검은\n자장면");
				noodlesTextArea.setSize(200, 100);
				noodlesTextArea.setLocation(100, 0);

				noodles.add(noodlesLabel);
				noodles.add(noodlesTextArea);
				panel2.add(noodles);
			}else if((info[2].equals("true")&&info[3].equals("true")&&info[5].equals("true"))
					||(info[2].equals("true")&&info[4].equals("true")&&info[5].equals("true"))
					||(info[3].equals("true")&&info[4].equals("true")&&info[5].equals("true"))){
				JButton noodles = new JButton();
				noodles.setSize(300, 100);
				noodles.setLocation(50, 270);
				noodles.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						ChangePanel.changePanel(mf, favoritepage, new NoodlesPage(mf));

					}
				});
				JLabel  noodlesLabel = new JLabel(new ImageIcon(img.getNoodlesImg()));
				noodlesLabel.setSize(100, 100);
				noodlesLabel.setLocation(0, 0);
				JTextArea noodlesTextArea = new JTextArea("짜장면\n길고 검은\n자장면");
				noodlesTextArea.setSize(200, 100);
				noodlesTextArea.setLocation(100, 0);

				noodles.add(noodlesLabel);
				noodles.add(noodlesTextArea);
				panel2.add(noodles);
			}else if((info[2].equals("true")&&info[5].equals("true"))
					||(info[3].equals("true")&&info[5].equals("true"))
					||(info[4].equals("true")&&info[5].equals("true"))){
				JButton noodles = new JButton();
				noodles.setSize(300, 100);
				noodles.setLocation(50, 150);
				noodles.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						ChangePanel.changePanel(mf, favoritepage, new NoodlesPage(mf));

					}
				});
				JLabel  noodlesLabel = new JLabel(new ImageIcon(img.getNoodlesImg()));
				noodlesLabel.setSize(100, 100);
				noodlesLabel.setLocation(0, 0);
				JTextArea noodlesTextArea = new JTextArea("짜장면\n길고 검은\n자장면");
				noodlesTextArea.setSize(200, 100);
				noodlesTextArea.setLocation(100, 0);

				noodles.add(noodlesLabel);
				noodles.add(noodlesTextArea);
				panel2.add(noodles);
			}else if(info[5].equals("true")) {
				JButton noodles = new JButton();
				noodles.setSize(300, 100);
				noodles.setLocation(50, 30);
				noodles.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						ChangePanel.changePanel(mf, favoritepage, new NoodlesPage(mf));

					}
				});
				JLabel  noodlesLabel = new JLabel(new ImageIcon(img.getNoodlesImg()));
				noodlesLabel.setSize(100, 100);
				noodlesLabel.setLocation(0, 0);
				JTextArea noodlesTextArea = new JTextArea("짜장면\n길고 검은\n자장면");
				noodlesTextArea.setSize(200, 100);
				noodlesTextArea.setLocation(100, 0);

				noodles.add(noodlesLabel);
				noodles.add(noodlesTextArea);
				panel2.add(noodles);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

		this.add(panel1);
		this.add(panel2);
		mf.add(this);

	}

}
