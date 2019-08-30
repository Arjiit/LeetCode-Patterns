class Solution {
    public String removeDuplicateLetters(String s) {
    // T.C. - O(n)
        /*
        We maintain two arrays, count to store the number of characters of each type in the string and a boolean array
        to keep track if we have used the element or not.
        We compare the last element of the appended stringbuilder to the next element and if it is lexicographically
        smaller, we check if stringbuilder's last element occurs later in our string using count array, if it does
        we delete it from stringbuilder and add it later.
        */
        StringBuilder sb = new StringBuilder();
        int[] count = new int[26];
        boolean[] used = new boolean[26];
        for (char c: s.toCharArray()) {
            count[c - 'a']++;
        }
        char[] chs = s.toCharArray();
        for (char c: chs) {
            count[c - 'a']--;
            
            if (used[c-'a']) {
                continue;
            }
            
            while(sb.length() > 0 && c < sb.charAt(sb.length() - 1) && count[sb.charAt(sb.length() - 1) - 'a'] > 0) { // if there exists an element later
                used[sb.charAt(sb.length() -1) - 'a'] = false; //mark it as unused
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.append(c);
            used[c - 'a'] = true; //since we have appended, we mark it as true
        }
        return sb.toString();
    }
}