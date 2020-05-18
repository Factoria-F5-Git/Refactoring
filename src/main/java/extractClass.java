class Player {

    public static final int IN_POSSESSION_OF_THE_BALL = 1;
    public static final int NOT_IN_POSSESSION_OF_THE_BALL = 0;

    // Access level modifiers, all public?
    public int totalPoints;
    public int ballPossession;
    public int shotLine;

    public Player(int totalPoints, int shotLine, int ballPossession) {
        this.totalPoints = totalPoints;
        this.shotLine = shotLine;
        this.ballPossession = ballPossession;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void shoot() {
        if (this.ballPossession == IN_POSSESSION_OF_THE_BALL) {
            this.totalPoints += shotLine;
        }
    }

    public void pass(Player otherPlayer) {
        if (this.ballPossession == IN_POSSESSION_OF_THE_BALL) {
            otherPlayer.totalPoints += shotLine;
        }
        this.ballPossession = NOT_IN_POSSESSION_OF_THE_BALL;
        otherPlayer.ballPossession = IN_POSSESSION_OF_THE_BALL;
    }
}
