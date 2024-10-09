package com.graphhopper.util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ShallowImmutablePointListTest {

    /**
     * Test getLat with a valid index.
     */
    @Test
    void testGetLat() {
        // Arrange
        PointList pointList = new PointList(10, true);
        pointList.add(1.0, 2.0, 3.0); // Latitude, Longitude, Elevation

        ShallowImmutablePointList shallowList = new ShallowImmutablePointList(0, 1, pointList);

        // Act
        double lat = shallowList.getLat(0);

        // Assert (Oracle)
        assertEquals(1.0, lat, "The latitude should match the value in the wrapped list.");
    }

    /**
     * Test getLon with a valid index.
     */
    @Test
    void testGetLon() {
        // Arrange
        PointList pointList = new PointList(10, true);
        pointList.add(1.0, 2.0, 3.0);

        ShallowImmutablePointList shallowList = new ShallowImmutablePointList(0, 1, pointList);

        // Act
        double lon = shallowList.getLon(0);

        // Assert (Oracle)
        assertEquals(2.0, lon, "The longitude should match the value in the wrapped list.");
    }

    /**
     * Test getEle with a valid index.
     */
    @Test
    void testGetEle() {
        // Arrange
        PointList pointList = new PointList(10, true);
        pointList.add(1.0, 2.0, 3.0);

        ShallowImmutablePointList shallowList = new ShallowImmutablePointList(0, 1, pointList);

        // Act
        double ele = shallowList.getEle(0);

        // Assert (Oracle)
        assertEquals(3.0, ele, "The elevation should match the value in the wrapped list.");
    }

    /**
     * Test setElevation with a valid index.
     */
    @Test
    void testSetElevation() {
        // Arrange
        PointList pointList = new PointList(10, true);
        pointList.add(1.0, 2.0, 3.0);

        ShallowImmutablePointList shallowList = new ShallowImmutablePointList(0, 1, pointList);

        // Act
        shallowList.setElevation(0, 4.0);

        // Assert (Oracle)
        assertEquals(4.0, shallowList.getEle(0), "The elevation should be updated to the new value.");
    }

    /**
     * Test makeImmutable to ensure it calls the wrapped PointList's makeImmutable method.
     */
    @Test
    void testMakeImmutable() {
        // Arrange
        PointList pointList = new PointList(10, true);
        pointList.add(1.0, 2.0, 3.0);

        ShallowImmutablePointList shallowList = new ShallowImmutablePointList(0, 1, pointList);

        // Act
        shallowList.makeImmutable();

        // Assert (Oracle)
        assertTrue(shallowList.isImmutable(), "The wrapped PointList should be immutable after calling makeImmutable.");
    }

    /**
     * Test isImmutable to verify if it correctly reflects the immutability status of the wrapped list.
     */
    @Test
    void testIsImmutable() {
        // Arrange
        PointList pointList = new PointList(10, true);
        pointList.add(1.0, 2.0, 3.0);

        ShallowImmutablePointList shallowList = new ShallowImmutablePointList(0, 1, pointList);

        // Act - ensure immutability
        shallowList.makeImmutable();

        // Assert (Oracle)
        assertTrue(shallowList.isImmutable(), "The wrapped PointList should be immutable after calling makeImmutable.");
    }
}
