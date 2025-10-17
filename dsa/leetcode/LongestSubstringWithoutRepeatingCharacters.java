
/** 
* Leetcode #3 | https://leetcode.com/problems/longest-substring-without-repeating-characters/
*/
import javax.imageio.ImageTranscoder;
import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lenghtOfLongestSubstring(String s){
        int n = s.length();

        if(n == 0) return 0;

        int left = 0;
        int right = 0;
        int maxLen = 0;

        HashMap<Character, Integer> charMap = new HashMap<>();

        while (right < n){
            char rightChar = s.charAt(right);

            if (charMap.containsKey(rightChar)) left = Math.max((charMap.get(rightChar) + 1), left);

            charMap.put(rightChar, right);

            int len = right - left + 1;
            maxLen = Math.max(maxLen, len);
            right++;
        }

        return maxLen;
    }
}
