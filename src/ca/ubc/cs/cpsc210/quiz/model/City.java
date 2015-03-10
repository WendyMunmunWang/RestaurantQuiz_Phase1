package ca.ubc.cs.cpsc210.quiz.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a name having a name, province/state code and country code
 */
public class City implements GeoArea {
    private String cityName;
    private String province;
    private String countryCode;

    public City(String cityName, String province, String countryCode) throws java.lang.IllegalArgumentException {

        this.cityName = cityName;
        this.province = province;
        this.countryCode = countryCode;
        if (countryCode.length() != 2 || province.length() != 2)
            throw new IllegalArgumentException();
    }

    //Returns a string consisting of the form "city, province, country" (e.g. "Vancouver, BC, CA")
    public String getCityString() {
        return cityName+", "+province+", "+countryCode;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof GeoArea)) return false;//o can be city or neibourhood
        if (o instanceof Neighbourhood)
            return this.equals(((Neighbourhood) o).getCity());

        City city = (City) o;


        if (!cityName.equals(city.cityName)) return false;
        if (!countryCode.equals(city.countryCode)) return false;
        if (!province.equals(city.province)) return false;


        return true;
    }

    @Override
    public int hashCode() {
        int result = cityName.hashCode();
        result = 31 * result + province.hashCode();
        result = 31 * result + countryCode.hashCode();
        return result;
    }

    //Produces an array of strings that contains only the string produced by getCityString
    public List<String> getAllGeoStrings() {
        List<String> getCityStringString = new ArrayList<String>();
        List<City> cities = new ArrayList<City>();
        for (int i = 0; i <= cities.size(); i++) {
            getCityStringString.add(this.getCityString());

        }
        return getCityStringString;
    }
}
