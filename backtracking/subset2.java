class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        getSubset(nums, 0, new ArrayList<>(), res);
        return res;
    }
    
    public void getSubset(int[] nums, int start, List<Integer> temp, List<List<Integer>> res) {
            res.add(new ArrayList<>(temp));
        
        for (int i = start; i<nums.length; i++) {
            if (i > start && nums[i] == nums[i-1]) { // to avoid duplicates in a temporary subset. This will happen when the next iteration will occur after the function is removed from the call stack.
                System.out.println("same");
                continue;
            }
            temp.add(nums[i]);
        System.out.println(Arrays.deepToString(temp.toArray()));
            getSubset(nums, i+1, temp, res);
            System.out.println("here");
            temp.remove(temp.size() - 1);
        System.out.println(Arrays.deepToString(temp.toArray()));

        }
    }
}