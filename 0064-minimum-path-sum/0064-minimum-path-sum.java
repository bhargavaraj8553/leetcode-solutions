
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int[] oneRow: dp){
            Arrays.fill(oneRow, -1);
        }
        return func(grid, 0, 0, m, n, dp);
    }

    public int func(int[][] grid, int i, int j, int m, int n, int[][] dp){
        if (i==m-1 && j == n-1) return grid[i][j];
        if (i>m-1 || j>n-1) return (int)1e7;

        if (dp[i][j]!=-1) return dp[i][j];
        int bottomSum= grid[i][j] + func(grid, i+1, j, m, n, dp);
        int rightSum = grid[i][j] + func(grid, i, j+1, m, n, dp);

        return dp[i][j]= Math.min(bottomSum, rightSum);
    }
}