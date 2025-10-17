/**
 *  #Leetcode 1903 | https://leetcode.com/problems/largest-odd-number-in-string/description/
 */

public class LargestOddNumberString {
    public String largestOddNumber(String num) {
        int n = num.length();

        if ((int) num.charAt(n - 1) % 2 == 1) return num;

        int i = n - 1;

        while (i >= 0) {
            int val = (int) num.charAt(i);

            if (val % 2 == 1) return num.substring(0, i + 1);

            i--;
        }

        return  "";
    }
}