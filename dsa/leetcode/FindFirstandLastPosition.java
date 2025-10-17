/**
 * #Leetcode34 | https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */

public class FindFirstandLastPosition {

    public int[] searchRange(int[] nums, int target) {

        int len = nums.length;
        int first = firstIndex (nums, target, len);
        int last = lastIndex (nums, target, len);

        return new int[] {first, last};
    }

    private  int firstIndex (int[] arr, int k, int n) {
        int low = 0;
        int high = n - 1;
        int res = -1;

        while (low <= high) {

            int mid = low + (high - low);

            if (arr[mid] == k) {
                res = mid;
                high = mid - 1;
            }

            if (arr[mid] < k) low = mid + 1;

            else high = mid - 1;
        }

        return res;
    }

    private int lastIndex (int[] arr, int k, int n) {

        int low = 0;
        int high = n - 1;
        int res = -1;

        while (low <= high) {

            int mid = low + (high - low);

            if (arr[mid] == k) {
                res = mid;
                low = mid + 1;
            }

            if (arr[mid] < k) low = mid + 1;

            else high = mid - 1;
        }

        return res;
    }
}