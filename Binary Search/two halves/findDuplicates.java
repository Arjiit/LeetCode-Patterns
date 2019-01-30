class Solution {
    public int findDuplicate(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + (r-l)/2;
            int count = 0;
            for (int x : nums) {
                if (x <= mid) {
                    count = count + 1;
                }   
            }
            
            if (count > mid) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}