class Solution {
    // duplicates can occur atmost 2 times
    public int removeDuplicates2(int[] nums) {
     
        if (nums.length < 3) {
            return nums.length;
        }
        // starting tail from 2.
        int tail = 2;   
        for (int i=2; i<nums.length;i++) {
            if (nums[i] != nums[tail-1] || nums[i] != nums[tail-2]) { // checking if current is equal to previous two or not.
            nums[tail] = nums[i]; // modifying in the current array.
            tail++;
            }
           
            
        }
        return tail;
    }
}