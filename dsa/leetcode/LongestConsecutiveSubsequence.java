import java.util.HashSet;
import java.util.Set;

/**
 *  #GFG | https://www.geeksforgeeks.org/problems/longest-consecutive-subsequence2449/1
 */

public class LongestConsecutiveSubsequence {
    
    public int longestConsecutive(int[] arr) {

        int n = arr.length;

        if (n == 0)return 0;

        Set<Integer> numSet = new HashSet<>();

        int longest = 0;

        for (int a : arr) numSet.add(a);

        for (int a: numSet) {

            if (!numSet.contains(a - 1)) {

                int cnt = 1;

                int currentNum = a;

                while (numSet.contains(currentNum + 1)) {

                    cnt++;

                    currentNum++;
                }
                longest = Math.max(longest, cnt);
            }
        }

        return longest;
        
    }
}
