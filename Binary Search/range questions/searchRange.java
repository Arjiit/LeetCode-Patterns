class Solution {
    public int[] searchRange(int[] nums, int target) {
        /*
        We can have two approaches to do binary search here:
        1) Like implemented below, find the target itself using binary search, it will tend to be
        biased towards low i.e. we will get the first occurence. And then find the next greater 
        element using the same binary search.

        2) To first find mid, which is equal to target then keep shrinking by checking if mid  - 1
        is also equal to mid i.e. target that means we might have target in lower half, so we do a 
        binary search in left half with 0, mid-1.
        T.C. - O(logN)
        */
        if (nums.length == 0) {
            return new int[]{-1,-1};
        }
        
        int left = doBinary(nums, target);
        if (nums[left] != target) {
            return new int[] {-1,-1};
        }
        int right_end = doBinary(nums, target+1);
        int right = -1;
        if (nums[right_end] >= target+1) {
            right = right_end - 1;
        } else {
            right = right_end;
        }
        return new int[]{left, right};
    }
    
    public int doBinary(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while(low < high) {
            int mid = low + (high - low)/2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}