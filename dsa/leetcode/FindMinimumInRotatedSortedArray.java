/**
 * #Leetcode153 | https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
 */

public class FindMinimumInRotatedSortedArray {

    public int findMin(int[] arr) {

        int n = arr.length;

        int low = 0;

        int high = n - 1;

        int ans = Integer.MAX_VALUE;

        while (low <= high) {

            int mid = low + ( high - low) / 2;

            //search space is already sorted
            //then arr[low] will always be
            //the minimum in that search space:
            if (arr[low] <= arr[mid] && arr[mid] <= arr[high]) {
                ans = Math.min(ans, arr[low]);
                break;
            }

            if (arr[low] <= arr[mid]) {

                ans = Math.min(ans, arr[low]);

                low = mid + 1;

            }

            else {

                ans = Math.min(ans, arr[mid]);

                high = mid -1;

            }
        }

        return ans;
    }
}