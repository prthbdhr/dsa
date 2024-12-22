/**
 *  #Leetcode 1781 | Sum of Beauty of All Substrings
 */

public class SumBeautyOfAllSubstrings {
    private final char a = 'a';

    public int beautySum(String s) {
        int n = s.length();
        int totalBeauty = 0;

        for (int i = 0; i < n; i++) {
            TreeMap<Integer, Integer> freqMap = new TreeMap<>();
            int[] freq = new int[26];

            for (int j = i; j < n; j++) { // Start from `i` and iterate till the end of the string
                char ch = s.charAt(j);
                int ind = ch - a;

                // Update `freqMap` for the old frequency
                if (freq[ind] > 0) {
                    int oldFreq = freq[ind];
                    freqMap.put(oldFreq, freqMap.get(oldFreq) - 1);
                    if (freqMap.get(oldFreq) == 0) {
                        freqMap.remove(oldFreq);
                    }
                }

                // Increment frequency and update `freqMap`
                freq[ind]++;
                int newFreq = freq[ind];
                freqMap.put(newFreq, freqMap.getOrDefault(newFreq, 0) + 1);

                // Calculate beauty for the current substring
                int maxFreq = freqMap.lastKey(); // Highest frequency
                int minFreq = freqMap.firstKey(); // Lowest frequency
                totalBeauty += (maxFreq - minFreq);
            }
        }

        return totalBeauty;
    }
}