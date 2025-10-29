import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * #Leetcode 15 | https://leetcode.com/problems/3sum/
 */

public class ThreeSum {
    
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {

                int sum = nums[i] + nums[j] + nums[k];

                if (sum == 0) {

                    List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);

                    res.add(triplet);

                    j++;
                    k--;

                    while (j < k && nums[j - 1] == nums[j]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                }

                else if (sum < 0) j++;
                
                else k--;    
            }
        }

        return res;
    }
}
