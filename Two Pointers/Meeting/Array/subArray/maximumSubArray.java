class Solution {
    public int maxSubArray(int[] nums) {
        int maxSoFar = nums[0];
        int globalMax = nums[0];

        for (int i = 1; i<nums.length;i++) {
            
            maxSoFar = Math.max(maxSoFar + nums[i], nums[i]);
            
            globalMax = Math.max(globalMax, maxSoFar);
            
        }
        return globalMax;
    }
}