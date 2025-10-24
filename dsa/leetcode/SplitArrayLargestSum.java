/**
 * #Leetcode 410 | https://leetcode.com/problems/split-array-largest-sum/description/
 */


public  class SplitArrayLargestSum {

    public int splitArray(int[] nums, int k) {
        int n = nums.length;

        if (n < k) return -1;

        int low = Arrays.stream(nums).max().getAsInt();
        int high = Arrays.stream(nums).sum();

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int numOfSubArrays =  countSubArrays(nums, mid);

            if (numOfSubArrays <= k) high = mid - 1;

            else low = mid + 1;
        }

        return low;
    }

    private int countSubArrays(int[] arr, int cap) {
        int subArray = 1;
        int maxSum = 0;

        for (int a: arr) {
            maxSum += a;

            if (maxSum > cap) {
                subArray++;
                maxSum = a;
            }
        }

        return subArray;
    }
}