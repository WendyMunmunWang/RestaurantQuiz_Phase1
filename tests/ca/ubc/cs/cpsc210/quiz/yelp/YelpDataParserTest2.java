package ca.ubc.cs.cpsc210.quiz.yelp;

import ca.ubc.cs.cpsc210.quiz.model.*;
import org.json.JSONException;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class YelpDataParserTest2 {
    private static final String FILEPATH = "./testdata/yelp-restaurants-multiple2.json";
    private static StringBuilder jsonResponse;
    private static List<Restaurant> restaurants;

    @BeforeClass
    public static void runBefore() {
        try {
            BufferedReader in = new BufferedReader(new FileReader(FILEPATH));
            jsonResponse = new StringBuilder();
            String str;
            while ((str = in.readLine()) != null) {
                jsonResponse.append(str);
            }
            in.close();
            parseRestaurants();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void parseRestaurants() {
        try {
            restaurants = YelpDataParser.parseRestaurantData(jsonResponse.toString(), "Vancouver");
        } catch (JSONException e) {
            e.printStackTrace();
            fail("Basic parsing failed");
        }
    }

    @Test
    public void testNumRestaurants() {
        assertEquals(9, restaurants.size());
    } //change one of the city names to Toronto

    @Test
    public void testFirstRestaurantAddress() {
        Restaurant r = restaurants.get(0);

        assertEquals("1509 W 12th Avenue", r.getAddress());
    }

    @Test
    public void testFirstNullPostalCode() {
        Restaurant r = restaurants.get(0);

        assertEquals(null, r.getPostalCode());
    }

    @Test
    public void testLastNullPostalCode() {
        Restaurant r = restaurants.get(restaurants.size() - 1);
        assertEquals(null, r.getPostalCode());
    }

    @Test
    public void testSecondPostalCode() {
        Restaurant r = restaurants.get(1);

        assertEquals("V6H 1L1", r.getPostalCode());
    }

    @Test
    public void testFirstNullNeibourhoods() {
        Restaurant r = restaurants.get(0);
        City city = new City("Vancouver", "BC", "CA");
        assertEquals(city, r.getGeographicalArea());
    }

   /*@Test
    public void testFirstRestaurantcCategories() {
        Category category1 = new Category("Breakfast & Brunch", "breakfast_brunch");
        assertEquals(category1, restaurants.get(0).getCategories().get(0));
    }
    @Test
    public void testFirstRestaurantcCategoriesNum() {

        assertEquals(3, restaurants.get(0).getCategories().size());
    }

    @Test
    public void testLastRestaurantcCategories() {
        Category category2 = new Category("Malaysian", "malaysian");
        assertEquals(restaurants.get(restaurants.size() - 1).getCategories().get(0), category2);
    }
    @Test
    public void testLastRestaurantcCategoriesNum() {

        assertEquals(restaurants.get(restaurants.size() - 1).getCategories().size(), 2);
    }
    @Test
    public void testFirstRestaurantGetGeographicalArea() {
        String neibourhoodName = new String();
        String cityName = new String();
        String provinceName = new String();
        String stateName = new String();
        cityName = "Vancouver";
        provinceName = "BC";
        stateName =  "CA";
        neibourhoodName = "Fairview Slopes";
        City city = new City(cityName, provinceName, stateName);
        Neighbourhood neighbourhood = new Neighbourhood(neibourhoodName, city);
        GeoArea n2 = restaurants.get(0).getGeographicalArea();
        assertEquals(restaurants.get(0).getGeographicalArea(), neighbourhood);
    }
    @Test
    public void testLastRestaurantGetGeographicalArea() {
        String neibourhoodName = new String();
        String cityName = new String();
        String provinceName = new String();
        String stateName = new String();
        cityName = "Vancouver";
        provinceName = "BC";
        stateName =  "CA";
        neibourhoodName = "Riley Park";
        City city = new City(cityName, provinceName, stateName);
        Neighbourhood neighbourhood = new Neighbourhood(neibourhoodName, city);

        assertEquals(restaurants.get(restaurants.size() - 1).getGeographicalArea(), neighbourhood);
    }
*/
}