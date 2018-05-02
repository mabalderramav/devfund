package org.minions.devfund.lourdes;

import org.junit.Test;

import static org.junit.Assert.*;

public class SquarelotronTest {


    @Test
    public void testUpsideDownFlipDimensionOne(){
        int size = 1;
        int ring = 1;
        Squarelotron squarelotron= new Squarelotron(size);
        int[]expected = new int[]{1};
        assertArrayEquals(squarelotron.upsideDownFlip(ring).squarelotron[0], expected);
    }
    @Test
    public void testUpsideDownFlipDimensionTwo(){
        int size = 2;
        int ring = 1;
        Squarelotron squarelotron= new Squarelotron(size);
        int[][] expected = {{3,4},{1,2}};
        assertArrayEquals(squarelotron.upsideDownFlip(ring).squarelotron, expected);
    }

    @Test
    public void testUpsideDownFlipDimensionThree(){
        int size = 3;
        int ring = 1;
        Squarelotron squarelotron= new Squarelotron(size);
        int[][] expected = {{7,8,9},{4,5,6},{1,2,3}};
        assertArrayEquals(squarelotron.upsideDownFlip(ring).squarelotron, expected);
    }

    @Test
    public void testUpsideDownFlipDimensionFour(){
        int size = 4;
        int ring = 1;
        Squarelotron squarelotron= new Squarelotron(size);
        int[][] expected = {{13,14,15,16},{9,6,7,12},{5,10,11,8},{1,2,3,4}};
        assertArrayEquals(squarelotron.upsideDownFlip(ring).squarelotron, expected);
    }
    @Test

    public void testUpsideDownFlipDimensionFourRingTwo(){
        int size = 4;
        int ring = 2;
        Squarelotron squarelotron= new Squarelotron(size);
        int[][] expected = {{1,2,3,4},{5,10,11,8},{9,6,7,12},{13,14,15,16}};
        assertArrayEquals(squarelotron.upsideDownFlip(ring).squarelotron, expected);
    }

    @Test
    public void testUpsideDownFlipDimensionFive(){
        int size = 5;
        int ring = 1;
        Squarelotron squarelotron= new Squarelotron(size);
        int[][] expected = {{21,22,23,24,25},{16,7,8,9,20},{11,12,13,14,15},{6,17,18,19,10},{1,2,3,4,5}};
        assertArrayEquals(squarelotron.upsideDownFlip(ring).squarelotron, expected);
    }

    @Test
    public void testUpsideDownFlipDimensionFiveRingTwo(){
        int size = 5;
        int ring = 2;
        Squarelotron squarelotron= new Squarelotron(size);
        int[][] expected = {{1,2,3,4,5},{6,17,18,19,10},{11,12,13,14,15},{16,7,8,9,20},{21,22,23,24,25}};
        assertArrayEquals(squarelotron.upsideDownFlip(ring).squarelotron, expected);
    }

    @Test
    public void testUpsideDownFlipDimensionFiveRingThree(){
        int size = 5;
        int ring = 3;
        Squarelotron squarelotron= new Squarelotron(size);
        int[][] expected = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        assertArrayEquals(squarelotron.upsideDownFlip(ring).squarelotron, expected);
    }

    @Test
    public void mainDiagonalFlipDimensionOne() {
        int size = 1;
        int ring = 1;
        Squarelotron squarelotron = new Squarelotron(size);
        int[] expected = new int[]{1};
        assertArrayEquals(squarelotron.mainDiagonalFlip(ring).squarelotron[0],expected);
    }

    @Test
    public void mainDiagonalFlipDimensionTwo() {
        int size = 2;
        int ring = 1;
        Squarelotron squarelotron= new Squarelotron(size);
        int[][] expected = {{1,3},{2,4}};
        assertArrayEquals(squarelotron.mainDiagonalFlip(ring).squarelotron,expected);
    }
    @Test
    public void mainDiagonalFlipDimensionThree() {
        int size = 3;
        int ring = 1;
        Squarelotron squarelotron = new Squarelotron(size);
        int[][] expected = {{1,4,7},{2,5,8},{3,6,9}};
        assertArrayEquals(squarelotron.mainDiagonalFlip(ring).squarelotron,expected);
    }

    @Test
    public void mainDiagonalFlipDimensionFour() {
        int size = 4;
        int ring = 1;
        Squarelotron squarelotron= new Squarelotron(size);
        int[][] expected = {{1,5,9,13},{2,6,7,14},{3,10,11,15},{4,8,12,16}};
        assertArrayEquals(squarelotron.mainDiagonalFlip(ring).squarelotron,expected);
    }

    @Test
    public void testMainDiagonalFlipDimensionFiveRingOne() {
        int size = 5;
        int ring = 1;
        Squarelotron squarelotron= new Squarelotron(size);
        int[][] expected = {{1,6,11,16,21},{2,7,8,9,22},{3,12,13,14,23},{4,17,18,19,24},{5,10,15,20,25}};
        assertArrayEquals(squarelotron.mainDiagonalFlip(ring).squarelotron,expected);
    }

    @Test
    public void mainDiagonalFlipDimensionFiveRingTwo() {
        int size = 5;
        int ring = 2;
        Squarelotron squarelotron= new Squarelotron(size);
        int[][] expected = {{1,2,3,4,5},{6,7,12,17,10},{11,8,13,18,15},{16,9,14,19,20},{21,22,23,24,25}};
        assertArrayEquals(squarelotron.mainDiagonalFlip(ring).squarelotron,expected);
    }

    @Test
    public void mainDiagonalFlipDimensionFiveRingThree() {
        int size = 5;
        int ring = 3;
        Squarelotron squarelotron= new Squarelotron(size);
        int[][] expected = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        assertArrayEquals(squarelotron.mainDiagonalFlip(ring).squarelotron,expected);
    }
}