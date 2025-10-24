/**
 *  https://www.geeksforgeeks.org/problems/infix-to-postfix-1587115620/1
 */

public class InfixToPostfix {

    public static String infixToPostfix(String s) {

        Stack<Character> st = new Stack<>();

        StringBuilder res = new StringBuilder();

        for (char ch: s.toCharArray()) {

            if (isOparend(ch)) res.append(ch);

            else if (ch == '(') st.push(ch);

            else if (ch == ')') {

                while (!st.isEmpty() && st.peek() != '(') res.append(st.pop());

                st.pop();
            }

            else {

                while (!st.isEmpty() && getPriority(ch) <= getPriority(st.peek())) res.append(st.pop());

                st.push(ch);
            }
        }

        while (!st.isEmpty()) res.append(st.pop());

        return res.toString();
    }

    static int getPriority(char ch) {

        if (ch == '^') return 3;

        else if (ch == '*' || ch == '/') return 2;

        else if (ch == '+' || ch == '-') return 1;

        return -1;
    }

    static boolean isOparend (char ch) {

        return Character.isLetterOrDigit(ch);
    }
}