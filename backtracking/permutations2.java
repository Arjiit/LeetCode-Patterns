class Solution {
	public List<List<Integer>> permuteUnique(int[] nums) {
		boolean [] visited = new boolean [nums.length];
		Set<List<Integer>> set = new HashSet<>();
		helper(nums, visited, new ArrayList<>(),set);
		List<List<Integer>> res = new ArrayList<>(set);
		return res; 
	}
	/*
    We are keeping a track of position of element we have used from nums.
    So, we used a boolean visited array.
    */
		public void helper(int [] nums, boolean [] visited, List<Integer> temp, Set<List<Integer>> set){
		if (temp.size() == nums.length){
			set.add(new ArrayList<>(temp));
			return; 
		}
		
		for(int i = 0; i < nums.length; i++){
			if (!visited[i]){
				visited[i] = true; // we mark that the element in the array is visited.
				temp.add(nums[i]); 
				helper(nums, visited, temp, set);
				visited[i] = false; // un marking the element.
				temp.remove(temp.size()-1);
			}
		}
	}
}         

/*
when we are not using an HashSet, then we have to take care that, we don't add duplicate
numbers. (the condition, we put before adding in permutations questions)

		for(int i = 0; i < nums.length; i++){
			if (!visited[i]) {
				continue;
			}

			used[i] = true;
			temp.add(nums[i]);
			helper(nums, visited, temp, res);
			used[i] = false;
			temp.remove(temp.size() - 1);

			while(i+1 < nums.length && nums[i] == nums[i+1]) { // check for duplicates
				i++;
			}

		}

*/                                                                              