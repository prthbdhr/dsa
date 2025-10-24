/**
 *  https://www.geeksforgeeks.org/problems/count-number-of-substrings4528/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=count-number-of-substrings
 */

public class SubstringsWithKDistinct {
    public int countSubstr(String s, int k) {
        return atMost(s, k) - atMost(s, k - 1);
    }

    private int atMost (String s, int k) {
        int n = s.length();
        int i = 0, j = 0;
        int res = 0;

        Map<Character, Integer> map = new HashMap<>();

        while (j < n) {
            char ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            while (map.size() > k) {
                char startChar = s.charAt(i);

                map.put(startChar, map.get(startChar) - 1);

                if (map.get(startChar) == 0) {
                    map.remove(startChar);
                }

                i++;
            }

            res += j - i + 1;

            j++;
        }

        return res;
    }
}