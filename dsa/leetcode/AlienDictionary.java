package dsa.leetcode;

// https://www.geeksforgeeks.org/problems/alien-dictionary/1

import java.util.*;

public class AlienDictionary {
    
    public String findOrder(String[] words) {

        if (words == null || words.length == 0) return "";

        // Build the graph
        Map<Character, Set<Character>> graph = buildGraph(words);

        if (graph == null) return ""; // invalid dictionary

        // calculate in-degrees
        Map<Character, Integer> indegree = calculateInDegrees(graph);

        // Topological Sort using Kahn's Algorithm
        return topologicalOrder(graph, indegree);
    }

    // Helper method to build the graph from the list of words
    private Map<Character, Set<Character>> buildGraph(String[] words) {

        Map<Character, Set<Character>> graph = new HashMap<>();

        // add all unique characters to the graph
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new HashSet<>());
            }
        }

        // Add edges based on the order of characters in adjacent words
        for (int i = 0; i < words.length - 1; i++) {

            if (!addEdgesFromWords(words[i], words[i + 1], graph)) {
                return null; // invalid dictionary
            }
        }
        
        return graph;
    }

    // Helper method to add edges from two adjacent words
    private boolean addEdgesFromWords(String word1, String word2, Map<Character, Set <Character>> graph) {

        int minLen = Math.min(word1.length(), word2.length());

        for (int i = 0; i < minLen; i++) {

            char c1 = word1.charAt(i);
            char c2 = word2.charAt(i);

            if (c1 != c2) {
                graph.get(c1).add(c2); // add edge c1 -> c2
                return true;
            }
        }

        // check if word1 is longer than word2 and is a prefix
        // because that would be invalid
        // how this is invalid: ["abc", "ab"]
        // how this is valid: ["ab", "abc"]
        // why this works: because in a valid alien dictionary, a prefix word should come before the longer word,
        // because the prefix word would define the order of characters first
        return word1.length() <= word2.length(); // checked  for invalid case
    }

    // Helper method to calculate in-degrees of each node
    private Map<Character, Integer> calculateInDegrees (Map<Character, Set<Character>> graph) {
        
        Map<Character, Integer> inDegree = new HashMap<>();

        // initialize in-degrees to 0
        for (char c : graph.keySet()) inDegree.put(c, 0);

        // calculate in-degrees
        for (char c : graph.keySet()) {
            for (char neighbor : graph.get(c)) inDegree.put(neighbor, inDegree.get(neighbor) + 1);
        }
        
        return inDegree;
    }

    private String topologicalOrder(Map<Character, Set<Character>> graph, Map<Character,Integer> indegree) {

        Queue<Character> qu = getZeroIndegreeNodes(indegree);

        StringBuilder res = new StringBuilder();

        while (!qu.isEmpty()) {

            char ch = qu.poll();

            res.append(ch);

            for (char it: graph.get(ch)) {
            
                indegree.put(it, indegree.get(it) - 1);

                if (indegree.get(it) == 0) qu.offer(it);
            }
        }

        // if the length of the result is not equal to the number of unique characters,
        // it means there was a cycle in the graph, hence return ""

        return res.length() == graph.size() ? res.toString() : "";
    }

    private Queue<Character> getZeroIndegreeNodes (Map<Character,Integer> indegree) {

        Queue<Character> qu = new LinkedList<>();

        // add all nodes with in-degree 0 to the queue
        for (char c : indegree.keySet()) {
            if (indegree.get(c) == 0) qu.offer(c);
        }

        return qu;
    }
}
