class Bird {

    public Origin origin;
    public double numberOfCoconuts;
    public boolean isNailed;
    public double voltage;

    Bird(Origin origin, double numberOfCoconuts, double voltage, boolean isNailed) {
        this.origin = origin;
        this.numberOfCoconuts = numberOfCoconuts;
        this.voltage = voltage;
        this.isNailed = isNailed;
    }

    double getSpeed() {
        switch (origin) {
            case EUROPEAN:
                return 9.0;
            case AFRICAN:
                return 9.0 - 1.2 * numberOfCoconuts;
            case NORWEGIAN_BLUE:
                return (isNailed) ? 0 : (9.0 * voltage);
        }
        throw new RuntimeException("Should be unreachable");
    }
}

enum Origin {
    EUROPEAN,
    AFRICAN,
    NORWEGIAN_BLUE
}