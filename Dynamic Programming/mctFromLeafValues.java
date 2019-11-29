class Solution {
    class Result {
        int maxMul;
        int res;
        
        public Result(int maxMul, int res){
            this.maxMul = maxMul;
            this.res = res;
        }
    }
    
    public int mctFromLeafValues(int[] arr) {
        Result[][] dp = new Result[arr.length][arr.length];
        return maxDown(arr, 0, arr.length - 1, dp).res;   
    }
    
    public Result maxDown(int[] arr, int start, int end, Result[][] dp) {
        if (start > end) return new Result(1, 0);
        if (start == end) return new Result(arr[start], 0); // for leaf nodes 0 is the result
        if (dp[start][end] != null) return dp[start][end]; // if already calculated for a start to end, then return value as is
        Result min = null;
        // [6][2,4] and [6,2][4] the one with minimum cost will have value stored
        // in dp[start][end]
        // two variables, maxMul - to calculate max node value from left and right
        // res - to store cumulative result, which is result of left, right and current. current is max node from left multiplied with max left from right.
        for (int i=start; i<end; i++){
            Result a = maxDown(arr, start, i, dp);
            Result b = maxDown(arr, i+1, end, dp);
            Result val = new Result(Math.max(a.maxMul, b.maxMul), a.res + b.res + a.maxMul*b.maxMul);
            if (min == null) min = val;
            else if (min.res > val.res) min = val;
        }
        dp[start][end] = min;
        return min;
    }
}