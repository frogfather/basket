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
  discount1 = new Discount("Milk","bogof",2,0.50);
  discount2 = new Discount("Over Twenty","Total",0,10.0);
  discount3 = new Discount("Loyalty","Total",0,2.0);

  basket1 = new Basket("Test basket");
}

}