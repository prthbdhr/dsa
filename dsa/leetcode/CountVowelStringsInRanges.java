/**
 *  #Leetcode 2559 | https://leetcode.com/problems/count-vowel-strings-in-ranges
 */

public class CountVowelStringsInRanges {
    private final String vowelString = "aeiou";

    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] res = new int[queries.length];

        int[] prefixSum = new int[words.length];

        prefixSum[0] = isVowel(words[0]) ? 1 : 0;

        for (int i = 1; i < words.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + (isVowel(words[i]) ? 1 : 0);
        }

        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];

            res[i] = prefixSum[end] - (start > 0 ? prefixSum[start - 1] : 0);
        }

        return res;
    }

    private boolean isVowel (String word) {
        return vowelString.indexOf(word.charAt(0)) != -1 && vowelString.indexOf(word.charAt(word.length() - 1)) != -1;
    }
}