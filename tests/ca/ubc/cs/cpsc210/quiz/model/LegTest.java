package ca.ubc.cs.cpsc210.quiz.model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class LegTest {
    private Leg leg;
    private double lat;
    private double lng;

    @Before
    public void setUp() throws Exception {
        lat = 0;
        lng = 0;
        leg = new Leg();

    }

    @Test
    public void testAddPoint() throws Exception {
        LatLng myLatLng = new LatLng(lat, lng);
        lat = 30;
        lng = 30;
        leg.addPoint(myLatLng);
        assertEquals(leg.getPoints().get(0), myLatLng);

    }

    @Test
    public void testAddAllPoints() throws Exception {
        Leg newLeg = new Leg();
        LatLng myLatLng1 = new LatLng(lat, lng);
        lat = 30;
        lng = 30;
        newLeg.addPoint(myLatLng1);
        LatLng myLatLng2 = new LatLng(lat, lng);
        lat = 20;
        lng = 24;
        newLeg.addPoint(myLatLng2);
        LatLng myLatLng3 = new LatLng(lat, lng);
        lat = 30;
        lng = 40;
        newLeg.addPoint(myLatLng3);
        leg.addAllPoints(newLeg.getPoints());

        List<LatLng> testLatLng = new ArrayList<LatLng>();
        testLatLng.add(myLatLng1);
        testLatLng.add(myLatLng2);
        testLatLng.add(myLatLng3);

        assertEquals(testLatLng.get(0), newLeg.getPoints().get(0));


    }

    @Test
    public void testGetPoints() throws Exception {
        Leg newLeg = new Leg();
        LatLng myLatLng1 = new LatLng(lat, lng);
        lat = 30;
        lng = 30;
        newLeg.addPoint(myLatLng1);
        LatLng myLatLng2 = new LatLng(lat, lng);
        lat = 20;
        lng = 24;
        newLeg.addPoint(myLatLng2);
        LatLng myLatLng3 = new LatLng(lat, lng);
        lat = 30;
        lng = 40;
        newLeg.addPoint(myLatLng3);

        List<LatLng> testLatLng = new ArrayList<LatLng>();
        testLatLng.add(myLatLng1);
        testLatLng.add(myLatLng2);
        testLatLng.add(myLatLng3);
        assertEquals(newLeg.getPoints(), testLatLng);



    }


}