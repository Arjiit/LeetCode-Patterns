class Solution {
    public int removeDuplicates(int[] nums) {
        int tail = 1;
        for (int i=1; i< nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                continue;
            }
            nums[tail] = nums[i];
            tail++;
        }
        return tail;
    }
}