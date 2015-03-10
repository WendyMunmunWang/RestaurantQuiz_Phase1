package ca.ubc.cs.cpsc210.quiz.model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class RestaurantTest  {



   @Test
    public void testEquals() throws Exception {
        City cityA = new City("Vancouver", "BC", "CA");
        City cityB = new City("Richmond", "GD", "CN");
        Neighbourhood neighbourhood = new Neighbourhood("Fancy Slopes East Bank", cityA);
        List<Category> categoriesA  = new ArrayList<Category>();
        List<Category> categoriesB = new ArrayList<Category>();
        Category category1 = new Category("western food", "wf");
        Category category2 = new Category("Chinese", "cn");
        Category category3 = new Category("Indian", "india");
        categoriesA.add(category1);
        categoriesA.add(category2);
        categoriesA.add(category3);
        categoriesB.add(category1);
        categoriesB.add(category2);
        Restaurant restaurantA = new Restaurant("McDonals", categoriesA, "P3HHH", "NO 1road", "V6X 3L4", cityA);
        Restaurant restaurantB = new Restaurant("McDonals", categoriesA, "P3HHH", "NO 1road", "V6X 3L4", cityB);
       Restaurant restaurantC = new Restaurant("McDonals", categoriesA, "P3HHH", "NO 1road", "V6X 3L4", cityA);
       Restaurant restaurantD = new Restaurant("ABC", categoriesA, "P3HHH", "NO 1road", "V6X 3L4", cityA);
       Restaurant restaurantE = new Restaurant("McDonals", categoriesB, "P3HHH", "NO 1road", "V6X 3L4", cityA);
        assertFalse(restaurantA.equals(restaurantB));
        assertTrue(restaurantA.equals(restaurantC));
        assertFalse(restaurantA.equals(restaurantD));
       assertFalse(restaurantA.equals(restaurantE));


    }
    @Test
    public void testtoString() throws Exception {

        City cityA = new City("Vancouver", "BC", "CA");
        Neighbourhood neighbourhood = new Neighbourhood("Fancy Slopes Drive", cityA);
        List<Category> categoriesA  = new ArrayList<Category>();
         Category category1 = new Category("western food", "wf");
        Category category2 = new Category("Chinese", "cn");
        Category category3 = new Category("Indian", "india");
        categoriesA.add(category1);
        categoriesA.add(category2);
        categoriesA.add(category3);
        Restaurant restaurantA = new Restaurant("McDonals", categoriesA, "P3HHH", "NO 1road", "V6X 3L4", neighbourhood);
        System.out.println(restaurantA.toString());
        assertEquals(restaurantA.toString(), "McDonals, Fancy, Vancouver, BC, CA, V6X 3L4");
        Restaurant restaurantB = new Restaurant("McDonals", categoriesA, "P3HHH", "NO 1road", null, neighbourhood);
        assertEquals(restaurantB.toString(),"McDonals, Fancy, Vancouver, BC, CA" );



    }
}