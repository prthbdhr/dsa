
/**
 *  #Leetcode1901 | https://leetcode.com/problems/find-a-peak-element-ii/
 */

public class FindPeakElement_II {

    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int low = 0;
        int high = m - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int maxRow = findPeakCol(mat, n, mid);

            int left = (mid - 1) >= 0 ? mat[maxRow][mid - 1] : -1;
            int right = (mid + 1) < m ? mat[maxRow][mid + 1] : -1;

            int peakVal = mat[maxRow][mid];

            if (peakVal > left && peakVal > right) return new int[]{maxRow, mid};

            if (left > peakVal) high = mid - 1;

            else low = mid + 1;
        }

        return new int[]{-1, -1};
    }

    private int findPeakCol(int[][] mat, int rows, int col) {
        int maxVal = Integer.MIN_VALUE;
        int maxIndex = -1;

        for (int i = 0; i < rows; i++) {

            if (mat[i][col] > maxVal) {
                maxVal = mat[i][col];
                maxIndex = i;
            }
        }

        return maxIndex;
    }
}