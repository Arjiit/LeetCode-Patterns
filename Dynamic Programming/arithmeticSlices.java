class Solution {
    /*
    Idea is to store arithmetic slices upto that index in a dp array and
    return sum of values in the dp array.
    */
    public int numberOfArithmeticSlices(int[] A) {
        if (A.length < 3) {
            return 0;
        }
        int n = A.length;
        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = 0;
        int res = 0;
        for (int i=2; i<dp.length; i++) {
            if (A[i] - A[i-1] == A[i-1] - A[i-2]) {
                dp[i] = dp[i-1] + 1;
            }
            res = res + dp[i];
        }
        return res;
    }
}