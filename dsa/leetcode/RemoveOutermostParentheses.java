/**
 *  #Leetcode 1021 | https://leetcode.com/problems/remove-outermost-parentheses/description/
 */

public class RemoveOutermostParentheses {
    public String removeOuterParentheses(String s) {
        StringBuilder st = new StringBuilder();

        int opened = 0;

        for (char c : s.toCharArray()) {

            if (c == '(' && opened++ > 0) {
                st.append(c);
            }

            if (c == ')' && opened-- > 1) {
                st.append(c);
            }
        }

        return st.toString();
    }
}