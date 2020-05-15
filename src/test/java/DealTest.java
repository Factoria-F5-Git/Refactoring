import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DealTest {

    Deal deal;

    @Test
    public void sendShouldCallSender() {
        TestSender testSender = new TestSender();
        assertEquals("Not sent!", testSender.message);

        deal = new Deal(testSender);

        deal.sendDeal();
        assertEquals("I've been sent", testSender.message);
    }

    @Test
    public void sendShouldCalculateSpecialDeal() {
        TestSender testSender = new TestSender();
        deal = new Deal(testSender);
        deal.setPrice(100);
        deal.setSpecialDeal(true);

        deal.sendDeal();

        assertEquals(95.0, deal.getTotal());
    }

    @Test
    public void sendShouldCalculateNormalDeal() {
        TestSender testSender = new TestSender();
        deal = new Deal(testSender);
        deal.setPrice(100);
        deal.setSpecialDeal(false);

        deal.sendDeal();

        assertEquals(98.0, deal.getTotal());
    }
}

class TestSender implements Sender{

    String message;

    TestSender(){
        message = "Not sent!";
    }

    @Override
    public void send() {
        message = "I've been sent";
    }
}
