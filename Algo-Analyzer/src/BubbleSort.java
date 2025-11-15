/**
 * Member 3 Task: Implement Bubble Sort and measure its performance.
 * Time Complexity: O(n^2) - Quadratic Time
 */

public class BubbleSort {

    /**
     * Performs a standard Bubble Sort.
     * Repeatedly steps through the list, compares adjacent elements and swaps them if they are in the wrong order.
     */
    public static void sort(int[] arr) {
        int n = arr.length;
        // Outer loop for each pass through the array
        for (int i = 0; i < n - 1; i++) {
            // Inner loop for comparing adjacent elements
            // The last 'i' elements are already in place after each pass
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] sizes = {100, 500, 1000};
        long[] times = new long[3];

        for (int i = 0; i < sizes.length; i++) {
            // Generate a fresh unsorted random array for each test
            int[] arr = DataUtils.generateRandomArray(sizes[i]);

            // Start timer for the sorting process
            long startTime = System.nanoTime();
            sort(arr);
            long endTime = System.nanoTime();

            times[i] = (endTime - startTime);
        }

        DataUtils.printResults("Bubble Sort", times[0], times[1], times[2]);
    }
}