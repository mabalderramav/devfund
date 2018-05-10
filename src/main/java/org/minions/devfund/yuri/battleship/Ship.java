package org.minions.devfund.yuri.battleship;

/**
 * This class represent to ship.
 */
public abstract class Ship {
    private int bowRow;
    private int bowColumn;
    private int length;
    private boolean horizontal;
    private boolean[] hit;
    /**
     * Constructor method.
     */
    public Ship() {
        //default constructor.
    }

    /**
     * Gets the ShipType.
     * @return ship type.
     */
    public abstract String getShipType();

    /**
     * Verifies that is possible to place a ship over an specific position.
     * @param row row value.
     * @param column column value.
     * @param horizontal horizontal value.
     * @param ocean the ocean.
     * @return <code>true, if is possible to place it.</code>
     * <code>false, if it is not.</code>
     */
    public boolean okToPlaceShipAt(final int row, final int column, final boolean horizontal, final Ocean ocean) {
        return true;
    }

    /**
     * Puts a ship in the ocean.
     * @param row row position.
     * @param column column position.
     * @param horizontal horizontal.
     * @param ocean the ocean.
     */
    public void placeShipAt(final int row, final int column, final boolean horizontal, final Ocean ocean) {
    }

    /**
     * Verifies that a ship has been sunk.
     * @param row row position.
     * @param column column position.
     * @return <code>true, if the ship has been hunk.</code>
     * <code>false, if it is not.</code>
     */
    public boolean shootAt(final int row, final int column) {
     return true;
    }

    /**
     * Verifies that a ship has been hit.
     * @return <code>true, if the ship has been hit.</code>
     * <code>false, if it is not.</code>
     */
    public boolean isSunk() {
        return true;
    }
}
