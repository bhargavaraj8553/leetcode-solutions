class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int[] singleRow: dp){
            Arrays.fill(singleRow, -1);
        }
        return func(obstacleGrid, 0, 0, dp);
    }

    public int func(int[][] obstacleGrid, int i, int j, int[][] dp){
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (i> m-1 || j>n-1) return 0;
        if (obstacleGrid[i][j]==1) return 0;
        if (i==m-1 && j==n-1) return 1;

        if (dp[i][j]!=-1) return dp[i][j];
        int right = func(obstacleGrid, i+1, j, dp);
        int down = func(obstacleGrid, i, j+1, dp);
        return dp[i][j] = right+ down;
    }
}
