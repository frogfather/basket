import static org.junit.Assert.assertEquals;
import org.junit.*;
import basket.*;

public class DiscountTest{

Discount discount1;

@Before
public void before(){
  discount1 = new Discount("Corn Flakes","bogof",2,50.0);
}

@Test
public void canGetItem(){
  assertEquals("Corn Flakes",discount1.getItem());
}

@Test
public void canGetCategory(){
  assertEquals("bogof",discount1.getCategory());
}

@Test
public void canGetQuantity(){
  assertEquals(2,discount1.getQuantity());
}

@Test
public void canGetPercentage(){
  assertEquals(50,discount1.getPercentage(),0.01);
}


}
