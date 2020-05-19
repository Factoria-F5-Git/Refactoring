import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class DealTest {
    @Mock
    Sender mockSender;

    Deal deal;

    @Test
    public void sendShouldCallSenderWithTestSender() {
        TestSender testSender = new TestSender();
        assertEquals("Not sent!", testSender.message);

        deal = new Deal(testSender);

        deal.sendDeal();
        assertEquals("I've been sent", testSender.message);
    }

    public void sendShouldCallSenderWithMockSender() {
        mockSender = mock(Sender.class);
        deal = new Deal(mockSender);
        deal.sendDeal();

        verify(mockSender).send();
    }

    @Test
    public void sendShouldCalculateSpecialDeal() {
        TestSender testSender = new TestSender();
        deal = new Deal(testSender);
        deal.price = 100;
        deal.specialDeal = true;

        deal.sendDeal();

        assertEquals(95.0, deal.total);
    }

    @Test
    public void sendShouldCalculateNormalDeal() {
        TestSender testSender = new TestSender();
        deal = new Deal(testSender);
        deal.price = 100;
        deal.specialDeal = false;

        deal.sendDeal();

        assertEquals(98.0, deal.total);
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
