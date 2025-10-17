
/**
 * Leetcode #1358 | https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/description/
 */

public class NumberofSubstringsContainingAllThreeCharacters {

    public int numberOfSubstrings(String s) {
        int res = 0;
        int left = 0;
        int right = 0;
        int[] lastIndex = new int[]{-1, -1, -1};
        int n = s.length();

        while (right < n){

            lastIndex[s.charAt(right) - 'a'] = right;

            if (lastIndex[0] != -1 && lastIndex[1] != -1 && lastIndex[2] != -1){
                int minIndex = Math.min(lastIndex[0],
                        Math.min(lastIndex[1], lastIndex[2])
                        );

                res += minIndex + 1;
            }

            right++;
        }

        return  res;
    }
}
