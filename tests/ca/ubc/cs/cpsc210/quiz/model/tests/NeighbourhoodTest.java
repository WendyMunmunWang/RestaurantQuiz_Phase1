package ca.ubc.cs.cpsc210.quiz.model.tests;


import ca.ubc.cs.cpsc210.quiz.model.City;
import ca.ubc.cs.cpsc210.quiz.model.Neighbourhood;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;


public class NeighbourhoodTest {

    @Test
    public void testGetCityString() {
        City city = new City("Vancouver", "BC", "CA");
        Neighbourhood nbhd = new Neighbourhood("Fancy Slopes East", city);

        assertEquals("Vancouver, BC, CA", nbhd.getCityString());
    }

    @Test
    public void testGetAllGeoStrings() {
        City city = new City("Vancouver", "BC", "CA");
        Neighbourhood nbhd = new Neighbourhood("Fancy Slopes East Bank", city);

        List<String> geoStrings = nbhd.getAllGeoStrings();
        assertEquals(4, geoStrings.size());

        assertEquals("Fancy, Vancouver, BC, CA", geoStrings.get(0));
        assertEquals("Fancy Slopes, Vancouver, BC, CA", geoStrings.get(1));
        assertEquals("Fancy Slopes East, Vancouver, BC, CA", geoStrings.get(2));
        assertEquals("Fancy Slopes East Bank, Vancouver, BC, CA", geoStrings.get(3));
    }

    @Test
    public void testEquals(){
        City cityA = new City("Vancouver", "BC", "CA");
        Neighbourhood nbhdA = new Neighbourhood("Fancy Slopes East Bank", cityA);
        City cityB = new City("Vancouver", "BC", "CA");
        Neighbourhood nbhdB = new Neighbourhood("Fancy Slopes East Bank", cityB);
        assertTrue(nbhdA.equals(nbhdB));
        City cityC = new City("Richmond", "BC", "CA");

        Neighbourhood nbhdC = new Neighbourhood("Fancy Slopes East Bank", cityC);
        Neighbourhood nbhdD = new Neighbourhood("Richmond", cityC);
        assertTrue(nbhdC.equals(nbhdD));
        assertFalse(nbhdA.equals(nbhdC));




    }
}
