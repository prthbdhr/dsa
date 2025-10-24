package dsa;
/*
* https://www.geeksforgeeks.org/problems/minimum-window-subsequence/0
 */

public class MinimumWindowSubstring {

    public String minWindow(String s, String t){
        int n = s.length();
        int m = t.length();

        int left = 0;
        int right = 0;
        int sIndex = -1;
        int minLen = (int) 1e9;
        int count = 0;

        int[] charMap = new int[256];

        for (int i = 0; i < m; i++) charMap[t.charAt(i)]++;

        while (right < n) {
            int rightChar = s.charAt(right);

            if (charMap[rightChar] > 0) count++;

            charMap[rightChar]--;

            while (count == m) {
                int leftChar = s.charAt(left);
                int len = right - left + 1;

                if(len < minLen) {
                    minLen = len;
                    sIndex = left;
                }

                charMap[leftChar]++;

                if (charMap[leftChar] > 0) count--;

                left++;
            }

            right++;
        }

        return sIndex == -1 ? "" : s.substring(sIndex, sIndex + minLen);
    }
}
