public class BestTimetoBuyandSellStock {
    
    public int maxProfit(int[] nums) {

        int n = nums.length;

        int i = 0, j = 1;

        int maxProfit = 0;

        while (i < n - 1 && j < n) {

            int profit = nums[j] - nums[i];

            maxProfit = Math.max(maxProfit, profit);

            if (profit < 0) i = j;

            j++;

        } 

        return maxProfit;
    }
}
