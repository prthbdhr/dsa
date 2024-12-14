/**
 *  https://www.geeksforgeeks.org/problems/the-painters-partition-problem1535/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=practice_card
 */


/**
 * This class provides a solution to the Painter Partition Problem.
 * The objective is to determine the minimum time required to paint all boards
 * by splitting the work among `k` painters, while minimizing the maximum workload.
 */
public class PainterPartitionProblem_II {

    /**
     * Determines the minimum time required to paint all boards.
     *
     * @param arr Array of integers representing the length of each board.
     * @param k   The number of painters available.
     * @return The minimum time required to paint all boards.
     */
    public int minTime(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k <= 0) {
            throw new IllegalArgumentException("Invalid input: array cannot be null or empty, and painters must be positive.");
        }

        int maxBoardLength = Arrays.stream(arr).max().orElse(0); // Maximum board length.
        int totalLength = Arrays.stream(arr).sum(); // Total length of all boards.

        int low = maxBoardLength;
        int high = totalLength;

        // Binary search to find the minimum time.
        while (low <= high) {
            int mid = low + (high - low) / 2;

            int requiredPainters = calculatePainters(arr, mid);

            if (requiredPainters <= k) {
                high = mid - 1; // Try to minimize the workload.
            } else {
                low = mid + 1; // Increase the workload to reduce painters.
            }
        }

        return low;
    }

    /**
     * Calculates the number of painters required for a given maximum workload (cap).
     *
     * @param arr Array of integers representing the length of each board.
     * @param cap The maximum workload a single painter can handle.
     * @return The number of painters required.
     */
    private int calculatePainters(int[] arr, int cap) {
        int painters = 1;
        int currentLoad = 0;

        for (int boardLength : arr) {
            currentLoad += boardLength;

            // If the current load exceeds the capacity, assign a new painter.
            if (currentLoad > cap) {
                painters++;
                currentLoad = boardLength;
            }
        }

        return painters;
    }
}