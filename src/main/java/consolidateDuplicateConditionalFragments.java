class Deal {

    public double total;
    public double price;
    public Sender sender;
    public boolean specialDeal;

    Deal(Sender sender) {
        this.sender = sender;
    }

    public void sendDeal() {
        if (specialDeal) {
            total = price * 0.95;
            sender.send();
        } else {
            total = price * 0.98;
            sender.send();
        }
    }
}

class DealSender implements Sender {

    @Override
    public void send() {
        System.out.println("printing....");
    }
}

interface Sender {
    void send();
}
