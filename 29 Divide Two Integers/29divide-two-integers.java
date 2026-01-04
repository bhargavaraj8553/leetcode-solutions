
class Solution {
    public int divide(int dividend, int divisor) {

        if (divisor == 0) return Integer.MAX_VALUE;
        //not required still writing
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        //only one overflow can come in this


        boolean isPositive = !(dividend < 0) ^ (divisor < 0);
        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);
        long quotient = 0;

        while (n >= d) {

            int i = 0;
            while (n >= (d << (i + 1))) {
                i++;
            }
            n = n - (d << i);
            quotient += (1L << i);
        }
        return isPositive ? (int) quotient : (-(int) quotient);
    }
}