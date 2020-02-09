class Solution {
    public int dominantIndex(int[] nums) {
            Integer max = null;
        Integer second_max = null;
        int index = 0;
        for (int i=0; i< nums.length; i++) {
            if (max == null || nums[i] > max) {
                second_max = max;
                max = nums[i];
                index = i;
            } else if (second_max == null || (nums[i] > second_max && nums[i] < max))  {
                second_max = nums[i];
            }
        }
        if (nums.length == 1 || max >= 2*second_max) {
            return index;
        }
        return -1;
    }
}