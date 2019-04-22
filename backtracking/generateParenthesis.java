class Solution {
    public List<String> generateParenthesis(int n) {
        /*
        keep track of open and close brackets
        if open == close then we can only place open brackets
        if open < close then we can either place open or close brackets
        when both open and close become 0, we have one of our answers
        */
        
        List<String> result = new ArrayList<>();
        String str = "";
        getParenthesis(n, n, str, result);
        
        return result;
    }
    
    public void getParenthesis(int open, int close, String current, List<String> result) {
        if (open == 0 && close == 0) {
            result.add(current);
            return;
        }
        
        if (open > 0) {
             getParenthesis(open - 1, close, current + "(", result);         
        }
        
        if (open < close) {
            getParenthesis(open, close - 1, current + ")", result);
        }
    }
}