package org.minions.devfund.lourdes.battleship;

import java.util.Arrays;

public class Ocean {
    private Ship[][] ship;
    private int shotsFired;
    private int hitCount;
    private int shipsSunk;

    public Ocean() {
        this.ship = new Ship[20][20];
        this.shotsFired= 0;
        this.hitCount = 0;
        this.shipsSunk = 0;
        for (Ship[] row : ship) {
            Arrays.fill(row, new EmptySea());
        }
    }
    public boolean isOccupied(int row, int column){
        return ship[row][column].getShipType().equals("empty");
    }

    public Ship[][] getShip() {
        return ship;
    }

}
