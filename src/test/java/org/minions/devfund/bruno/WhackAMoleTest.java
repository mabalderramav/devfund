package org.minions.devfund.bruno;

import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.assertTrue;

/**
 * This class in charged of testing the whack a mole game.
 */
public class WhackAMoleTest {

    private static final int NUM_ATTEMPTS = 50;
    private static final int GRID_DIMENSION = 10;
    private static final int NUM_MOLES = 10;

    /**
     * Verifies if the game working correctly.
     */
    @Test
    public void whackAMoleGameTest() {
        WhackAMole whackAMoleGame = new WhackAMole(NUM_ATTEMPTS, GRID_DIMENSION);

        whackAMoleGame.printGridToUser();
        assertTrue(whackAMoleGame.place(2, 3));
    }

    /**
     * Verifies if the game working correctly.
     */
    @Test
    public void whackAMolePlayGameTest() {

        // Config Game
        WhackAMole game = new WhackAMole(NUM_ATTEMPTS, GRID_DIMENSION);
        game.placeAllMoles(NUM_MOLES);

        // Start Game
        System.out.println("Welcome to Whack-A-Mole!\n");
        game.printGridToUser();
        Scanner scanner = new Scanner(System.in);
        int gridSize = GRID_DIMENSION - 1;

        while (!game.gameOver()) {
            System.out.print("Enter a row number(0 - " + gridSize + "):  ");
            int userInputX = scanner.nextInt();
            System.out.print("Enter a column number(0 - " + gridSize + "):  ");
            int userInputY = scanner.nextInt();
            game.whack(userInputX, userInputY);
            game.printGridToUser();
        }
        scanner.close();
    }

    public static void main(String[] args){

        // Config Game
        WhackAMole game = new WhackAMole(NUM_ATTEMPTS, GRID_DIMENSION);
        game.placeAllMoles(NUM_MOLES);

        // Start Game
        System.out.println("Welcome to Whack-A-Mole!\n");
        game.printGridToUser();
        Scanner scanner = new Scanner(System.in);
        int gridSize = GRID_DIMENSION - 1;

        while (!game.gameOver()) {
            System.out.print("Enter a row number(0 - " + gridSize + "):  ");
            int userInputX = scanner.nextInt();
            System.out.print("Enter a column number(0 - " + gridSize + "):  ");
            int userInputY = scanner.nextInt();
            game.whack(userInputX, userInputY);
            game.printGridToUser();
        }
        scanner.close();
    }

}
