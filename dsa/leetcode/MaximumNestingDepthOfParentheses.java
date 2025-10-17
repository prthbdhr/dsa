/**
 *  #Leetcode 1614 | https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/description/
 */

public class MaximumNestingDepthOfParentheses {
    public int maxDepth(String s) {
        int ans = 0;
        int opened = 0;

        for (char c : s.toCharArray()) {
            opened += (c == '(') ? 1 : 0;
            opened -= (c == ')') ? 1 : 0;

            ans = Math.max(ans, opened);
        }

        return ans;
    }
}