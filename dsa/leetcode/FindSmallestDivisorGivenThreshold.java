
/**
 * #Leetcode 1283 | https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/
 */

public class FindSmallestDivisorGivenThreshold {

    public static int smallestDivisor(int[] arr, int limit) {

        if (arr.length < limit) return -1;

        int maxi = Arrays.stream(arr).max().getAsInt();

        int low = 1, high = maxi;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (sumByD(arr, mid) <= limit) high = mid - 1;

            else low = mid + 1;
        }

        return low;
    }

    private int sumByD (int[] arr, int div) {
        int sum = 0;

        for (int a: arr) sum += (a + div - 1) / div; //to get he ceil value

        return sum;
    }

}

