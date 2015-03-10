package ca.ubc.cs.cpsc210.quiz.model.tests;


import ca.ubc.cs.cpsc210.quiz.model.City;
import ca.ubc.cs.cpsc210.quiz.model.Neighbourhood;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class CityTest {

    @Test
    public void testGetGeographicalString() {
        City city = new City("Vancouver", "BC", "CA");
        assertEquals("Vancouver, BC, CA", city.getCityString());
    }

    @Test
    public void testGetAllGeoStrings() {
        City city = new City("Vancouver", "BC", "CA");
        List<String> geoStrings = city.getAllGeoStrings();

        assertEquals(1, geoStrings.size());
        assertEquals("Vancouver, BC, CA", geoStrings.get(0));
    }

    @Test
    public void testEquals(){
        City cityA = new City("Vancouver", "BC", "CA");
        City cityB = new City("Richmond", "BC", "CA");
        City cityC = new City("Vancouver", "ON", "CA");
        City cityD = new City("Vancouver", "BC", "US");
        City cityE = new City("Vancouver", "BC", "CA");
        String neibourhoodName = new String();
        Neighbourhood neighbourhood = new Neighbourhood(neibourhoodName, cityA);
        assertTrue(cityA.equals(neighbourhood));
        assertFalse(cityB.equals(neighbourhood));
        assertTrue(cityA.equals(cityE));
        assertFalse(cityA.equals(cityB));
        assertFalse(cityA.equals(cityC));
        assertFalse(cityA.equals(cityD));

    }

}
