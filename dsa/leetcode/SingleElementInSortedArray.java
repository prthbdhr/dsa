/**
 * #Leetcode540 | https://leetcode.com/problems/single-element-in-a-sorted-array/description/
 *
 *  [ You are given a sorted array consisting of only integers
 *  where every element appears exactly twice, except for one
 *  element which appears exactly once.Return the single element
 *  that appears only once.]
 */

public  class SingleElementInSortedArray {

    public int singleNonDuplicate(int[] nums) {

        int n = nums.length;

        if (n == 1 || nums[1] != nums[0]) return nums[0];

        if (nums[n - 1] != nums[n - 2]) return nums[n - 1];

        int low = 1;
        int high = n - 2;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            while (nums[mid] != nums[mid + 1] && nums[mid] != nums[mid - 1]) return nums[mid];

            if (
                    mid % 2 == 0 && nums[mid] == nums[mid + 1] ||
                    mid % 2 == 1 && nums[mid] == nums[mid - 1]
            ) low = mid + 1;

            else high = mid - 1;
        }

        return -1;
    }
}