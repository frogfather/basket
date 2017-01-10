package basket;
import java.util.*;
import java.io.Console;

public class Discount{
  private String item;
  private String category;
  private int quantity;
  private Double percentage;

public Discount(String item, String category, int quantity, Double percentage){
  this.item = item;
  this.category = category;
  this.quantity = quantity;
  this.percentage = percentage;
  }  

public String getItemName(){
  return this.item;
}

public String getCategory(){
  return this.category;
}

public int getQuantity(){
  return this.quantity;
}

public Double getPercentage(){
  return this.percentage;
}

}