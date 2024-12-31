/**
 *  #Leetcode 983 | https://leetcode.com/problems/minimum-cost-for-tickets/
 */

public class MinimumCostForTickets {
    private int dLen;
    private int cLen;

    public int mincostTickets(int[] days, int[] costs) {
        dLen = days.length;
        cLen = costs.length;

        Map<Integer, Integer> memo = new HashMap<>();

        return dfs(0, dLen,cLen, days, costs, memo);

    }

    private int dfs (int i, int dLen, int cLen, int[] days, int[] costs, Map<Integer, Integer> memo) {
        if (i == dLen) {
            return 0; // last day no cost needed
        }

        if (memo.containsKey(i)) {
            return memo.get(i); // return already counted cost for day i
        }

        int cost = Integer.MAX_VALUE;
        int j = i;

        for (int k = 0; k < cLen; k++) {
            int duration = (k == 0) ? 1 : (k == 1) ? 7 : 30;

            while (j < dLen && days[j] < days[i] + duration) {
                j++; // move to the next day where the tockrts no longer valid
            }

            // recursively calculatre the cost from index j
            cost = Math.min(cost, (costs[k] + dfs(j, dLen, cLen, days, costs, memo)));
        }

        memo.put(i, cost); // memorise the result of index i

        return cost;
    }
}