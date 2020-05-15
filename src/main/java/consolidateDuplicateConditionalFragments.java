class Deal {

    private double total;
    private double price;
    private Sender sender;

    Deal(Sender sender) {
        this.sender = sender;
    }

    private boolean specialDeal;

    public boolean isSpecialDeal() {
        return specialDeal;
    }

    public void sendDeal() {
        if (isSpecialDeal()) {
            total = price * 0.95;
            sender.send();
        } else {
            total = price * 0.98;
            sender.send();
        }
    }

    public double getTotal() {
        return total;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setSpecialDeal(boolean isSpecialDeal) {
        specialDeal = isSpecialDeal;
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
