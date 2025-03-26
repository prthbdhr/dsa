/**
 *  https://www.geeksforgeeks.org/problems/the-celebrity-problem/1
 */

public class TheCelebrityProblem {

    public int celebrity(int mat[][]) {

        int n = mat.length;

        int top = 0;
        int down = n - 1;

        while (top < down) {

            if (mat[top][down] == 1) top++;

            else if (mat[down][top] == 1) down--;

            else {

                top++;
                down--;
            }
        }

        if (top > down) return -1;

        for (int i = 0; i < n; i++) {

            if (i == top) continue;

            if (mat[top][i] == 1 || mat[i][down] == 0) return -1;
        }

        return top;
    }
}