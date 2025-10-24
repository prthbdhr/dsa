import java.util.HashMap;

public class LongestSubarraywithSumK {

    public int longestSubarray(int[] arr, int k) {
       int n = arr.length;

        HashMap<Integer, Integer> sumMap = new HashMap<>(); // prefix sum to index

        int sum = 0;
        int maxLength = 0;

        for (int  i = 0; i < n; i++) {

            sum += arr[i];

            if (sum == k){
                maxLength = i + 1; // from index 0 to i + 1
            }

            if (sumMap.containsKey(sum - k)) {
                maxLength = Math.max(maxLength, i - sumMap.get(sum - k)); // update maxLength if we found a longer subarray
            }
            
            if (!sumMap.containsKey(sum)){
                sumMap.put(sum, i); // store the first occurrence of the prefix sum
            }
        }

        return maxLength;
    }
}