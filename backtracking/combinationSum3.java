class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        getResult(k, n, new ArrayList<>(), res, 1);
        return res;
    }
    /*
    Idea is to try different combinations and keep track of temporary list 
    size and the remaining sum to target.
    */
    
    public void getResult(int k, int n, List<Integer> temp, List<List<Integer>> result, int start) {
        if ((temp.size() == k)&&(n == 0)) {
            result.add(new ArrayList<>(temp));
        }
        
        for (int i=start; i<10; i++) {
            if (i > n) {
                break;
            }
            
            temp.add(i);
        System.out.println(Arrays.deepToString(temp.toArray()));
            getResult(k, n - i, temp, result, i+1);
            System.out.println("here");
            temp.remove(temp.size() - 1);
            System.out.println(Arrays.deepToString(temp.toArray()));
        }
    }
}