/**
 *  #Leetcode 28 | https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/
 */

public class FindIndexOfFirstOccurrenceInString {

    public int strStr(String haystack, String needle) {
        int left = 0;
        int right = needle.length();

        while (right <= haystack.length()) {
            if (needle.equals(haystack.substring(left, right))) {
                return left;
            }

            left++;
            right++;
        }

        return -1;
    }
}