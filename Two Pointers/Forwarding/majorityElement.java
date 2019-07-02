class Solution {
    public int majorityElement(int[] nums) {
    /*
        Bayer's moore voting algorithm.
        http://www.cs.utexas.edu/~moore/best-ideas/mjrty/example.html#step13
    */
        int major = nums[0];
        int count = 1;
        for (int i =1; i<nums.length;i++) {
            if (count == 0) {
                count ++;
                major = nums[i];
            }
            
            else if (major == nums[i]) {
                count ++;
            }
            
            else {
                count --;
            }
        }
        return major;
    }
}