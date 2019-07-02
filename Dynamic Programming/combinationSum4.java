class Solution {
    public int combinationSum4(int[] nums, int target) {
        /*
        Bottom Up Dp to solve the problem - at each step we can either choose the
        number or we can't choose.
        We create a DP table with index representing the sum and the values in the 
        array representing the number of ways making that sum.
        */
        int[] dp = new int[target+1];
        
        dp[0] = 1; // ways to make 0 sum.
        
        for (int i=1; i< dp.length; i++)  {
            for (int num: nums) {
                if (i - num >= 0) {
                    dp[i] += dp[i-num];
                }
            }
        }
       return dp[target]; 
    }
}