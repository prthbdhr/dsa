/**
 *  https://www.geeksforgeeks.org/problems/median-in-a-row-wise-sorted-matrix1527/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=median-in-a-row-wise-sorted-matrix
 */


public  class MedianInrow_wiseSortedMatrix {
    public int median(int mat[][]) {
        int n = mat.length;
        int m = mat[0].length;

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            low = Math.min(low, mat[i][0]);
            high = Math.max(high, mat[i][m - 1]);
        }

        int req = (m * n) / 2;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int smallEqual = countSmallEqual(mat, n, m, mid);

            if (smallEqual > req) high = mid - 1;

            else low = mid + 1;
        }

        return  low;
    }

    private int countSmallEqual (int[][] mat, int n, int m, int cap) {
        int count = 0;

        for (int i = 0; i < n; i++) {
            count += unBound(mat[i], cap, m);
        }

        return count;
    }

    private int unBound (int[] arr, int cap, int m) {
        int low = 0;
        int high = m - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] > cap) high = mid - 1;

            else low = mid + 1;
        }

        return low;
    }
}