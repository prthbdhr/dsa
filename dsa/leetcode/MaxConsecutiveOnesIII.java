
/** 
* Leetcode #1004 | https://leetcode.com/problems/max-consecutive-ones-iii/description/
*/

public class MaxConsecutiveOnesIII {
    public int MaxConsecutiveOnes(int[] nums, int k){
        int maxLen = 0;
        int left = 0;
        int right = 0;
        int n = nums.length;
        int countZeroes = 0;

        while(right < n){
            if(nums[right] == 0) countZeroes++;

            while (countZeroes > k){
                if (nums[left] == 0) countZeroes--;
                left++;
            }

            if(countZeroes <= k){
                int len = right - left + 1;
                maxLen = Math.max(maxLen, len);
            }

            right++;
        }

        return maxLen;

    }
}
