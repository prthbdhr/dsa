/*
 *   https://www.geeksforgeeks.org/problems/inversion-of-array-1587115620/
 * 1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign
 * =inversion-of-array
 */

public class CountInversions {

    static int inversionCount(int arr[]) {
        return mergeSort(arr, 0, arr.length - 1);
    }

    static int mergeSort(int[] arr, int low, int high) {
        int cnt = 0;

        if (low >= high) return cnt;

        int mid = (low + high) / 2;

        cnt += mergeSort(arr, low, mid);
        cnt += mergeSort(arr, mid + 1, high);
        cnt += merge(arr, low, mid, high);

        return cnt;
    }

    static int merge (int[] arr, int left, int mid, int high) {
        int cnt = 0;

        ArrayList<Integer> temp = new ArrayList<>();

        int i = left;
        int j = mid + 1;

        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j]) {
                temp.add(arr[i]);
                i++;
            }

            else {
                cnt += mid - i + 1;
                temp.add(arr[j]);
                j++;
            }
        }

        while (i <= mid) {
            temp.add(arr[i]);
            i++;
        }

        while (j <= high) {
            temp.add(arr[j]);
            j++;
        }

        for (int k = left; k <= high; k++) {
            arr[k] = temp.get(k - left);
        }

        return  cnt;
    }
}