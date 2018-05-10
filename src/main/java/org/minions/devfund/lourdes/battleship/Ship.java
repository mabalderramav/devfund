package org.minions.devfund.lourdes.battleship;

public abstract class Ship {
    private int bowRow;
    private int bowColumn;
    private int lenght;
    private boolean horizontal;
    private boolean[] hit;

    abstract String getShipType();
//    public boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean){
//
//    }
    public boolean placeShipAt(int row, int column, boolean horizontal, Ocean ocean){

    }
    public int getBowRow() {
        return bowRow;
    }

    public void setBowRow(int bowRow) {
        this.bowRow = bowRow;
    }

    public int getBowColumn() {
        return bowColumn;
    }

    public void setBowColumn(int bowColumn) {
        this.bowColumn = bowColumn;
    }

    public int getLenght() {
        return lenght;
    }

    public void setLenght(int lenght) {
        this.lenght = lenght;
    }

    public boolean isHorizontal() {
        return horizontal;
    }

    public void setHorizontal(boolean horizontal) {
        this.horizontal = horizontal;
    }

    public boolean[] getHit() {
        return hit;
    }

    public void setHit(boolean[] hit) {
        this.hit = hit;
    }
}
