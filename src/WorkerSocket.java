import java.io.*;
import java.net.*;

/**
 * WorkerSocket est un serveur qui calcule Pi en utilisant la méthode de Monte Carlo
 * et envoie le résultat (nombre de points dans le quart de disque) au Master.
 */
public class WorkerSocket {
    static int port = 25545; // Port par défaut
    private static boolean isRunning = true;

    /**
     * Méthode pour calculer Monte Carlo.
     * Simule des lancers aléatoires et retourne le nombre de points
     * qui tombent dans un quart de disque.
     *
     * @param totalThrows Nombre total de lancers
     * @return Nombre de points dans le quart de disque
     */
    private static int computeMonteCarlo(int totalThrows) {
        int countInside = 0;
        for (int i = 0; i < totalThrows; i++) {
            double x = Math.random(); // Coordonnée x aléatoire entre 0 et 1
            double y = Math.random(); // Coordonnée y aléatoire entre 0 et 1
            if (x * x + y * y <= 1.0) { // Vérifier si le point est dans le quart de disque
                countInside++;
            }
        }
        return countInside;
    }

    /**
     * Point d'entrée principal du programme.
     * Le Worker attend les messages du Master, effectue le calcul Monte Carlo
     * et renvoie les résultats.
     */
    public static void main(String[] args) throws Exception {
        // Si un argument est passé, utiliser comme port
        if (args.length > 0 && !("".equals(args[0]))) {
            port = Integer.parseInt(args[0]);
        }

        System.out.println("Worker démarré sur le port : " + port);
        ServerSocket serverSocket = new ServerSocket(port);

        // Attendre une connexion du Master
        Socket socket = serverSocket.accept();
        System.out.println("Connexion établie avec Master.");

        // Création des flux pour communiquer avec Master
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);

        String str;
        while (isRunning) {
            str = reader.readLine(); // Lire le message du Master
            if (str != null && !str.equals("END")) {
                System.out.println("Reçu de Master : totalCount = " + str);

                // Calculer Monte Carlo
                int totalThrows = Integer.parseInt(str);
                //int totalInside = computeMonteCarlo(totalThrows);
                int totalInside = (int) new Master().doRun(totalThrows, 1,"");

                // Envoyer le résultat au Master
                System.out.println("Envoi au Master : totalInside = " + totalInside);
                writer.println(totalInside);
            } else {
                // Arrêter le serveur si "END" est reçu
                System.out.println("Commande END reçue. Fermeture du serveur...");
                isRunning = false;
            }
        }

        // Fermer les flux et le socket
        reader.close();
        writer.close();
        socket.close();
        serverSocket.close();
    }
}
