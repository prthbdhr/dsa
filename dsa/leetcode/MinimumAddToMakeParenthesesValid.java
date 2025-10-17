/**
 *  #Leetcode 921 | https://leetcode.com/problems/minimum-add-to-make-parentheses-valid
 */

public class MinimumAddToMakeParenthesesValid {

    public int minAddToMakeValid(String s) {
        int stack = 0;
        int moves = 0;

        for (char ch: s.toCharArray()) {
            if (c == '(') {
                stack++;
            } else {
                if (stack == 0) {
                    moves++;
                } else {
                    stack--;
                }
            }
        }

        return stack + moves;
    }
}