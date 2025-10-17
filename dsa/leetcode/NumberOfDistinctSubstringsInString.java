/**
 *  https://www.naukri.com/code360/problems/count-distinct-substrings_985292?utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_tries_videos
 */

//  problem clss
public class NumberOfDistinctSubstringsInString {
    public static int countDistinctSubstrings(String s) {
        int n = s.length();
        TrieNode root = new TrieNode();
        int count = 0;

        for (int i = 0; i < n; i++) {
            TrieNode node = root;

            for (int j = i; j < n; j++) {
                char ch = s.charAt(j);

                if (!node.containsKey(ch)) {
                    node.put(ch, new TrieNode());

                    count++;
                }

                node = node.get(ch);
            }
        }

        return ++count;
    }
}

// TrieNode class
public class TrieNode {
    private final TrieNode[] links = new TrieNode[26];
    private boolean flag = false;
    private final char a = 'a';

    public boolean containsKey (char ch) {
        return links[ch - a] =! null;
    }

    public void put (char ch, TrieNode node) {
        links[ch - a] = node;
    }

    public TrieNode get (char ch) {
        return links[ch - a];
    }

    public boolean isEnd() {
        return flag;
    }

    public void setEnd () {
        flag = true;
    }
}