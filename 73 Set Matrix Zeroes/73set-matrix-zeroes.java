class Solution {
    public void setZeroes(int[][] matrix) {
        int m= matrix.length;
        int n= matrix[0].length;
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j]==0){
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }
        
        updateValuesInResultMatrix(matrix, rowSet, colSet);
    }

    private void updateValuesInResultMatrix(int[][] resultMatrix, Set<Integer> rowSet, Set<Integer> colSet) {
        for (int i = 0; i < resultMatrix.length; i++) {
            for (int j = 0; j < resultMatrix[0].length; j++) {
              if (rowSet.contains(i)|| colSet.contains(j)){
                  resultMatrix[i][j]=0;
              }
            }

        }
    }
}