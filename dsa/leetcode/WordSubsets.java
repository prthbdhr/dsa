/**
 * #Leetcode 916 | https://leetcode.com/problems/word-subsets
 */

public  class WordSubsets {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] words2Max = count("");

        for (String w2: words1) {
            int[] w2Count = count(w2);

            for (int i = 0; i < 26; i++) {
                words2Max[i] = Math.max(words2Max[i], w2Count[i]);
            }
        }

        List< String > ans = new ArrayList<>();

        search: for (String w1: words1) {
            int[] w1Count = count(w1);

            for (int i = 0; i < 26; i++) {
                if (words2Max[i] > w1Count[i]) {
                    continue search;
                }
            }

            ans.add(w1);
        }

        return ans;
    }

    private int[] count (String s) {
        int[] ans = new int[26];

        for (char c: s.toCharArray()) {
            ans[c - 'a']++;
        }

        return ans;
    }
}