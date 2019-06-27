class Solution {
    /*
    making sum numbers positive and others negative from the set is equivalent to finding subset
    from the set of positive minus set of negative numbers that equal to target.
    Subset(positive) - Subset(negative) = target
    Adding Subset(positive) + Subset(negative) on both the sides gives us
    Subset(P) = (target + Sum(nums))/2
    So, we have to find no of ways to make sum of integers from the array equal to RHS above
    which we can do by DP. Each index of the DP array corresponds to sum. So, we loop through
    each of the numbers and look to fill the DP array by number of previous ways (i.e. we
    do not include the number dp[i]) plus the number of ways if we include that 
    particular number (dp[i-n]).
    */
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int i=0; i<nums.length; i++) {
            sum = sum + nums[i];
        }
        int newSum = (S+sum)/2;
        
        if (sum < S || (S+sum) % 2 != 0) {
            return 0;
        }
                
        int[] dp = new int[newSum + 1];
        dp[0] = 1;
        for (int n:nums) {
            for (int i=newSum; i >= n; i--) {
                dp[i] = dp[i] + dp[i - n]; // no of ways possible + no of ways possible if we don't include a particular number n.
            }
        }
        return dp[newSum];
    }
}