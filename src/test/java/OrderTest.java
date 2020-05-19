import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderTest {

    private Order order;
    private User user;
    private List<Product> productList;

    @Test
    public void calculateTotalShouldHave90PercentDiscountWhenUserIsFromCN() {
        productList = new ArrayList<Product>();
        Product product = new Product();
        product.quantity = 1.0;
        product.price = 3.15;
        productList.add(product);
        product = new Product();
        product.quantity = 3.0;
        product.price = 1.0;
        productList.add(product);

        user = new User();
        user.country = "CN";

        //inside or outside the test? what is the difference with the PizzaDeliveryTest?
        order = new Order(productList, user);

        assertEquals(5.535, order.calculateTotal());
    }

    //could we write another test with a different country?

}
