package org.minions.devfund.alejandro;
import java.util.Scanner;

/**
 * class for main wack a mole game.
 */
public interface MainWhackAMole {

    /**
     * This is the main method to start running the game.
     * @param args arguments.
     */
    static void main(final String[] args) {

        final int attempts = 50;
        final int dimensions = 10;
        final int amountOfMoles = 10;
        final int exitNumber = -1;
        Scanner scanner = new Scanner(System.in, "UTF-8");
        WhackAMole whackAMole = new WhackAMole(attempts, dimensions);
        whackAMole.setMoles(amountOfMoles);
        whackAMole.fillMatrix();

        boolean keepPlaying = true;
        whackAMole.printGridToUser();
        while (keepPlaying) {
            System.out.print("Enter x Value:  ");
            int x = scanner.nextInt();
            System.out.print("Enter y Value:  ");
            int y = scanner.nextInt();
            if (x == -1 && y == -1) {
                System.out.println("The game has end with you surrendering,...");
                whackAMole.printGrid();
                keepPlaying = false;
            } else if ((x > dimensions - 1 || x < exitNumber) || (y > dimensions - 1 || y < exitNumber)) {
                System.out.println("Out of boundaries try again");
            } else {
                whackAMole.whack(x, y);
                whackAMole.printGridToUser();
                System.out.println("You have: " + whackAMole.getAttemptsLeft() + "attempts");
                System.out.println("Moles left: " + whackAMole.getMoleLeft());
            }
            if (whackAMole.getAttemptsLeft() == 0) {
                System.out.println("You do not have more attempts");
                keepPlaying = false;
            }
            if (whackAMole.getMoleLeft() == 0) {
                System.out.println("You have won the game with a score of: "
                        + whackAMole.getScore() + "congratulations!!!!");
                keepPlaying = false;
            }
        }
    }
}
