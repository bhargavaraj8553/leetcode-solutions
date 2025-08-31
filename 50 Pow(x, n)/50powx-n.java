class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n == -1) return 1 / x;
        if (n < 0) {
            x = 1 / x;
            if (n == Integer.MIN_VALUE) {
                return x * myPow(x, Integer.MAX_VALUE);
            }
            n = -n;
        }
        if (n % 2 == 0) {
            double halfAns = myPow(x, n / 2);
            return halfAns * halfAns;
        } else {
            return x * myPow(x, n - 1);
        }
    }
}