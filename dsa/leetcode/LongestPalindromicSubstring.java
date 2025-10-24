/**
 *  #Leetcode 5 | https://leetcode.com/problems/longest-palindromic-substring/description/
 */

public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        int n = s.length();

        if (n < 2 || s == null) {
            return s;
        }

        int start = 0;
        int end = 0;

        for (int i = 0; i < n; i++) {
            int oddLen = expandByMid(s, i, i, n); // as odd lengther substring mid is same and 1
            int evenLen = expandByMid(s, i, i + 1, n); // as even substring mid is diff

            int maxLen = Math.max(oddLen, evenLen);

            if (maxLen > (end - start)) {
                start = i - (maxLen - 1) / 2;
                end = i + (maxLen / 2);
            }
        }

        return s.substring(start, end + 1);
    }

    private int expandByMid (String s, int left, int right, int n) {
        while ( left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
        }

        return right - left - 1;
    }
}