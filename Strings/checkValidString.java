class Solution {
    public boolean checkValidString(String s) {
        int leftBracket = 0;
        for (int i=0;  i<s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '*') {
                leftBracket++;
            } else {
                leftBracket--;
            }
                if (leftBracket < 0) {
            return false;
        }
        }
        
        if (leftBracket == 0) {
            return true;
        }
        int rightBracket = 0;
        for (int i=s.length()-1; i>=0; i--) {
            if (s.charAt(i) == ')' || s.charAt(i) == '*') {
                rightBracket++;
            } else {
                rightBracket--;
            }
            if (rightBracket < 0) {
            return false;
        }
        }
        
        return true;
    }
}