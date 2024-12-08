/**
 *  Leetcode #1423 | https://leetcode.com/problems/subarrays-with-k-different-integers/description/
 */

public  class SubarrayswithKDifferentIntegers {

    public int subarraysWithKDistinct(int[] nums, int k) {
        return (
                subArrayLenlessEqualK(
                        nums,
                        nums.length,
                        k)
                        -
                subArrayLenlessEqualK(
                        nums,
                        nums.length,
                        (k - 1)
                ));
    }

    private int subArrayLenlessEqualK(int[] arr, int n, int k){
        int left = 0;
        int right = 0;
        int res = 0;

        HashMap<Integer, Integer> arrMap = new HashMap<>();

        while (right < n){
            arrMap.put(arr[right], arrMap.getOrDefault(arr[right], 0) + 1);
            while (arrMap.size() > k) {
                arrMap.put(arr[left], arrMap.get(arr[left]) - 1);

                if (arrMap.get(arr[left]) == 0) arrMap.remove(arr[left]);

                left++;
            }

            int subLen = right - left + 1;
            res += subLen;

            right++;
        }

        return res;
    }
}