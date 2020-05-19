class Citizen {

    public boolean isDead;
    public boolean isRetired;
    public boolean isSeparated;
    public int seniority;
    public int monthsDisabled;
    public boolean isPartTime;

    // Refactoring 1: Replace Nested Conditional with Guard Clauses
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

    public double separatedAmount() {
        return 7;
    }

    public double normalPayAmount() {
        return 5;
    }

    public double retiredAmount() {
        return 3;
    }

    public double deadAmount() {
        return 10;
    }

    // Refactoring 2: Consolidate Conditional Expression
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

