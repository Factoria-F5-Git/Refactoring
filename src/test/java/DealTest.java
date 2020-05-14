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