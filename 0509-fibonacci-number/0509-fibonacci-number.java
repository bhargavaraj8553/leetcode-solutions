class Solution {

    // 🔹 Space Optimized DP (Best Approach)
    // Intuition (Brute Force):
    // Fibonacci = sum of previous two numbers → f(n) = f(n-1) + f(n-2)
    // Recursion recalculates same values → exponential time

    // Why Optimized:
    // We only need last 2 states, not full dp array → reduces space from O(n) to O(1)

    // How to think:
    // Instead of storing all values, track only previous two results and build forward

    // TC: O(n)
    // SC: O(1)
    public int fib(int n) {
        if (n <= 1) return n; // base case

        int prev2 = 0; // f(0)
        int prev = 1;  // f(1)

        for (int i = 2; i <= n; i++) {
            int curr = prev + prev2; // current fibonacci
            prev2 = prev;            // shift window
            prev = curr;
        }
        return prev;
    }


    /**
     * 🔹 Memoization (Top-Down DP)
     *
     * Intuition (Brute Force):
     * Recursively compute f(n-1) + f(n-2), but many calls repeat
     *
     * Why Optimized:
     * Store already computed values → avoid recomputation
     *
     * How to think:
     * "If already solved, reuse it" → classic overlapping subproblem
     *
     * TC: O(n)
     * SC: O(n) recursion stack + dp array
     *
     * Common Mistake (you fixed):
     * Base case must be n <= 1, not n < 1
     */
    /*
    class Solution {
        public int fib(int n) {
            int[] dp = new int[n+1];
            Arrays.fill(dp, -1);
            return fibonacciSeries(n, dp);
        }

        private int fibonacciSeries(int n, int[] dp) {
            if (n <= 1) {
                return dp[n] = n; // store base case
            }
            if (dp[n] != -1) return dp[n];

            return dp[n] = fibonacciSeries(n-1, dp) + fibonacciSeries(n-2, dp);
        }
    }
    */


    /**
     * 🔹 Basic Recursion (Brute Force)
     *
     * Intuition:
     * Directly follow definition: f(n) = f(n-1) + f(n-2)
     *
     * Problem:
     * Same subproblems recomputed multiple times → exponential growth
     *
     * TC: O(2^n)
     * SC: O(n) recursion stack
     *
     * Use only to derive recurrence, not in interviews
     */
    /*
    class Solution {
        public int fib(int n) {
            if (n <= 1) return n;
            return fib(n-1) + fib(n-2);
        }
    }
    */
}