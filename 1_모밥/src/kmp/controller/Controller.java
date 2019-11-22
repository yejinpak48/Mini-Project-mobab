package kmp.controller;

import java.awt.Component;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import kmp.model.vo.Beer;
import kmp.model.vo.Member;
import kmp.view.ChargePage;
import kmp.view.LoginPage;
import kmp.view.MainFrame;
import kmp.view.PopUp;



public class Controller extends Member {
	private LoginPage lp = new LoginPage();
	private MainFrame mf;
	private JPanel mapPage;

	public Controller() {
	}

	FileInputStream fin = null;

	public void check(String id) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("MemberList.txt"));
			bw.write(id);
			bw.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean loginCheck(String id, String pwd) {

		try {
			File member = new File("MemberList.txt");
			BufferedReader br = new BufferedReader(new FileReader(member));
			String line = "";
			while ((line = br.readLine()) != null) {
				String[] info = line.split(", ");
				if (id.equals(info[0])) {
					if (pwd.equals(info[1])) {
						return true;
					}
				} 
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;

		// //1. 아이디검사
		// //아이디를 통해 파일이름 받아오기
		// String fileName = id + ".txt";
		// File member = new File(fileName);
		//
		// //해당 이름의 파일이 없을 경우 false 리턴
		// if(!member.isFile()) {
		// return false;
		// }
		//
		// //2. 패스워드 검사
		// BufferedReader br = null;
		// try{
		// //필요한 파일 읽기
		// br = new BufferedReader(new FileReader(id + ".txt"));
		// String temp = br.readLine();
		//
		// //split을 이용해 ", " 를 구분자로 하여 파일에 저장된 값을 나누기
		// String[] info = temp.split(", ");
		//
		// //입력한 pwd와 파일에 저장되어있는 pwd가 같지 않을 경우 false 출력
		// if(!pwd.equals(info[1])) {
		// return false;
		// }
		// }catch(IOException e) {
		// e.printStackTrace();
		// }
		//
		// //아이디 검사와 패스워드 검사에서 아무 이상이 없다면 true 리턴
		// return true;
	}

	// [호석] 아이디 찾기 메소드
	@SuppressWarnings("resource")
	public boolean findId(String name, String email) {
		try {
			File memberList = new File("MemberList.txt");
			BufferedReader br = new BufferedReader(new FileReader(memberList));
			String line = "";
			while ((line = br.readLine()) != null) {
				String[] info = line.split(", ");
				System.out.println(info[2]);
				if (name.equals(info[2])) {
					if (email.equals(info[3])) {
						return true;
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	// [호석] 비밀번호 찾기 메소드
	@SuppressWarnings("resource")
	public boolean findPwd(String id, String name, String email) {
		try {
			File memberList = new File("MemberList.txt");
			BufferedReader br = new BufferedReader(new FileReader(memberList));
			String line = "";
			while ((line = br.readLine()) != null) {
				String[] info = line.split(", ");
				if (id.equals(info[0])) {
					if (name.equals(info[2])) {
						if (email.equals(info[3])) {
							return true;
						}
					}
				} 
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	// 현수 아이디 중복확인
	public boolean isDuplicatedId(String id) {
		String fileName = id + ".txt";
		File member = new File(fileName);
 
		if (member.isFile()) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isIdTypeErr(String id) {
		if(infoErr1(id)){
			return true;
		}
		return false;
	}

	public void join(String id, String pwd, String name, String email, String phone, int age, String academy,
			char classroom, char gender) {

		int point = 0, charged = 0;
		boolean favoriteBeer = false, favoriteGram = false, favoriteNoodles = false, favoriteSandwich = false;

		// type1 txt생성
		BufferedWriter mList = null;
		try {

			mList = new BufferedWriter(new FileWriter("MemberList.txt", true));

			mList.write(id + ", " + pwd + ", " + name + ", " + email + ", " + phone + ", " + academy + ", " + classroom
					+ ", " + age + ", " + gender + ", " + point + ", " + charged);
			mList.newLine();
			mList.flush();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				mList.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// type2 txt생성
		BufferedWriter idList = null;
		try {
			idList = new BufferedWriter(new FileWriter(id + ".txt"));

			idList.write(id + ", "  + name + ", " 
					+ favoriteBeer + ", " + favoriteGram + ", " + favoriteNoodles + ", " + favoriteSandwich
					+ "\nbeerStore, 0"
					+ "\n7gram, 0"
					+ "\nnoodles, 0"
					+ "\nsandwich, 0");


			idList.flush();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				idList.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public boolean isDuplicatedPhone(String phone) {

		try {
			File member = new File("MemberList.txt");
			BufferedReader br = null;
			br = new BufferedReader(new FileReader(member));
			String line = "";
			while ((line = br.readLine()) != null) {
				String[] info = line.split(", ");
				if (phone.equals(info[4])) {
					return true;
				} else {
					return false;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;

	}

	public int totalPrice(int price, int ea) {

		Beer b = new Beer();

		int sum = 0;

		sum = (ea * price);

		return sum;

	}

	// [호석] 맴버인포 페이지에 로그인한 멤버의 비밀번호 정보 출력하기 메소드 
	public String outputPwdInfo(String id) {
		try {
			File memberList = new File("MemberList.txt");
			BufferedReader br = new BufferedReader(new FileReader(memberList));
			String line = "";
			while ((line = br.readLine()) != null) {
				String[] info = line.split(", ");
				if (id.equals(info[0])) {
					return info[1];
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "찾는 정보가 없습니다";
	}


	// [호석] 맴버인포 페이지에 로그인한 멤버의 이름 정보 출력하기 메소드 
	public String outputNameInfo(String id) {
		try {
			File memberList = new File("MemberList.txt");
			BufferedReader br = new BufferedReader(new FileReader(memberList));
			String line = "";
			while ((line = br.readLine()) != null) {
				String[] info = line.split(", ");
				if (id.equals(info[0])) {
					return info[2];
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "찾는 정보가 없습니다";
	}

	// [호석] 맴버인포 페이지에 로그인한 멤버의 이메일 정보 출력하기 메소드
	public String outputEmailInfo(String id) {
		try {
			File memberList = new File("MemberList.txt");
			BufferedReader br = new BufferedReader(new FileReader(memberList));
			String line = "";
			while ((line = br.readLine()) != null) {
				String[] info = line.split(", ");
				if (id.equals(info[0])) {
					return info[3];
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "찾는 정보가 없습니다";
	}

	// [호석] 맴버인포 페이지에 로그인한 멤버의 전화번호 정보 출력하기 메소드
	public String outputPhoneNumInfo(String id) {
		try {
			File memberList = new File("MemberList.txt");
			BufferedReader br = new BufferedReader(new FileReader(memberList));
			String line = "";
			while ((line = br.readLine()) != null) {
				String[] info = line.split(", ");
				if (id.equals(info[0])) {
					return info[4];
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "찾는 정보가 없습니다";
	}

	// [호석] 맴버인포 페이지에 로그인한 멤버의 학원 정보 출력하기 메소드
	public String outputAcademyInfo(String id) {
		try {
			File memberList = new File("MemberList.txt");
			BufferedReader br = new BufferedReader(new FileReader(memberList));
			String line = "";
			while ((line = br.readLine()) != null) {
				String[] info = line.split(", ");
				if (id.equals(info[0])) {
					return info[5];
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "찾는 정보가 없습니다";
	}

	// [호석] 맴버인포 페이지에 로그인한 멤버의 반 정보 출력하기 메소드
	public String outputClassroomInfo(String id) {
		try {
			File memberList = new File("MemberList.txt");
			BufferedReader br = new BufferedReader(new FileReader(memberList));
			String line = "";
			while ((line = br.readLine()) != null) {
				String[] info = line.split(", ");
				if (id.equals(info[0])) {
					return info[6];
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "찾는 정보가 없습니다";
	}

	// [호석] 맴버인포 페이지에 로그인한 멤버의 보유금액 정보 출력하기 메소드
	public String outputChargedInfo(String id) {
		try {
			File memberList = new File("MemberList.txt");
			BufferedReader br = new BufferedReader(new FileReader(memberList));
			String line = "";
			while ((line = br.readLine()) != null) {
				String[] info = line.split(", ");
				if (id.equals(info[0])) {
					return info[8];
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "찾는 정보가 없습니다";
	}

	// [호석] 맴버인포 페이지에 로그인한 멤버의 성별 정보 출력하기 메소드
	public String outputGenderInfo(String id) {
		try {
			File memberList = new File("MemberList.txt");
			BufferedReader br = new BufferedReader(new FileReader(memberList));
			String line = "";
			while ((line = br.readLine()) != null) {
				String[] info = line.split(", ");
				if (id.equals(info[0])) {
					return info[10];
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "찾는 정보가 없습니다";
	}



	public String outputstore(String sikdang) {
		String totalMoney = "";
		BufferedReader br = null;

		try {
			LoginPage lp = new LoginPage();
			lp.getId();
			File memberList = new File( lp.getId() + ".txt");
			br = new BufferedReader(new FileReader(memberList));
			String line = "";
//			System.out.println(sikdang);
			while ((line = br.readLine()) != null) {
//				System.out.println("1");
				String[] info = line.split(", ");
				if(sikdang.equals(info[0])) {
					totalMoney = info[1];
//					System.out.println(totalMoney);
				}
			}
//			System.out.println(totalMoney +"가나다");

			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return totalMoney;
	}

	public void payHistory(String sikdang, String price) {
		lp.getId();
		String filename=lp.getId()+".txt";
		BufferedWriter mList = null;
		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader(lp.getId() + ".txt"));

			String line = "";
			String save = "";
			while((line = br.readLine()) != null) {
				String info[] = line.split(", ");
				if(info[0].equals(sikdang)) {
					save += info[0] + ", " 
							+ (Integer.parseInt(info[1]) + Integer.parseInt(price)) +"\n";
				}else {
					save += line +"\n";
				}
			}

			//			mList.write(name + "," + Integer.parseInt(price.getText()));

			mList = new BufferedWriter(new FileWriter(lp.getId()+".txt"));
			mList.write(save);
			mList.flush();

		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}


	public void minusPay(String price) {
		BufferedWriter mList = null;
		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader("MemberList.txt"));
			String line = "";
			String save = "";
			while((line = br.readLine()) != null) {
				String info[] = line.split(", ");
				if(info[0].equals(lp.getId())) {
					for(int i= 0; i < info.length-1; i++) {
					save += info[i] + ", ";
					}		
					save+= (Integer.parseInt(info[10]) - Integer.parseInt(price)) +"\n";
				}else {
					save += line +"\n";
				}
			}

			mList = new BufferedWriter(new FileWriter("MemberList.txt"));
			mList.write(save);
			mList.flush();

		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}



	public Component map(int i) {

		Image mapBeerImg = new ImageIcon("images/mapbeer.png").getImage().getScaledInstance(310, 280, 0);
		Image mapGramImg = new ImageIcon("images/mapGram.png").getImage().getScaledInstance(310, 280, 0);
		Image mapNoodlesImg = new ImageIcon("images/mapNoodles.png").getImage().getScaledInstance(310, 280, 0);
		Image mapSandwichImg = new ImageIcon("images/mapSandwich.png").getImage().getScaledInstance(310, 280, 0);


		JLabel mapImg = new JLabel("");

		if(i == 1) {
			mapImg = new JLabel(new ImageIcon(mapBeerImg));
			mapImg.setSize(310, 280);
			mapImg.setLocation(20, 10);

		}else if(i == 2) {
			mapImg = new JLabel(new ImageIcon(mapGramImg));
			mapImg.setSize(310, 280);
			mapImg.setLocation(20, 10);

		}else if(i == 3) {
			mapImg = new JLabel(new ImageIcon(mapNoodlesImg));
			mapImg.setSize(310, 280);
			mapImg.setLocation(20, 10);

		}else if(i == 4) {
			mapImg = new JLabel(new ImageIcon(mapSandwichImg));
			mapImg.setSize(310, 280);
			mapImg.setLocation(20, 10);

		}

		return mapImg;
	}


	//charge 충전버튼
	public void charged(int charged) {
		ChargePage cp = new ChargePage();
		Member[] m = new Member[1];

		try {
			BufferedReader br = new BufferedReader(new FileReader("MemberList.txt"));
			String save = "";
			String line="";

			while ((line = br.readLine()) != null) {
				String[] info = line.split(", ");

				if(lp.getId().equals(info[0])) {
					for(int i = 0; i < 10;i++) {
						save += info[i] + ", ";
					}
					save += charged;

				}else {
					for(int i = 0; i < info.length;i++) {
						if(i != info.length-1) {
							save += info[i] + ", ";
						}else {
							save += info[i];
						}
					}
				}
				save += "\n";
			}
			BufferedWriter bw = null;

			bw = new BufferedWriter(new FileWriter("MemberList.txt"));
			bw.write(save);
			bw.close();
			br.close();

		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public boolean phoneOverlap(String phone) {
		for(int i = 0; i < phone.length(); i++) {
			if(phone.charAt(i)>='a'&&phone.charAt(i)<='z'||phone.charAt(i)=='-') {
				PopUp pu = new PopUp();
				pu.phoneErr();
				return false;
			}
		}
		return true;
	}
	
	
	public boolean infoErr1(String id) {
		for(int i = 0; i < id.length();i++) {
			if(!((id.charAt(i)>='0'&&id.charAt(i)<='9')||(id.charAt(i)>='a'&&id.charAt(i)<='z')||(id.charAt(i)>='A'&&id.charAt(i)<='Z'))) {
				return true;
			}
		}
		return false;
	}
	
	public int infoErr(String id, String pwd, String name, String phone) {
		for(int i = 0; i < id.length();i++) {
			if(!((id.charAt(i)>='0'&&id.charAt(i)<='9')||(id.charAt(i)>='a'&&id.charAt(i)<='z')||(id.charAt(i)>='A'&&id.charAt(i)<='Z'))) {
				return 1;
			}
		}
		for(int i = 0; i < pwd.length();i++) {
			if(!((pwd.charAt(i)>='0'&&pwd.charAt(i)<='9')||(pwd.charAt(i)>='a'&&pwd.charAt(i)<='z')||(id.charAt(i)>='A'&&id.charAt(i)<='Z'))) {
				return 2;
			}
		}
		for(int i = 0; i < name.length(); i ++) {
			if(!(name.charAt(i)>='가'&&name.charAt(i)<='힣')) {
				return 3;
			}
		}
		for(int i = 0; i < phone.length();i++) {
			if(!(phone.charAt(i)>='0'&&phone.charAt(i)<='9')) {
				return 4;
			}
		}
		return 0;
	}

	//회원정보 수정
	public void changePwd(String id, String pwd) {
		String save = "";
		String line = "";
		try {
			File memberList = new File("MemberList.txt");
			BufferedReader br = new BufferedReader(new FileReader(memberList));
			while ((line = br.readLine()) != null) {
				String[] info = line.split(", ");
				if (id.equals(info[0])) {
					for(int i = 0; i < 11; i++) {
						if(info[i] == info[1]) {
							save += pwd + ", ";
						}else if(i == 10) {
							save += info[i];
						}else {
							save += info[i] + ", ";
						}
					}

				}else {
					for(int i = 0; i < info.length; i++) {
						if(i != info.length-1) {
							save += info[i] + ", ";
						}else {
							save += info[i];
						}
					}
				}
				save += "\n";
			}
			BufferedWriter bw = null;

			bw = new BufferedWriter(new FileWriter("MemberList.txt"));
			bw.write(save);
			bw.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}


	public void changeEmail(String id, String email) {
		String save = "";
		String line = "";
		try {
			File memberList = new File("MemberList.txt");
			BufferedReader br = new BufferedReader(new FileReader(memberList));
			while ((line = br.readLine()) != null) {
				String[] info = line.split(", ");
				if (id.equals(info[0])) {
					for(int i = 0; i < 11; i++) {
						if(info[i] == info[3]) {
							save += email + ", ";
						}else if(i == 10) {
							save += info[i];
						}else {
							save += info[i] + ", ";
						}
					}

				}else {
					for(int i = 0; i < info.length; i++) {
						if(i != info.length-1) {
							save += info[i] + ", ";
						}else {
							save += info[i];
						}
					}
				}
				save += "\n";
			}
			BufferedWriter bw = null;

			bw = new BufferedWriter(new FileWriter("MemberList.txt"));
			bw.write(save);
			bw.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}



	public boolean changePhoneNum(String id, String mp) {
		String save = "";
		String line = "";
		try {
			File memberList = new File("MemberList.txt");
			BufferedReader br = new BufferedReader(new FileReader(memberList));
			while ((line = br.readLine()) != null) {
				String[] info = line.split(", ");
				if (id.equals(info[0])) {
					for(int i = 0; i < 11; i++) {
						if(info[i] == info[4]) {
							save += mp + ", ";
						}else if(i == 10) {
							save += info[i];
						}else {
							save += info[i] + ", ";
						}
					}

				}else {
					for(int i = 0; i < info.length; i++) {
						if(i != info.length-1) {
							save += info[i] + ", ";
						}else {
							save += info[i];
						}
					}
				}
				save += "\n";
			}
			BufferedWriter bw = null;

			bw = new BufferedWriter(new FileWriter("MemberList.txt"));
			bw.write(save);
			bw.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return false;
	}

}
