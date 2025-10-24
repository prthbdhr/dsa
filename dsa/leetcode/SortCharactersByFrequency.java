/**
 *  #Leetcoe 451 | Sort Characters By Frequency
 */

public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put (c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Character> pq = new PriorityQueue<>( (x, y) -> map.get(y) - map.get(x));

        pq.addAll(map.keySet());

        StringBuilder res = new StringBuilder();

        while (!pq.isEmpty()) {
            char c = pq.poll();

            for (int i = 0; i < map.get(c); i++) {
                res.append(c);
            }
        }

        return res.toString();
    }
}