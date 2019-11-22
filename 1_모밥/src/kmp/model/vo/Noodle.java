package kmp.model.vo;

import java.awt.Image;
import java.io.Serializable;
import java.util.Arrays;


public class Noodle implements Serializable{
   private String[][] menu  = new String[][] {{"짜장면","5000"} ,{"짬뽕","5500"} ,{"볶음밥","6000"}, {"탕수육","8000"}};
   private String number = "02-539-4004";
   private String location = "강남구 역삼동 736-22";
   private Image map;
   private String name = "중리";
   private int[] price = new int[4];
   private int sum = 0;
   
   
   
   
   
   
   public Noodle() {
	   for(int i=0;i<this.menu.length;i++) {
	    	  for(int j=0;j<this.menu[i].length;j++) {
	    		  if(j==1) {
	    			  price[i]=Integer.parseInt(this.menu[i][j]);
	    		  }
	    	  }
	      }    
   }
   

//   public Noodle(String[][] menu, String number, String location, Image mf3ap, String name, int[] price) {
//      super();
//      this.menu = menu;
//      this.number = number;
//      this.location = location;
//      this.map = map;
//      this.name = name;
//      for(int i=0;i<this.menu.length;i++) {
//    	  for(int j=0;j<this.menu[i].length;j++) {
//    		  if(j==1) {
//    			  price[i]=Integer.parseInt(this.menu[i][j]);
//    		  }
//    	  }
//      }      
//   
//   
//   }


  


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


public String[][] getMenu() {
      
      return menu;
   }

   public String getNumber() {
      
      return number;
   }

   public String getLocation() {
      return location;
   }

   public Image getMap() {
      return map;
   }

   public String getName() {
      return name;
   }

   public void setMenu(String[][] menu) {
      this.menu = menu;
   }

   public void setNumber(String number) {
      this.number = number;
   }

   public void setLocation(String location) {
      this.location = location;
   }

   public void setMap(Image map) {
      this.map = map;
   }

   public void setName(String name) {
      this.name = name;
   }



   
   
   
}
