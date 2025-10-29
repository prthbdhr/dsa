/*
 * #LeetCode 2965 | https://leetcode.com/problems/find-missing-and-repeated-values/
 *
 * Algorithm:
 * 1. Calculate the sum and square sum of all numbers in the grid.
 * 2. Compute the expected sum and square sum for numbers from 1 to n^2.
 * 3. Use the equations:
 *    - sumDiff = sum - expectedSum (repeated - missing)
 *    - sqrDiff = sqrSum - expectedSquareSum (repeated^2 - missing^2)
 *    - Solve for repeated and missing:
 *      - repeated = (sqrDiff / sumDiff + sumDiff) / 2
 *      - missing = (sqrDiff / sumDiff - sumDiff) / 2
 * 4. Return the result as [repeated, missing].
 *
 * Diagram:
 * Let grid = [[1, 2], [2, 4]]
 * Total numbers = 4 (1 to 4)
 * ExpectedSum = 10, ExpectedSquareSum = 30
 * ActualSum = 9, ActualSquareSum = 25
 * sumDiff = 9 - 10 = -1 (repeated - missing)
 * sqrDiff = 25 - 30 = -5 (repeated^2 - missing^2)
 * repeated = (-5 / -1 + -1) / 2 = 2
 * missing = (-5 / -1 - -1) / 2 = 3
 */

public class FindMissingandRepeatedValues {
    
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        
        long sum = 0;
        long sqrSum = 0;

        long n = grid.length;

        long total = n * n;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                sum += grid[i][j];

                sqrSum += (long) grid[i][j] * grid[i][j];
            }
        }

        long sumDiff = sum - (total * (total + 1)) / 2; // repeated - missing
        long sqrDiff = sqrSum - (total * (total + 1) * (2 * total + 1)) / 6; // repeated^2 - missing^2

        int repeat = (int) ((sqrDiff / sumDiff + sumDiff) / 2); // repeated
        int missing = (int) ((sqrDiff / sumDiff - sumDiff) / 2); // missing

        return new int[] {repeat, missing};
    }
}
