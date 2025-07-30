Moteur De Matching De Nom (Name Matching Engine):

*Purpose and Scope:
        Le Moteur De Matching De Nom est un systeme developpe en Java concu pour trouver des
        correspondances entre noms a l'aide de differentes techniques de comparaison de chaines. Il est utile pour :
        - la deduplication de donnees,
        - les fonctionnalites de recherche,
        - les systemes de liaison d'enregistrements (record linkage).
        Ce moteur repose sur une architecture modulaire et configurable, ce qui le rend adaptable a divers cas
        dusage.

*System Overview:
        Le moteur utilise une architecture modulaire qui separe les differentes responsabilites telles que :
          pretraitement, generation de candidats, algorithmes de comparaison, selection des resultats.
        Name Matching Process:
          Entrees Utilisateur Pretraitement Generation de Candidats Comparaison des Noms Selection des
        Resultats Resultats Finaux

*Core Components:
- Moteur : Classe principale qui orchestre le processus.
- GenerateurDeCondidat : Genere une liste de noms candidats.
- SelectionneurDeResultat : Filtre et classe les resultats.
- Comparateur_nom : Interface pour les algorithmes de comparaison.
- Preprocesseur : Nettoyage et normalisation.
- Configuration : Parametres du moteur.
- Recuperateur : Recupere les donnees.


*Methodes principales:
Moteur.java :
- rechercher(String, List<String>) : List<Preprocesseur>
- dedupliquer(List<String>) : List<String>
- comparer(List<String>, List<String>) : List<String>
Algorithmes de comparaison
- JaroWinkler : Similarite basee sur distance dedition.
- Levenshtein : Nombre minimal doperations necessaires.
- Egalite : Retourne 1.0 si identique, 0.0 sinon.

*Exemple dutilisation:
JaroWinkler jaro = new JaroWinkler();
Levenshtein lev = new Levenshtein();
Egalite egal = new Egalite();
double score = jaro.comparer("tim", "Tim");

*Fonctionnalites cles:
- Architecture modulaire
- Algorithmes de comparaison multiples
- Pretraitement configurable
- Generation efficace de candidats
- Processus configurable

*Structure des fichiers:
src/moteur_de_matching_de_nom/
 Moteur.java
 Comparateur_nom.java
 JaroWinkler.java
 Levenshtein.java
 Egalite.java
 ProgrammePrincipal.java

*Sources principales:
- Moteur.java (lignes 647)
- ProgrammePrincipal.java (lignes 619)
*Resume:
Ce moteur fournit une solution puissante et personnalisable pour effectuer des comparaisons de noms dans
des systemes de recherche, de nettoyage ou de liaison denregistrements
