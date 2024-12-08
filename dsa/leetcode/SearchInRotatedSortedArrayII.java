/**
 * #Leetcode81 | https://leetcode.com/problems/search-in-rotated-sorted-array-ii
 *
 *      [ a specific edge case can occur where the condition
 *      nums[low] <= nums[mid] or nums[mid] <= nums[high] is inconclusive.
 *      To address this, we need to handle the situation
 *      when nums[low] == nums[mid] == nums[high]
 *      by incrementing or decrementing low and high.]
 *
 */

public class SearchInRotatedSortedArrayII {

    public boolean search(int[] nums, int k) {
        int n = nums.length;
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == k) return true;

            if (nums[low] == nums[mid] && nums[low] == nums[high]) {

                low++;
                high--;

            }   else if (nums[low] <= nums[mid]) {

                if (nums[low] <= k && nums[mid] >= k) high = mid - 1;

                else low = mid + 1;

            } else {

                if(nums[mid] <= k && nums[high] >= k) low = mid + 1;

                else high = mid - 1;
            }
        }

        return false;
    }
}