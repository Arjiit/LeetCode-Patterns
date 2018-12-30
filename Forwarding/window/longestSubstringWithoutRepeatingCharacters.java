class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet hs = new HashSet<>();
        int head = 0;
        int res = 0;
        for (int i =0; i<s.length(); i++) {
            while(hs.contains(s.charAt(i))) {
                hs.remove(s.charAt(head));
                head++;
            }
            hs.add(s.charAt(i));
            res = Math.max(res, i - head + 1);
        }
        return res;
    }
}