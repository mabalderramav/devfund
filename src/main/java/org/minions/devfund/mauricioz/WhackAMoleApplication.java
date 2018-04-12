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
        printGridToUSer(game);
        printBoard(game);
        while (game.getAttemptsLeft() > 0) {
            System.out.println("Enter a value for X coordinate (0-9): ");
            positionX = scanner.nextInt();
            System.out.println("Enter a value for Y coordinate (0-9): ");
            positionY = scanner.nextInt();
            if (positionX != -1 && positionY != -1) {
                game.whack(positionX, positionY);
                printBoard(game);
            } else {
                break;
            }

        }
        printGrid(game);
        System.out.println("Final Score: " + game.getScore());

    }

    /**
     * print the initial grid.
     * @param game current game.
     */
    public static void printGridToUSer(final WhackAMole game) {
        for (int i = 0; i < game.getMoleGridLength(); i++) {
            for (int j = 0; j < game.getMoleGridLength(); j++) {
                System.out.print("\t * ");
            }
            System.out.println();
        }
    }

    /**
     * print final grid.
     * @param game current game
     */
    public static void printGrid(final WhackAMole game) {
        for (int i = 0; i < game.getMoleGridLength(); i++) {
            for (int j = 0; j < game.getMoleGridLength(); j++) {
                System.out.print(game.getMoleGrid(i, j) + "\t");
            }
            System.out.println();
        }
    }

    /**
     * print board of the game results.
     * @param game current game.
     */
    public static void printBoard(final WhackAMole game) {
        System.out.println("Attempts Left: " + game.getAttemptsLeft());
        System.out.println("Moles Left: " + game.getMolesLeft());
        System.out.println("Score: " + game.getScore());
    }
}
