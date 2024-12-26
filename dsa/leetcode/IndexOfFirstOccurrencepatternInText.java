/**
 *  https://www.geeksforgeeks.org/problems/index-of-the-first-occurrence-of-pattern-in-a-text/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=index-of-the-first-occurrence-of-pattern-in-a-text%2F
 */

public class IndexOfFirstOccurrencepatternInText{
    public int findMatching(String text, String pat) {
        if (text == null || pat == null || pat.length() > text.length()) {
            return -1;
        }

        int textLen = text.length();
        int patLen = pat.length();

        for (int i = 0; i <= (textLen - patLen); i++) {
            boolean isMatched = true;

            for (int j = 0; j < patLen; j++) {
                if (text.charAt(i + j) != pat.charAt(j)) {
                    isMatched = false;
                    break;
                }
            }

            if (isMatched) {
                return i;
            }
        }

        return -1;
    }
}