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



### TP Je sais plus 

Programmation multiniveaux: On va faire qu'un code en mémoire distribuée utilise un code en mémoire paralléle.

Dans worker socket, on créer une méthode qui calcule la fonction monteCarlo et puis aprés envoie le résultat au master.

Dans workerSocket , au lieu d'utiliser la fonction crée , on appelle la classe Master de PI.java. Donc WorkerSocker peut utiliser des bibliothéques.




