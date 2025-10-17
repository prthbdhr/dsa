
/**
 *  #Leetcode 2149 | https://leetcode.com/problems/rearrange-array-elements-by-sign/description/
 */

public class RearrangeArrayElementsSign {

    public int[] rearrangeArray(int[] nums) {

        int n = nums.length;

        int pos = 0;
        int neg = 1;

        int[] res = new int[n];

        for (int num: nums) {

            if (num >= 0) {

                res[pos] = num;

                pos += 2;
            }

            else {

                res[neg] = num;

                neg += 2;
            }
        }

        return res;
    }
    
}
