package ca.ubc.cs.cpsc210.quiz.yelp.tests;


import ca.ubc.cs.cpsc210.quiz.model.*;
import ca.ubc.cs.cpsc210.quiz.yelp.YelpDataParser;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class YelpDataParserTest {
    private static final String FILEPATH = "./testdata/yelp-restaurants-multiple.json";
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
        assertEquals(10, restaurants.size());
    }

    @Test
    public void testFirstRestaurantAddress() {
        Restaurant r = restaurants.get(0);

        assertEquals("1509 W 12th Avenue", r.getAddress());
    }

    @Test
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

}
