/**
 *  #Leetcode 1422 | https://leetcode.com/problems/maximum-score-after-splitting-a-string
 */

public class MaximumScoreAfterSplittingString {
    private final char ZERO = '0';
    private final char ONE = '1';

    public int maxScore(String s) {
        int n = s.length();

        int zeros = 0;
        int ones = 0;

        for (char c : s.toCharArray()) {
            if (c == ONE) {
                ones++;
            }
        }

        int res = 0;

        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == ZERO) {
                zeros++;
            }

            else {
                ones--;
            }

            res = Math.max(res, (zeros + ones));
        }

        return res;
    }
}