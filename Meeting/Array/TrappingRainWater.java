class Solution {
    public int trap(int[] height) {
        int leftMax = 0;
        int rightMax = 0;
        int l = 0;
        int res = 0;
        int r = height.length - 1;
        
        while (l < r) {
        if (height[l] > leftMax) {
            leftMax = height[l];
        }
        
        if (height[r] > rightMax) {
            rightMax = height[r];
        }
        
            if (rightMax > leftMax) {
                res = res + Math.max(0, leftMax - height[l]);
                l++;
            } else {
                res = res + Math.max(0, rightMax - height[r]);
                r--;
            }
     
    }
           return res;
    }
}