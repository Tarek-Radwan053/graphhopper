# Tâche 2: Tests Unitaires Automatiques

### Groupe
- **Liwaa Zebian - 20213839**
- **Tarek Radwan - 20231177**

### Lien vers le Référentiel GitHub
Vous pouvez accéder au repository de ce projet en suivant ce lien : [Github Repo](https://github.com/Tarek-Radwan053/graphhopper)

### Étude de Cas
Pour cette tâche, nous avons choisi de travailler sur le projet **GraphHopper Web API**, spécifiquement en testant les classes `ShallowImmutablePointList`, `Helper`, et `PointList`. Ces classes offrent des fonctionnalités essentielles comme la gestion de listes de points et le support pour des opérations avancées sur ces listes.

### Description des Tests

#### Classe `ShallowImmutablePointListTest`
1. **testGetCoordinatesAndElevation**  
   - *Description*: Ce test vérifie la récupération des valeurs de latitude, longitude, et élévation à partir d’indices valides, et s’assure que des exceptions sont lancées pour des indices invalides, y compris des indices négatifs.
   - *Objectif*: Garantir que `getLat`, `getLon`, et `getEle` renvoient les valeurs correctes et gèrent correctement les erreurs d'indice.
   - *Utilisation de Java Faker*: Ce test utilise Java Faker pour générer des coordonnées aléatoires, ajoutant ainsi de la variabilité aux données de test.

2. **testSetElevation**  
   - *Description*: Ce test vérifie la méthode `setElevation` pour la mise à jour de l'élévation d'un point. Il s’assure également que des exceptions sont levées pour des indices invalides.
   - *Objectif*: Confirmer que `setElevation` fonctionne correctement dans des conditions valides et gère les erreurs d'indice.

3. **testMakeImmutable**  
   - *Description*: Ce test vérifie que `makeImmutable` rend la liste immuable. Il tente ensuite de modifier la liste pour s’assurer qu’une `UnsupportedOperationException` est levée.
   - *Objectif*: Valider que `makeImmutable` empêche toute modification de la liste après son appel.

4. **testGetIntervalString**  
   - *Description*: Ce test vérifie la représentation de l'intervalle de la liste via `getIntervalString` pour différents intervalles, y compris un intervalle vide.
   - *Objectif*: S’assurer que `getIntervalString` retourne le format correct pour divers cas d’intervalle.

#### Classe `HelperTest`
1. **testParseList**  
   - *Description*: Ce test vérifie la capacité de `parseList` à analyser correctement les chaînes de caractères en listes de points.
   - *Objectif*: S’assurer que les chaînes d’entrée sont correctement converties en objets de liste.

2. **testSaveProperties**  
   - *Description*: Ce test valide la méthode `saveProperties` en s’assurant qu’elle enregistre les propriétés de la liste dans le format attendu.
   - *Objectif*: Garantir que les propriétés de la liste sont correctement sauvegardées et peuvent être récupérées.

3. **testIsToString_ValidInput**  
   - *Description*: Ce test vérifie la méthode `isToString` pour s'assurer qu'elle retourne une représentation correcte et lisible de l'objet.
   - *Objectif*: Confirmer que `isToString` produit une chaîne qui correspond au format attendu pour des données valides.

#### Classe `PointListTest`
1. **testAddPoint3D**  
   - *Description*: Ce test vérifie la méthode `add` pour ajouter un point en 3D à `PointList`, en s’assurant que les valeurs ajoutées sont récupérables.
   - *Objectif*: Valider que les points sont correctement ajoutés et que les données de latitude, longitude, et élévation sont accessibles.

2. **testParse2DJSON**  
   - *Description*: Ce test valide la méthode `parse2DJSON` pour analyser une chaîne JSON 2D et remplir la `PointList` en conséquence. Vérifie que la taille et les valeurs des points sont correctes.
   - *Objectif*: S’assurer que `parse2DJSON` interprète les données JSON correctement et ajoute les points à la liste.

3. **testClone**  
   - *Description*: Ce test vérifie la méthode `clone` en créant une copie de la `PointList`. Il vérifie que la liste clonée a les mêmes valeurs et peut être inversée si le paramètre est activé.
   - *Objectif*: Confirmer que `clone` génère une copie fidèle de la liste, avec une option pour inverser l’ordre des points.

### Taux de Couverture Final
Après l'ajout de ces tests, le taux de couverture global est de **42%** (était **37.53%**). La couverture a été mesurée à l'aide de l'outil JaCoCo pour garantir une évaluation précise.




