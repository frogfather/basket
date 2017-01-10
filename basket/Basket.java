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

public Item getItem(String name){
  for (Item temp : this.items){
    if (temp.getName().equals(name)){
      return temp;
    }
  }
  return null;
}

public void deleteItem(String name){
  Item toDelete = getItem(name);
  if (toDelete != null){
    this.items.remove(this.items.indexOf(toDelete));
  updateHash(name,false);  
    } 
  }

  public void addDiscount(Discount discount){
    this.discounts.add(discount);
  }

  public Discount getDiscount(String name){
    for (Discount temp : this.discounts){
      if (temp.getItemName().equals(name)){
        return temp;
      }
    }
    return null;
  }


  public void deleteDiscount(String name){
    Discount toDelete = getDiscount(name);
    if (toDelete != null){
      this.discounts.remove(this.discounts.indexOf(toDelete));
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
      if (temp.getCategory().equals("bogof")){
      //find how many of this product we have
      String itemName = temp.getItemName();
      int quantForDiscount = temp.getQuantity();
      int quantInHand = getItemQuantity(itemName); 
      if (quantInHand >= quantForDiscount){
      int numberOfDiscounts = quantInHand/quantForDiscount; 
      Item thisItem = getItem(itemName);
      //numberOfDiscounts is how many times we 
      //apply the discount. So if the discount
      //is on two items and we have 5 it gets 
      //applied twice
      //we now need the price of the item
      //and the discount to apply
      Double itemPrice = thisItem.getPrice();
      Double thisDiscount = (quantForDiscount * numberOfDiscounts *itemPrice * temp.getPercentage()/100);
      return thisDiscount;
      }
      }
    }
  }
  return 0.0;
}

}