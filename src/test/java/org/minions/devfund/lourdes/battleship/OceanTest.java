package org.minions.devfund.lourdes.battleship;

import org.junit.Test;

import static org.junit.Assert.*;

public class OceanTest {

    @Test
    public void testOceanInitialization() {
        Ocean ocean= new Ocean();
        Ship[][] shipMatrix = ocean.getShip();
        for (Ship[] row: shipMatrix){
            for(Ship cellValue: row){
                assertEquals(cellValue.getShipType(), "empty");
            }
        }
    }

    @Test
    public void testIsOccupied(){
        Ocean ocean = new Ocean();
        Ship battleCruiser = new BattleCruiser();
        battleCruiser.placeShipAt(0,0, true, ocean);
        assertTrue(ocean.isOccupied(0,0));

    }

    @Test
    public void testIsNotOccupied(){
        Ocean ocean = new Ocean();
        Ship battleCruiser = new BattleCruiser();
        battleCruiser.placeShipAt(0,0, true, ocean);
        assertFalse(ocean.isOccupied(1,0));

    }

}