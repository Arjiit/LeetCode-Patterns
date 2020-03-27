class Solution {
    /*
        Similar to word break solution. TC- O(b^d) since each word can be broken down
        on an avg in b parts.
    */
    HashSet<String> set;
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        set = new HashSet<>();
        List<String> res = new ArrayList<>();
        if (words.length == 0 || words.length == 1) return res;
        for(String w: words) {
            set.add(w);
        }
        for(String w: words) {
            if (isConcat(w)) {
                res.add(w);
            }
        }
        return res;
    }
    
    public boolean isConcat(String word) {
        int len = word.length();
        for(int i=1; i<len; i++) {
            String prefix = word.substring(0,i);
            String suffix = word.substring(i);
            if (set.contains(prefix) && (set.contains(suffix) || isConcat(suffix))) {
                return true;
            }
        }
        return false;
    }
}


/*
String#hashCode() takes O(L) for the first computation.
 Because we use #substring() a lot here, we cannot utilize the hashCode cache,
  so dict.contains(word.substring(j, i)) in the inner loop takes O(L), which make it a triple loop over length L, 
  that's O(L^3), and the overall is O(N*L^3).
*/

class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        // we can only make combinations from smaller words. Hence, we sort
        
        Arrays.sort(words, new Comparator<String>() {
           public int compare(String s1, String s2) {
               return s1.length() - s2.length();
           } 
        });
        // or Arrays.sort(words, (a,b) -> a.length() - b.length());
        HashSet<String> preWords = new HashSet<>();
        for(int i=0; i<words.length; i++) {
            if (canForm(words[i], preWords)) {
                res.add(words[i]);
            }
            preWords.add(words[i]);
        }
        return res;
    }
    
    public boolean canForm(String word, HashSet<String> dict) {
        if (dict.isEmpty()) return false;
        boolean[] dp = new boolean[word.length() + 1];
        dp[0] = true;
        
        for(int i=1; i<=word.length();i++) {
            for(int j=0; j<i; j++) {
                if(dp[j] && dict.contains(word.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[word.length()];
    }
}