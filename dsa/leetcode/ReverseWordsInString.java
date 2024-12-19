/**
 *  #Leetcode 151 | https://leetcode.com/problems/reverse-words-in-a-string/description/
 */

public  class ReverseWordsInString {
    public String reverseWords(String s) {
        String[] str = s.trim().split("\\s+");

        String res = "";

        for (int i = str.length; i > 0; i--) {
            res += str[i] + "";
        }

        return res + str[0];
    }
}