# Configuration des différents nombres de points à tester
$POINTS_LIST = @(16000000, 160000000, 1600000000)

# Configurations des threads à tester
$THREAD_COUNTS = 1, 2, 4, 8, 16

# Nombre de répétitions par configuration
$REPEAT_COUNT = 5

# Nom des fichiers CSV générés par le programme Java
$OUTPUT_CSV_1 = "pi_result.csv"
$OUTPUT_CSV_2 = "assigment102.csv"

Write-Host "Running calculations. Results will be saved in $OUTPUT_CSV_1 and $OUTPUT_CSV_2."

# Boucle sur chaque nombre de points à tester
foreach ($TOTAL_POINTS in $POINTS_LIST) {
    Write-Host "Running calculations with $TOTAL_POINTS points..."

    # Boucle sur les configurations de threads
    foreach ($t in $THREAD_COUNTS) {
        # Calcul du nombre de points par travailleur pour le programme Pi
        $pointsParTravailleur = [math]::Floor($TOTAL_POINTS / $t)

        # Boucle pour répétitions
        for ($i = 1; $i -le $REPEAT_COUNT; $i++) {
            Write-Host "Running with $t threads (Iteration $i) for $OUTPUT_CSV_1..."
            # Exécution de la commande Java avec le programme Pi
            java Pi $pointsParTravailleur $t $OUTPUT_CSV_1

            Write-Host "Running with $t threads (Iteration $i) for $OUTPUT_CSV_2..."
            # Exécution de la commande Java avec le programme Assignment102
            #java Assignment102 $TOTAL_POINTS $t $OUTPUT_CSV_2
        }
    }
}

Write-Host "Calculations completed. Results saved in $OUTPUT_CSV_1 and $OUTPUT_CSV_2."


