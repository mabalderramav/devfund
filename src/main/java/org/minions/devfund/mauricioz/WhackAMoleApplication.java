package org.minions.devfund.mauricioz;

import java.util.Scanner;

/***
 * WhackAMoleApplication class to start Whackamole game.
 */
public class WhackAMoleApplication {

    /**
     * constructor.
     */
    protected WhackAMoleApplication() { }

    /**
     *main method to manage Whackamole game.
     * @param args default value
     */
    public static void main(final String[] args) {
        final int attemptsNumber = 50;
        final int boardDimension = 10;
        int positionX;
        int positionY;
        Scanner scanner = new Scanner(System.in, "UTF-8");
        WhackAMole game = new WhackAMole(attemptsNumber, boardDimension);
        System.out.println("Game is Started.........");
        game.printGridToUSer();
        game.printBoard();
        while (game.getAttemptsLeft() > 0) {
            System.out.println("Enter a value for X coordinate (0-9): ");
            positionX = scanner.nextInt();
            System.out.println("Enter a value for Y coordinate (0-9): ");
            positionY = scanner.nextInt();
            if (positionX != -1 && positionY != -1) {
                game.whack(positionX, positionY);
                game.printBoard();
            } else {
                break;
            }

        }
        game.printGrid();
        System.out.println("Final Score: " + game.getScore());

    }
}
