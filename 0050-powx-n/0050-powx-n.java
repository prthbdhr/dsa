class Solution {
    public double myPow(double x, int n) {
        
        if (n == 0) return 1.0;

        if (n < 0) {

            x = 1 / x;

            if (n == Integer.MIN_VALUE) return x * myPow(x, - (n + 1));

            n = -n;
        }

        double half = myPow(x, n / 2);

        return (n % 2 == 0) ? half * half : half * half * x;
    }
}