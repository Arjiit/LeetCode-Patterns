class Solution {
    private boolean used[] = new boolean[9];
    
    public int numberOfPatterns(int m, int n) {
        int res = 0;
        for (int len = m; len <=n; len++) {
            res = res + calculatePatterns(-1, len); // we calculate number of patterns possible for
            //each length and every time we have to pass a new unused boolean array to keep track
            for (int i=0; i<9; i++) {
                used[i] = false;
            }
        }
        return res;
    }
    
    private int calculatePatterns(int last, int len) {
        if (len ==0) {
            return 1;
        }
        
        int sum = 0;
        for (int i=0; i<9; i++) {
            if (isValid(i, last)) { // we check if there is a path from last to i.
                used[i] = true; // if path exists then we mark i as visited.
                sum = sum + calculatePatterns(i, len - 1); // last gets updated to i and we move ahead
                used[i] = false; //after we are done exploring all possibilities from i, we recur back.
            }
        }
        return sum;
    }
    
    public boolean isValid(int index, int last) {
        if (used[index]) // if the digit is already used we can't move there from last
            return false;
        if (last == -1) { // first digit of pattern
            return true;
        }
        
        if ((index + last)%2 == 1) // moving across or bottom up in row or column
            return true;
        
        int mid = (index + last)/2;
        if (mid == 4) { // if last is at one end of diagonal and next(i) is on other end, then 
            // if mid element is selected then only we can move.
            return used[mid];
        }
        // adjacent cells on the diagonal - 00 and 10
        
        if ((index%3 != last%3) && (index/3 != last/3)) {
            return true;
        }
        // all other cells that are not adjacent
        return used[mid];
    }
}