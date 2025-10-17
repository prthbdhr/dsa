/**
 *  https://www.geeksforgeeks.org/problems/longest-increasing-subsequence-1587115620/1
 */

public class LongestIncreasingSubsequence {

    static int lis(int arr[]) {
        int n = arr.length;

        int[] dp = new int[n];

        Arrays.fill(dp, 1);

        int maxi = 1;

        for (int i = 1; i < n; i++) {

            for (int j = 0; j < i; j++) {

                if (arr[j] < arr[i]) dp[i] = Math.max(dp[i], 1 + dp[j]);

            }

            maxi = Math.max(maxi, dp[i]);
        }

        return maxi;
    }
}