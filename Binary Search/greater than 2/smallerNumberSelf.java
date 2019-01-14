class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        if (nums.length == 0) {
            return res;
        }
        int r = nums.length - 1;
        for (int i =0; i< nums.length-1; i++) {
            int count = 0;
            for (int end = i+1; end < nums.length; end++) {
                if (nums[i] > nums[end]) {
                    count++;
                }
            }
            res.add(count);
        }
        res.add(0);
        
        return res;
    }
}