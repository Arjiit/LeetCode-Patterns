class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0 && t.length() == 0) {
            return true;
        }
        if (s.length() == 0 && t.length() != 0) {
            return true;
        }
        int s_ptr = 0;
        for (int i=0; i<t.length(); i++) {
            if (t.charAt(i) == s.charAt(s_ptr)) {
                s_ptr++;
            }
            if (s_ptr == s.length()) {
                return true;
            }
        }
        return false;
    }
}