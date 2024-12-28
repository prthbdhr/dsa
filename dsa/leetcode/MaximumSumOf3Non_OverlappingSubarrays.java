/**
 *  #Leetcode 689 | https://leetcode.com/problems/maximum-sum-of-3-non-overlapping-subarrays
 **/

public class MaximumSumOf3Non_OverlappingSubarrays {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[3];
        if (nums == null || n < 3 * k) return result;

        // Compute subarray sums in-place
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        // Arrays to store best indices for left and right
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];

        // Compute maxLeft (index of max sum subarray ending at or before i)
        int leftMaxIndex = 0;
        for (int i = k - 1; i < n; i++) {
            int curSum = prefixSum[i + 1] - prefixSum[i + 1 - k];
            if (curSum > prefixSum[leftMaxIndex + k] - prefixSum[leftMaxIndex]) {
                leftMaxIndex = i + 1 - k;
            }
            maxLeft[i] = leftMaxIndex;
        }

        // Compute maxRight (index of max sum subarray starting at or after i)
        int rightMaxIndex = n - k;
        for (int i = n - k; i >= 0; i--) {
            int curSum = prefixSum[i + k] - prefixSum[i];
            if (curSum >= prefixSum[rightMaxIndex + k] - prefixSum[rightMaxIndex]) {
                rightMaxIndex = i;
            }
            maxRight[i] = rightMaxIndex;
        }

        // Compute the result by iterating through the middle subarray
        int maxSum = 0;
        for (int mid = k; mid <= n - 2 * k; mid++) {
            int left = maxLeft[mid - 1];
            int right = maxRight[mid + k];
            int curSum = (prefixSum[left + k] - prefixSum[left]) +
                    (prefixSum[mid + k] - prefixSum[mid]) +
                    (prefixSum[right + k] - prefixSum[right]);
            if (curSum > maxSum) {
                maxSum = curSum;
                result[0] = left;
                result[1] = mid;
                result[2] = right;
            }
        }

        return result;
    }
}