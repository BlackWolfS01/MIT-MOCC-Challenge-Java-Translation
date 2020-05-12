import java.util.ArrayList;
/*
Author: Mattehw John Werner
Spectre Studios LLC
Completed Percentage: 50%
(Work in Progress)
*/
public class Controller {
     public static void main(String[] args){
          String[] names = new String[]{"wine","beer","pizza","fries","burgers","cola","apple","donut","cake"};
          int[] values = new int[]{90,90,95,100,90,79,50,10};
          int[] calories = new int[]{123,154,258,354,365,150,95,195};
          ArrayList food = buildMenu(names, values, calories);
     }

     public static int tcalcTotalValue() {
          return 0;
     }
     public static ArrayList<Food> buildMenu(String[] names, int[] values, int[] calories){
          ArrayList<Food> menu = new ArrayList<> ();
          for(int i = 0; i <= values.length; i++){
               menu.add(new Food(names[i], values[i], calories[i]));
          }
          return menu;
     }
}

class Food{
     private String name;
     private int value;
     private int calories;
     public Food(String n, int v, int c){
          this.name = n;
          this.value = v;
          this.calories = c;
     }

     public String getName() { return this.name; }
     public int getValue() { return this.value; }
     public int getCalories() { return this.calories; }

     public void setName(String name) { this.name = name; }
     public void setValue(int value) { this.value = value; }
     public void setCalories(int calories) { this.calories = calories; }

     public float density(){ return this.value / this.calories; }

     public String toString(){
          return this.name + "; Value: " + Integer.toString(this.value) + "; Calories: " + Integer.toString(this.calories);
     }
}

