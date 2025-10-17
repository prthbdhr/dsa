/**
 * #Leetcode1011 | https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/
 */

public class CapacityToShipPackagesWithinDDays {

    public int shipWithinDays(int[] weights, int days) {
        int low = Arrays.stream(weights).max().getAsInt();
        int high = Arrays.stream(weights).sum();

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int numOfDays = findDays(weights, mid);

            if (numOfDays <= days) high = mid - 1;

            else low = mid + 1;
        }

        return low;
    }

    private int findDays (int[] weights, int capacity) {
        int days = 1;
        int load = 0;

        for (int weight: weights) {

            if ( (load + weight) > capacity) {
                days++;
                load = weight;
            }

            else {
                load += weight;
            }
        }

        return days;
    }
}