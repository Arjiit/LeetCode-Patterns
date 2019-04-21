class Solution {
    public int deleteAndEarn(int[] nums) {

/*
TLE solution - sorting the array and taking leftSum and rightSum for a particular index.
*/
        Arrays.sort(nums);
        int[] res = new int[nums.length];
        
        for (int i=0; i<nums.length; i++) {
        int left_pts = 0;
        int right_pts = 0;
        int total = nums[i];
        int left_ptr = i-1;
        int right_ptr = i+1;
            while (left_ptr >= 0) {
                if (nums[left_ptr] == nums[i] - 1) {
                    continue;
                }
                
             left_pts = left_pts + nums[left_ptr];
                left_ptr--;
            }
            
        while (right_ptr < nums.length) {
            if (nums[right_ptr] == nums[i] + 1) {
                continue;
            }
            right_pts = right_pts + nums[right_ptr];
            right_ptr++;
        }
            total = total + left_pts + right_pts;
            res[i] = total;
    }
        int max = Integer.MIN_VALUE;
        for (int i=0; i< res.length; i++) {
            max = Math.max(max,res[i]);
        }
    return max;
}
}


// Using Dynamic Programming

class Solution {
    public int deleteAndEarn(int[] nums) {
        /*
        not choosing nums[i] - 1 and nums[i] + 1 makes it into a house robber type question.
        so we calculate max sum possible at any index = Math.max(dp[i-1], dp[i-2] + nums[i])
        
        New thing: we store the count in an array and the index represent the number in nums.
        if numbers are repeated we just have to take it as many times it occurs, so the relation
        changes to
        array_count[i] = Math.max(array_count[i], array_count[i-2]*i)
        */
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
      int[] array_count = new int[10001];
        int[] dp = new int[10001];
        for (int i: nums) {
            array_count[i]++;
        }
        
        for(int i=2; i<dp.length; i++) {
            array_count[i] = Math.max(array_count[i-1], array_count[i-2] + (array_count[i])*i);
        }
        return array_count[array_count.length - 1];
    }
}