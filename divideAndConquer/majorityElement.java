class Solution {
    /*
    Majority element is that which occurs more than n/2 times.
    We start with assigning first element as majority and give it a count 1,
    we increase the count if we find the majority element else decrement,
    if count reaches 0, we make the current element major and count as 1.
    */
    public int majorityElement(int[] nums) {
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