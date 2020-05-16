class Bird {

    private Origin origin;
    private double numberOfCoconuts;
    private boolean isNailed;
    private double voltage;

    Bird(Origin origin, double numberOfCoconuts, double voltage, boolean isNailed){
        this.origin = origin;
        this.numberOfCoconuts = numberOfCoconuts;
        this.voltage = voltage;
        this.isNailed = isNailed;
    }

    double getSpeed() {
        switch (origin) {
            case EUROPEAN:
                return getBaseSpeed();
            case AFRICAN:
                return getBaseSpeed() - getLoadFactor() * numberOfCoconuts;
            case NORWEGIAN_BLUE:
                return (isNailed) ? 0 : getBaseSpeed(voltage);
        }
        throw new RuntimeException("Should be unreachable");
    }

    double getBaseSpeed(){
        return 9.0;
    }

    double getBaseSpeed(double voltage){
        return 9.0*voltage;
    }

    double getLoadFactor(){
        return 1.2;
    }
}

enum Origin {
    EUROPEAN,
    AFRICAN,
    NORWEGIAN_BLUE
}
//
//abstract class Bird {
//    // ...
//    abstract double getSpeed();
//}

//class European extends Bird {
//    double getSpeed() {
//        return getBaseSpeed();
//    }
//}
//class African extends Bird {
//    double getSpeed() {
//        return getBaseSpeed() - getLoadFactor() * numberOfCoconuts;
//    }
//}
//class NorwegianBlue extends Bird {
//    double getSpeed() {
//        return (isNailed) ? 0 : getBaseSpeed(voltage);
//    }
//}
//
//// Somewhere in client code
//speed = bird.getSpeed();