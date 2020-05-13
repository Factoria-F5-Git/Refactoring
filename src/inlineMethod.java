class PizzaDelivery {

    public int getRating(int numberOfLateDeliveries) {
        return moreThanFiveLateDeliveries(numberOfLateDeliveries) ? 2 : 1;
    }

    static boolean moreThanFiveLateDeliveries(int numberOfLateDeliveries) {
        return numberOfLateDeliveries > 5;
    }
}