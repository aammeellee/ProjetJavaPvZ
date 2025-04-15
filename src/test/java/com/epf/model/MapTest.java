package com.epf.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MapTest {

    @Test
    public void testConstructeurCompletEtGetters() {
        Map map = new Map(1, 5, 9, "images/map/gazon.png");

        assertEquals(1, map.getIdMap());
        assertEquals(5, map.getLigne());
        assertEquals(9, map.getColonne());
        assertEquals("images/map/gazon.png", map.getCheminImage());
    }

    @Test
    public void testSetters() {
        Map map = new Map();
        map.setIdMap(2);
        map.setLigne(6);
        map.setColonne(8);
        map.setCheminImage("images/map/autre.png");

        assertEquals(2, map.getIdMap());
        assertEquals(6, map.getLigne());
        assertEquals(8, map.getColonne());
        assertEquals("images/map/autre.png", map.getCheminImage());
    }

    @Test
    public void testToString() {
        Map map = new Map(3, 4, 7, "images/map/test.png");
        String attendu = "Map{idMap=3, ligne=4, colonne=7, cheminImage='images/map/test.png'}";
        assertEquals(attendu, map.toString());
    }
}
