/*
 *  #LeetCode 3461 | https://leetcode.com/problems/check-if-digits-are-equal-in-string-after-operations-i
 */

public class CheckIfDigitsAreEqualStringAfterOperationsOne {

    public boolean hasSameDigits(String s) {

        int n = s.length();

        char[] sArray = s.toCharArray();

        for (int i = 0; i <= n - 2; i++) {

            for (int j = 1; j <= n - 1 - i; j++) {

                int dig1 = sArray[j] - '0';
                int dig2 = sArray[j + 1] - '0';

                sArray[j] = (char) (((dig1 + dig2) % 10) + '0');
            }
        }

        return sArray[0] == sArray[1];
    }
    
}
