class Solution {
    public List<String> summaryRanges(int[] nums) {
        /*
            Note down start, end at each index or use a while loop and keep incrementing i and append.
        */
        List<String> res = new ArrayList<>();
        if (nums.length == 0){
            return res;
        }
        if (nums.length == 1){
            res.add(String.valueOf(nums[0]));
            return res;
        }
        int start = nums[0];
        int end = nums[0];
        for (int i=1; i<nums.length; i++){
            if ( i < nums.length && nums[i] == end+1) {
                end = nums[i];
            } else {
                StringBuilder sb = new StringBuilder();
                    sb.append(String.valueOf(start));
                if (end != start) {
                    sb.append("->");
                    sb.append(String.valueOf(end));
                }
                
                res.add(sb.toString());
                System.out.println(nums[i]);
                start = nums[i];
                end = nums[i];
            }
            if (i == nums.length - 1) {
                StringBuilder sb = new StringBuilder();
                sb.append(String.valueOf(start));
                if ( end != start) {
                    sb.append("->");
                    sb.append(String.valueOf(end));
                }
                res.add(sb.toString());
            }
        }
        return res;
    }
}