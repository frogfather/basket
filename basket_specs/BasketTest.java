import static org.junit.Assert.assertEquals;
import org.junit.*;
import basket.*;

public class BasketTest{

Item item1;
Item item2;
Item item3;
Item item4;
Item item5;
Item item6;
Item item7;
Item item8;
Discount discount1;
Discount discount2;
Basket basket1;

@Before
public void before(){
  item1 = new Item("Corn Flakes",0.99);
  item2 = new Item("Milk",1.25);
  item3 = new Item("Milk",1.25);
  item4 = new Item("Something expensive",19.00);
  item5 = new Item("Expensive Thing",17.60);
  item6 = new Item("Milk",1.25);
  item7 = new Item("Milk",1.25);
  item8 = new Item("Milk",1.25);
  
  discount1 = new Discount("Milk","bogof",2,50.0);
 
  discount2 = new Discount("Loyalty","loyalty",0,2.0);
  basket1 = new Basket("Test basket");
}

@Test
public void canGetName(){
  assertEquals("Test basket",basket1.getName());
}

@Test
public void canAddItem(){
  basket1.addItem(item1);
  assertEquals(1,basket1.getItemCount());
}
@Test
public void canRemoveItem(){
  basket1.addItem(item1);
  assertEquals(1,basket1.getItemCount()); 
  assertEquals(1, basket1.getItemQuantity("Corn Flakes"));

  basket1.deleteItem("Corn Flakes");
  assertEquals(0,basket1.getItemCount()); 
  assertEquals(0, basket1.getItemQuantity("Corn Flakes"));
}

@Test
public void canEmptyBasket(){
  basket1.addItem(item1);
  basket1.addItem(item2);
  assertEquals(2,basket1.getItemCount());
  basket1.emptyBasket();
  assertEquals(0,basket1.getItemCount());
  assertEquals(0,basket1.getItemHashCount());
}

@Test 
public void canUpdateHash(){
  basket1.addItem(item2);
  basket1.addItem(item3);
  assertEquals(2, basket1.getItemQuantity("Milk"));
}

@Test
public void canCalcDiscount(){
  basket1.addItem(item1);
  basket1.addItem(item2);
  basket1.addItem(item3);
  basket1.addDiscount(discount1);
assertEquals(1.25,basket1.calcBogof(),0.01);
}

@Test
public void canCalcBogofWithMultiples(){
 basket1.addItem(item2);
 basket1.addItem(item3);
 basket1.addItem(item6);
 basket1.addItem(item7);
 basket1.addItem(item8);
 basket1.addDiscount(discount1);
 assertEquals(2.50,basket1.calcBogof(),0.01); 
}

@Test
public void canCalcTotalPrice(){
  basket1.addItem(item1);
  basket1.addItem(item2);
  basket1.addItem(item3);
  assertEquals(3.49,basket1.getBaseTotal(),0.01);
}

@Test
public void canCalcOverTwentyPoundDiscount(){
basket1.addItem(item4);
basket1.addItem(item2);
basket1.addItem(item3);
Double subTotal = basket1.getBaseTotal();
assertEquals(2.15,basket1.calcOverTwentyDiscount(subTotal),0.01);
}

@Test
public void testOverTwentyDiscountNotAppliedUnderTwenty(){
  basket1.addItem(item4);
  basket1.addItem(item1);
  Double subTotal = basket1.getBaseTotal();
assertEquals(0,basket1.calcOverTwentyDiscount(subTotal),0.01);
}

@Test
public void testNoOverTwentyDiscountAfterBogof(){
  basket1.addItem(item5);
  basket1.addItem(item2);
  basket1.addItem(item3);
  basket1.addDiscount(discount1);
  Double subTotal = basket1.getBaseTotal();
  Double bogof = basket1.calcBogof();
  assertEquals(2.01,basket1.calcOverTwentyDiscount(subTotal),0.01);
 assertEquals(0,basket1.calcOverTwentyDiscount(subTotal-bogof),0.01);
  }

@Test
public void testLoyaltyDiscount(){
  basket1.addItem(item2);
  basket1.addItem(item3);
  basket1.addDiscount(discount2);
  Double subTotal = basket1.getBaseTotal();
assertEquals(0.05,basket1.calcLoyaltyDiscount(subTotal),0.01);  
}

@Test 
public void testAllDiscountsTogether(){
  basket1.addItem(item1);
  basket1.addItem(item2);
  basket1.addItem(item3);
  basket1.addItem(item4);
  basket1.addItem(item5);
// total is 40.09
  basket1.addDiscount(discount1);
  basket1.addDiscount(discount2);
Double subTotal = basket1.getBaseTotal();
assertEquals(40.09,subTotal,0.01);
Double bogof = basket1.calcBogof();
assertEquals(1.25,bogof,0.01);
Double overTwenty = basket1.calcOverTwentyDiscount(subTotal-bogof);
assertEquals(3.884,overTwenty,0.0001);
Double loyalty = basket1.calcLoyaltyDiscount(subTotal-bogof-overTwenty);
assertEquals(0.699,loyalty,0.001);
}

@Test
public void noLoyaltyDiscountWithoutCard(){
   basket1.addItem(item1);
   basket1.addItem(item2);
   basket1.addItem(item3);
   basket1.addItem(item4);
   basket1.addItem(item5);
 // total is 40.09
   basket1.addDiscount(discount1);
 Double subTotal = basket1.getBaseTotal();
 assertEquals(40.09,subTotal,0.01);
 Double bogof = basket1.calcBogof();
 assertEquals(1.25,bogof,0.01);
 Double overTwenty = basket1.calcOverTwentyDiscount(subTotal-bogof);
 assertEquals(3.884,overTwenty,0.0001);
 Double loyalty = basket1.calcLoyaltyDiscount(subTotal-bogof-overTwenty);
 assertEquals(0.0,loyalty,0.001); 
}

}