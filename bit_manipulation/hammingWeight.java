public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        /*
        in java, there is no unsigned int, max number possible is 2147483647, So, the input
        2147483648 is represented in Java as -2147483648, since int type in java has
        cyclic representation i.e.  Integer.MAX_VALUE+1==Integer.MIN_VALUE, hence we 
        use (n != 0) instead of (n > 0) because 2147483648 would be seen as -2147483648.
        */
        int count = 0;
        int andResult = 0;
        while (n != 0) {
            andResult = n & 1;
            if (andResult == 1) {
                count++;
            } 
            n = n >>> 1; // unsigned bit shifting
        }
        return count;
    }
}