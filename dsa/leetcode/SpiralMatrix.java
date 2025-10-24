import java.util.ArrayList;
import java.util.List;

/**
 * #Leetcode 54 | https://leetcode.com/problems/spiral-matrix/
 */

public class SpiralMatrix {
    
    public List<Integer> spiralOrder(int[][] matrix) {

        int n = matrix.length;

        int m = matrix[0].length;

        List<Integer> res = new ArrayList<>();

        int top = 0, left = 0;
        int bottom = n - 1, right = m - 1;

        while (top <= bottom && left <= right) {

            //top row
            for (int j = left; j <= right; j++) res.add(matrix[top][j]);

            top++;

            //right col
            for (int i = top; i <= bottom; i++) res.add(matrix[i][right]);

            right--;

            // bottom row
            if (top <= bottom) {
                for (int j = right; j >= left; j--) res.add(matrix[bottom][j]);

                bottom--;
            }

            // left col
            if (left <= right) {
                for (int i = bottom; i >= top; i--) res.add(matrix[i][left]);  

                left++;
            }
        }

        return res;
    }
}
