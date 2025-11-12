/**
 * Member 4 Task: Implement Quick Sort and measure its performance.
 * Time Complexity: O(n log n) on average - Log-linear Time
 */

public class QuickSort {

    /**
     * Main recursive function that implements QuickSort.
     * @param arr Array to be sorted
     * @param low Starting index
     * @param high Ending index
     */
    public static void sort(int[] arr, int low, int high) {
        if (low < high) {
            // pi is partitioning index, arr[pi] is now at right place
            int pi = partition(arr, low, high);

            // Recursively sort elements before partition and after partition
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

    /**
     * Takes the last element as pivot, places the pivot element at its correct
     * position in sorted array, and places all smaller (smaller than pivot)
     * to left of pivot and all greater elements to right of pivot.
     */
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); // index of smaller element

        for (int j = low; j < high; j++) {
            // If current element is smaller than the pivot
            if (arr[j] < pivot) {
                i++;
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        int[] sizes = {100, 500, 1000};
        long[] times = new long[3];

        for (int i = 0; i < sizes.length; i++) {
            // Generate a fresh unsorted random array for each test
            int[] arr = DataUtils.generateRandomArray(sizes[i]);

            // Start timer for the sorting process
            long startTime = System.nanoTime();
            // Initial call covers the entire array from index 0 to length-1
            sort(arr, 0, arr.length - 1);
            long endTime = System.nanoTime();

            times[i] = (endTime - startTime);
        }

        DataUtils.printResults("Quick Sort", times[0], times[1], times[2]);
    }
}