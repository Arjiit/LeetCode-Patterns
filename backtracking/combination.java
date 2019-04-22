class Solution {
    
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(n,k,new ArrayList<>(), 1, result);
        return result;
    }
    
    private void backtrack(int n, int k, List<Integer> curList, int start, List<List<Integer>> result){
        if(curList.size() == k){
            result.add(new ArrayList<>(curList));
            return;
        }
        
        for(int i = start; i <= n; i++){
             curList.add(i);
             backtrack(n, k, curList, i + 1, result);
             curList.remove(curList.size() - 1); // removing last element so as to backtrack
            // so after [1,2]
            /*
            2 gets removed and we have [1] with i = 2, 
            now i gets incremented in the for loop and becomes 3, so 3 gets added to curList, so we have [1,3]
            again base case is reached [1,3] is added to result.
            3 is removed. i is 3 and in next for loop i becomes 4, so now 4 gets added [1,4] and so 
            on.
            once all combinations of 1 has been added, we go back to first call in the stack that was
            backtrack with curList as [1] and i = 1 and then next line is executed from which 1 is removed and i is incremented to 2. and now 2 gets added to curList and we have in curList = [2].
            */
        }
    }
}