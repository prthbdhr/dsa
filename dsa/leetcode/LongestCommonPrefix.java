/**
 *  #Leetcode 19 | https://leetcode.com/problems/longest-common-prefix/
 */

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;

        if (strs == null || n == 0) return "";

        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[n - 1];

        int c = 0;

        while (c < first.length()) {

            if (first.charAt(c) != last.charAt(c)) break;

            c++;
        }

        return c == 0 ? "" : first.substring(0, c);
    }
}