class Solution {
    public int subarraySum(int[] nums, int k) {
       // y = curSum - k;
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        int curSum = 0;
        int count = 0;
        hm.put(0,1);
        for (int i=0; i< nums.length; i++) {
           curSum = curSum + nums[i];
            if (hm.containsKey(curSum - k)) {
                count = count + hm.get(curSum - k);
            } 
            if (!hm.containsKey(curSum)) {
                 hm.put(curSum, 1);    
            } else {
                hm.put(curSum, hm.get(curSum) + 1); 
            }
               
        }
        
        return count;
    }
}