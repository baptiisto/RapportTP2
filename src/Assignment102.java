public class Assignment102 {
    public static void main(String[] args) {
        int i = 10000000;
        PiMonteCarlo PiVal = new PiMonteCarlo(i);
        long startTime = System.currentTimeMillis();
        double value = PiVal.getPi();
        long stopTime = System.currentTimeMillis();
        System.out.println("\nPi:" + value);
        System.out.println("Difference to exact value of pi: " + (value - Math.PI));
        System.out.println("Error: " + (Math.abs((value - Math.PI)) / Math.PI) +"\n");
        System.out.println("Ntot: " + i);
        System.out.println("Available processors: " + Runtime.getRuntime().availableProcessors());
        System.out.println("Time Duration (ms): " + (stopTime - startTime));
    }
}
