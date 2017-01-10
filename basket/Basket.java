package basket;
import java.util.*;
import java.io.Console;

public class Basket{
  private HashMap<String,Integer> itemQuantities;
  private String name;
  private ArrayList<Item> items;
 private ArrayList<Discount> discounts;

public Basket(String name){
  this.name = name;
  this.items = new ArrayList<Item>();
  this.discounts = new ArrayList<Discount>();
  itemQuantities = new HashMap<String,Integer>();
  }

public String getName(){
  return this.name;
}

public void addItem(Item item){
  this.items.add(item);
  updateHash(item.getName(),true);
}

public int getItemPosition(String name){
  int itemPosition = -1;
  for (Item temp : this.items){
    if (temp.getName().equals(name)){
      itemPosition = this.items.indexOf(temp);
    }
  }
  return itemPosition;
}

public void deleteItem(String name){
  int itemPostition = getItemPosition(name);
  if (itemPostition > -1){
    this.items.remove(itemPostition);
  updateHash(name,false);  
    } 
  }

public void emptyBasket(){
this.items.clear();
this.itemQuantities.clear();
}

public int getItemCount(){
  return this.items.size();
}

public void updateHash(String name, Boolean add){
      if (itemQuantities.get(name) == null){
      if (add){
        itemQuantities.put(name,1);
        }
      }
      else {
      int currVal = (int)itemQuantities.get(name);
      if (add){
      currVal++;
      } 
      else {
      currVal--;
      }
      itemQuantities.put(name,currVal);  
      }
    }

public int getItemQuantity(String name){
  if (itemQuantities.get(name) != null){
    return itemQuantities.get(name);
  }
  else
  {return 1;}  
}

public int getItemHashCount(){
  return this.itemQuantities.size();
}

public Double calcBogof(){
  if (this.discounts.size() > 0){
    for (Discount temp : this.discounts){
      
    }
  }
}

}