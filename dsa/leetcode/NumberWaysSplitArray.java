/**
 * #Leetcode 2270 | https://leetcode.com/problems/number-of-ways-to-split-array/
 */

public class NumberWaysSplitArray {
    public int waysToSplitArray(int[] nums) {
        long lSum = 0;
        long rSum = 0;

        for (int n : nums) {
            rSum += n;
        }

        int count = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            lSum += nums[i];
            rSum -= nums[i];

            if (lSum >= rSum) {
                count++;
            }
        }

        return count;
    }
}