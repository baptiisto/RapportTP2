import java.io.*;

public class CsvWriter {
    private String fileName;

    // Constructor
    public CsvWriter(String fileName) {
        this.fileName = fileName;
    }

    // Method to save results
    public void saveResults(double pi, double difference, double error, long ntot, int processors, long timeDuration) {
        // Check if fileName is empty
        if (this.fileName == null || this.fileName.trim().isEmpty()) {
            //System.err.println("Filename is empty. Results will not be saved.");
            return;
        }

        File file = new File(this.fileName);
        boolean isNewFile = !file.exists();

        try (FileWriter fw = new FileWriter(file, true); BufferedWriter bw = new BufferedWriter(fw); PrintWriter writer = new PrintWriter(bw)) {
            if (isNewFile) {
                // Write header if file is new
                writer.println("PI,Difference,Error,Ntot,AvailableProcessors,TimeDuration(ms)");
            }
            // Add results to file
            writer.printf("%f;%f;%f;%d;%d;%d;%n", pi, difference, error, ntot, processors, timeDuration);
            System.out.println("Results saved to file: " + this.fileName);
        } catch (IOException e) {
            System.err.println("Error writing to CSV file: " + e.getMessage());
        }
    }
}

