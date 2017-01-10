import static org.junit.Assert.assertEquals;
import org.junit.*;
import basket.*;

public class BasketTest{

Item item1;
Item item2;
Item item3;
Discount discount1;
Discount discount2;
Discount discount3;
Basket basket1;

@Before
public void before(){
  item1 = new Item("Corn Flakes",0.99);
  item2 = new Item("Milk",1.25);
  item3 = new Item("Milk",1.25);
  discount1 = new Discount("Milk","bogof",2,50.0);
  discount2 = new Discount("Over Twenty","Total",0,10.0);
  discount3 = new Discount("Loyalty","Total",0,2.0);

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

}