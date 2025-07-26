class Solution {
    public int rob(int[] nums) {
        
        int n = nums.length;

        if (n == 1) return nums[0];

        int arr1[] = new int[n - 1];
        int arr2[] = new int[n - 1];

        for (int i = 0; i < n; i++) {

            if (i != 0) arr1[i - 1] = nums[i];

            if (i != n - 1) arr2[i] = nums[i];
        }

        return Math.max(solve(n - 1, arr1), solve(n - 1, arr2));
    }

    private int solve (int n, int[] nums) {

        int prev1 = nums[0];
        int prev2 = 0;

        for (int i = 0; i < n; i++) {

            int take = (i > 1) ? nums[i] + prev2 : nums[i];

            int notTake = prev1;

            prev2 = prev1;

            prev1 = Math.max(take, notTake);
        }

        return prev1;
    }
}