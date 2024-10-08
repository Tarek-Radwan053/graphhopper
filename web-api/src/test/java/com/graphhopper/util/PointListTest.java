package com.graphhopper.util;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PointListTest {

    private PointList pointList;
    private PointList emptyPointList;

    @BeforeEach
    public void setUp() {
        pointList = new PointList();
        emptyPointList = PointList.EMPTY;
    }



    @Test
    public void testAddPoint3D() {
        pointList = new PointList(10, true);
        pointList.add(10.0, 20.0, 30.0);
        assertEquals(1, pointList.size());
        assertEquals(10.0, pointList.getLat(0));
        assertEquals(20.0, pointList.getLon(0));
        assertEquals(30.0, pointList.getEle(0));
    }











    @Test
    public void testClone() {
        pointList.add(10.0, 20.0);
        PointList cloned = pointList.clone(false);
        assertEquals(pointList.size(), cloned.size());
        assertTrue(pointList.equals(cloned));
    }

    @Test
    public void testParse2DJSON() {
        String json = "[20.0,10.0], [25.0,15.0]";
        PointList parsedList = new PointList();
        parsedList.parse2DJSON(json);
        assertEquals(2, parsedList.size());
        assertEquals(20.0, parsedList.getLon(0));
        assertEquals(10.0, parsedList.getLat(0));
        assertEquals(25.0, parsedList.getLon(1));
        assertEquals(15.0, parsedList.getLat(1));
    }





    @Test
    public void testCloneWithReverse() {
        pointList.add(10.0, 20.0);
        pointList.add(30.0, 40.0);
        PointList clonedReversed = pointList.clone(true);
        assertEquals(30.0, clonedReversed.getLat(0));
        assertEquals(40.0, clonedReversed.getLon(0));
        assertEquals(10.0, clonedReversed.getLat(1));
        assertEquals(20.0, clonedReversed.getLon(1));
    }

}
