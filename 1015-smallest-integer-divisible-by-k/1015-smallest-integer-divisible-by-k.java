class Solution {

    public int smallestRepunitDivByK(int K) {

        int rem = 0;

        for (int i = 1; i <= K; i++) {

            rem = (rem * 10 + 1) % K;

            if (rem == 0) return i;
        }
        
        return -1;
    }
}