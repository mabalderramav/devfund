package org.minions.devfund.alejandro;

public class WhackAMole {

    public int score, molesLeft, attemptsLeft;
    private char [][] moleGrid;
    private char hiddenMole = 'm';
    private char mole = 'M';
    private char nothing = '*';
    private char mode;

    public WhackAMole(int numAttempts, int gridDimension){
        /*
          Constructor for the game, specifies total number of whacks allowed,
          and the grid dimension. After reading through the assignment,
          make sure to initialize the moleGrid with the appropriate character.
         */
        this.moleGrid = new char[gridDimension][gridDimension];
        this.molesLeft = 10;
        this.attemptsLeft = numAttempts;
        this.score = 0;
        fillMatrix(gridDimension);
    }

    private void fillMatrix(int size) {
        /*
          This method will fill the grid with random placed moles.
         */
        fillGrid();
        fillMoles(size);
    }

    private void fillMoles(int size) {
        /*
          This method fill the grid with hidden moles.
         */
        for (int i = 0; i < size; i++) {
            boolean p = false;
            while (!p) {
                int randomX = (int) (Math.random() * size + 0);
                int randomY = (int) (Math.random() * size + 0);
                if (place(randomX, randomY)) {
                    this.moleGrid[randomX][randomY] = hiddenMole;
                    p = true;
                }
            }
        }
    }

    private void fillGrid() {
        /*
          This method fill the grid with *.
         */
        for (int i = 0; i < moleGrid.length; i++) {
            for (int y = 0; y < moleGrid.length; y++) {
                moleGrid[i][y] = nothing;
            }
        }
    }


    private boolean place(int x, int y) {
        /*
          Given a location, place a hiddenMole at that location.
          Return true if you can. (Also update number of moles left.)
         */
        return this.moleGrid[x][y] != hiddenMole;
    }

    public void whack(int x, int y) {
        /*
          Given a location, take a whack at that location.
          If that location contains a hiddenMole, the score,
          number of attemptsLeft, and molesLeft is updated.
          If that location does not contain a hiddenMole, only attemptsLeft is updated.
         */
        char whack = 'W';
        if(!place(x,y)){
            this.moleGrid[x][y] = mole;
            this.score++;
            this.attemptsLeft--;
            this.molesLeft--;

        }
        else {
            this.moleGrid[x][y] = whack;
            this.attemptsLeft--;
        }
    }

    private void grid(char mode) {
        /**
         * This method draw the grid whether is for keep playing or finalize the game.
         */
        for (char[] aMoleGrid : moleGrid) {
            for (int y = 0; y < moleGrid.length; y++) {
                if (mode == 'u' && (aMoleGrid[y] == hiddenMole)){
                    System.out.print(" " + nothing + " ");
                }
                else {
                    if(aMoleGrid[y]==hiddenMole) {
                        aMoleGrid[y] = mole;
                    }
                    System.out.print(" " + aMoleGrid[y] + " ");
                }
            }
            System.out.println();
        }
    }

    public void printGridToUser() {
        /**
         * Print the grid without showing where the moles are.
         * For every spot that has recorded a “whacked hiddenMole,” print out a W, or * otherwise.
         */
        this.mode = 'u';
        grid(mode);
    }

    public void printGrid() {
        /**
         * Print the grid completely. This is effectively dumping the 2d array on the screen.
         * The places where the moles are should be printed as an ‘M’.
         * The places where the moles have been whacked should be printed as a ‘W’.
         * The places that don’t have a hiddenMole should be printed as *.
         */
        this.mode = 'i';
        grid(mode);
    }
}
