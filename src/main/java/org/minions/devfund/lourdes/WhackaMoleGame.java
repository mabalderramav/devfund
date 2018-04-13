package org.minions.devfund.lourdes;

import java.util.Random;
import java.util.Scanner;

/**
 * Main Class of the application game.
 */
public final class WhackaMoleGame {

    /**
     * Private constructor.
     */
    private WhackaMoleGame() {
        //test
    }

    /**
     * Main method that start the game.
     *
     * @param args arguments.
     */
    public static void main(final String[] args) {
        final int maxAttepmts = 50;
        final int gridSize = 10;
        final int maxNumMoles = 10;

        WhackAMole whackaMole = new WhackAMole(maxAttepmts, gridSize);
        Random randomNumber = new Random();
        while (whackaMole.getMolesLeft() <= maxNumMoles) {
            int positionX = randomNumber.nextInt(gridSize);
            int positionY = randomNumber.nextInt(gridSize);
            whackaMole.place(positionX, positionY);
        }

        Scanner scanner = new Scanner(System.in, "UTF-8");
        System.out.println("You have a maximum of 50 attempts to get all the moles.");
        while (whackaMole.getAttemptsLeft() > 0) {
            System.out.println("Enter Coordinate X (range between 0 to 9)");
            int readX = scanner.nextInt();
            System.out.println("Enter Coordinate Y (range between 0 to 9");
            int readY = scanner.nextInt();

            if (readX == -1 && readY == -1) {
                System.out.println("You have surrendered!");
                whackaMole.printGrid();
                break;
            }
            if (whackaMole.getScore() == maxNumMoles) {
                System.out.println("You Won!!!");
                break;
            }
            whackaMole.whack(readX, readY);
            whackaMole.printGridToUser();
        }
    }
}
