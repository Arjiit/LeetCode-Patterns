class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        possibleLists(candidates, target, 0, candidates.length, temp, res, 0);
        return res;
    }
    
    public void possibleLists(int[] candidates, int target, int start, int end, List<Integer> temp, List<List<Integer>> res, int total) {
        if (total > target) {
            return;
        }
        
        if (total == target) {
            if(!res.contains(temp)){
                res.add(new ArrayList(temp));
            }
        }
        
        for (int i = start; i<end; i++) {
            temp.add(candidates[i]);
        System.out.println(Arrays.deepToString(temp.toArray()));
            possibleLists(candidates, target, i+1, end, temp, res, total + candidates[i]);
            System.out.println("here");
            temp.remove(temp.size() -1);
        System.out.println(Arrays.deepToString(temp.toArray()));
        }
    }
}