class Solution {
    /*
    We use rule from combinatorics to find the unique number that can take
    place at each position of the digit.
    */
    public int countNumbersWithUniqueDigits(int n) {
    
        if (n == 0) {
            return 1;
        }
        
        if (n == 1) {
            return 10;
        }
        
        if (n == 2) { // for two digits to have unique digit, 9 * 9 = 81 ways plus 10 for single digit numbers.
            return 91;
        }
        
        int cur = 91;
        int prod = 81; // 9 for first digit, 9 for second digit to be unique
        int num = 8;
        int end = 3;
        
        while (end <= n) {
            prod = prod*num; // no. of ways the digits can be unique.
            end++;
            num--;
            cur = cur + prod; // adding previous ways for digits to be unique.
        }
        return cur;
    }
}