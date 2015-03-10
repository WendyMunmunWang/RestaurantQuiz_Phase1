package ca.ubc.cs.cpsc210.quiz.model;

/**
 * Stand-in for com.google.android.gms.maps.model.LatLng
 * Represents a position specified with latitude/longitude coords
 */
public class LatLng {
    private double lat;
    private double lng;


    public LatLng(double lat,double lng){
        lat = this.lat;
        lng = this.lng;


 }

    public double getLat(){
        return lat;
    }

    public double getLng(){
        return lng;
    }

}
