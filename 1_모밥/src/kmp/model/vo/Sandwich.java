package kmp.model.vo;

import java.awt.Image;
import java.io.Serializable;

import javax.swing.ImageIcon;

public class Sandwich implements Serializable{
	private String[][] menu  = new String[][] {{"클럽 샌드위치","5500"} ,{"포카치아","6300"} ,{"파니니","6500"}, {"바게트","6500"}};
	private String number = "02-569-5954";
	private String location = "강남구 역삼동 87-길";
	private Image map;
	private String name = "7gram";
	private int[] price = new int[4];
	private int sum = 0;

	

	public Sandwich(){
		for(int i=0;i<this.menu.length;i++) {
			for(int j=0;j<this.menu[i].length;j++) {
				if(j==1) {
					price[i]=Integer.parseInt(this.menu[i][j]);
				}
			}
		}    
	}



	public String[][] getMenu() {
		return menu;
	}



	public void setMenu(String[][] menu) {
		this.menu = menu;
	}



	public String getNumber() {
		return number;
	}



	public void setNumber(String number) {
		this.number = number;
	}



	public String getLocation() {
		return location;
	}



	public void setLocation(String location) {
		this.location = location;
	}



	public Image getMap() {
		return map;
	}



	public void setMap(Image map) {
		this.map = map;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int[] getPrice() {
		return price;
	}



	public void setPrice(int[] price) {
		this.price = price;
	}



	public int getSum() {
		return sum;
	}



	public void setSum(int sum) {
		this.sum = sum;
	}


	
	
	

}
