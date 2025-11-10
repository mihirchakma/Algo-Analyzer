import java.util.Arrays;

/**
 * Member 2 Task: Implement Binary Search and measure its performance.
 * Note: Binary Search requires a sorted array to work correctly.
 * Time Complexity: O(log n) - Logarithmic Time
 */

public class BinarySearch {

    /**
     * Performs a standard iterative binary search.
     * Repeatedly divides the search interval in half.
     */
    public static void search(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if target is present at mid
            if (arr[mid] == target) {
                return;
            }

            // If target is greater, ignore left half
            if (arr[mid] < target) {
                left = mid + 1;
            }
            // If target is smaller, ignore right half
            else {
                right = mid - 1;
            }
        }
    }

    public static void main(String[] args) {
        int[] sizes = {100, 500, 1000};
        long[] times = new long[3];

        for (int i = 0; i < sizes.length; i++) {
            int[] arr = DataUtils.generateRandomArray(sizes[i]);

            // CRITICAL STEP: Binary Search ONLY works on sorted arrays.
            // We must sort the array before we start the timer for the search itself.
            Arrays.sort(arr);

            // Search for a value not in the array (-1) to ensure worst-case path (full log n steps).
            int target = -1;

            // Start timer (measuring ONLY the search, not the sort)
            long startTime = System.nanoTime();
            search(arr, target);
            long endTime = System.nanoTime();

            times[i] = (endTime - startTime);
        }

        DataUtils.printResults("Binary Search (Sorted)", times[0], times[1], times[2]);
    }
}