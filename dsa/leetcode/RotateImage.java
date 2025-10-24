package dsa.leetcode;
/**
 *  #Leetcode 48 | https://leetcode.com/problems/rotate-image/
 */


public class RotateImage {

    public void rotate(int[][] matrix) {

        int n = matrix.length;

        int m = matrix[0].length;

        // transpose matrix
        for (int i = 0; i < n; i++) {
            
            for (int j = 0; j < m; j++) {
                
                if (i < j) {
                    
                    matrix[i][j] ^= matrix[j][i];
                    matrix[j][i] ^= matrix[i][j];
                    matrix[i][j] ^= matrix[j][i];
                }
            }
        }

        // reverse each row
        for (int i = 0; i < n; i++) {
            
            for (int j = 0; j < m / 2; j++) {

                matrix[i][j] ^= matrix[i][m - j - 1];
                matrix[i][m - j - 1] ^= matrix[i][j];
                matrix[i][j] ^= matrix[i][m - j - 1];
            }
        }
    }  
}
