class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0,1);
        
        for (int i=0; i<nums.length; i++) {
            sum = sum + nums[i];
            if (map.containsKey(sum - k)) {
                count = count + map.get(sum-k);
            }
            if (!map.containsKey(sum)) {
                map.put(sum,1);
            } else {
                map.put(sum,map.get(sum) + 1);
            }
        }
        return count;
    }
}