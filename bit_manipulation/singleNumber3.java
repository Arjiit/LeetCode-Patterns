class Solution {
    public int[] singleNumber(int[] nums) {
        /*
        We keep xoring elements in the array and since 0^N = N and N^N = 0, then result would have a^b since a
        and b occur just once. So, we could also be sure that there would definitely be a 1 in the result as 
        a and b are different numbers. So, we have to find that last set bit, which we can find by this formula
        diff = diff & ~(diff - 1), this would make the last set bit as 1 and rest 0. So, this is the bit which 
        differs in a and b. So, we loop throught the array again and check the elements having this set bit 
        and this bit unset and xor in those two halves to find a and b.
        */
        // Pass 1 : 
        // Get the XOR of the two numbers we need to find
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        // Get its last set bit
        diff &= -diff;
        
        // Pass 2 :
        int[] rets = {0, 0}; // this array stores the two numbers we will return
        for (int num : nums)
        {
            if ((num & diff) == 0) // the bit is not set
            {
                rets[0] ^= num;
            }
            else // the bit is set
            {
                rets[1] ^= num;
            }
        }
        return rets;
    }
}