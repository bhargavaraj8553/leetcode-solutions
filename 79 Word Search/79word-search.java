class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(i, j, 0, word, board)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int row, int column, int wordIndex, String word, char[][] board) {
        if (wordIndex== word.length()){
            return true;
        }
        if (row<0|| column<0|| row>=board.length||column>=board[0].length
        || board[row][column]!= word.charAt(wordIndex)){
            return false;
        }

        char temp = board[row][column];
        board[row][column] = '#';

        boolean nextRow = dfs(row+1, column, wordIndex+1, word, board);
        boolean prevRow = dfs(row-1, column, wordIndex+1, word, board);
        boolean nextCol = dfs(row, column+1, wordIndex+1, word, board);
        boolean prevCol = dfs(row, column-1, wordIndex+1, word, board);
        board[row][column] = temp;

        return nextRow||prevRow||nextCol||prevCol;
    }
}