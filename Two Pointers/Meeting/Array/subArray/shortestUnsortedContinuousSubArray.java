class Solution {
    public int findUnsortedSubarray(int[] nums) {
        
        int startIndex = 0;
        int endIndex = nums.length - 1;
        int index1 = 0;
        int index2 = 0;
        int max = nums[0];
        int min = nums[endIndex];
        for (int i=1; i<nums.length;i++) {
            if (nums[i] < max) {
                index1 = i; 
            }
            max = Math.max(nums[i], max);
        }
        
        for (int i = endIndex; i >=0; i--) {
            if (nums[i] > min) {
                index2 = i;
            }
            min = Math.min(nums[i], min);
        }
        return index1 != index2 ? index1 - index2 + 1: 0;
    }
}