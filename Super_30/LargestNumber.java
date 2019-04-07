class Solution {
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i=0; i< nums.length; i++) { // converting int array to string
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, new Comparator<String>() {
            public int compare(String str1, String str2) {
                String s1 = str1 + str2;
                String s2 = str2 + str1; // concatenating both ways and checking which is highest
                return s2.compareTo(s1);
            }
        });
        for (int i=0; i < strs.length; i++) {
            System.out.print(strs[i]);
        }
        if (strs[0].equals("0")) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        for (String str: strs) {
            //System.out.println(str);
            
            sb.append(str);
            //System.out.println(sb.toString());
        }
        return sb.toString(); // returning as a string
    }
}