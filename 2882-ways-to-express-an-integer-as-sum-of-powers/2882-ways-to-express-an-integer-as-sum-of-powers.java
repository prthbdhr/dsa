class Solution {

    final int MOD = 1_000_000_007;

    Long[][] dp;

    public int numberOfWays(int n, int x) {
        
        dp = new Long[n + 1][n + 1];;

        return (int) solve (1, n, x);
    }

    private long solve(int num, int target, int x) {

        if (target == 0) return 1;

        if (target < num) return 0;

        if (dp[num][target] != null) return dp[num][target];

        long pow = (long) Math.pow(num, x);

        if (pow > target) return dp[num][target] = 0L;

        long notTake = solve(num + 1, target, x);

        long take = solve(num + 1, target - (int)pow, x);

        return dp[num][target] = (take + notTake) % MOD;
    }
}

