class Solution {
    public int findLength(int[] A, int[] B) {
        //dp[i][j] is maximum repeated length
        // if array in A ends at index i-1 and B ends at index j-1
        
        int[][] dp = new int[A.length + 1][B.length + 1];
        int ans = 0;
        for (int i=1; i<= A.length; i++) {
            for (int j =1; j <= B.length; j++) {
                if (A[i-1]==B[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    ans = Math.max(ans,dp[i][j]);
                }
                
            }
        }

