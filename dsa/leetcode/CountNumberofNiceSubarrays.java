
/**
* Leetcode #1248 |https://leetcode.com/problems/count-number-of-nice-subarrays/description
*/
public class CountNumberofNiceSubarrays {

    public int numberOfSubarrays(int[] nums, int k) {
        int res = 0;
        int left = 0;
        int right = 0;
        int prefixes = 0;
        int countOdds = 0;

        while (right < nums.length) {
            int rightVal = nums[right];

            if (isOdd(rightVal)) {
                countOdds++;
            }

            while (countOdds > k) {
                if (isOdd(nums[left])) {
                    countOdds--;
                }
                left++;
                prefixes = 0;
            }

            if (countOdds == k) {
                while (left <= right && isEven(nums[left])) {
                    prefixes++;
                    left++;
                }

                res += prefixes + 1;
            }

            right++;
        }

        return res;
    }

    private boolean isEven(int a) {
        return (a % 2 == 0);
    }

    private boolean isOdd(int a) {
        return (a % 2 != 0);
    }
}
