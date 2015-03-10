package ca.ubc.cs.cpsc210.quiz.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RouteTest {
    private Route route;
    private int distance;
    private Leg leg;
    private double lat;
    private double lng;

    @Before
    public void setUp() throws Exception {
        route = new Route();
        leg = new Leg();
        distance = 0;
        lat = 0;
        lng = 0;



    }

    @Test
    public void testAddleg() throws Exception {
        Leg leg1 = new Leg();
        leg1.setDistance(30);
        LatLng latLng1 = new LatLng(30, 30);
        LatLng latLng2 = new LatLng(20, 20);
        leg1.addPoint(latLng1);
        leg1.addPoint(latLng2);
        route.addLeg(leg1);

        Leg leg2 = new Leg();
        leg2.setDistance(40);
        LatLng latLng3 = new LatLng(50, 30);
        LatLng latLng4 = new LatLng(40, 20);
        leg2.addPoint(latLng3);
        leg2.addPoint(latLng4);
        route.addLeg(leg2);

        assertEquals(route.getLegs().get(0), leg1);



    }


}