class Citizen {

    private boolean isDead;
    private boolean isRetired;
    private boolean isSeparated;
    private int seniority;
    private int monthsDisabled;
    private boolean isPartTime;

    Citizen(boolean isDead, boolean isRetired, boolean isSeparated) {

        this.isDead = isDead;
        this.isRetired = isRetired;
        this.isSeparated = isSeparated;
    }

    // 2 different constructors
    Citizen(int seniority, int monthsDisabled, boolean isPartTime) {
        this.seniority = seniority;
        this.monthsDisabled = monthsDisabled;
        this.isPartTime = isPartTime;
    }

    // Replace Nested Conditional with Guard Clauses
    public double getPayAmount() {
        double result;
        if (isDead) {
            result = deadAmount();
        } else {
            if (isSeparated) {
                result = separatedAmount();
            } else {
                if (isRetired) {
                    result = retiredAmount();
                } else {
                    result = normalPayAmount();
                }
            }
        }
        return result;
    }

    // do they need to be separate methods?
    private double separatedAmount() {
        return 7;
    }

    private double normalPayAmount() {
        return 5;
    }

    private double retiredAmount() {
        return 3;
    }

    private double deadAmount() {
        return 10;
    }

    // Consolidate Conditional Expression
    double disabilityAmount() {
        if (seniority < 2) {
            return 0;
        }
        if (monthsDisabled > 12) {
            return 0;
        }
        if (isPartTime) {
            return 0;
        }
        return 10;
    }
}

