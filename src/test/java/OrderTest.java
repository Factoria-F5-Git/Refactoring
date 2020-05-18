import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderTest {
    //private or public?
    private Order order;
    private User user;
    //naming?
    private List<Product> productList;

    @Test
    public void calculateTotalShouldHave90PercentDiscountWhenUserIsFromCN() {
        //why are we using arraylist instead of list?
        productList = new ArrayList<Product>();
        productList.add(new Product(1.0, 3.15));
        productList.add(new Product(3.0, 1.0));

        user = new User();
        user.country = "CN";

        //inside or outside the test? what is the difference with the PizzaDeliveryTest?
        order = new Order(productList, user);

        assertEquals(5.535, order.calculateTotal());
    }

    //could we write another test with a different country?

}
