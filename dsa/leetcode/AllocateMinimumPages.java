/**
 *  https://www.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=practice_card
 */

public class AllocateMinimumPages {

    public int findPages(int[] arr, int k) {
        int n = arr.length;

        if (n < k) return -1;

        int low = Arryas.stream(arr).max().getAsInt();
        int high = Arrays.stream(arr).sum();

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int numsOfStudents = countStudents(arr, mid);

            if (numsOfStudents <= k) high = mid -1;

            else low = mid + 1;
        }

        return low;
    }

    private int countStudents(int[] arr, int allowed) {
        int students = 1, bookAssigned = 0;

        for (int a: arr) {
            bookAssigned += a;

            if (bookAssigned > allowed) {
                students++;
                bookAssigned = a;
            }
        }

        return students;
    }
}