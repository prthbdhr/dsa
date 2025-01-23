/**
 * https://www.geeksforgeeks.org/problems/largest-subarray-with-0-sum/
 * 1?category%5B%5D=Hash&company%5B%5D=Amazon&page=1&query=category%5B%5DHashcompany
 * %5B%5DAmazonpage1company%5B%5DAmazoncategory%5B%5DHash&utm_source=youtube&utm_medium
 * =collab_striver_ytdescription&utm_campaign=largest-subarray-with-0-sum
 */

public class LargestSubarrayWith0sum {

    int maxLen(int arr[]) {
        int n = arr.length;

        int prefixSum = 0;

        int maxi = 0;

        HashMap<Integer, Integer> mp = new HashMap<>();

        for (int i = 0; i < n; i++) {
            prefixSum += arr[i];

            if (prefixSum == 0) {
                maxi = i + 1;
            }

            else {
                if (mp.containsKey(prefixSum)) {
                    int len = i - mp.get(prefixSum);

                    maxi = Math.max(maxi, len);
                }

                else {
                    mp.put(prefixSum, i);
                }
            }
        }

        return maxi;
    }
}