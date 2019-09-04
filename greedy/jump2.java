class Solution {
    /*
    Think of the problem as - at every step we get a new ladder, if it is large enough
    we keep it else throw it. Also, we keep climbing our current ladder and once it is 
    over we use the stored larger ladder.
    Stairs are number of stairs at a particular index
    */
    public int jump(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int ladder = nums[0]; // to keep track of largest ladder we have
        int stairs = nums[0]; // keep track of stairs in current ladder
        int jump = 1;
        
        for (int level=1; level <nums.length; level++) {
            if (level == nums.length - 1) { // if we reach the end, we return the jump recorded
                return jump;
            }
            
            if (level + nums[level] > ladder) {
                ladder = level + nums[level];
            }
            stairs--;
            
            if(stairs == 0) {
                jump++;
                stairs = ladder - level;
            }
        }
        return jump;
    }
}