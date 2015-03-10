package ca.ubc.cs.cpsc210.quiz.yelp;

import ca.ubc.cs.cpsc210.quiz.model.Category;
import ca.ubc.cs.cpsc210.quiz.model.City;
import ca.ubc.cs.cpsc210.quiz.model.Neighbourhood;
import ca.ubc.cs.cpsc210.quiz.model.Restaurant;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Parser for JSON data returned by Yelp.
 */

public class YelpDataParser {
    public YelpDataParser(){

    }
    //Parses a JSONObject received in response to a Yelp search for restaurants,
    // filtered by city name and produces corresponding list of restaurants that are not closed.
    // If the yelpCityFilter is null, "Vancouver" is used as the city filter.
    public static List<Restaurant> parseRestaurantData(String response, String yelpCityFilter)
            throws JSONException {
        JSONObject yelpSearch = new JSONObject(response);
        JSONArray targetContent;
        targetContent = yelpSearch.getJSONArray("businesses");
        String postalCode = new String();
        String cityName = new String();
        String stateName = new String();
        String countryName = new String();
        String restaurantID = new String();
        String restaurantName = new String();
        String address = new String();
        JSONArray neighbourhoods;
        String neibourhoodName = new String();
        Restaurant restaurant;
        List<Restaurant> restaurants = new ArrayList<Restaurant>();
        List<Category> categories = new ArrayList<Category>();

        // for each i, we get an object, which we turn into a restaurant.
        // write a function that turns an object into a restaurant
        for (int i = 0; i< targetContent.length();i++) {
            JSONObject obj = targetContent.getJSONObject(i);
            JSONObject objLocation = obj.getJSONObject("location");
            cityName = objLocation.getString("city");
            if (yelpCityFilter.equals(cityName)) {



                postalCode = objLocation.optString("postal_code");
                if (postalCode==null || postalCode.equals(""))
                    postalCode = null;

                //city or neibourhood
                stateName = objLocation.getString("state_code");
                countryName = objLocation.getString("country_code");
                City city = new City(cityName, stateName, countryName);
               /* neighbourhoods = objLocation.getJSONArray("neighborhoods");
                neibourhoodName = neighbourhoods.get(0).toString();
                Neighbourhood neighbourhood = new Neighbourhood(neibourhoodName, city);
*/


                //address
                address = objLocation.getJSONArray("address").getString(0);
                // no matter whether how many elements in the jsonarray, we are still using the first one
                //restaurantID
                restaurantID = obj.getString("id");
                //restaurantName
                restaurantName = obj.getString("name");


                //closed or not
                if (obj.getBoolean("is_closed")!=false) {
                    continue;
                } else {
                   categories = new ArrayList<Category>(); // you have []
                    for (int j = 0; j < obj.getJSONArray("categories").length(); j++) {
                        String categoryName = obj.getJSONArray("categories").getJSONArray(j).getString(0);
                        String categoryAlias = obj.getJSONArray("categories").getJSONArray(j).getString(1);
                        Category category = new Category(categoryName, categoryAlias);
                        categories.add(category);//categoryName and categoryAlias are automatically added to category;
                    }

                    // no neighbourhood (this block of line causing problem!!!)
                    Neighbourhood neighbourhood = null;
                     if (objLocation.has("neighborhoods")) {
                         neighbourhoods = objLocation.getJSONArray("neighborhoods");
                         neibourhoodName = neighbourhoods.get(0).toString();
                         neighbourhood = new Neighbourhood(neibourhoodName, city);

                        restaurant = new Restaurant(restaurantName, categories, restaurantID, address, postalCode, neighbourhood);
                    }
                    else {
                        restaurant = new Restaurant(restaurantName, categories, restaurantID, address, postalCode, city);
                    }

                }
                restaurants.add(restaurant);
            }
            else if (yelpCityFilter==null)
                restaurants = null;


        }
 return restaurants;




    }}




