class Solution {
    /*
    T.C. - O(n)
    */
    public boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) { // if we can reach the last position from that index
                lastPos = i; // we can store the position from where it can be reached in a variable
            }
        }
        return lastPos == 0; // if we are able to reach from the beginning then, we would have lastoPos as 0
    }
}