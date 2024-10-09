package com.graphhopper.util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ShallowImmutablePointListTest {

    @Test
    void testConstructorValidRange() {
        // Arrange
        PointList pointList = new PointList(10, true); // Enable 3D
        pointList.add(1.0, 2.0, 3.0); // Latitude, Longitude, Elevation
        pointList.add(4.0, 5.0, 6.0);

        // Act
        ShallowImmutablePointList shallowList = new ShallowImmutablePointList(0, 2, pointList);

        // Assert (Oracle)
        assertEquals(2, shallowList.size(), "The size should be 2 for the given range.");
    }

    @Test
    void testConstructorInvalidRange() {
        // Arrange
        PointList pointList = new PointList(10, true); // Enable 3D
        pointList.add(1.0, 2.0, 3.0);

        // Act and Assert (Oracle)
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new ShallowImmutablePointList(1, 0, pointList);
        });
        assertEquals("from must be smaller or equal to end", exception.getMessage(), "Should throw an exception for invalid range.");
    }

    @Test
    void testSize() {
        // Arrange
        PointList pointList = new PointList(10, true); // Enable 3D
        pointList.add(1.0, 2.0, 3.0);
        pointList.add(4.0, 5.0, 6.0);

        // Act
        ShallowImmutablePointList shallowList = new ShallowImmutablePointList(0, 2, pointList);

        // Assert (Oracle)
        assertEquals(2, shallowList.size(), "The size should be 2.");
    }

    @Test
    void testIsEmpty() {
        // Arrange
        PointList pointList = new PointList(10, true); // Enable 3D

        // Act
        ShallowImmutablePointList shallowList = new ShallowImmutablePointList(0, 0, pointList);

        // Assert (Oracle)
        assertTrue(shallowList.isEmpty(), "The list should be empty.");
    }

    @Test
    void testGetIntervalString() {
        // Arrange
        PointList pointList = new PointList(10, true); // Enable 3D
        pointList.add(1.0, 2.0, 3.0);
        pointList.add(4.0, 5.0, 6.0);

        // Act
        ShallowImmutablePointList shallowList = new ShallowImmutablePointList(0, 2, pointList);

        // Assert (Oracle)
        assertEquals("[0, 2[", shallowList.getIntervalString(), "Interval string should be '[0, 2['.");
    }

    @Test
    void testGetLatValidIndex() {
        // Arrange
        PointList pointList = new PointList(10, true); // Enable 3D
        pointList.add(1.0, 2.0, 3.0);

        // Act
        ShallowImmutablePointList shallowList = new ShallowImmutablePointList(0, 1, pointList);

        // Assert (Oracle)
        assertEquals(1.0, shallowList.getLat(0), "Latitude should be 1.0 for index 0.");
    }

    @Test
    void testGetLatInvalidIndex() {
        // Arrange
        PointList pointList = new PointList(10, true); // Enable 3D
        pointList.add(1.0, 2.0, 3.0);

        // Act and Assert (Oracle)
        ShallowImmutablePointList shallowList = new ShallowImmutablePointList(0, 1, pointList);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> shallowList.getLat(1), "Should throw exception for index out of range.");
    }

    // Additional tests for getLon and getEle with valid/invalid indices follow the same AAA structure.

}
