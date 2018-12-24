class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        int left = 0;
        int prod = 1;
        for (int right = 0; right< nums.length; right++) {
            
            prod = prod*nums[right];
            
            while (prod >= k && left <= right) {
                prod = prod/nums[left];
                left++;
            }
            count = count + (right - left) + 1 ;
        }
        return count;
    }
}