
/**
 *  https://www.naukri.com/code360/problems/implement-trie_1387095?utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_tries_videos
 */

public class ImplementTriePrefixTree{
    private  TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;

        for (char ch : word.toCharArray()) {

            if (!node.containsKey(ch)) {
                node.put(ch, new TrieNode());
            }

            node = node.get(ch);

            node.increasePrefix();
        }

        node.increaseEnds();
    }

    public int countWordsEqualTo(String word) {
        TrieNode node = root;

        for (char ch : word.toCharArray()) {

            if (!node.containsKey(ch)) {
                return 0;
            }

            node = node.get(ch);
        }

        return node.getcountEndsWith();
    }

    public int countWordsStartingWith(String word) {
        TrieNode node = root;

        for (char ch : word.toCharArray()) {

            if (!node.containsKey(ch)) {
                return 0;
            }

            node = node.get(ch);
        }

        return node.getCountPrefix();
    }

    public void erase(String word) {
        TrieNode node = root;

        for (char ch : word.toCharArray()) {

            if (!node.containsKey(ch)) {
                return;
            }

            node = node.get(ch);

            node.reducePrefix();
        }

        node.deleteEnd();
    }

    static class TrieNode {
        private  final  TrieNode[] links = new TrieNode[26];
        private int countEndsWith;
        private  int countPrefix;
        private final char a = 'a';

        public TrieNode () {
            countPrefix = 0;
            countEndsWith = 0;
        }

        public boolean containsKey (char ch) {
            return links[ch - a] != null;
        }

        public TrieNode get (char ch) {
            return links[ch - a];
        }

        public void put (char ch, TrieNode node) {
            links[ch  - a] = node;
        }

        public void increaseEnds () {
            countEndsWith++;
        }

        public void  increasePrefix () {
            countPrefix++;
        }

        public  void reducePrefix () {
            countPrefix--;
        }

        public void deleteEnd () {
            countEndsWith--;
        }

        public int getcountEndsWith () {
            return countEndsWith;
        }

        public int getCountPrefix () {
            return countPrefix;
        }
    }
}