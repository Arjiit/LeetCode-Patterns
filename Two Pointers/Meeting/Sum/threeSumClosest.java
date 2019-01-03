class Solution {
    public int threeSumClosest(int[] nums, int target) {
      
        int curMin = Integer.MAX_VALUE;
        int res = 0;
        int sum = 0;
        Arrays.sort(nums);
        
        for (int i =0; i<nums.length-2; i++) {
            if (i>0 && nums[i] == nums[i-1]) {
                continue;
            }
            int l = i+1;
            int r = nums.length - 1;
 
            
            while (l < r) {
                sum = nums[i] + nums[l] + nums[r];
                if ( sum == target) {
                    return sum;
                }
                
                if (Math.abs(sum-target) < curMin) {
                    res = nums[i] + nums[l] + nums[r];
                    curMin = Math.abs(sum-target);
                    
                }
                
                if (sum < target) {
                    l++;
                } else {
                    
                    r--;   
                }
            }
        }
        return res;
    }
}