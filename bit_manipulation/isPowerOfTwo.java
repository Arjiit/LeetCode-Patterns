class Solution {
    public boolean isPowerOfTwo(int n) {
        int count = 0;
        if (n == 0) {
            return false;
        }
        while (n > 0) {
            int andResult = n & 1;
            if (andResult == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count == 1 ? true:false;
    }
}