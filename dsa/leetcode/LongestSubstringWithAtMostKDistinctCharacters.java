


public class LongestSubstringWithAtMostKDistinctCharacters {

    public static int findLongestAtDisK(String s, int k){
        int n = s.length();
        int left = 0;
        int right = 0;
        int maxLen = 0;
        HashMap<Character, Integer> charMap = new HashMap<>();

        while (right < n){
            char rightChar = s.charAt(right);
            charMap.put(rightChar, charMap.getOrDefault(rightChar,0) + 1);

            if (charMap.size() > k){
                char leftChar = s.chaAt(left);
                charMap.Put(leftChar, charMap.get(leftChar) - 1);

                if (charMap.get(leftChar) == 0) charMap.remove(leftChar);

                left++;
            }

            if (charMap.size() <= k){
                int len = right - left + 1;
                maxLen = Math.max(maxLen, len);
            }

            right++;
        }

        return maxLen;
    }
}