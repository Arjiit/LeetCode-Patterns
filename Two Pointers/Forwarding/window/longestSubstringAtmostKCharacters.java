class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
    
        if (s == null || s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        int start = 0;
        int end = 0;
        int maxLen = 0;
        
        while (end < s.length()) {
            char c = s.charAt(end);
            if (hm.containsKey(c)) {
                hm.put(s.charAt(end), hm.get(s.charAt(end)) + 1);
            } else {
                hm.put(s.charAt(end), 1);
            }
            
        while (hm.size() > k) {
            c = s.charAt(start);
            hm.put (c, hm.get(c) - 1);
            if (hm.get(c) == 0) {
                hm.remove(c);
            }
            start++;
            }
            maxLen = Math.max(maxLen, end - start + 1);
            end++;
        }
        return maxLen;
}
}
        