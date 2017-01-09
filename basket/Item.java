package basket;
import java.util.*;
import java.io.Console;

public class Item{
  private String name;
  private Double price;

public Item(String name, Double price){
  this.name = name;
  this.price = price;
}  

public String getName(){
  return this.name;
}

public Double getPrice(){
  return this.price;
}

}