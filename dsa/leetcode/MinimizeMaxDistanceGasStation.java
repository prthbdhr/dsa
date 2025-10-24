/**
 *  https://www.geeksforgeeks.org/problems/minimize-max-distance-to-gas-station/0
 */

public class MinimizeMaxDistanceGasStation {
    public static double findSmallestMaxDist(int stations[], int k) {
        int n = stations.length;

        if (n <= 1) {
            return 0;
        }

        double low = 0;
        double high = 0;

        for (int i = 0; i < n - 1; i++) {
            high = Math.max(high, (double)(stations[i + 1] - stations[i]));
        }

        final double diff = 1e-6;

        while ((high - low) > diff) {
            double mid = low + (high - low) / 2.0;

            if (canMakeByK(stations, mid, k, n)) {
                high = mid;
            }

            else {
                low = mid;
            }
        }

        return high;
    }

    static boolean canMakeByK(int[] stations, double distance, int k, int n) {
        int countGasStations = 0;

        for (int i = 1; i < n ; i++) {
            double gap = stations[i] - stations[i - 1];

            int canBePlaced = (int) (gap / distance);

            if (gap == canBePlaced * distance) {
                canBePlaced--;
            }

            countGasStations += canBePlaced;

            if (countGasStations > k) return false;
        }

        return true;
    }
}