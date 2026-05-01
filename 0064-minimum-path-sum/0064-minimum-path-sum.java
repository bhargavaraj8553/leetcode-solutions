class Solution {

    // 🔹 Memoization (Top Down DP) – Minimum Path Sum

    // 🧠 Intuition (Brute Force):
    // From (i, j) → we can go DOWN (i+1, j) or RIGHT (i, j+1)
    // Total cost = current cell value + min(cost of both choices)

    // ✅ Correct DP thinking:
    // func(i, j) = minimum cost to reach destination from (i, j)

    // ❌ Possible mistake (not in your code):
    // Forgetting to include grid[i][j] in cost → wrong answer

    // ❌ Possible mistake:
    // Using wrong boundary check (mixing m and n)

    // ❌ Possible mistake:
    // Returning 0 for out of bounds → this will wrongly favor invalid paths
    // (we need large value instead)

    // TC: O(m * n)
    // SC: O(m * n) + recursion stack

    public int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        // initialize dp with -1 → means not computed
        for (int[] oneRow : dp) {
            Arrays.fill(oneRow, -1);
        }

        return func(grid, 0, 0, m, n, dp);
    }

    public int func(int[][] grid, int i, int j, int m, int n, int[][] dp) {

        // ✅ Reached destination → return its value
        if (i == m - 1 && j == n - 1) return grid[i][j];

        // ❌ Out of bounds → return very large value (acts like infinity)
        // so this path is never chosen in min()
        if (i > m - 1 || j > n - 1) return (int) 1e7;

        // 🔁 Reuse computed result
        if (dp[i][j] != -1) return dp[i][j];

        // ⬇️ Move down
        int down = grid[i][j] + func(grid, i + 1, j, m, n, dp);

        // ➡️ Move right
        int right = grid[i][j] + func(grid, i, j + 1, m, n, dp);

        // 🧠 DP relation:
        // choose minimum cost path
        return dp[i][j] = Math.min(down, right);
    }
}