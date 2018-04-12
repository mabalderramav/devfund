package org.minions.devfund.roy;

/**
 * Main class.
 */
class Main {
    public static final int ATTEMPTS = 50;
    public static final int DIMENSIONS = 10;

    /**
     * Main method to run the game.
     *
     * @param args of java.
     */
    public static void main(final String[] args) {
        new Main().run();
    }

    /**
     * Run the application.
     *
     */
    private void run() {
        WhackAMole whackAMole = new WhackAMole(ATTEMPTS, DIMENSIONS);
        whackAMole.playGame();
    }
}
