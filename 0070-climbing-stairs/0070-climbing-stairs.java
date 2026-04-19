
class Solution {

    // 🔹 Space Optimized DP (Climbing Stairs)
    // Same as Fibonacci: f(n) = f(n-1) + f(n-2)

    // TC: O(n)
    // SC: O(1)

    public int climbStairs(int n) {
        if (n <= 2) return n; // base case (common mistake: I sometimes use < instead of <=)

        int prev2 = 1; // ways to reach step 1
        int prev = 2;  // ways to reach step 2

        for (int i = 3; i <= n; i++) { // important: <= n, not < n
            int current = prev2 + prev; // compute current step
            prev2 = prev;               // shift window
            prev = current;
        }
        return prev;
    }
}