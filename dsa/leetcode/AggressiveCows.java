/**
 * https://www.geeksforgeeks.org/problems/aggressive-cows/0
 */

public class AggressiveCows {
    private int n;
    public int aggressiveCows(int[] stalls, int k) {

        this.n = stalls.length;

        if (k > n) return -1;

        Arrays.sort(stalls);

        int low = 1, high = (stalls[n - 1] - stalls[0]);

        while (low <= high) {
            int mid = low + (high - low) / 2;

            boolean canBePlaced = canWePlaced(stalls, mid, k);

            if (canBePlaced) low = mod + 1;

            else high = mid - 1;
        }

        return high;
    }

    private boolean canWePlaced (int[] stalls, int dis, int cows) {
        int countOfCows = 1, lastCow = stalls[0];

        for (int stl: stalls) {
            int disBetween = stl - lastCow;

            if (disBetween >= dis) {
                countOfCows++;
                lastCow = stl;
            }

            if (countOfCows >= cows) return true;
        }

        return false;
    }
}