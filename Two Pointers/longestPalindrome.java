class Solution {
// O(N^2) time, O(1) space
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0;
        int end = 0;
        for (int i=0; i<s.length(); i++) {
            int len1 = expandFromCentre(s, i, i); //"racecar" for 'e'
            int len2 = expandFromCentre(s, i, i+1); //babaabab
            
            int max_len = Math.max(len1, len2);
            if (max_len > end - start) {
                start = i - ((max_len - 1)/2);
                end = i + (max_len/2);
            }
        }
        return s.substring(start, end+1);
    }
    
    public int expandFromCentre(String s, int left, int right) {
        if (s == null || left > right) return 0;
        
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}