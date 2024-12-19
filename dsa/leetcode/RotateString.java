/**
 *  #Leetcode 796 | https://leetcode.com/problems/rotate-string/description/
 */

public class RotateString {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return  false;

//        return (s + s).contains(goal);

        int n = s.length();

        for (int i = 0; i < n; i++) {

            if (s.substring(i) + s.substring(0, i).equals(goal)) return true;
        }

        return false;
    }
}