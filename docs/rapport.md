# TP4 - Calcul de π par une méthode de Monte Carlo

## I. Monte Carlo pour calculer π

Soit l'aire `A_quartD` d'un quart de disque de rayon 1 :

```
A_quartD = (π * r^2) / 4
```

Pour un carré de côté `r = 1`, l'aire `A_c` est :

```
A_c = r^2 = 1
```

On considère des points `X_p(x_p, y_p)` dont les coordonnées sont tirées uniformément dans l'intervalle `]0,1[`.

La probabilité que `X_p` appartienne au quart de disque est :

```
P = A_quartD / A_c = π / 4
```

En effectuant `n_tot` tirages aléatoires, soit `n_cible` le nombre de points situés dans le quart de disque. Si `n_tot` est grand, on peut estimer `P` par :

```
P ≈ n_cible / n_tot ≈ π / 4
```

D'où :

```
π ≈ 4 * n_cible / n_tot
```
### Image : Schéma de MonteCarlo 
![SchémaDeMonteCarlo](MonteCarlo.png)

## II. Algorithme

```python
ncible = 0
for (p = 0; n_tot > 0; n_tot--) {
    xp = rand()  # Loi U(]0,1[)
    yp = rand()
    if ((xp**2 + yp**2) < 1) {
        ncible += 1
    }
}
π = 4 * ncible / n_tot
```

### Tâches

1. **T0 : Tirer et compter `n_tot` points**
    - **T0p : Tirer un point**
        1. **T0p1 : Tirer `X_p`**
        2. **T0p2 : Incrémenter `n_cible`**

2. **T1 : Calculer `π`**

### Dépendances entre tâches :
- `T1` dépend de `T0`
- `T0p2` dépend de `T0p1`
- Les instances de `T0p1` sont indépendantes entre elles.
- Les instances de `T0p2` sont indépendantes entre elles.

### Ressource critique et section critique :
- **`n_cible`** est une ressource critique.
- **Section critique** : `ncible += 1`.

## Adapatation du code pour le rendre paralléle 

### Paradigme Itérations parallèles


    ENTRÉES :
    n_tot : nombre total de points
    
    FONCTION TirerPoint()
    xp ← valeur aléatoire entre 0 et 1
    yp ← valeur aléatoire entre 0 et 1
    RETOURNER (xp^2 + yp^2 < 1)
    FIN FONCTION
    
    PROCÉDURE PRINCIPALE
    ncible ← 0
    
        PARALLEL POUR i DE 1 À n_tot
            SI TirerPoint() ALORS
                INCRÉMENTER ncible
            FIN SI
        FIN PARALLEL POUR
    
        π ← 4 * ncible / n_tot
        AFFICHER "Estimation de π : ", π 
    FIN PROCÉDURE

### Explications :

Tirer un point :

Tirer aléatoirement un point (xp, yp) dans un carré de 1x1 et vérifier s'il est dans un quart de cercle (xp^2 + yp^2 < 1).
Parallélisme :

Les tirages sont effectués simultanément pour accélérer le calcul.

Compter les points :

Incrémenter un compteur ncible pour chaque point dans le quart de cercle.

Estimation de π :

Calculer π avec la formule π ≈ 4 * ncible / n_tot.

### Paradigme Master Worker


    ENTRÉES :
    n_tot : nombre total de points
    n_workers : nombre de workers
    
    FONCTION TirerPoint()
    xp ← valeur aléatoire entre 0 et 1
    yp ← valeur aléatoire entre 0 et 1
    RETOURNER (xp^2 + yp^2 < 1)
    FIN FONCTION
    
    FONCTION MonteCarloPartial(n_charge)
    ncible_partial ← 0
    POUR i DE 1 À n_pcharge FAIRE
    SI TirerPoint() ALORS
    ncible_partial ← ncible_partial + 1
    FIN SI
    FIN POUR
    RETOURNER ncible_partial
    FIN FONCTION
    
    PROCÉDURE PRINCIPALE
    n_charge ← n_tot / n_workers
    Liste ncibles ← Liste vide
    
        POUR chaque worker DE 1 À n_workers
            ncible_partial ← MonteCarloPartial(n_charge)
            AJOUTER ncible_partial à ncibles
        FIN POUR
    
        ncible_total ← Somme des valeurs dans ncibles
        π ← 4 * ncible_total / n_tot
        AFFICHER "Estimation de π : ", π
    FIN PROCÉDURE

### Explications en pseudo-code :

Chaque worker effectue une partie des calculs (calcul de ncible_partial).

Workers :
Chaque worker travaille de manière indépendante, calculant son propre ncible_partial pour un sous-ensemble des points(n_charge).

Collecte des résultats :

Le master collecte les résultats de chaque worker et effectue une somme des ncible_partial.

Estimation de π :

Le master calcule π en utilisant la formule π ≈ 4 * ncible_total / n_tot.





### TP 4

#### Illustration
![MonteCarloCodeDistribué](MasterSocketUml.png)
![DiagrammeDesTachesMasterWorker](DiagrammedestachesMASTERSocket.png)
#### Presentation de la conception
   Le diagramme montre une architecture en mémoire distribuée, où les tâches de calcul (simulation Monte Carlo) sont décomposées et réparties entre des Workers par un Master.

   MasterSocket : Le nœud maître, qui coordonne l'ensemble du processus. Ses roles sont de :
   De Distribuer les taches au workers en les répartissant.
   De Fusionner les résultats partiels des Workers et calcul du résultat final.

   WorkerSocket : Les nœuds de travail qui exécutent les simulations Monte Carlo. Ses roles sont de :
   Recevoir des instructions du Master via un Socket.
   Effectuer les calculs Monte Carlo (Avec la classe Master de PI).
   Retourner les résultats partiels au Master.

   ServerSocket : gere et accepte les connexions entre le MasterSocket et les WorkerSocket .

   Classes I/O (BufferedReader, PrintWriter, InputStream,outputSream.) :
   Permettent l'échange des données par des flux données qui seront soient écrits soit lus (envoie des résultats , ou de paramétres)
   
   IOException : Gère les erreurs potentielles dans les communications réseau ou les flux d'I/O.

#### Le paradigme choisi
Le paradigme choisi est le paradigme MasterWorker en mémoire distribuéé. Le Master et les workers communiquent leurs informations a traers des Sockets.
Précédemment dans le code on créait une méthode qui calcule la fonction monteCarlo et puis aprés envoie le résultat au master.
Dans la version finale du code, on fait que le worker appelle le master du programme PI (on fait que le master a 1 seul worker). Donc le paradigme change à ce moment et on passe  a de la programmation multiniveaux.
Programmation multiniveaux:  Code en mémoire distribuée qui utilise un code en mémoire paralléle.

## 2. Analyse des performances

### Expérience 1 : calcul de la stabilité forte (Code : assigment102 : Nombre de Points : 10^6,10^7 *16  Nombre de processeurs : 1,2,4,8,16)
| PI   | Difference | Error | Ntot            | AvailableProcessors | TimeDuration(ms) |
|------|------------|-------|-----------------|---------------------|------------------|
|3,141701|0,000108|0,000363| 1600000,000000  |1,000000|265,600000|
3,142529|0,000936|0,000433| 1600000,000000  |2,000000|497,600000|
3,142360|0,000767|0,000411| 1600000,000000  |4,000000|798,000000|
3,141881|0,000288|0,000238| 1600000,000000  |8,000000|1048,600000|
3,142393|0,000800|0,000411| 1600000,000000  |16,000000|1154,800000|
3,141688|0,000095|0,000080| 16000000,000000 |1,000000|2942,000000|
3,141531|-0,000062|0,000049| 16000000,000000 |2,000000|4545,600000|
3,141605|0,000012|0,000073| 16000000,000000 |4,000000|7998,200000|
3,141542|-0,000051|0,000126| 16000000,000000 |8,000000|9142,600000|
3,141311|-0,000282|0,000214| 16000000,000000 |16,000000|9784,000000|

### Expérience 2: (10^6 nombre de points, Pi.java)
| PI   | Difference | Error | Ntot     | AvailableProcessors | TimeDuration(ms) |
|------|------------|-------|----------|---------------------|------------------|
|3,141830|0,000237|0,000124|1600000,000000|1,000000|115,400000|
|3,141716|0,000123|0,000269|1600000,000000|2,000000|73,600000|
|3,140863|-0,000730|0,000365|1600000,000000|4,000000|59,600000|
|3,141544|-0,000049|0,000204|1600000,000000|8,000000|52,200000|
|3,142654|0,001061|0,000501|1600000,000000|16,000000|75,800000|
|3,141629|0,000036|0,000083|16000000,000000|1,000000|839,200000|
|3,141530|-0,000063|0,000051|16000000,000000|2,000000|474,000000|
|3,141615|0,000022|0,000054|16000000,000000|4,000000|318,200000|
|3,141845|0,000253|0,000106|16000000,000000|8,000000|202,800000|
|3,141546|-0,000047|0,000119|16000000,000000|16,000000|222,400000|
|3,141681|0,000088|0,000039|160000000,000000|1,000000|8541,600000|
|3,141735|0,000142|0,000045|60000000,000000|2,000000|4457,800000|
|3,141574|-0,000018|0,000022|160000000,000000|4,000000|2672,40000|
|3,141526|-0,000067|0,000032|160000000,000000|8,000000|1538,200000|
|3,141510|-0,000083|0,000042|160000000,000000|16,000000|1567,400000|


### Expérience 5: (10^7 nombre de points,Pi.java)
| PI   | Difference | Error | Ntot      | AvailableProcessors | TimeDuration(ms) |
|------|------------|-------|-----------|---------------------|------------------|
|      |            |       | 160000000 | 1                   |                  |
|      |            |       | 160000000 | 1                   |                  |
|      |            |       | 160000000 | 1                   |                  |
|      |            |       | 160000000 | 1                   |                  |
|      |            |       | 160000000 | 2                   |                  |
|      |            |       | 160000000 | 2                   |                  |
|      |            |       | 160000000 | 2                   |                  |
|      |            |       | 160000000 | 2                   |                  |
|      |            |       | 160000000 | 2                   |                  |
|      |            |       | 160000000 | 2                   |                  |
|      |            |       | 160000000 | 4                   |                  |
|      |            |       | 160000000 | 4                   |                  |
|      |            |       | 160000000 | 4                   |                  |
|      |            |       | 160000000 | 4                   |                  |
|      |            |       | 160000000 | 4                   |                  |
|      |            |       | 160000000 | 8                   |                  |
|      |            |       | 160000000 | 8                   |                  |
|      |            |       | 160000000 | 8                   |                  |
|      |            |       | 160000000 | 8                   |                  |
|      |            |       | 160000000 | 8                   |                  |
|      |            |       | 160000000 | 16                  |                  |
|      |            |       | 160000000 | 16                  |                  |
|      |            |       | 160000000 | 16                  |                  |
|      |            |       | 160000000 | 16                  |                  |
|      |            |       | 160000000 | 16                  |                  |


### Expérience 6 : (10^8 nombre de points,Pi.java)
| PI   | Difference | Error | Ntot       | AvailableProcessors | TimeDuration(ms) |
|------|------------|-------|------------|---------------------|------------------|
|      |            |       | 1600000000 | 1                   |                  |
|      |            |       | 1600000000 | 1                   |                  |
|      |            |       | 1600000000 | 1                   |                  |
|      |            |       | 1600000000 | 1                   |                  |
|      |            |       | 1600000000 | 2                   |                  |
|      |            |       | 1600000000 | 2                   |                  |
|      |            |       | 1600000000 | 2                   |                  |
|      |            |       | 1600000000 | 2                   |                  |
|      |            |       | 1600000000 | 2                   |                  |
|      |            |       | 1600000000 | 2                   |                  |
|      |            |       | 1600000000 | 4                   |                  |
|      |            |       | 1600000000 | 4                   |                  |
|      |            |       | 1600000000 | 4                   |                  |
|      |            |       | 1600000000 | 4                   |                  |
|      |            |       | 1600000000 | 4                   |                  |
|      |            |       | 1600000000 | 8                   |                  |
|      |            |       | 1600000000 | 8                   |                  |
|      |            |       | 1600000000 | 8                   |                  |
|      |            |       | 1600000000 | 8                   |                  |
|      |            |       | 1600000000 | 8                   |                  |
|      |            |       | 1600000000 | 16                  |                  |
|      |            |       | 1600000000 | 16                  |                  |
|      |            |       | 1600000000 | 16                  |                  |
|      |            |       | 1600000000 | 16                  |                  |
|      |            |       | 1600000000 | 16                  |                  |


Plan à suivre : 
1 Methode MC
2 Algo et parallélisation
   a) Iteraration
   b) MasterWorker
3 Mise en oeuvre sur Machine à Partagé
   a) Analyse Assignment 102
   b) Analyse Pi.java
4 Qualité de test de perf

5 Mise en oeuvre en memoire dist
   a) Java Socket Mw

6 Perf MW


