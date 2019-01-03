class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        
         if(nums==null || nums.length<1)
		return 0;
        
        int l = 0;
        int i = 0;
        int r = 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;

        for(r=0; r<nums.length; r++) {
                sum = sum + nums[r];
            
            while (sum >= s) {
                min = Math.min(min, r-l+1);
                sum = sum - nums[l];
                l++;
            }
            
        }
        return min == Integer.MAX_VALUE ? 0: min;
    }
}