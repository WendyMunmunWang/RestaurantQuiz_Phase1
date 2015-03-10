package ca.ubc.cs.cpsc210.quiz.google;

import ca.ubc.cs.cpsc210.quiz.model.LatLng;
import ca.ubc.cs.cpsc210.quiz.model.Leg;
import ca.ubc.cs.cpsc210.quiz.model.Route;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


/**
 * Parser for response from Google Directions API.
 */
public class GoogleDirectionsParser {


    public GoogleDirectionsParser(){

    }
    //produce a Route object that contains a Leg object for each leg found in the JSON response.
    // Each Leg object must contain a LatLng point for each point in each step of the leg.
    public static Route parseRoute(java.lang.String response) throws org.json.JSONException {
        JSONObject route = new JSONObject(response);
        Route routeReturn = new Route();
        JSONArray legs;
        legs = route.getJSONArray("routes").getJSONObject(0).getJSONArray("legs");
        List<LatLng> latLngs = new ArrayList<LatLng>();
        int distance;
        String eachPolylineString;
        PolylineDecoder polylineDecoder = new PolylineDecoder();

        for (int j = 0; j<legs.length(); j++){
            Leg newLeg = new Leg();
            distance = legs.getJSONObject(j).getJSONObject("distance").getInt("value");
            newLeg.setDistance(distance);
            for (int i = 0; i<legs.getJSONObject(j).getJSONArray("steps").length(); i++){

          eachPolylineString =  legs.getJSONObject(j).getJSONArray("steps").getJSONObject(i).getJSONObject("polyline").getString("points");
          latLngs = polylineDecoder.decodePoly(eachPolylineString);

         // distance = legs.getJSONObject(j).getJSONArray("steps").getJSONObject(i).getJSONObject("distance").getInt("value");
         // newLeg.setDistance(distance);
          newLeg.addAllPoints(latLngs);}

            routeReturn.addLeg(newLeg);

        }



        //add a new leg with distance and list of points to the route every loop
        return routeReturn;}
 }