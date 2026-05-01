class Solution {

    // 🔹 Memoization (Top Down DP) with obstacles

    // 🧠 Intuition:
    // From (i, j) → we can go DOWN (i+1) or RIGHT (j+1)
    // Total paths = paths from down + paths from right

    // ❗ Constraint:
    // If obstacle (1) → cannot move → return 0

    // ✅ Correct DP thinking used here:
    // func(i, j) returns number of paths from (i, j) → destination

    // ❌ Possible mistake (not in your code):
    // Using global ans and accumulating → wrong for DP

    // ❌ Possible mistake:
    // Not checking obstacle before base case → may count blocked destination

    // ❌ Possible mistake:
    // Writing dp[i][j] when i/j is out of bounds → crash

    // ❌ Possible mistake:
    // Confusing directions:
    // i+1 = down, j+1 = right

    // TC: O(m * n)
    // SC: O(m * n) + recursion stack

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];

        // initialize dp with -1 → not computed
        for (int[] singleRow : dp) {
            Arrays.fill(singleRow, -1);
        }

        return func(obstacleGrid, 0, 0, dp);
    }

    public int func(int[][] obstacleGrid, int i, int j, int[][] dp) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        // ❌ Out of bounds → no path
        if (i > m - 1 || j > n - 1) return 0;

        // 🚫 Obstacle → cannot pass
        if (obstacleGrid[i][j] == 1) return 0;

        // ✅ Reached destination → 1 valid path
        if (i == m - 1 && j == n - 1) return 1;

        // 🔁 Reuse computed result
        if (dp[i][j] != -1) return dp[i][j];

        // ⬇️ Move down
        int down = func(obstacleGrid, i + 1, j, dp);

        // ➡️ Move right
        int right = func(obstacleGrid, i, j + 1, dp);

        // 🧠 DP relation
        return dp[i][j] = down + right;
    }
}