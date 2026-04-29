class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int[] oneRow : dp) {
            Arrays.fill(oneRow, -1);
        }
        return func(0, 0, m, n, dp);

    }

    private int func(int i, int j, int m, int n, int[][] dp) {
        if (i > m - 1 || j > n - 1) {
            return 0;
        }

        if (i == m - 1 && j == n - 1) {
            return dp[i][j] = 1;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int down = func(i + 1, j, m, n, dp);
        int right = func(i, j + 1, m, n, dp);
        return dp[i][j] = down + right;
    }
}