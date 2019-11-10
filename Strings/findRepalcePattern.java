class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        /*
        Keeping two hashmaps to keep track of characters in (pattern, word) and (word, pattern)
        */
        List<String> res = new ArrayList<>();
        
        for (int i=0; i < words.length; i++) {
            if (isMatch(words[i], pattern)) {
                res.add(words[i]);
            }
        }
        return res;
    }
    
    public boolean isMatch(String word, String pattern) {
        HashMap<Character, Character> hm1 = new HashMap<>();
        HashMap<Character, Character> hm2 = new HashMap<>();
        
        for(int i=0; i<word.length(); i++) {
            if (!hm1.containsKey(word.charAt(i))) {
                hm1.put(word.charAt(i), pattern.charAt(i));
            }

            if (!hm2.containsKey(pattern.charAt(i))) {
                hm2.put(pattern.charAt(i), word.charAt(i));
            }
            
            if ((hm1.get(word.charAt(i)) != pattern.charAt(i)) || (hm2.get(pattern.charAt(i)) != word.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    
    
}