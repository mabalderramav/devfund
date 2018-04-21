package org.minions.devfund.marylin;

import java.util.Random;
import java.util.Scanner;

public class WhackAMole {

    int score;
    int molesLeft;
    int attemptsLeft;
    char moleGrid[][];

    // Constructor
    WhackAMole(int numAttempts, int gridDimension) {
        this.score = 0;
        this.molesLeft = 0;
        this.attemptsLeft = numAttempts;
        this.moleGrid = new char[gridDimension][gridDimension];
        for (int i = 0; i < gridDimension; i++) {
            for (int j = 0; j < gridDimension; j++) {
                this.moleGrid[i][j] = '*';
            }
            System.out.println();
        }
    }

    boolean place(int x, int y) {
        this.moleGrid[x][y] = 'M';
        if (this.moleGrid[x][y] == 'M') {
            this.molesLeft = this.molesLeft + 1;
            return true;
        } else {
            return false;
        }
    }

    void whack(int x, int y) {
        if (this.moleGrid[x][y] == 'M') {
            this.score = this.score + 1;
            this.molesLeft = this.molesLeft - 1;
        }

        this.moleGrid[x][y] = 'W';
        this.attemptsLeft = this.attemptsLeft - 1;
    }

    void printGridToUser() {
        for (int i = 0; i < moleGrid.length; i++) {
            for (int j = 0; j < moleGrid.length; j++) {
                if (moleGrid[i][j] != 'W') {
                    System.out.print(" * ");
                } else {
                    System.out.print(" " + moleGrid[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    void printGrid() {
        for (int i = 0; i < moleGrid.length; i++) {
            for (int j = 0; j < moleGrid.length; j++) {
                System.out.print(" " + moleGrid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int gridLength = 10;
        int attemps = 50;
        int number_of_moles = 10;

        // create a 10 by 10 grid
        WhackAMole whackamole = new WhackAMole(attemps, gridLength);

        // randomly place 10 moles
        for (int i = 0; i < number_of_moles; i++) {
            Random rand = new Random();
            int x = rand.nextInt(number_of_moles);
            int y = rand.nextInt(number_of_moles);
            whackamole.place(x, y);
            System.out.println("Mole places at " + x + "," + y);
        }

        System.out.println("-----You have a maximum of " + attemps + " attempts to get all the moles-----");
        int xCoordinate;
        int yCoordinate;
        Scanner xScanner;
        Scanner yScanner;
        for (int i = attemps - 1; i >= 0; i++) {
            xScanner = new Scanner(System.in);
            System.out.print("Enter the x coordinates: ");
            xCoordinate = xScanner.nextInt();

            yScanner = new Scanner(System.in);
            System.out.print("Enter the y coordinates: ");
            yCoordinate = yScanner.nextInt();

            if (xCoordinate == -1 || yCoordinate == -1) {
                System.out.println("Giving up!!");
                whackamole.printGrid();
                break;
            } else {
                System.out.println("State of Game");
                whackamole.whack(xCoordinate, yCoordinate);
                whackamole.printGridToUser();
            }

            if (whackamole.molesLeft == 0) {
                System.out.println("All moles were whacked with score: " + whackamole.score);
                break;
            }

            if (whackamole.attemptsLeft == 0) {
                System.out.println("There are no more attemps with score: " + whackamole.score);
                break;
            }
        }
    }
}
