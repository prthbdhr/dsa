package dsa;

/**
 *  #Leetcode 727 | leetcode.com/problems/minimum-window-subsequence/description ( premium )
 *  https://www.geeksforgeeks.org/problems/minimum-window-subsequence/1 ( free )
 */
public class MinimumWindowSubsequence {

    static String minWindow(String s1, String s2) {
        String minWindow = "";

        int n = s1.length();
        int m = s2.length();

        int s1Index = 0;
        int s2Index = 0;

        int minLen = (int) (1e9);

        for ( ; s1Index < n; s1Index++) {

            if(s1.charAt(s1Index) == s2.charAt(s2Index)) {

                s2Index++;

                if(s2Index == m) {

                    int endIndex = s1Index + 1;

                    s2Index--;

                    while (s2Index >= 0) {

                        if (s1.charAt(s1Index) == s2.charAt(s2Index)) s2Index--;

                        s1Index--;
                    }

                    s1Index++;
                    s2Index++;

                    int currentWindowLen = endIndex - s1Index;

                    if (currentWindowLen < minLen) {

                        minLen = currentWindowLen;

                        minWindow = s1.substring(s1Index, endIndex); // s1Index = endIndex - currentWindowLen
                    }
                }
            }
        }

        return minWindow;
    }
}
