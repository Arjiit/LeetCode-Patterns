class Solution {
    public int scoreOfParentheses(String S) {
        /*
            "(()(()))"
            (1.(1)) -> (1.2) -> (3) -> 6
        */
        int layer = 0;
        int score = 0;
        char prev = 'a';
        for (int i=0; i<S.length(); i++) {
            if (S.charAt(i) == '(') {
                layer++;
                prev = '(';
            } else {
                layer--;
                if (prev == '(') {
                    score += Math.pow(2,layer);
                }
                
                prev = ')';
            }
        }
        return score;
    }
}