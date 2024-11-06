Tarek Radwan(20231177) Liwaa Zebian
Dans ce projet, nous utilisons plusieurs flags JVM afin d’optimiser la performance, la qualité, et l'observabilité pendant l'exécution des tests. Chaque flag a été choisi pour son impact spécifique sur l'environnement de test.

1. -XX:+UseG1GC
Motivation : Ce flag active le garbage collector G1, qui est conçu pour offrir un compromis entre la latence et le throughput. G1 est particulièrement utile dans les applications qui gèrent de grandes quantités de mémoire et ont des exigences strictes en termes de latence. Son utilisation permet une gestion plus efficace de la mémoire pendant les tests, réduisant ainsi les pauses liées à la collecte des déchets.
2. -XX:+PrintGCDetails
Motivation : Ce flag active l'impression détaillée des informations de garbage collection dans les logs. Cela permet de suivre en temps réel l'activité du garbage collector et d'identifier d'éventuels problèmes de performance liés à la gestion de la mémoire. Il est essentiel pour l'observabilité, car il fournit des insights précieux sur le comportement de la JVM et les performances de la gestion mémoire pendant les tests.
3. -Xms512m -Xmx1024m
Motivation : Ces flags définissent les tailles minimales (-Xms) et maximales (-Xmx) de la mémoire heap de la JVM. En fixant une taille initiale de 512 Mo et une taille maximale de 1024 Mo, nous assurons que la JVM dispose d'une mémoire suffisante pour exécuter les tests tout en évitant des fuites mémoire potentielles. Ces valeurs permettent de garantir que les tests s'exécutent de manière stable sans nécessiter trop de ressources, ce qui est particulièrement utile pour les environnements CI/CD.
4. -XX:+OptimizeStringConcat
Motivation : Ce flag active l'optimisation des concaténations de chaînes de caractères, ce qui peut améliorer les performances lorsqu'il y a de nombreuses opérations de concatenation dans le code testé. Cela réduit le coût des appels String.concat() et optimise les ressources nécessaires pour ces opérations, ce qui peut réduire légèrement le temps d'exécution global des tests dans certains cas.
5. -XX:+ShowCodeDetailsInExceptionMessages
Motivation : Ce flag permet d’afficher des détails supplémentaires sur le code lors des exceptions. Lorsqu'une exception est lancée, la JVM fournit plus d'informations sur le contexte du code, ce qui facilite le débogage. Cette option est particulièrement utile pour les tests unitaires afin de mieux comprendre les erreurs et les exceptions.

Pourquoi la JVM n’a-t-elle jamais de mauvaise journée ? Parce qu’elle sait toujours comment gérer ses exceptions ! 😄
