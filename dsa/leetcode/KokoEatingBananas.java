/**
 * #Leetcode875 | https://leetcode.com/problems/koko-eating-bananas/description/
 */


public  class KokoEatingBananas {

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = Arrays.stream(piles).max().getAsInt();

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int totalHour = calculateTotalhour(piles, mid);

            if (totalHour <= h) high = mid - 1;

            else low = mid + 1;
        }

        return low;
    }

    private int calculateTotalhour(int[] arr, int hrs) {
        int totalH = 0;

        for (int a: arr) totalH += Math.ceil((double)(a) / (double) hrs);

        return totalH;
    }
}