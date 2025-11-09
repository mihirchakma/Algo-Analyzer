import java.util.Random;

/**
 * Shared utility class for the Algorithm Analyzer project.
 * Provides common methods for generating test data and printing formatted results.
 */
public class DataUtils {

    /**
     * Generates an array of random integers.
     * @param size The number of elements in the array.
     * @return An array filled with random integers between 0 and 9999.
     */
    public static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(10000); // Generates random numbers from 0 to 9999
        }
        return arr;
    }

    /**
     * Prints the performance results in a formatted table.
     * Converts the high-precision nanosecond time back to milliseconds for readability.
     * * @param algorithmName Name of the algorithm being tested.
     * @param time100ns Execution time for 100 elements in nanoseconds.
     * @param time500ns Execution time for 500 elements in nanoseconds.
     * @param time1000ns Execution time for 1000 elements in nanoseconds.
     */
    public static void printResults(String algorithmName, long time100ns, long time500ns, long time1000ns) {
        System.out.println("\n========================================");
        System.out.println("Algorithm: " + algorithmName);
        System.out.println("========================================");
        System.out.printf("%-15s | %-15s%n", "Input Size", "Time (ms)");
        System.out.println("----------------------------------------");

        // We divide by 1,000,000.0 to convert nanoseconds to milliseconds while keeping decimal precision.
        System.out.printf("%-15d | %-15.4f%n", 100, time100ns / 1_000_000.0);
        System.out.printf("%-15d | %-15.4f%n", 500, time500ns / 1_000_000.0);
        System.out.printf("%-15d | %-15.4f%n", 1000, time1000ns / 1_000_000.0);
        System.out.println("========================================\n");
    }
}