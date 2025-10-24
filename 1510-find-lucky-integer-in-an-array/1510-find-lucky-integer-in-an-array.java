class Solution {
    public int findLucky(int[] arr) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int a: arr) map.put(a, map.getOrDefault(a, 0) + 1);

        int res = -1;

        for (int key: map.keySet()) {

            if (map.get(key) == key)  res = key;
        }

        return res;   
    }
}