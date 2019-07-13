class Solution {
    public int singleNumber(int[] nums) {
        /*
        for each ith position of the bit for all the numbers, since every element is appearing
        three times, if count of 1's is divisible by 3 on ith position, then we set bit to 0
        else 1.
        */
    int key;
    int result=0;
    for(int i=0;i<32;i++){
        key=0;
        for(int j=0;j<nums.length;j++){
            key+=(nums[j]>>i)&1;
        }
        result|=((key%3)<<i);
    }
    return result;
}
}