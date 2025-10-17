package dsa
/**
* Leetcode #930 | https://leetcode.com/problems/binary-subarrays-with-sum/description/ 
*/

public class BinarySubarraysWithSum {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int sum = 0;
        int leftEqual = 0, leftLess = 0;
        int right = 0;
        int sumEqual = 0, sumLess = 0;

        while(right < nums.length){

            sumLess += nums[right];
            sumEqual += nums[right];

            while(leftLess <= right && sumLess >= goal) sumLess -= nums[leftLess++];

            while (leftEqual <= right && sumEqual > goal) sumEqual -= nums[leftEqual++];

            sum = leftLess - leftEqual;

            right++;
        }

        return sum;
    }
}
