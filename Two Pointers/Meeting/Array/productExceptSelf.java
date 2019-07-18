class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int prod = 1;
        for (int i=0; i<nums.length; i++) {
            if (i >= 1) {
                prod = prod*nums[i-1];
            }
            left[i] = prod;
        }
        
        
        int p = 1;
        for (int i=nums.length - 1; i>=0; i--) {
            if (i < nums.length - 1) {
                p = p*nums[i+1];
            }
            right[i] = p;
        }
        
        for (int i = 0; i< nums.length; i++) {
            nums[i] = left[i]*right[i];
        }
        
        return nums;
    }
}