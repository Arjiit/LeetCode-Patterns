class Solution {
    public int maxSubArray(int[] nums) {
        int start = 0;
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int end = 0; end < nums.length; end++) {
            sum = sum + nums[end];
            maxSum = Math.max(maxSum, sum);

            if (sum <= 0) {
                sum = 0;
            }
                        System.out.println("Sum is " + sum + " MaxSum is " + maxSum);
     }
        return maxSum;
    }
}