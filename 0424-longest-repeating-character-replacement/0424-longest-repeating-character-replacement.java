class Solution {
    public int characterReplacement(String s, int k) {
        
        int[] frq = new int[26];

        int i = 0;
        int j = 0;

        int maxi = 0;

        int maxLen = 0;

        while (j < s.length()) {

            char ch = s.charAt(j);

            frq[ch - 'A']++;

            maxLen = Math.max(maxLen, frq[ch - 'A']);

            while (j - i + 1  - maxLen > k) {

                frq[s.charAt(i) - 'A']--;

                i++;
            }

            maxi = Math.max(maxi, j - i + 1);

            j++;
        }

        return maxi;
    }
}