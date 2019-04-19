class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        if (nums.length == 1) {
            return nums[0];
        }
        
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        
        int[][] dp = new int[2][nums.length];
        // first row means first house is robbed
        // second row means first house is not robbed
        
        dp[0][0] = nums[0];
        dp[0][1] = Math.max(nums[1], nums[0]);
        dp[1][0] = 0;
        dp[1][1] = nums[1];
        for (int i=2; i<nums.length; i++) {
            dp[0][i] = Math.max(dp[0][i-1], (nums[i] + dp[0][i-2]));
            dp[1][i] = Math.max(dp[1][i-1], (nums[i] + dp[1][i-2]));
        }
        return Math.max(dp[0][nums.length -2], dp[1][nums.length-1]);
    }
}