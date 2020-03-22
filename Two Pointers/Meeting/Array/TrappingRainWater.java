
// O(N^2) solution
class Solution {
    public int trap(int[] height) {
        int total = 0;
        for (int i=1; i<height.length; i++) {
            int cur_left= max(height, 0, i);
            //System.out.println(cur_left);
            int cur_right = max(height, i, height.length-1);
            //System.out.println(cur_right);
            int cur_max = Math.min(cur_left, cur_right);
            total = total + cur_max - height[i];
        }
        return total;
    }
    
    public int max(int[] height, int left, int right) {
        int max = 0;
        for (int i=left; i<=right; i++) {
            if (height[i] > max) {
                max = height[i];
            }
        }
        return max;
    }
}

// O(N) time, O(N) space
class Solution {
    public int trap(int[] height) {
        int[] left = precomputeLeft(height);
        int[] right = preComputeRight(height);
        int total = 0;
        for (int i=0; i<height.length; i++) {
            
            total += Math.min(left[i], right[i]) - height[i];
        }
        return total;
    }
    
    public int[] precomputeLeft(int[] height) {
        int[] res = new int[height.length];
        if (height.length == 0) {
            return res;
        }
        res[0] = height[0];
        for (int i=1; i<height.length; i++) {
            res[i] = Math.max(res[i-1], height[i]);
        }
        return res;
    }
    
    public int[] preComputeRight(int[] height) {
        int[] res = new int[height.length];
        if (height.length == 0) {
            return res;
        }
        res[height.length - 1] = height[height.length -1];
        for (int i=height.length - 2; i>= 0; i--) {
            res[i] = Math.max(res[i+1], height[i]);
        }
        return res;
    }
}

// O(N) time. O(1) space using lower envelope technique
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