class Solution {
    public int hammingDistance(int x, int y) {
    /*
    We need to find the different digits, we see that if
    we take 'and' of the digit and 'or' of the digit then check if 
    they are npt equal, then they digits are different.
    We do an 'and' with 1 to find out the last bit of the number
    and keep doing right shift till the number is 0.
    */
        int orResult = 0;
        int andResult = 0;
        int count = 0;
        int lastbit1 = 1;
        int lastbit2 = 1;
        while(x > 0 || y > 0) {
            lastbit1 = x & 1;
            lastbit2 = y & 1;
            orResult = lastbit1 | lastbit2;
            andResult = lastbit1 & lastbit2;
            System.out.println(orResult);
            System.out.println(andResult);
            if (orResult != andResult) {
                count++;
            }
            x = x >> 1;
            y = y >> 1;
            
        }
        return count;
    }
}