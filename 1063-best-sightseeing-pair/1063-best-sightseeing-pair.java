class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;

        int maxScore = Integer.MIN_VALUE;

        int maxLeft = values[0];

        for (int i = 1; i < n; i++) {
            int curRight = values[i] - i;

            maxScore = Math.max(maxScore, (curRight + maxLeft));

            int curLeft = values[i] + i;
            
            maxLeft = Math.max(maxLeft, curLeft);
        }
        
        return maxScore;
    }
}