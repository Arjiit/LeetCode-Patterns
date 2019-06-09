class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        getSubset(0, nums, new ArrayList<>(), res);
        return res;
    }
    /*
    Everytime we add a new element to the temp array,
    we add it to the final list.
    */
    
    public void getSubset(int startIndex, int[] nums, List<Integer> temp, List<List<Integer>> res) {
    
            res.add(new ArrayList<>(temp));
  
        
        for (int i=startIndex; i < nums.length; i++) {
            System.out.println(nums[i]);
            temp.add(nums[i]);
            getSubset(i+1, nums, temp, res);
            temp.remove(temp.size() - 1); // backtracking here.
        }
    }
}