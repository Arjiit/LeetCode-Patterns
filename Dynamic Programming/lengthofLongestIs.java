class Solution {
    /*
    Each index of dp represents the length of max subsequence from 0 to i.
    if the number found at j is greater than 1, then we see the max subsequence
    till i i.e. dp[i] and increase by 1.
    */
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        int[] dp = new int[nums.length]; // array to store our subproblem
        Arrays.fill(dp, 1); // by default the answer is 1 as the longest subsequence at any point is the number itself
        
        for (int j=1; j< nums.length; j++) {
            for (int i= 0; i< j; i++) {
                if (nums[j] > nums[i]) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
        }
        //loop through the dp array to find the max value
        int max = 1;
        for (int i=0; i< dp.length; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}