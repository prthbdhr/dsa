/**
 *  #Leetcode 132 | https://leetcode.com/problems/palindrome-partitioning-ii/description/
 */

public class PalindromePartitioning_II {

    public int minCut(String s) {

        int n = s.length();

        int[] dp = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {

            int mini = (int) 1e9;

            for (int j = i; j < n; j++) {

                if (isPalindrom(i, j,s)) {

                    int cost = 1 + dp[j + 1];

                    mini = Math.min(mini, cost);
                }
            }

            dp[i] = mini;
        }

        return dp[0] - 1;
    }

    private int solve(int i, int n, String s, int[] dp) {

        if (i == n) return 0;

        if (dp[i] != -1) return dp[i];

        int mini = (int) 1e9;

        for (int j = i; j < n; j++) {

            if (isPalindrom(i, j,s)) {

                int cost = 1 + solve(j + 1, n, s, dp);

                mini = Math.min(mini, cost);
            }
        }

        return dp[i] = mini;
    }

    private boolean isPalindrom(int i, int j, String s) {

        while (i < j) {

            if (s.charAt(i) != s.charAt(j)) return false;

            i++;
            j--;
        }

        return true;
    }
}