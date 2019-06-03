class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
       /*
       we can't use the element from the array twice, so we use a boolean
       array to keep track of whether an element has been used or not.
       
       */
        int sum = 0;
        for (int i=0; i<nums.length; i++) {
            sum = sum + nums[i];
        }
        if (sum%k != 0) {
            return false;
        }
        return canPartiton(0, nums, new boolean[nums.length], k, 0, sum/k);
    }
    
    public boolean canPartiton(int iterationStart, int[] arr, boolean[] used, int k, int inProgressBucketSum, int targetBucketSum) {
            if (k == 1) {
                return true;
            }
        
            if (inProgressBucketSum == targetBucketSum) {
                return canPartiton(0, arr, used, k-1, 0, targetBucketSum); // we start a new iteration // to find subset of sum equal to sum/k
            }
        
            for (int i= iterationStart; i < arr.length; i++){
                if (!used[i]) { // if the element is not used
                    used[i] = true; //choosing the element
                if (canPartiton(i+1, arr, used, k, inProgressBucketSum + arr[i], targetBucketSum)) {
                    return true;
                }
        /*
        critical thing here is unchoosing when the combinations don't work.
        */
                    used[i] = false; //unchoosing
                }
            }
        return false; // if nothing works
        }
    }