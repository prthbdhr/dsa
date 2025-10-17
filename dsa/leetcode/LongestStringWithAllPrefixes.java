/**
 * Finds the longest string such that all its prefixes are present in the Trie.
 */

public class LongestStringWithAllPrefixes {
    public static String completeString(int n, String[] a) {
        Trie trie = new Trie();

        // Insert all words into the Trie
        for (String word : a) {
            trie.insert(word);
        }

        String longest = "None"; // Default return value if no valid string is found

        // Check each word to see if it qualifies as a complete string
        for (String w : a) {
            if (trie.isCompleteString(w)) {
                if (
                        longest.equals("None") || // First valid string
                                longest.length() < w.length() || // Longer string
                                (longest.length() == w.length() && w.compareTo(longest) < 0) // Lexicographically smaller
                ) {
                    longest = w;
                }
            }
        }

        return longest;
    }
}

// Trie class for storing words and checking prefixes
class Trie {
    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Insert a word into the Trie
    public void insert(String word) {
        TrieNode node = root;

        for (char w : word.toCharArray()) {
            if (!node.containsKey(w)) {
                node.put(w, new TrieNode());
            }
            node = node.get(w);
        }

        node.setEnd(); // Mark the end of the word
    }

    // Check if a word is a complete string
    public boolean isCompleteString(String word) {
        TrieNode node = root;

        for (char w : word.toCharArray()) {
            if (!node.containsKey(w)) { // Prefix does not exist
                return false;
            }

            node = node.get(w);

            if (!node.isEnd()) { // Prefix is not a valid end of a word
                return false;
            }
        }

        return true; // All prefixes exist and are valid
    }
}

// TrieNode class representing each node in the Trie
class TrieNode {
    private final TrieNode[] links = new TrieNode[26];
    private boolean isEnd = false;

    // Check if a character is a valid key in this node
    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    // Retrieve the child node corresponding to a character
    public TrieNode get(char ch) {
        return links[ch - 'a'];
    }

    // Add a new child node for a character
    public void put(char ch, TrieNode node) {
        links[ch - 'a'] = node;
    }

    // Mark this node as the end of a word
    public void setEnd() {
        isEnd = true;
    }

    // Check if this node is the end of a word
    public boolean isEnd() {
        return isEnd;
    }
}
