class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        int max = nums[0];
        int min = nums[0];
        int maxSoFar = nums[0];
        
        for (int i = 1; i< nums.length; i++) {
            if (nums[i] < 0) {
                int temp = max;
                max = min;
                min = temp;
            }
            
            max = Math.max(nums[i], max*nums[i]);
            min = Math.min(nums[i], min*nums[i]);
            maxSoFar = Math.max(maxSoFar, max);
        }
        return maxSoFar;
    }
}