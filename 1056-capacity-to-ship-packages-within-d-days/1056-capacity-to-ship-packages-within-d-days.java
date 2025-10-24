class Solution {
    public int shipWithinDays(int[] weights, int days) {

        int low = Arrays.stream(weights).max().getAsInt();
        int high = Arrays.stream(weights).sum();

        while (low <= high) {
            int cap = low + (high - low) / 2;

            if (canTake(weights, cap, days)) {
                high = cap - 1;
            }

            else {
                low = cap + 1;
            }
        }

        return low;
    }

    private boolean canTake(int[] weights, int cap, int days) {
        int load = 0;
        int day = 1;

        for (int wt: weights) {

            if (wt + load <= cap) {
                load += wt;
            }

            else {
                day++;
                load = wt;
            }
        }

        return day <= days;
    }
}