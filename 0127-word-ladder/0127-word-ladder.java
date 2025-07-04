class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Queue<Pair> qu = new LinkedList<>();

        qu.add(new Pair(beginWord, 1));

        Set<String> st = new HashSet<>();

        int len = wordList.size();

        for (String word: wordList) st.add(word);

        st.remove(beginWord);

        while (!qu.isEmpty()) {

            Pair pair = qu.poll();
            String word = pair.word;
            int steps = pair.steps;

            if (word.equals(endWord)) return steps;

            for (int i = 0; i < word.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {

                    char[] wordArray = word.toCharArray();

                    wordArray[i] = ch;

                    String replacedWord = new String(wordArray);

                    if (st.contains(replacedWord)) {
                        st.remove(replacedWord);
                        qu.add(new Pair(replacedWord, steps + 1));
                    }
                }
            }
        }

        return 0;
    }
}

class Pair {

    public String word;
    public int steps;

    public Pair(String word, int steps) {
        this.word = word;
        this.steps = steps;
    }
}