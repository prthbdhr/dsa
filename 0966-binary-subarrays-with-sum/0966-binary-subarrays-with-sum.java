class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return slidingWindowAtMost(nums, goal) - (goal > 0 ? slidingWindowAtMost(nums, goal - 1) : 0);
    }

    private int slidingWindowAtMost(int[] nums, int goal) {
        int left = 0, right = 0;
        int sum = 0;
        int count = 0;

        while (right < nums.length) {
            sum += nums[right];

            while (left <= right && sum > goal) {
                sum -= nums[left];
                left++;
            }

            count += right - left + 1;
            right++;
        }

        return count;
    }
}