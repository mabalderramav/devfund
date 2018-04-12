package org.minions.devfund;

import java.util.Random;
import java.util.Scanner;

/**
 * Main Class of the application game
 */
public class WhackaMoleGame {


    public static void main(String[] args) {
        final int MAX_ATTEMPTS=50;
        final int GRID_SIZE=10;
        final int MAX_NUM_MOLES=10;

        WhackAMole whackaMole = new WhackAMole(MAX_ATTEMPTS, GRID_SIZE);
        Random random_number = new Random();
        while (whackaMole.molesLeft <= MAX_NUM_MOLES) {
            int positionX = random_number.nextInt(GRID_SIZE);
            int positionY = random_number.nextInt(GRID_SIZE);
            whackaMole.place(positionX, positionY);
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("You have a maximum of 50 attempts to get all the moles.");
        while (whackaMole.attemptsLeft > 0) {
            System.out.println("Enter Coordinate X (range between 0 to 9)");
            int read_x = scanner.nextInt();
            System.out.println("Enter Coordinate Y (range between 0 to 9");
            int read_y = scanner.nextInt();

            if (read_x == -1 && read_y == -1) {
                System.out.println("You have surrendered!");
                whackaMole.printGrid();
                break;
            }
            if (whackaMole.score == MAX_NUM_MOLES) {
                System.out.println("You Won!!!");
                break;
            }
            whackaMole.whack(read_x, read_y);
            whackaMole.printGridToUser();
        }
    }
}
