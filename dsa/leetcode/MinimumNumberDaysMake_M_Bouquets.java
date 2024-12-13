/**
 * #Leetcode1482 | https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/description/
 */

public class MinimumNumberDaysMake_M_Bouquets {

    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        long val = (long) m * k;

        if (val > n) return -1;

        int low = Arrays.stream(bloomDay).min().getAsInt();
        int high = Arrays.stream(bloomDay).max().getAsInt();

        while (low <= high) {
            int mid = low + (high - low) / 2;
            boolean possible = isPossible(bloomDay, mid, m, k);

            if (possible) high = mid - 1;

            else low = mid + 1;
        }

        return low;
    }

    private boolean isPossible(int[] bloomDay, int day, int m, int k) {
        int count = 0, numOfB = 0;

        for (int bd: bloomDay) {

            if (bd <= day) count++;

            else {
                numOfB += (count / k);
                count = 0;
            }
        }

        numOfB += (count / k);

        return (numOfB >= m);
    }
}