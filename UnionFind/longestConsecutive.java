class Solution {
    public int longestConsecutive(int[] nums) {
        /*
            finding the first element of the consecutive sequence and then finding the next ones.
            T.C- O(n)
        */
        HashSet<Integer> hm = new HashSet<>();
        for (int i=0; i<nums.length; i++) {
            hm.add(nums[i]);
        }
        int longest = 0;
        
        for (int num : hm) {
            int key = num;
            if(!hm.contains(key - 1)) {
                int count = 1;
                while(hm.contains(key + 1)) {
                    count++;
                    key++;
                }
                longest = Math.max(longest, count);
            }
        }
        return longest;
    }
}

