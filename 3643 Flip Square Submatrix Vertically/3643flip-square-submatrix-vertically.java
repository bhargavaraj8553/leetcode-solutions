class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int rowStart, rowEnd;
        int colStart = y, colEnd = y + k - 1;

        while (colStart <= colEnd) {
            rowStart = x;
            rowEnd = x + k - 1;
            while (rowStart < rowEnd) {
                int temp = grid[rowStart][colStart];
                grid[rowStart][colStart] = grid[rowEnd][colStart];
                grid[rowEnd][colStart] = temp;
                rowStart++;
                rowEnd--;
            }
            colStart++;
        }
        return grid;
    }
}
