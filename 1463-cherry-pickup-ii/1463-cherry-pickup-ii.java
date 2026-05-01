class Solution {
    public int cherryPickup(int[][] grid) {
        int r= grid.length;
        int c= grid[0].length;
        int[][][] dp= new int[r][c][c];
        for (int[][] squareDp: dp){
            for (int[] singleRow: squareDp){
                Arrays.fill(singleRow, -1);
            }
        }
        return func(grid, 0, 0, c-1, r, c, dp);
    }

    private static int func(int[][] grid, int i, int j1, int j2, int m, int n, int[][][] dp){
        if (j1<0 || j1>n-1 || j2<0 || j2>n-1) return Integer.MIN_VALUE/2;
        if (i==m-1) {
            if (j1!= j2) return grid[i][j1]+ grid[i][j2];
            else return grid[i][j1];
        }
        if (dp[i][j1][j2]!=-1) return dp[i][j1][j2];
        int maxi = Integer.MIN_VALUE;
        for (int d1 = -1;d1<2; d1++){
            for (int d2=-1;d2<2;d2++){
                int toAdd = 0;
                if (j1== j2) toAdd = grid[i][j1];
                else toAdd = grid[i][j1] + grid[i][j2];
                toAdd = toAdd + func(grid, i+1, j1+d1, j2+d2, m, n, dp);
                maxi = Math.max(maxi, toAdd);
            }
        }
        return dp[i][j1][j2]= maxi;
    }
}