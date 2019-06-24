class Solution {
    public List<Integer> splitIntoFibonacci(String S) {
        /*
        prev
        prevPrev
        cur = prev + prevPrev
        when cur != prev + prevPrev (break)
        
        we add the number to result array only if it matches the condition and then call
        boolean backtrack function
        to check if we get true (only get true on base condition), on other conditions
        the loop will break. If true is found, then all together the function returns
        true else if nothing works, false is returned.
        */
        
        List<Integer> res = new ArrayList<>();
        backtrack(S, res, 0);
        return res;
    }
    
    public boolean backtrack(String s, List<Integer> res, int pos){
        if (pos==s.length() && res.size() >= 3) {
            return true;
        }
        
        for(int i= pos; i<s.length(); i++) {
            if (s.charAt(pos) == '0' && i > pos) {
                break;
            }
            
            long num = Long.parseLong(s.substring(pos, i+1));
            if (num > Integer.MAX_VALUE) {
                break;
            }
            
            int size = res.size();
            if ((size) >= 2 && (num > res.get(res.size() - 1) + res.get(res.size()-2))) {
                break;
            }
            
            if (size <= 1 || (num == res.get(res.size()-1) + res.get(res.size()-2))) {
                res.add((int)num);
                // branch pruning. if one branch has found fib seq, return true to upper call
                if (backtrack(s, res, i+1)) {
                    return true;
                }
                res.remove(res.size() - 1);
            }
        }
        return false;
    }
}