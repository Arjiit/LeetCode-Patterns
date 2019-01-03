class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int left = 0;
        int sum = 0;
        int right = 0;
        
        int res = Integer.MAX_VALUE;
        while(right < nums.length) {
            sum = sum + nums[right];
            right++;
            while (sum >= s) {
                sum = sum - nums[left];
                left++;
                res = Math.min(res, right - left + 1);
            }
             
            
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}