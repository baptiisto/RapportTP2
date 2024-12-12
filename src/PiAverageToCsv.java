import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PiAverageToCsv {

    public static void main(String[] args) throws IOException {
        String inputFilePath = "src/pi_result_forte.csv";  // Remplace ce chemin par le chemin de ton fichier CSV
        String outputFilePath = "src/pi_moyenne_forte.csv";  // Chemin du fichier de sortie

        List<List<Double>> columnsData = readCsv(inputFilePath);

        // Calculer la moyenne toutes les 5 lignes pour chaque colonne
        List<List<Double>> averagedData = calculateAverages(columnsData, 5);

        // Sauvegarder les résultats dans un nouveau fichier CSV, y compris l'entête
        writeCsvWithHeader(averagedData, inputFilePath, outputFilePath);

        System.out.println("Le fichier CSV avec les moyennes a été généré à : " + outputFilePath);
    }

    private static List<List<Double>> readCsv(String filePath) throws IOException {
        List<List<Double>> columnsData = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean firstLine = true;
            // Lire les lignes du fichier CSV
            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");
                // Si c'est la première ligne (l'entête), on ignore l'ajout de données
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                for (int i = 0; i < values.length; i++) {
                    if (columnsData.size() <= i) {
                        columnsData.add(new ArrayList<>());
                    }
                    columnsData.get(i).add(Double.parseDouble(values[i].replace(",", ".")));  // Remplacer la virgule par un point
                }
            }
        }
        return columnsData;
    }

    private static List<List<Double>> calculateAverages(List<List<Double>> columnsData, int interval) {
        List<List<Double>> averagedData = new ArrayList<>();
        int numColumns = columnsData.size();
        int numRows = columnsData.get(0).size();

        // Calculer la moyenne toutes les 5 lignes
        for (int i = 0; i < numColumns; i++) {
            List<Double> column = columnsData.get(i);
            List<Double> averagedColumn = new ArrayList<>();
            for (int j = 0; j < numRows; j += interval) {
                int end = Math.min(j + interval, numRows);
                double sum = 0;
                for (int k = j; k < end; k++) {
                    sum += column.get(k);
                }
                double average = sum / (end - j);  // Moyenne des valeurs sur l'intervalle
                averagedColumn.add(average);
            }
            averagedData.add(averagedColumn);
        }
        return averagedData;
    }

    private static void writeCsvWithHeader(List<List<Double>> averagedData, String inputFilePath, String outputFilePath) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath));
             FileWriter writer = new FileWriter(outputFilePath)) {

            // Lire l'entête
            String header = br.readLine();
            writer.write(header + "\n");

            int numRows = averagedData.get(0).size();
            int numColumns = averagedData.size();

            // Écrire les moyennes dans le fichier CSV
            for (int i = 0; i < numRows; i++) {
                StringBuilder line = new StringBuilder();
                for (int j = 0; j < numColumns; j++) {
                    line.append(String.format("%.6f", averagedData.get(j).get(i)));  // Formater les valeurs avec 6 décimales
                    if (j < numColumns - 1) {
                        line.append(";");
                    }
                }
                writer.write(line.toString());
                writer.write("\n");
            }
        }
    }
}
