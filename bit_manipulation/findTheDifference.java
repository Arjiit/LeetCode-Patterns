class Solution {
    public char findTheDifference(String s, String t) {
        /*
        Can also be done by bit manipulation, but keeping a track of 
        characters in the array.
        */
       int[] arr = new int[26];
        for (int i=0; i< s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        
        for (int i=0; i< t.length(); i++) {
            arr[t.charAt(i) - 'a']--;
        }
        
        for (int i=0; i< arr.length; i++) {
            if (arr[i] != 0) {
                return (char)(i + (int)'a');
            }
        }
        return s.charAt(0);
    }
}