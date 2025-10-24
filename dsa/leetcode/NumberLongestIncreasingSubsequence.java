/**
 *  #Leetcode 673 | https://leetcode.com/problems/number-of-longest-increasing-subsequence
 */

public class NumberLongestIncreasingSubsequence {

    public int findNumberOfLIS(int[] nums) {

        int n = nums.length;

        int[] dp = new int[n];

        int[] count = new int[n];

        Arrays.fill(dp, 1);

        Arrays.fill(count, 1);

        int maxi = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {

                if (nums[j] < nums[i]) {

                    if (dp[i] < 1 + dp[j]) {

                        dp[i] = 1 + dp[j];

                        count[i] = count[j];
                    }

                    else if (dp[i] == 1 + dp[j]) {
                        count[i] += count[j];
                    }
                }
            }

            maxi = Math.max(maxi, dp[i]);
        }

        int res = 0;

        for (int i = 0; i < n; i++) {

            if (dp[i] == maxi) res += count[i];
        }

        return res;
    }
}