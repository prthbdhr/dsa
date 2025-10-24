

/**
 * Leetcode #1423 | https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/description/
 */

public class MaximumPointsYouCanObtainfromCards {

    public int maxScore(int[] cardPoints, int k) {
        int leftSum = 0;
        int rightSum = 0;

        int len = cardPoints.length;

        for (int i = 0; i < k; i++) leftSum += cardPoints[i];

        int maxSum = leftSum;

        int rightIndex = len - 1;

        for (int i = k - 1; i >= 0; i--) {
            leftSum -= cardPoints[i];
            rightSum += cardPoints[rightIndex--];

            maxSum = Math.max(maxSum, (leftSum + rightSum));
        }

        return  maxSum;
    }
}
