package ca.ubc.cs.cpsc210.quiz.model;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;


/**
 * Represents a neighbourhood having a name in a city
 */
public class Neighbourhood implements GeoArea {
    private String neighborhoodName = new String();

    private City city;

    public Neighbourhood(String neighbourhoodName, City city) {
        this.city = city;
        this.neighborhoodName = neighbourhoodName;
    }

    /**
     * Two neighbourhoods are equal if they have the same city and same name
     * When o is a City, this neighbourhood is equal to it, if it has the same city.
     */

    public City getCity() {
        return city;

    }

    //Gets the city string for this neighbourhood's city
    public String getCityString() {
        return city.getCityString();

    }

    @Override
    public List<String> getAllGeoStrings() {
        List<String> nameSeperator = new ArrayList<String>();
        List<String> cuttednameSeperator = new ArrayList<String>();
        List<String> allGeoStrings = new ArrayList<String>();
        String nameSeperatorString = new String();
        String newString = new String();
        String resultString = new String();


        if (this.neighborhoodName != null){
            nameSeperator = Arrays.asList(neighborhoodName.split(" "));//split the string into arraylist



            for (int i = 0; i < nameSeperator.size(); i++) {
                if (i == 0){
                newString = newString + nameSeperator.get(i);
                resultString = newString + ", "+ this.getCityString();}
                else {newString = newString + " " + nameSeperator.get(i);
                resultString = newString + ", "+ this.getCityString();}//combine the string and getCityString together
            allGeoStrings.add(resultString);}}
        if (this.neighborhoodName == null){
           resultString = this.getCityString();
            allGeoStrings.add(resultString);

        }
        return allGeoStrings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        // will have to revisit this if we add subtypes of GeoArea other than City and Neighborhood
        if (o == null || !(o instanceof GeoArea)) return false;

        // when o is a City, this Neighborhood is equal to o if the cities are equal
        if (o instanceof City)
            return city.equals(o);

        // must be a Neighborhood
        Neighbourhood other = (Neighbourhood) o;

        return (city.equals(other.city));
    }

    @Override
    public int hashCode() {
        return city != null ? city.hashCode() : 0;
    }
}















