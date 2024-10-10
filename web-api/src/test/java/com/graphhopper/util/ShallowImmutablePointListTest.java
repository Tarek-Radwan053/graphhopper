package com.graphhopper.util;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ShallowImmutablePointListTest {

    /**
     * Test des méthodes getLat, getLon et getEle avec des index valides et invalides.
     * Utilisation de Java Faker pour générer des coordonnées aléatoires.
     *
     * ARRANGE : Crée une PointList avec deux points aléatoires et la wrappe dans ShallowImmutablePointList.
     * ACT : Appelle getLat, getLon, et getEle pour récupérer les coordonnées et l'élévation des points.
     * ASSERT (ORACLE) : Vérifie que les valeurs retournées correspondent aux valeurs attendues et
     * qu'une exception est lancée pour les index invalides.
     */
    @Test
    void testGetCoordinatesAndElevation() {
        // Arrange
        Faker faker = new Faker();
        double lat1 = Double.parseDouble(faker.address().latitude()); // Random latitude
        double lon1 = Double.parseDouble(faker.address().longitude()); // Random longitude
        double ele1 = faker.number().randomDouble(1, 0, 100); // Random elevation between 0 and 100

        double lat2 = Double.parseDouble(faker.address().latitude());
        double lon2 = Double.parseDouble(faker.address().longitude());
        double ele2 = faker.number().randomDouble(1, 0, 100);

        PointList pointList = new PointList(10, true); // PointList avec support 3D activé
        pointList.add(lat1, lon1, ele1); // Premier point : Lat, Lon, Ele
        pointList.add(lat2, lon2, ele2); // Deuxième point : Lat, Lon, Ele

        ShallowImmutablePointList shallowList = new ShallowImmutablePointList(0, 2, pointList);

        // Act and Assert (valeurs valides)
        assertEquals(lat1, shallowList.getLat(0), "La latitude du premier point devrait correspondre.");
        assertEquals(lon1, shallowList.getLon(0), "La longitude du premier point devrait correspondre.");
        assertEquals(ele1, shallowList.getEle(0), "L'élévation du premier point devrait correspondre.");

        assertEquals(lat2, shallowList.getLat(1), "La latitude du deuxième point devrait correspondre.");
        assertEquals(lon2, shallowList.getLon(1), "La longitude du deuxième point devrait correspondre.");
        assertEquals(ele2, shallowList.getEle(1), "L'élévation du deuxième point devrait correspondre.");

        // Act and Assert (index invalides)
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> shallowList.getLat(2),
                "Une exception devrait être lancée pour un index de latitude invalide.");
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> shallowList.getLon(2),
                "Une exception devrait être lancée pour un index de longitude invalide.");
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> shallowList.getEle(2),
                "Une exception devrait être lancée pour un index d'élévation invalide.");

        // Additional check with negative index
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> shallowList.getLat(-1),
                "Une exception devrait être lancée pour un index de latitude négatif.");
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> shallowList.getLon(-1),
                "Une exception devrait être lancée pour un index de longitude négatif.");
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> shallowList.getEle(-1),
                "Une exception devrait être lancée pour un index d'élévation négatif.");
    }

    /**
     * Test de la méthode setElevation avec des index valides et invalides.
     *
     * ARRANGE : Crée une PointList avec un point et la wrappe dans ShallowImmutablePointList.
     * ACT : Appelle setElevation(0, 4.0) pour mettre à jour l'élévation du premier point.
     * ASSERT (ORACLE) : Vérifie que l'élévation a été mise à jour avec la nouvelle valeur et vérifie également
     * les index invalides.
     */
    @Test
    void testSetElevation() {
        // Arrange
        PointList pointList = new PointList(10, true); // PointList avec support 3D activé
        pointList.add(1.0, 2.0, 3.0);

        ShallowImmutablePointList shallowList = new ShallowImmutablePointList(0, 1, pointList);

        // Act
        shallowList.setElevation(0, 4.0);

        // Assert (Oracle pour valeur valide)
        assertEquals(4.0, shallowList.getEle(0), "L'élévation devrait être mise à jour à 4.0.");

        // Additional assertions for invalid indexes
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> shallowList.setElevation(1, 5.0),
                "Une exception devrait être lancée pour un index de modification invalide.");
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> shallowList.setElevation(-1, 5.0),
                "Une exception devrait être lancée pour un index de modification négatif.");
    }

    /**
     * Test de la méthode makeImmutable pour s'assurer qu'elle rend la PointList immuable.
     *
     * ARRANGE : Crée une PointList avec un point et la wrappe dans ShallowImmutablePointList.
     * ACT : Appelle makeImmutable() pour marquer la PointList comme immuable.
     * ASSERT (ORACLE) : Vérifie que la PointList est maintenant immuable en utilisant isImmutable()
     * et vérifie que les méthodes de modification lancent des exceptions.
     */
    @Test
    void testMakeImmutable() {
        // Arrange
        PointList pointList = new PointList(10, true); // PointList avec support 3D activé
        pointList.add(1.0, 2.0, 3.0);

        ShallowImmutablePointList shallowList = new ShallowImmutablePointList(0, 1, pointList);

        // Act
        shallowList.makeImmutable();

        // Assert immutability
        assertTrue(shallowList.isImmutable(), "La PointList devrait être immuable après l'appel de makeImmutable.");

        // Additional immutability checks
        assertThrows(UnsupportedOperationException.class, () -> shallowList.add(1.0, 2.0, 3.0),
                "Une exception devrait être lancée lors de l'ajout d'un point à une liste immuable.");
        assertThrows(UnsupportedOperationException.class, () -> shallowList.removeLastPoint(),
                "Une exception devrait être lancée lors de la suppression d'un point dans une liste immuable.");
        assertThrows(UnsupportedOperationException.class, () -> shallowList.clear(),
                "Une exception devrait être lancée lors de l'appel de clear sur une liste immuable.");
    }

    /**
     * Test de la méthode getIntervalString pour vérifier la représentation de l'intervalle.
     *
     * ARRANGE : Crée une PointList avec plusieurs points et la wrappe dans ShallowImmutablePointList.
     * ACT : Appelle getIntervalString pour obtenir la représentation de l'intervalle.
     * ASSERT (ORACLE) : Vérifie que le format et les valeurs de la chaîne retournée sont corrects,
     * et teste des intervalles différents.
     */
    @Test
    void testGetIntervalString() {
        // Arrange
        PointList pointList = new PointList(10, true);
        pointList.add(1.0, 2.0, 3.0);
        pointList.add(4.0, 5.0, 6.0);
        pointList.add(7.0, 8.0, 9.0);

        ShallowImmutablePointList shallowList1 = new ShallowImmutablePointList(0, 2, pointList);
        ShallowImmutablePointList shallowList2 = new ShallowImmutablePointList(1, 3, pointList);

        // Act and Assert
        assertEquals("[0, 2[", shallowList1.getIntervalString(), "La chaîne de l'intervalle devrait être '[0, 2['.");
        assertEquals("[1, 3[", shallowList2.getIntervalString(), "La chaîne de l'intervalle devrait être '[1, 3['.");

        // Test edge case with empty interval
        ShallowImmutablePointList shallowListEmpty = new ShallowImmutablePointList(2, 2, pointList);
        assertEquals("[2, 2[", shallowListEmpty.getIntervalString(), "La chaîne de l'intervalle vide devrait être '[2, 2['.");
    }
}
