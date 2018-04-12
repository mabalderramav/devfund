package org.minions.devfund.alejandro;
import java.util.Scanner;


class MainWhackAMole {
    /**
     * This is the main class to run the game.
     * @param args arguments.
     */

    public static void main(String[] args) {
        /*
          This is the main method to run the game flow.
         */
        Scanner in = new Scanner(System.in);
        WhackAMole whackAMole = new WhackAMole(50,10);
        boolean keepPlaying = true;
        whackAMole.printGridToUser();
        while (keepPlaying){
            System.out.print("Enter x Value:  ");
            int x = in.nextInt();
            System.out.print("Enter y Value:  ");
            int y = in.nextInt();
            if (x == -1 && y == -1){
                System.out.println("The game has end with you surrendering,...");
                whackAMole.printGrid();
                keepPlaying = false;
            }
            else if ((x>9 || x<-1) || (y>9 || y<-1)){
                System.out.println("Out of boundaries try again");
            }
            else {
                whackAMole.whack(x,y);
                whackAMole.printGridToUser();
                System.out.println("You have: " + whackAMole.attemptsLeft + "attempts");
                System.out.println("Moles left: " + whackAMole.molesLeft);
            }
            if(whackAMole.attemptsLeft == 0){
                System.out.println("You do not have more attempts");
                keepPlaying = false;
            }

            if(whackAMole.molesLeft == 0){
                System.out.println("You have won the game congratulations!!!!");
                keepPlaying = false;
            }
        }

    }
}
