
/**
* Leetcode #904 | https://leetcode.com/problems/fruit-into-baskets/description
*/
import java.util.HashMap;

public class FruitIntoBaskets {
    private final int k = 2;
    public int totalFruit(int[] fruits){
        int left = 0;
        int right = 0;
        int maxLen = 0;

        HashMap<Integer, Integer> fruitsMap = new HashMap<>();

        while(right < fruits.length){
            int rightFruit = fruits[right];
            fruitsMap.put(rightFruit, fruitsMap.getOrDefault(right, 0) + 1);

            while (fruitsMap.size() > k){
                int leftFruit = fruits[left];
                fruitsMap.put(leftFruit, (fruitsMap.get(leftFruit) - 1));

                if (fruitsMap.get(leftFruit) == 0)fruitsMap.remove(leftFruit);

                left++;
            }

            int subLen = right - left + 1;
            maxLen = Math.max(maxLen, subLen);

            right++;
        }

        return maxLen;
    }
}
