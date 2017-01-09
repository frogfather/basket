import static org.junit.Assert.assertEquals;
import org.junit.*;
import basket.*;

public class ItemTest{

Item item1;
Item item2;
Item item3;


@Before
public void before(){
item1 = new Item("Corn Flakes",0.99);
item2 = new Item("Shampoo",1.20);
item3 = new Item("Milk", 0.79);
}

@Test
public void canGetName(){
  assertEquals("Corn Flakes",item1.getName());
  }

@Test
public void canGetPrice(){
  assertEquals(1.20, item2.getPrice(),0.01);
}

}