class Solution {

    // 🔹 Memoization (Top Down DP)

    // 🧠 Brute force intuition:
    // From (i, j) → we can go DOWN or RIGHT
    // So total paths = paths from down + paths from right

    // ❌ My past mistake:
    // I was using a global ans[] and doing ans += ...
    // → That was WRONG because DP needs each function to RETURN its own answer
    // → That caused overcounting

    // ✅ Correct thinking:
    // func(i, j) should RETURN number of paths from (i, j) → destination

    // ❌ Another mistake I made:
    // I tried to write dp[i][j] = 0 in out of bounds
    // → but (i, j) might be invalid index → crash
    // → So just return 0, don't touch dp

    // TC: O(m * n)
    // SC: O(m * n) + recursion stack

    public int uniquePaths(int m, int n) {

        int[][] dp = new int[m][n];

        // initialize with -1 → means not computed
        for (int[] oneRow : dp) {
            Arrays.fill(oneRow, -1);
        }

        return func(0, 0, m, n, dp);
    }

    private int func(int i, int j, int m, int n, int[][] dp) {

        // ❌ Out of bounds → no path possible
        // (Important: don't write dp[i][j] here, index may be invalid)
        if (i > m - 1 || j > n - 1) {
            return 0;
        }

        // ✅ Reached destination → exactly 1 path
        if (i == m - 1 && j == n - 1) {
            return dp[i][j] = 1;
        }

        // 🔁 If already computed → reuse
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // ⬇️ Move down
        int down = func(i + 1, j, m, n, dp);

        // ➡️ Move right
        int right = func(i, j + 1, m, n, dp);

        // 🧠 Core DP relation:
        // total paths = down + right
        return dp[i][j] = down + right;
    }
}