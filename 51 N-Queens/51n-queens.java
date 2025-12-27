class Solution {
    public List<List<String>> solveNQueens(int n) {

        // These sets help us check if a column or diagonal is already attacked
        Set<Integer> colSet = new HashSet<>();      // stores columns where queens already exist
        Set<Integer> posDiagSet = new HashSet<>();  // (row + col) identifies positive diagonals
        Set<Integer> negDiagSet = new HashSet<>();  // (row - col) identifies negative diagonals

        List<List<String>> result = new ArrayList<>();

        // Create an empty n x n chessboard and fill with '.'
        char[][] board = new char[n][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = '.';
            }
        }

        // Start DFS from row 0
        dfs(result, 0, n, board, colSet, posDiagSet, negDiagSet);
        return result;
    }

    private void dfs(List<List<String>> result, int row, int n,
                     char[][] board, Set<Integer> colSet,
                     Set<Integer> posDiagSet, Set<Integer> negDiagSet) {

        // Base case: all queens placed
        if (row == n) {
            List<String> oneCombination = new ArrayList<>();
            for (char[] rows : board) {
                oneCombination.add(new String(rows));  // convert char[] to String
            }
            result.add(oneCombination);
            return;
        }

        // Try placing queen in every column on this row
        for (int col = 0; col < n; col++) {

            // Check if current (row,col) is safe:
            // colSet: prevents two queens in same column
            // posDiagSet (row + col): prevents two queens on same positive diagonal
            // negDiagSet (row - col): prevents two queens on same negative diagonal
            if (!colSet.contains(col) &&
                !posDiagSet.contains(row + col) &&
                !negDiagSet.contains(row - col)) {

                // Mark this column and diagonals as used
                colSet.add(col);
                posDiagSet.add(row + col);
                negDiagSet.add(row - col);

                // Place queen
                board[row][col] = 'Q';

                // Recurse for next row
                dfs(result, row + 1, n, board, colSet, posDiagSet, negDiagSet);

                // Backtrack — undo placement
                colSet.remove(col);
                posDiagSet.remove(row + col);
                negDiagSet.remove(row - col);
                board[row][col] = '.';
            }
        }
    }
}


/*
class SolutionAlternative {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();

        // Initialize board with '.'
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        solve(0, board, result);
        return result;
    }

    // DFS place queens row by row
    private void solve(int row, char[][] board, List<List<String>> result) {
        if (row == board.length) {
            result.add(build(board));
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (isSafe(row, col, board)) {   // only difference - diagonal check via loops
                board[row][col] = 'Q';
                solve(row + 1, board, result);
                board[row][col] = '.';
            }
        }
    }

    // Check diagonals using loops
    private boolean isSafe(int row, int col, char[][] board) {

        // check column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }

        // check upper-left diagonal
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0;
             i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        // check upper-right diagonal
        for (int i = row - 1, j = col + 1;
             i >= 0 && j < board.length;
             i--, j++) {
            if (board[i][j] == 'Q') return false;
        }

        return true;
    }

    private List<String> build(char[][] board) {
        List<String> res = new ArrayList<>();
        for (char[] row : board) {
            res.add(new String(row));
        }
        return res;
    }
}
*/
