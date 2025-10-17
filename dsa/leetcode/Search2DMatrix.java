/**
 * #Leetcode74 | https://leetcode.com/problems/search-a-2d-matrix/
 */


public class Search2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            int low = 0, high = m - 1;

            while (low <= high) {
                int mid = low + (high - low);

                if (matrix[i][mid] == target) return true;

                if (matrix[i][mid] < target) low = mid + 1;

                else high = mid - 1;
            }
        }

        return false;
    }
}