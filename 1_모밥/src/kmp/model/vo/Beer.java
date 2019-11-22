package kmp.model.vo;

import java.awt.Image;
import java.util.Arrays;

import javax.swing.ImageIcon;

public class Beer {
   private String[] menu = new String[] {"뷔페","qnldp"};
   private String number = "02-565-5674";
   private String location = "서울특별시 강남구 역삼동";
   private Image map = new ImageIcon("images/mapbeer.png").getImage().getScaledInstance(60, 60, 0);
   private String name = "맥주창고";
   private int price = 5000;
   private int sum = 0;
   

   public Beer() {}

   public String[] getMenu() {
      String[] men = new String[2];
      for(int i=0;i<menu.length;i++) {
       men[i]=menu[i];
      }
      return men;
   }

   public void setMenu(String[] menu) {
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

   public int getPrice() {
      return price;
   }

   public void setPrice(int price) {
      this.price = price;
   }

   
   public int getSum() {
      return sum;
   }
   
   public void setSum(int sum) {
      this.sum = sum;
   }

   
   
   @Override
   public String toString() {
      return "Beer [menu=" + Arrays.toString(menu) + ", number=" + number + ", location=" + location + ", map=" + map
            + ", name=" + name + ", price=" + price + "]";
   }

   

}