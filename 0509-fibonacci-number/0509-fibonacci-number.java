
/**
 * memoization solution
 */
class Solution {
    public int fib(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return fibonacciSeries(n, dp);
    }

    private int fibonacciSeries(int n, int[] dp) {
        if (n<=1){
            return dp[n] = n;
        }
        if (dp[n]!=-1) return dp[n];
        return dp[n] = fibonacciSeries(n-1,dp) + fibonacciSeries(n-2, dp);
    }
}

/**
 * basic recursion solution
 * class Solution {
 *     public int fib(int n) {
 *         if (n<=1) return n;
 *         return fib(n-1)+ fib(n-2);
 *     }
 * }
 */