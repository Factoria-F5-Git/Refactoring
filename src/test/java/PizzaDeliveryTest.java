import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PizzaDeliveryTest {
    PizzaDelivery pizzaDelivery = new PizzaDelivery();

    @Test
    public void getRatingShouldReturn1WhenLateDeliveriesIs5() {
        assertEquals(pizzaDelivery.getRating(5), 1);
    }

    //could we write a test for less than 5 deliveries late?

}