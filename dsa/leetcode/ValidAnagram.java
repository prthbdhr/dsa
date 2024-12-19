/**
 *  #Leetcode 242 | https://leetcode.com/problems/valid-anagram/description/
 */

public class ValidAnagram {
//    public boolean isAnagram(String s, String t) {
//        int n = s.length();
//
//        if (n != t.length()) return false;
//
//        HashMap<Character, Integer> sMap = new HashMap<>();
//
//        for (int i = 0; i < n; i++) {
//            char sChar = s.charAt(i);
//
//            sMap.put(sChar, sMap.getOrDefault(sChar, 0) + 1);
//        }
//
//        for (char c : t.toCharArray()){
//            if (!sMap.containsKey(c) || sMap.get(c) == 0) return false;
//            sMap.put(c, sMap.getOrDefault(c, 0) - 1);
//        }
//
//        return true;
//    }
    public boolean isAnagram(String s, String t) {
        char[] sStr = s.toCharArray();
        char[] tStr = t.toCharArray();

        Arrays.sort(sStr);
        Arrays.sort(tStr);

        return Arrays.equals(sStr,tStr);
    }

}