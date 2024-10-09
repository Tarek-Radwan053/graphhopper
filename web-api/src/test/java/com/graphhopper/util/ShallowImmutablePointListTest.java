package com.graphhopper.util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ShallowImmutablePointListTest {

    /**
     * Test de la méthode getLat avec un index valide.
     *
     * ARRANGE : Crée une PointList avec un point et la wrappe dans ShallowImmutablePointList.
     * ACT : Appelle getLat(0) pour récupérer la latitude du premier point.
     * ASSERT (ORACLE) : Vérifie que la latitude retournée correspond à la valeur attendue.
     */
    @Test
    void testGetLat() {
        // Arrange
        PointList pointList = new PointList(10, true); // PointList avec support 3D activé
        pointList.add(1.0, 2.0, 3.0); // Latitude, Longitude, Élévation

        ShallowImmutablePointList shallowList = new ShallowImmutablePointList(0, 1, pointList);

        // Act
        double lat = shallowList.getLat(0);

        // Assert (Oracle)
        assertEquals(1.0, lat, "La latitude devrait correspondre à la valeur dans la liste enveloppée.");
    }

    /**
     * Test de la méthode getLon avec un index valide.
     *
     * ARRANGE : Crée une PointList avec un point et la wrappe dans ShallowImmutablePointList.
     * ACT : Appelle getLon(0) pour récupérer la longitude du premier point.
     * ASSERT (ORACLE) : Vérifie que la longitude retournée correspond à la valeur attendue.
     */
    @Test
    void testGetLon() {
        // Arrange
        PointList pointList = new PointList(10, true); // PointList avec support 3D activé
        pointList.add(1.0, 2.0, 3.0);

        ShallowImmutablePointList shallowList = new ShallowImmutablePointList(0, 1, pointList);

        // Act
        double lon = shallowList.getLon(0);

        // Assert (Oracle)
        assertEquals(2.0, lon, "La longitude devrait correspondre à la valeur dans la liste enveloppée.");
    }

    /**
     * Test de la méthode getEle avec un index valide.
     *
     * ARRANGE : Crée une PointList avec un point et la wrappe dans ShallowImmutablePointList.
     * ACT : Appelle getEle(0) pour récupérer l'élévation du premier point.
     * ASSERT (ORACLE) : Vérifie que l'élévation retournée correspond à la valeur attendue.
     */
    @Test
    void testGetEle() {
        // Arrange
        PointList pointList = new PointList(10, true); // PointList avec support 3D activé
        pointList.add(1.0, 2.0, 3.0);

        ShallowImmutablePointList shallowList = new ShallowImmutablePointList(0, 1, pointList);

        // Act
        double ele = shallowList.getEle(0);

        // Assert (Oracle)
        assertEquals(3.0, ele, "L'élévation devrait correspondre à la valeur dans la liste enveloppée.");
    }

    /**
     * Test de la méthode setElevation avec un index valide.
     *
     * ARRANGE : Crée une PointList avec un point et la wrappe dans ShallowImmutablePointList.
     * ACT : Appelle setElevation(0, 4.0) pour mettre à jour l'élévation du premier point.
     * ASSERT (ORACLE) : Vérifie que l'élévation a été mise à jour avec la nouvelle valeur.
     */
    @Test
    void testSetElevation() {
        // Arrange
        PointList pointList = new PointList(10, true); // PointList avec support 3D activé
        pointList.add(1.0, 2.0, 3.0);

        ShallowImmutablePointList shallowList = new ShallowImmutablePointList(0, 1, pointList);

        // Act
        shallowList.setElevation(0, 4.0);

        // Assert (Oracle)
        assertEquals(4.0, shallowList.getEle(0), "L'élévation devrait être mise à jour avec la nouvelle valeur.");
    }

    /**
     * Test de la méthode makeImmutable pour s'assurer qu'elle rend la PointList immuable.
     *
     * ARRANGE : Crée une PointList avec un point et la wrappe dans ShallowImmutablePointList.
     * ACT : Appelle makeImmutable() pour marquer la PointList comme immuable.
     * ASSERT (ORACLE) : Vérifie que la PointList est maintenant immuable en utilisant isImmutable().
     */
    @Test
    void testMakeImmutable() {
        // Arrange
        PointList pointList = new PointList(10, true); // PointList avec support 3D activé
        pointList.add(1.0, 2.0, 3.0);

        ShallowImmutablePointList shallowList = new ShallowImmutablePointList(0, 1, pointList);

        // Act
        shallowList.makeImmutable();

        // Assert (Oracle)
        assertTrue(shallowList.isImmutable(), "La PointList enveloppée devrait être immuable après l'appel de makeImmutable.");
    }

    /**
     * Test de la méthode isImmutable pour vérifier si elle reflète correctement le statut d'immutabilité de la liste enveloppée.
     *
     * ARRANGE : Crée une PointList avec un point et la wrappe dans ShallowImmutablePointList.
     * ACT : Appelle makeImmutable() et vérifie le statut d'immutabilité avec isImmutable().
     * ASSERT (ORACLE) : Confirme que isImmutable() retourne true après l'appel de makeImmutable().
     */
    @Test
    void testIsImmutable() {
        // Arrange
        PointList pointList = new PointList(10, true); // PointList avec support 3D activé
        pointList.add(1.0, 2.0, 3.0);

        ShallowImmutablePointList shallowList = new ShallowImmutablePointList(0, 1, pointList);

        // Act - s'assure de l'immutabilité
        shallowList.makeImmutable();

        // Assert (Oracle)
        assertTrue(shallowList.isImmutable(), "La PointList enveloppée devrait être immuable après l'appel de makeImmutable.");
    }
}
