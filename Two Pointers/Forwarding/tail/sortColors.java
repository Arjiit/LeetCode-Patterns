class Solution {
    public void sortColors(int[] nums) {
        int i = 0;
        int r = 0;
        int b = nums.length - 1;
        
        while (i <= b) {
            if (nums[i] == 0) {
                int temp = nums[r];
                nums[r] = nums[i];
                nums[i] = temp;
                i++;
                r++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                int temp = nums[b];
                nums[b] = nums[i];
                nums[i] = temp;
                b--; // we don't increment i as we don't know the value and value may be 1.
            }
        } 
    }
}