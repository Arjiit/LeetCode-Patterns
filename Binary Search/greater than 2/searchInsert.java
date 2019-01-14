class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        
        int l = 0;
        int r = nums.length;
        
        while (l < r) {
            int mid = l + (r-l)/2;
            
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }
}