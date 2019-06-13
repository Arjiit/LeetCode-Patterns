class Solution {
   private int count;
    public int countArrangement(int N) {
        List<List<Integer>> res = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>(); 
        getArrangement(N, 1, set);
        return count;
    }
    
    /*
    if we add element to list and then check in the end, then we would get a TLE.
    Hence, we check before adding to the set and if it doesnt satisy we try the 
    next iteration, which would mean that set size would be less than N and so, the 
    count is not incremented and we go back and try different combinations.
    */
    
    public void getArrangement(int n, int pos, HashSet<Integer> set) {
        if (set.size() == n) {a
                count++;
            return;
        }
        
        for (int i=1; i<=n; i++) {
            if(set.contains(i)) {
                continue;
            }
            if (i%pos == 0 || pos%i ==0) { // first iteration it will check if 1%1, then 2%2 (i%pos) and next iteration 2%1(i%pos), then 2%1(pos%i). Removing the last element that is added so we get the
    /*
    [] -> [1] -> [1,2] -> [1] -> []
    [] -> [2] -> [2,1] -> [2] -> []
    
    pos keeps increasing in recursion to keep track of position.
    loop takes care of different order of numbers from the sequence.
    */
            
            set.add(i);
            getArrangement(n, pos+1, set);
            set.remove(i);

        }
    }
    }
}