package org.minions.devfund.marylin;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SquarelotronTest {

    /**********************************************************
     **********************upsideDownFlip**********************
     *********************************************************/
//    @Test
//    public void test_UpsideDownFlip_TwoByTwoGrid_FirstRing() {
//        Squarelotron initialSquarelotron = new Squarelotron(2); //{{1, 2}, {3, 4}}
//        System.out.println("========INITIAL=========");
//        initialSquarelotron.printSquarelotron();
//        int[][] expectedGrid = {{3, 4}, {1, 2}};
//        Squarelotron expectedSquarelotron = new Squarelotron(expectedGrid);
//        System.out.println("-------EXPECTED---------");
//        expectedSquarelotron.printSquarelotron();
//        Squarelotron actualSquarelotron = initialSquarelotron.upsideDownFlip(1);
//        System.out.println("*******ACTUAL**********");
//        actualSquarelotron.printSquarelotron();
//        assertTrue("Grid is not the expected.", expectedSquarelotron.equals(actualSquarelotron));
//    }
//
//    @Test
//    public void test_UpsideDownFlip_ThreeByThreeGrid_FirstRing() {
//        System.out.println("========INITIAL=========");
//        Squarelotron initialSquarelotron = new Squarelotron(3); //{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}
//        initialSquarelotron.printSquarelotron();
//        int[][] expectedGrid = {{7, 8, 9}, {4, 5, 6}, {1, 2, 3}};
//        Squarelotron expectedSquarelotron = new Squarelotron(expectedGrid);
//        System.out.println("-------EXPECTED---------");
//        expectedSquarelotron.printSquarelotron();
//        Squarelotron actualSquarelotron = initialSquarelotron.upsideDownFlip(1);
//        System.out.println("*******ACTUAL**********");
//        actualSquarelotron.printSquarelotron();
//        assertTrue("Grid is not the expected.", expectedSquarelotron.equals(actualSquarelotron));
//    }
//
//    @Test
//    public void test_UpsideDownFlip_ThreeByThreeGrid_SecondRing() {
//        System.out.println("========INITIAL=========");
//        Squarelotron initialSquarelotron = new Squarelotron(3); //{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}
//        initialSquarelotron.printSquarelotron();
//        int[][] expectedGrid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        Squarelotron expectedSquarelotron = new Squarelotron(expectedGrid);
//        System.out.println("-------EXPECTED---------");
//        expectedSquarelotron.printSquarelotron();
//        Squarelotron actualSquarelotron = initialSquarelotron.upsideDownFlip(2);
//        System.out.println("*******ACTUAL**********");
//        actualSquarelotron.printSquarelotron();
//        assertTrue("Grid is not the expected.", expectedSquarelotron.equals(actualSquarelotron));
//    }
//
//    @Test
//    public void test_UpsideDownFlip_FourByFourGrid_FirstRing() {
//        Squarelotron initialSquarelotron = new Squarelotron(4); //{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}}
//        System.out.println("========INITIAL=========");
//        initialSquarelotron.printSquarelotron();
//        int[][] expectedGrid = {{13, 14, 15, 16}, {9, 6, 7, 12}, {5, 10, 11, 8}, {1, 2, 3, 4}};
//        Squarelotron expectedSquarelotron = new Squarelotron(expectedGrid);
//        System.out.println("-------EXPECTED---------");
//        expectedSquarelotron.printSquarelotron();
//        Squarelotron actualSquarelotron = initialSquarelotron.upsideDownFlip(1);
//        System.out.println("*******ACTUAL**********");
//        actualSquarelotron.printSquarelotron();
//        assertTrue("Grid is not the expected.", expectedSquarelotron.equals(actualSquarelotron));
//    }
//
//
//    @Test
//    public void test_UpsideDownFlip_FourByFourGrid_SecondRing() {
//        Squarelotron initialSquarelotron = new Squarelotron(4); //{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}}
//        System.out.println("========INITIAL=========");
//        initialSquarelotron.printSquarelotron();
//        int[][] expectedGrid = {{1, 2, 3, 4}, {5, 10, 11, 8}, {9, 6, 7, 12}, {13, 14, 15, 16}};
//        Squarelotron expectedSquarelotron = new Squarelotron(expectedGrid);
//        System.out.println("-------EXPECTED---------");
//        expectedSquarelotron.printSquarelotron();
//        Squarelotron actualSquarelotron = initialSquarelotron.upsideDownFlip(2);
//        System.out.println("*******ACTUAL**********");
//        actualSquarelotron.printSquarelotron();
//        assertTrue("Grid is not the expected.", expectedSquarelotron.equals(actualSquarelotron));
//    }
//
//    @Test
//    public void test_UpsideDownFlip_FiveByFiveGrid_FirstRing() {
//        Squarelotron initialSquarelotron = new Squarelotron(5); //{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}}
//        System.out.println("========INITIAL=========");
//        initialSquarelotron.printSquarelotron();
//        int[][] expectedGrid = {{21, 22, 23, 24, 25}, {16, 7, 8, 9, 20}, {11, 12, 13, 14, 15}, {6, 17, 18, 19, 10}, {1, 2, 3, 4, 5}};
//        Squarelotron expectedSquarelotron = new Squarelotron(expectedGrid);
//        System.out.println("-------EXPECTED---------");
//        expectedSquarelotron.printSquarelotron();
//        Squarelotron actualSquarelotron = initialSquarelotron.upsideDownFlip(1);
//        System.out.println("*******ACTUAL**********");
//        actualSquarelotron.printSquarelotron();
//        assertTrue("Grid is not the expected.", expectedSquarelotron.equals(actualSquarelotron));
//    }
//
//    @Test
//    public void test_UpsideDownFlip_FiveByFiveGrid_SecondRing() {
//        Squarelotron initialSquarelotron = new Squarelotron(5); //{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}}
//        System.out.println("========INITIAL=========");
//        initialSquarelotron.printSquarelotron();
//        int[][] expectedGrid = {{1, 2, 3, 4, 5}, {6, 17, 18, 19, 10}, {11, 12, 13, 14, 15}, {16, 7, 8, 9, 20}, {21, 22, 23, 24, 25}};
//        Squarelotron expectedSquarelotron = new Squarelotron(expectedGrid);
//        System.out.println("-------EXPECTED---------");
//        expectedSquarelotron.printSquarelotron();
//        Squarelotron actualSquarelotron = initialSquarelotron.upsideDownFlip(2);
//        System.out.println("*******ACTUAL**********");
//        actualSquarelotron.printSquarelotron();
//        assertTrue("Grid is not the expected.", expectedSquarelotron.equals(actualSquarelotron));
//
//    }
//
//    @Test
//    public void test_UpsideDownFlip_FiveByFiveGrid_ThirdRing() {
//        Squarelotron initialSquarelotron = new Squarelotron(5); //{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}}
//        System.out.println("========INITIAL=========");
//        initialSquarelotron.printSquarelotron();
//        int[][] expectedGrid = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
//        Squarelotron expectedSquarelotron = new Squarelotron(expectedGrid);
//        System.out.println("-------EXPECTED---------");
//        expectedSquarelotron.printSquarelotron();
//        Squarelotron actualSquarelotron = initialSquarelotron.upsideDownFlip(3);
//        System.out.println("*******ACTUAL**********");
//        actualSquarelotron.printSquarelotron();
//        assertTrue("Grid is not the expected.", expectedSquarelotron.equals(actualSquarelotron));
//    }
//
//    /**********************************************************
//     *********************mainDiagonalFlip*********************
//     *********************************************************/
//    @Test
//    public void test_MainDiagonalFlip_TwoByTwoGrid_FirstRing() {
//        Squarelotron initialSquarelotron = new Squarelotron(2); //{{1, 2}, {3, 4}}
//        System.out.println("========INITIAL=========");
//        initialSquarelotron.printSquarelotron();
//        int[][] expectedGrid = {{1, 3}, {2, 4}};
//        Squarelotron expectedSquarelotron = new Squarelotron(expectedGrid);
//        System.out.println("-------EXPECTED---------");
//        expectedSquarelotron.printSquarelotron();
//        Squarelotron actualSquarelotron = initialSquarelotron.mainDiagonalFlip(1);
//        System.out.println("*******ACTUAL**********");
//        actualSquarelotron.printSquarelotron();
//        assertTrue("Grid is not the expected.", expectedSquarelotron.equals(actualSquarelotron));
//    }
//
//    @Test
//    public void test_MainDiagonalFlip_ThreeByThreeGrid_FirstRing() {
//        System.out.println("========INITIAL=========");
//        Squarelotron initialSquarelotron = new Squarelotron(3); //{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}
//        initialSquarelotron.printSquarelotron();
//        int[][] expectedGrid = {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
//        Squarelotron expectedSquarelotron = new Squarelotron(expectedGrid);
//        System.out.println("-------EXPECTED---------");
//        expectedSquarelotron.printSquarelotron();
//        Squarelotron actualSquarelotron = initialSquarelotron.mainDiagonalFlip(1);
//        System.out.println("*******ACTUAL**********");
//        actualSquarelotron.printSquarelotron();
//        assertTrue("Grid is not the expected.", expectedSquarelotron.equals(actualSquarelotron));
//    }
//
//    @Test
//    public void test_MainDiagonalFlip_ThreeByThreeGrid_SecondRing() {
//        System.out.println("========INITIAL=========");
//        Squarelotron initialSquarelotron = new Squarelotron(3); //{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}
//        initialSquarelotron.printSquarelotron();
//        int[][] expectedGrid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        Squarelotron expectedSquarelotron = new Squarelotron(expectedGrid);
//        System.out.println("-------EXPECTED---------");
//        expectedSquarelotron.printSquarelotron();
//        Squarelotron actualSquarelotron = initialSquarelotron.mainDiagonalFlip(2);
//        System.out.println("*******ACTUAL**********");
//        actualSquarelotron.printSquarelotron();
//        assertTrue("Grid is not the expected.", expectedSquarelotron.equals(actualSquarelotron));
//    }
//
//    @Test
//    public void test_MainDiagonalFlip_FourByFourGrid_FirstRing() {
//        Squarelotron initialSquarelotron = new Squarelotron(4); //{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}}
//        System.out.println("========INITIAL=========");
//        initialSquarelotron.printSquarelotron();
//        int[][] expectedGrid = {{1, 5, 9, 13}, {2, 6, 7, 14}, {3, 10, 11, 15}, {4, 8, 12, 16}};
//        Squarelotron expectedSquarelotron = new Squarelotron(expectedGrid);
//        System.out.println("-------EXPECTED---------");
//        expectedSquarelotron.printSquarelotron();
//        Squarelotron actualSquarelotron = initialSquarelotron.mainDiagonalFlip(1);
//        System.out.println("*******ACTUAL**********");
//        actualSquarelotron.printSquarelotron();
//        assertTrue("Grid is not the expected.", expectedSquarelotron.equals(actualSquarelotron));
//    }
//
//
//    @Test
//    public void test_MainDiagonalFlip_FourByFourGrid_SecondRing() {
//        Squarelotron initialSquarelotron = new Squarelotron(4); //{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}}
//        System.out.println("========INITIAL=========");
//        initialSquarelotron.printSquarelotron();
//        int[][] expectedGrid = {{1, 2, 3, 4}, {5, 6, 10, 8}, {9, 7, 11, 12}, {13, 14, 15, 16}};
//        Squarelotron expectedSquarelotron = new Squarelotron(expectedGrid);
//        System.out.println("-------EXPECTED---------");
//        expectedSquarelotron.printSquarelotron();
//        Squarelotron actualSquarelotron = initialSquarelotron.mainDiagonalFlip(2);
//        System.out.println("*******ACTUAL**********");
//        actualSquarelotron.printSquarelotron();
//        assertTrue("Grid is not the expected.", expectedSquarelotron.equals(actualSquarelotron));
//    }
//
//    @Test
//    public void test_MainDiagonalFlip_FiveByFiveGrid_FirstRing() {
//        Squarelotron initialSquarelotron = new Squarelotron(5); //{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}}
//        System.out.println("========INITIAL=========");
//        initialSquarelotron.printSquarelotron();
//        int[][] expectedGrid = {{1, 6, 11, 16, 21}, {2, 7, 8, 9, 22}, {3, 12, 13, 14, 23}, {4, 17, 18, 19, 24}, {5, 10, 15, 20, 25}};
//        Squarelotron expectedSquarelotron = new Squarelotron(expectedGrid);
//        System.out.println("-------EXPECTED---------");
//        expectedSquarelotron.printSquarelotron();
//        Squarelotron actualSquarelotron = initialSquarelotron.mainDiagonalFlip(1);
//        System.out.println("*******ACTUAL**********");
//        actualSquarelotron.printSquarelotron();
//        assertTrue("Grid is not the expected.", expectedSquarelotron.equals(actualSquarelotron));
//    }
//
//    @Test
//    public void test_MainDiagonalFlip_FiveByFiveGrid_SecondRing() {
//        Squarelotron initialSquarelotron = new Squarelotron(5); //{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}}
//        System.out.println("========INITIAL=========");
//        initialSquarelotron.printSquarelotron();
//        int[][] expectedGrid = {{1, 2, 3, 4, 5}, {6, 7, 12, 17, 10}, {11, 8, 13, 18, 15}, {16, 9, 14, 19, 20}, {21, 22, 23, 24, 25}};
//        Squarelotron expectedSquarelotron = new Squarelotron(expectedGrid);
//        System.out.println("-------EXPECTED---------");
//        expectedSquarelotron.printSquarelotron();
//        Squarelotron actualSquarelotron = initialSquarelotron.mainDiagonalFlip(2);
//        System.out.println("*******ACTUAL**********");
//        actualSquarelotron.printSquarelotron();
//        assertTrue("Grid is not the expected.", expectedSquarelotron.equals(actualSquarelotron));
//
//    }
//
//    @Test
//    public void test_MainDiagonalFlip_FiveByFiveGrid_ThirdRing() {
//        Squarelotron initialSquarelotron = new Squarelotron(5); //{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}}
//        System.out.println("========INITIAL=========");
//        initialSquarelotron.printSquarelotron();
//        int[][] expectedGrid = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
//        Squarelotron expectedSquarelotron = new Squarelotron(expectedGrid);
//        System.out.println("-------EXPECTED---------");
//        expectedSquarelotron.printSquarelotron();
//        Squarelotron actualSquarelotron = initialSquarelotron.mainDiagonalFlip(3);
//        System.out.println("*******ACTUAL**********");
//        actualSquarelotron.printSquarelotron();
//        assertTrue("Grid is not the expected.", expectedSquarelotron.equals(actualSquarelotron));
//    }

    /**********************************************************
     ************************rotateRight***********************
     *********************************************************/
    @Test
    public void test_RotateRight_TwoByTwoGrid_FirstRotate() {
        Squarelotron initialSquarelotron = new Squarelotron(2); //{{1, 2}, {3, 4}}
        System.out.println("========INITIAL=========");
        initialSquarelotron.printSquarelotron();
        //int[][] expectedGrid = {{3, 4}, {1, 2}};
        int[][] expectedGrid = {{3, 1}, {4, 2}};
        Squarelotron expectedSquarelotron = new Squarelotron(expectedGrid);
        System.out.println("-------EXPECTED---------");
        expectedSquarelotron.printSquarelotron();
        Squarelotron actualSquarelotron = initialSquarelotron.rotateRight(1);
        System.out.println("*******ACTUAL**********");
        actualSquarelotron.printSquarelotron();
        assertTrue("Grid is not the expected.", expectedSquarelotron.equals(actualSquarelotron));
    }

    @Test
    public void test_RotateRight_TwoByTwoGrid_SecondRotate() {
        Squarelotron initialSquarelotron = new Squarelotron(2); //{{1, 2}, {3, 4}}
        System.out.println("========INITIAL=========");
        initialSquarelotron.printSquarelotron();
        int[][] expectedGrid = {{4, 3}, {2, 1}};
        Squarelotron expectedSquarelotron = new Squarelotron(expectedGrid);
        System.out.println("-------EXPECTED---------");
        expectedSquarelotron.printSquarelotron();
        Squarelotron actualSquarelotron = initialSquarelotron.rotateRight(2);
        System.out.println("*******ACTUAL**********");
        actualSquarelotron.printSquarelotron();
        assertTrue("Grid is not the expected.", expectedSquarelotron.equals(actualSquarelotron));
    }

    @Test
    public void test_RotateRight_ThreeByThreeGrid_FirstRotate() {
        Squarelotron initialSquarelotron = new Squarelotron(3); //{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}
        System.out.println("========INITIAL=========");
        initialSquarelotron.printSquarelotron();
//        int[][] expectedGrid = {{7, 8, 9}, {4, 5, 6}, {1, 2, 3}};
        int[][] expectedGrid = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
        Squarelotron expectedSquarelotron = new Squarelotron(expectedGrid);
        System.out.println("-------EXPECTED---------");
        expectedSquarelotron.printSquarelotron();
        Squarelotron actualSquarelotron = initialSquarelotron.rotateRight(1);
        System.out.println("*******ACTUAL**********");
        actualSquarelotron.printSquarelotron();
        assertTrue("Grid is not the expected.", expectedSquarelotron.equals(actualSquarelotron));
    }

    @Test
    public void test_RotateRight_FourByFourGrid_FirstRotate() {
        Squarelotron initialSquarelotron = new Squarelotron(4); //{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}}
        System.out.println("========INITIAL=========");
        initialSquarelotron.printSquarelotron();
        int[][] expectedGrid = {{13, 9, 5, 1}, {14, 10, 6, 2}, {15, 11, 7, 3}, {16, 12, 8, 4}};
        Squarelotron expectedSquarelotron = new Squarelotron(expectedGrid);
        System.out.println("-------EXPECTED---------");
        expectedSquarelotron.printSquarelotron();
        Squarelotron actualSquarelotron = initialSquarelotron.rotateRight(1);
        System.out.println("*******ACTUAL**********");
        actualSquarelotron.printSquarelotron();
        assertTrue("Grid is not the expected.", expectedSquarelotron.equals(actualSquarelotron));
    }

    @Test
    public void test_RotateRight_FiveByFiveGrid_FirstRotate() {
        Squarelotron initialSquarelotron = new Squarelotron(5); //{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}}
        System.out.println("========INITIAL=========");
        initialSquarelotron.printSquarelotron();
//        int[][] expectedGrid = {{21, 22, 23, 24, 25}, {16, 17, 18, 19, 20}, {11, 12, 13, 14, 15}, {6, 7, 8, 9, 10}, {1, 2, 3, 4, 5}};
        int[][] expectedGrid = {{21, 16, 11, 6, 1}, {22, 17, 12, 7, 2}, {23, 18, 13, 8, 3}, {24, 19, 14, 9, 4}, {25, 20, 15, 10, 5}};
        Squarelotron expectedSquarelotron = new Squarelotron(expectedGrid);
        System.out.println("-------EXPECTED---------");
        expectedSquarelotron.printSquarelotron();
        Squarelotron actualSquarelotron = initialSquarelotron.rotateRight(1);
        System.out.println("*******ACTUAL**********");
        actualSquarelotron.printSquarelotron();
        assertTrue("Grid is not the expected.", expectedSquarelotron.equals(actualSquarelotron));
    }
}