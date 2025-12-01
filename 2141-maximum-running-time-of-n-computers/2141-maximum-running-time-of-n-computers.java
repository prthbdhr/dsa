class Solution {
    public long maxRunTime(int n, int[] batteries) {
        
        long sum = 0;

        for (int power: batteries) sum += power;

        long low = 1;
        long high = sum / n;

        while (low < high) {

            long mid = high - (high - low) / 2;

            if (isRem(n, batteries, mid)) low = mid;

            else high = mid - 1;
        }

        return low;
    }

    private boolean isRem(int n, int[] batteries, long target) {

        long rem = 0;

        for (int power: batteries) rem += Math.min(power, target);

        return rem >= (long) (n * target);
    }
}