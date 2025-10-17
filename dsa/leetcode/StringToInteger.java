/**
 *  #Leetcode 8 | https://leetcode.com/problems/string-to-integer-atoi/description/
 */

public class StringToInteger {
    private final int MAX = Integer.MAX_VALUE;
    private final int MIN = Integer.MIN_VALUE;
    private final char Zero = '0';
    private final char Plus = '+';
    private final char Minus = '-';
    private final char WhiteSpace = ' ';

    public int myAtoi(String s) {
        if (s == null || s.isEmpty()) return 0;

        int n = s.length();

        int pos = 0;
        int res = 0;
        int sign = 1;


        while (pos < n && s.charAt(pos) == WhiteSpace) pos++;

        if (pos < n && (s.charAt(pos) == Minus || s.charAt(pos) == Plus) ) {
            sign = s.charAt(pos) == Minus ? -1 : 1;
            pos ++;
        }

        while (pos < n && Character.isDigit(s.charAt(pos))) {
            int digit = s.charAt(pos) - Zero;

            if (res > (MAX - digit) / 10) {
                return sign == 1 ? MAX : MIN;
            }

            res = res * 10 + digit;
            pos++;
        }

        return sign * res;
    }
}