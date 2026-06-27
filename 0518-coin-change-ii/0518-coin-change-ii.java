class Solution {
    public int change(int amount, int[] coins) {

        int n = coins.length;

        int[][] dp = new int[n][amount + 1];

        for (int[] row: dp) Arrays.fill(row, -1);
        
        return solve(n - 1, amount, coins, dp);
    }

    private int solve(int i, int target, int[] nums, int[][] dp) {

        if (i == 0) {
            
            if (target % nums[i] == 0) return 1;

            else return 0;
        }

        if (dp[i][target] != -1) return dp[i][target];

        int nonTake = solve(i - 1, target, nums, dp);

        int take = (nums[i] <= target) ? solve(i, target - nums[i], nums, dp) : 0;

        return dp[i][target] = nonTake + take;
    }
}