class Solution {
    public List<Integer> majorityElement(int[] nums) {
        /*
        there can be atmost 2 majority elements when we have to find elements that appear more 
        than n/3 times. Hence, we maintain two counters and apply bayers moore voting algorithm.
        */
        List<Integer> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }
        int count1 = 1;
        int count2 = 0;
        int major1 = nums[0];
        int major2 = nums[0];
        
        for (int i=0; i< nums.length; i++) {
            if (nums[i] == major1) {
                count1++;
            } else if (nums[i] == major2) {
                count2++;
            } else if (count1 == 0) {
                major1 = nums[i];
                count1 = 1;
            } else if (count2 ==0) {
                major2 = nums[i];
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        // now that we have found candidates, we have to check if they 
        // are more occuring more than n/3 times;
        
         count1 = 0;
         count2 = 0;
        
        for (int num : nums) {
            if (num == major1) {
                count1++;
            } else if (num == major2) {
                count2++;
            }
        }
        
        if (count1 > nums.length/3) {
            res.add(major1);
        }
        
        if (count2 > nums.length/3) {
            res.add(major2);
        }
        
        return res;
    }
}