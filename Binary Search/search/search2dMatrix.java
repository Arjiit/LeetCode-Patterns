class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0;
        int r = m*n - 1;
        
        while (l <= r) {
            int mid = l + (r-l)/2;
            int row = mid/n;
            int col = mid%n;
            
            if (matrix[row][col] == target) {
                return true;
            }
            else if (matrix[row][col] > target) {
                r = mid -1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }
}