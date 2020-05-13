import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/*
Author: Matthew John Werner
Spectre.ZERO.ONE Studios LLC
 */

public class Controller {
     public static void main(String[] args){
          //Instances Variables
          String[] names = new String[]{"wine","beer","pizza","fries","burgers","cola","apple","donut","cake"};
          int[] values = new int[]{89,90,90,95,100,90,79,50,10};
          int[] calories = new int[]{123,123,154,258,354,365,150,95,195};
          System.out.println("Lecture 1: Optimization Part One");

          /* Functionality Test One */
          /*
          Food apple = new Food("Apple", 79, 150);
          System.out.print("Name: " + apple.getName() + ", Value: " +  Integer.toString(apple.getValue())  +
               ", Calories: " +  Integer.toString(apple.getCalories()));
          System.out.println(apple.toString());

           */
          ArrayList<Food> foodMenu = buildMenu(names, values, calories);
          testGreedy(foodMenu, 1000.0f);
     }

     public static void testGreedy(ArrayList<Food> items, float constraints){
          FoodSet set = greedy(items, constraints);
          System.out.println("Total Value of all items = "+ set.getTotalValue ());
          for(Food takenItem : set.getFood ()) {
               System.out.println("Item : " + takenItem.toString());
          }
     }

     public static FoodSet greedy(ArrayList<Food>  foodMenu, float maxCost) {
          ArrayList<Food> result = new ArrayList<>();
          Collections.sort ( foodMenu , ( Comparator< Food > ) ( o1 , o2 ) ->
                    ((Food)o1).getName().compareToIgnoreCase ( ((Food)o2).getName()) );
          float totalValue = 0.0f;
          float totalCost = 0.0f;
          for(Food element : foodMenu){
               if((totalCost + (float)element.getCalories ()) <= maxCost){
                    result.add(element);
                    totalValue += element.getValue();
                    totalCost += element.getCalories ();
               }
          }
          return new FoodSet(result, totalCost);
     }

     public static ArrayList<Food> buildMenu(String[] names, int[] values, int[] calories){
          ArrayList<Food> menu = new ArrayList<> ();
          for(int i = 0; i < names.length; i++)
              menu.add(new Food(names[i],values[i],calories[i]));
          return menu;
     }

     private static class FoodSet{
          private ArrayList<Food> food;
          private float totalValue;
          public FoodSet(ArrayList<Food> list, float totalValue){
               this.food = list;
               this.totalValue = totalValue;
          }
          public ArrayList<Food> getFood() { return this.food; }
          public float getTotalValue(){ return this.totalValue; }
          public void setFood(ArrayList<Food> list) { this.food = list; }
          public void setTotalValue(float value) { this.totalValue = value; }
     }
}

/*
Constructor Class
 */
class Food{
     private String name;
     private int value;
     private int calories;
     public Food(){
          this.name = "";
          this.value = 0;
          this.calories = 0;
     }
     public Food(String name){
          this.name = name;
          this.value = 0;
          this.calories = 0;
     }
     public Food(String name, int value) {
          this.name = name;
          this.value = value;
          this.calories = 0;
     }
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
