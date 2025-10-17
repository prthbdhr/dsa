/**
 *  #Leetcode 493 | https://leetcode.com/problems/reverse-pairs
 */

public class ReversePairs {

    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int low, int high) {
        int cnt = 0;

        if (low >= high) {
            return cnt;
        }

        int mid = (low + high) / 2;

        cnt += mergeSort(nums, low, mid);

        cnt += mergeSort(nums, mid + 1, high);

        cnt += countPossiblePairs(nums, low, mid, high);

       merge(nums, low, mid, high);

        return cnt;

    }

    private void merge(int[] nums, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;

        List<Integer> temp = new ArrayList<>();

        while (i <= mid && j <= high) {

            if (nums[i] <= nums[j]) {
                temp.add(nums[i]);
                i++;
            }

            else {
                temp.add(nums[j]);
                j++;
            }
        }

        while (i <= mid) {
            temp.add(nums[i]);
            i++;
        }

        while (j <= high) {
            temp.add(nums[j]);
            j++;
        }

        for (int k = low; k <= high; k++) {
            nums[k] = temp.get(k - low);
        }
    }

    private int countPossiblePairs(int[] nums, int low, int mid, int high) {
        int right = mid + 1;

        int cnt = 0;

        for (int left = 0; left < mid; left++) {

            while (right <= high && canMakePair(nums[left], nums[right])) {
                right++;
            }
            cnt += right - (mid + 1);
        }

        return cnt;
    }

    private boolean canMakePair(int a, int b) {
        return (long) a > 2 * (long) b;
    }
}