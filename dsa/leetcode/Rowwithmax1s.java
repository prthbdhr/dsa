/**
 *  https://www.geeksforgeeks.org/problems/row-with-max-1s0023/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=row-with-max-1s
 */

public class Rowwithmax1s {

    public int rowWithMax1s(int arr[][]) {
        int n = arr.length;
        int m = arr[0].length;

        int countMax = 0;
        int index = -1;

        for (int i = 0; i < n; i++) {
            int countOnes = m - lowerBound(arr[i], m, 1);

            if (countOnes > countMax) {
                countMax = countOnes;
                index = i;
            }
        }

        return index;
    }

    private int lowerBound (int[] arr, int len, int cap) {
        int low = 0;
        int high = len - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] >= cap) high = mid - 1;

            else low = mid + 1;
        }

        return  low;
    }
}