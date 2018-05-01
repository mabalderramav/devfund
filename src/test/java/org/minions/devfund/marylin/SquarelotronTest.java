package org.minions.devfund.marylin;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SquarelotronTest {

//    @Test
//    public void upsideDownFlip() {
//    }
//
//    @Test
//    public void mainDiagonalFlip() {
//    }
//
//    @Test
//    public void rotateRight() {
//    }

    @Test
    public void testTwoByTwoGridFirstRing() {
        Squarelotron initialSquarelotron = new Squarelotron(2); //{{1, 2}, {3, 4}}
        System.out.println("========INITIAL=========");
        initialSquarelotron.printSquarelotron();
        int[][] expectedGrid = {{3, 4}, {1, 2}};
        Squarelotron expectedSquarelotron = new Squarelotron(expectedGrid);
        System.out.println("-------EXPECTED---------");
        expectedSquarelotron.printSquarelotron();
        Squarelotron actualSquarelotron = initialSquarelotron.upsideDownFlip(1);
        System.out.println("*******ACTUAL**********");
        actualSquarelotron.printSquarelotron();
        assertTrue("Grid is not the expected.", expectedSquarelotron.equals(actualSquarelotron));
    }

    @Test
    public void testThreeByThreeGridFirstRing() {
        System.out.println("========INITIAL=========");
        Squarelotron initialSquarelotron = new Squarelotron(3); //{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}
        initialSquarelotron.printSquarelotron();
        int[][] expectedGrid = {{7, 8, 9}, {4, 5, 6}, {1, 2, 3}};
        Squarelotron expectedSquarelotron = new Squarelotron(expectedGrid);
        System.out.println("-------EXPECTED---------");
        expectedSquarelotron.printSquarelotron();
        Squarelotron actualSquarelotron = initialSquarelotron.upsideDownFlip(1);
        System.out.println("*******ACTUAL**********");
        actualSquarelotron.printSquarelotron();
        assertTrue("Grid is not the expected.", expectedSquarelotron.equals(actualSquarelotron));
    }

    @Test
    public void testThreeByThreeGridSecondRing() {
        System.out.println("========INITIAL=========");
        Squarelotron initialSquarelotron = new Squarelotron(3); //{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}
        initialSquarelotron.printSquarelotron();
        int[][] expectedGrid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Squarelotron expectedSquarelotron = new Squarelotron(expectedGrid);
        System.out.println("-------EXPECTED---------");
        expectedSquarelotron.printSquarelotron();
        Squarelotron actualSquarelotron = initialSquarelotron.upsideDownFlip(2);
        System.out.println("*******ACTUAL**********");
        actualSquarelotron.printSquarelotron();
        assertTrue("Grid is not the expected.", expectedSquarelotron.equals(actualSquarelotron));
    }

    @Test
    public void testFourByFourGridFirstRing() {
        Squarelotron initialSquarelotron = new Squarelotron(4); //{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}}
        initialSquarelotron.printSquarelotron();
        //int[][] expectedGrid = {{13, 14, 15, 16}, {9, 10, 11, 12}, {5, 6, 7, 8}, {1, 2, 3, 4}};
        int[][] expectedGrid = {{13, 14, 15, 16}, {9, 6, 7, 12}, {5, 10, 11, 8}, {1, 2, 3, 4}};
        Squarelotron expectedSquarelotron = new Squarelotron(expectedGrid);
        System.out.println("----------------");
        expectedSquarelotron.printSquarelotron();
        Squarelotron actualSquarelotron = initialSquarelotron.upsideDownFlip(1);
        System.out.println("*****************");
        actualSquarelotron.printSquarelotron();
        assertTrue("Grid is not the expected.", expectedSquarelotron.equals(actualSquarelotron));
    }


    @Test
    public void testFourByFourGridSecondRing() {
        Squarelotron initialSquarelotron = new Squarelotron(4); //{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}}
        initialSquarelotron.printSquarelotron();
        //int[][] expectedGrid = {{13, 14, 15, 16}, {9, 10, 11, 12}, {5, 6, 7, 8}, {1, 2, 3, 4}};
        int[][] expectedGrid = {{1, 2, 3, 4}, {5, 10, 11, 8}, {9, 6, 7, 12}, {13, 14, 15, 16}};
        Squarelotron expectedSquarelotron = new Squarelotron(expectedGrid);
        System.out.println("----------------");
        expectedSquarelotron.printSquarelotron();
        Squarelotron actualSquarelotron = initialSquarelotron.upsideDownFlip(2);
        System.out.println("*****************");
        actualSquarelotron.printSquarelotron();
        assertTrue("Grid is not the expected.", expectedSquarelotron.equals(actualSquarelotron));
    }

    @Test
    public void testFiveByFiveGridFirstRing() {
        Squarelotron initialSquarelotron = new Squarelotron(5); //{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}}
        initialSquarelotron.printSquarelotron();
        int[][] expectedGrid = {{21, 22, 23, 24, 25}, {16, 7, 8, 9, 20}, {11, 12, 13, 14, 15}, {6, 17, 18, 19, 10}, {1, 2, 3, 4, 5}};
        Squarelotron expectedSquarelotron = new Squarelotron(expectedGrid);
        System.out.println("----------------");
        expectedSquarelotron.printSquarelotron();
        Squarelotron actualSquarelotron = initialSquarelotron.upsideDownFlip(1);
        System.out.println("*****************");
        actualSquarelotron.printSquarelotron();
        assertTrue("Grid is not the expected.", expectedSquarelotron.equals(actualSquarelotron));
    }

    @Test
    public void testFiveByFiveGridSecondRing() {
        Squarelotron initialSquarelotron = new Squarelotron(5); //{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}}
        initialSquarelotron.printSquarelotron();
        int[][] expectedGrid = {{1, 2, 3, 4, 5}, {6, 17, 18, 19, 10}, {11, 12, 13, 14, 15}, {16, 7, 8, 9, 20}, {21, 22, 23, 24, 25}};
        Squarelotron expectedSquarelotron = new Squarelotron(expectedGrid);
        System.out.println("----------------");
        expectedSquarelotron.printSquarelotron();
        Squarelotron actualSquarelotron = initialSquarelotron.upsideDownFlip(2);
        System.out.println("*****************");
        actualSquarelotron.printSquarelotron();
        assertTrue("Grid is not the expected.", expectedSquarelotron.equals(actualSquarelotron));

    }

    @Test
    public void testFiveByFiveGridThirdRing() {
        Squarelotron initialSquarelotron = new Squarelotron(5); //{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}}
        initialSquarelotron.printSquarelotron();
        int[][] expectedGrid = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        Squarelotron expectedSquarelotron = new Squarelotron(expectedGrid);
        System.out.println("----------------");
        expectedSquarelotron.printSquarelotron();
        Squarelotron actualSquarelotron = initialSquarelotron.upsideDownFlip(3);
        System.out.println("*****************");
        actualSquarelotron.printSquarelotron();
        assertTrue("Grid is not the expected.", expectedSquarelotron.equals(actualSquarelotron));
    }
}