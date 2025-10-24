/**
 *  #Leetcode 73 | https://leetcode.com/problems/set-matrix-zeroes/
 */

public class SetMatrixZeroes {
    
    public void setZeroes(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;

        int col0 = 1; // to track first column

        // mark zeros in first row and col
        for (int i = 0; i < n; i++) {
            
            for (int j = 0; j < m; j++) {
                
                if (matrix[i][j] == 0) {
                    
                    matrix[i][0] = 0;

                    if (j != 0) matrix[0][j] = 0;

                    else col0 = 0;
                }
            }
        }

        // traverse from 1,1 to end
        for (int i = 1; i < n; i++) {
            
            for (int j = 1; j < m; j++) {
                
                if (matrix[i][j] != 0) {

                    if (matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
                }
            }
        }

        // first row
        if (matrix[0][0] == 0) {

            for (int j = 0; j < m; j++) matrix[0][j] = 0;
        }

        // first col
        if (col0 == 0) {

            for (int i = 0; i < n; i++) matrix[i][0] = 0;
        }

        return;              
    }
}
