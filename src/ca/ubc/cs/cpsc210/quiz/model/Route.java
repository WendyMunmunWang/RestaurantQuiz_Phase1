package ca.ubc.cs.cpsc210.quiz.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a route having a list of legs and a distance.
 */
public class Route {
    private int distance;
    private List<Leg> legList;
    public Route(){
        this.distance = 0;
        legList = new ArrayList<Leg>();

    }
    //Add a leg to this route
    public void addLeg(Leg leg){

        legList.add(leg);

    }
    //Get points on this route
    public java.util.List<Leg> getLegs(){
        return legList;

    }
    //Get total distance for this route (the sum of the distances for the legs
    //effects: returns total distance
    public int getDistance(){
       for (int i = 0; i<legList.size(); i++)
           distance = distance +legList.get(i).getDistance();
      return distance;
    }

}
