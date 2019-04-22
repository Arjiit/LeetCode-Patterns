class Solution {
    public boolean canPartition(int[] nums) {
        /*
        if sum of elements in the array is odd, it can't be split into two.
        for the even case we can split the sum into two.
        sort the array.
        and recursively check if target can be reduced to 0.
        since we are finding a particular number by reuducing the target and then 
        going back, this is also a depth first search apporach.
        */
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
        }
        
        if (sum % 2 == 1) {
            return false;
        } 
        Arrays.sort(nums);
        return checkPartition(nums, 0, sum/2);
    }
    
    public boolean checkPartition(int[] nums, int start, int target) {
        
        if (target == 0) {
            return true;
        }
        
        for (int i = start; i < nums.length; i++) {
            if (nums[i] > target) { // bounding condition (so that we don't go further) backtrack
                break;
            }
            System.out.println("i value " + i + " start " + start + " target " + target);
            if (i > start && nums[i] == nums[i-1]) {
                continue;
            }
            if(checkPartition(nums, i+1, target - nums[i])) { //incrementing i and not start.
                return true;
            }
        }
        return false;
    }
}