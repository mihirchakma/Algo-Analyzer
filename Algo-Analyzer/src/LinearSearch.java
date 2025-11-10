/**
 * Member 1 Task: Implement Linear Search and measure its performance.
 * Time Complexity: O(n) - Linear Time
 */

public class LinearSearch {

    /**
     * Performs a standard linear search on the array.
     * Iterates through every element until the target is found.
     */
    public static void search(int[] arr, int target) {
        for (int j : arr) {
            if (j == target) {
                return; // Return index if found
            }
        }
    }

    public static void main(String[] args) {
        int[] sizes = {100, 500, 1000};
        long[] times = new long[3];

        for (int i = 0; i < sizes.length; i++) {
            // Generate a new random array for each test size
            int[] arr = DataUtils.generateRandomArray(sizes[i]);

            // We search for -1 because our random generator only produces numbers 0-9999.
            // This guarantees a "worst-case" scenario where the algorithm must scan the entire array.
            int target = -1;

            // Start timer with nanosecond precision
            long startTime = System.nanoTime();
            search(arr, target);
            long endTime = System.nanoTime();

            // Calculate elapsed time in nanoseconds
            times[i] = (endTime - startTime);
        }

        // Print the final results table
        DataUtils.printResults("Linear Search", times[0], times[1], times[2]);
    }
}
