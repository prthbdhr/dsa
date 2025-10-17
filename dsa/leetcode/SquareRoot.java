/**
 *  https://www.geeksforgeeks.org/problems/square-root/0?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=square-root
 */


public class SquareRoot {

    int floorSqrt(int n) {

        if (n == 0 || n == 1) return n;

        int low = 1;
        int high = n;
        int res = 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            long long squar = mid * mid;

            if (squar == n) return mid;

            if (squar < n) {
                res = mid;
                low = mid + 1;
            }

            else high = mid - 1;
        }

        return res;
    }
}