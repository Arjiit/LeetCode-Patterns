class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
    if (matrix.length == 0) {
        return new int[]{};
    }
        int row = 0;
        int col = 0;
        
        int m = matrix.length;
        int n = matrix[0].length;
        int[] arr = new int[m*n];
        int k = 0;
        
        for (int i=0; i< m*n; i++) {
            arr[k] = matrix[row][col];
            k++;
            if ((row + col)%2 == 0) {
                if (col == n - 1) {
                    row++;
                } else if (row == 0) {
                    col++;
                } else {
                    row--;
                    col++;
                }
            } else {
                if (row == m -1) {
                    col++;
                } else if (col == 0) {
                    row++;
                } else {
                    row++;
                    col--;
                }
            }
        }
        return arr;
    }
}