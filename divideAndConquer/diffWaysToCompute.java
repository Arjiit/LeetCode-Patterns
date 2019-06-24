class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        if (input.isEmpty()) {
            return null;
        }
        
        return ways(input, 0, input.length() -1);
    }
    
    public List<Integer> ways(String input, int l, int r) {
        List<Integer> res = new ArrayList<>();
        List<Integer> left;
        List<Integer> right;
        
        for (int i=l; i <= r; i++) {
            if (isOperator(input.charAt(i))) {
                left = ways(input, l, i-1); // will return a list
                right = ways(input, i+1, r);
                
/*              for (int i=0; i<input.length(); i++) 
                String part1 = input.substring(0, i);
                String part2 = input.substring(i+1);
                List<Integer> part1Ret = diffWaysToCompute(part1);
                List<Integer> part2Ret = diffWaysToCompute(part2);
*/
                for (int L:left) {
                    for(int R:right) {
                        res.add(calculate(L, R, input.charAt(i)));
                    }
                }
            }
        }
        if (res.size() == 0) {
            res.add(Integer.valueOf(input.substring(l,r+1)));
        }
        return res;
    }
    
    public boolean isOperator(char ch) {
        if (ch == '+' || ch == '-' || ch == '*') {
            return true;
        }
        return false;
    }
    
    public int calculate(int left, int right, char operator) {
        if (operator == '+') {
            return left + right;
        }
        
        if (operator == '-'){
            return left - right;
        }
        
        if (operator == '*') {
            return left*right;
        }
        return 1;
    }
}