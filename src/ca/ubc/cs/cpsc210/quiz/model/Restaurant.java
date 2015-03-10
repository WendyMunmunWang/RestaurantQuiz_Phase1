package ca.ubc.cs.cpsc210.quiz.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * Represents a restaurant having a street address, geographical area, postal code, name, id categories
 * and list of reviews.
 */
public class Restaurant extends java.lang.Object {
    private GeoArea geoArea;
    private List<Category> categories;
    private String address;
    private String name;
    private String id;
    private String postalCode;
    public Restaurant(java.lang.String name, java.util.List<Category> categories,
               java.lang.String id, java.lang.String address,
               java.lang.String postalCode, GeoArea geographicalArea){
        this.name = name;
        this.categories = categories;
        this.id = id;
        this.address = address;
        this.postalCode = postalCode;
        this.geoArea = geographicalArea;

    }
    public String getAddress(){
        return address;
    }
    public String getName(){
        return name;
    }
    public List<Category> getCategories(){
        return categories;
    }
    public String getId(){
        return id;
    }
    public String getPostalCode(){
        return postalCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Restaurant)) return false;

        Restaurant that = (Restaurant) o;

        if (!address.equals(that.address)) return false;
        if (!categories.equals(that.categories)) return false;
        if (!geoArea.equals(that.geoArea)) return false;
        if (!id.equals(that.id)) return false;
        if (!name.equals(that.name)) return false;
        if (postalCode != null ? !postalCode.equals(that.postalCode) : that.postalCode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = geoArea.hashCode();
        result = 31 * result + categories.hashCode();
        result = 31 * result + address.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + id.hashCode();
        result = 31 * result + (postalCode != null ? postalCode.hashCode() : 0);
        return result;
    }

    public GeoArea getGeographicalArea(){
        return geoArea;

    }
    //Produces string representation of restaurant of form:
    // name + first string in geographical areas geostrings + postal code
    // (e.g., "Heirloom Vegetarian, Fairview, Vancouver, BC, CA, V6J 2E1")
    // Postal code omitted if it is null
    public String toString(){

//        String neibourhoodName = new String();
//        String cityName = new String();
//        String provinceName = new String();
//        String countryCode = new String();
//
//
//
//        City city = new City(cityName, provinceName,countryCode);
//        Neighbourhood neighbourhood = new Neighbourhood(neibourhoodName, city);
        if (this.getPostalCode()==null)//or postal code doesnt exist?
            return this.getName() + ", " + this.getGeographicalArea().getAllGeoStrings().get(0);

        else
            return this.getName() + ", "+ this.getGeographicalArea().getAllGeoStrings().get(0) + ", "+ this.getPostalCode();
    }



}