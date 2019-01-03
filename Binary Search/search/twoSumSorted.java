class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;
        int[] res = new int[2];
        while (l<r) {
            int sum = numbers[l] + numbers[r];
            
            if (sum == target) {
                res[0] = l+1;
                res[1] = r +1;
                return res;
            }
            if ( sum < target) {
                l++;
            } else if (sum > target){
                r--;
            }
            
        }
    return new int[0];
    }
    
}