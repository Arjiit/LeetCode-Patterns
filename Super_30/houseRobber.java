class Solution {
    public int rob(int[] nums) {
        // at each index we have to calculate maximum amount of money we can rob till that
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }
        
        if (nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i=2; i<nums.length; i++){
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
            System.out.println(dp[i] + " i is " + i);
        }
        return dp[nums.length-1];
    }
}