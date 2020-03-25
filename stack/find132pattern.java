class Solution {
// O(N) time and O(N) space
    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length < 3) return false;
        
        int[] minArray = new int[nums.length];
        minArray[0] = nums[0];
        for (int i=1; i<nums.length; i++) {
            minArray[i] = Math.min(nums[i], minArray[i-1]);
        }
        Stack<Integer> kStack = new Stack<>(); // stack to keep the middle element 2
        kStack.push(nums[nums.length - 1]);
        
        for(int j=nums.length - 1; j>=0; j--) {
            while (!kStack.isEmpty() && kStack.peek() <= minArray[j]) {
                kStack.pop(); // since k(2) should be greater than j(1)
            }
            if (!kStack.isEmpty() && kStack.peek() < nums[j]) {
                return true;
            }
            kStack.push(nums[j]);
        }
        return false;
    }
}