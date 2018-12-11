class Solution {
    public int triangleNumber(int[] nums) {
        int res = 0;
        int n = nums.length;
        
        Arrays.sort(nums);
        
        for (int i=n-1; i>=2; i--) {
            int r = i-1;
            int l = 0;
            while (l < r) {
                if (nums[l] + nums[r] > nums[i]) {
                    res = res + (r - l);
                    r--;
                } else {
                    l++;
                }
            }
        }
        return res;
    }
}