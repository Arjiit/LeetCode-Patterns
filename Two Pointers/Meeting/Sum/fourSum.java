class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
            for (int i=0; i<nums.length - 3; i++) {
                if (i > 0 && nums[i] == nums[i-1]) {
                    continue;
                }
                
                for (int m = i+1; m < nums.length - 2; m++) {
                    if (m > i + 1 && nums[m] == nums[m - 1]) {
                        continue;
                    }
                   int l = m+1;
                    int r = nums.length - 1;
                    
                    while (l < r) {
                        if (nums[i] + nums[m] + nums[l] + nums[r] == target) {
                            res.add(Arrays.asList(nums[i],nums[m],nums[l],nums[r]));
                            
                            while (l < r && nums[l+1] == nums[l]) {
                                l++;
                            }
                            while(l<r&&nums[r]==nums[r-1]){
                             r--;   
                            }
                            l++;
                            r--;
                            
                        } else if (nums[i] + nums[m] + nums[l] + nums[r] < target) {
                            l++;
                        } else {
                            r --;
                        }
                    }
                }
            }
        return res;
    }
}