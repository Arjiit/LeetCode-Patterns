class Solution {
    // Using DFS and storing results in a hashmap.
    /*
    In the worst case the runtime of this algorithm is O(2^n).

Consider the input "aaaaaa", with wordDict = ["a", "aa", "aaa", "aaaa", "aaaaa", "aaaaa"]. Every possible partition is a valid sentence, 
and there are 2^n-1 such partitions. It should be clear that the algorithm cannot do better than this since 
it generates all valid sentences. 
The cost of iterating over cached results will be exponential, as every possible partition will be cached, 
resulting in the same runtime as regular backtracking. Likewise, the space complexity will also be O(2^n) 
for the same reason - every partition is stored in memory.

Where this algorithm improves on regular backtracking is in a case like this: "aaaaab", 
with wordDict = ["a", "aa", "aaa", "aaaa", "aaaaa", "aaaaa"], i.e. the worst case scenario for Word Break I,
where no partition is valid due to the last letter 'b'. 
In this case there are no cached results, and the runtime improves from O(2^n) to O(n^2).
    */
    public List<String> wordBreak(String s, List<String> wordDict) {
        return dfs(s, wordDict, new HashMap<String, LinkedList<String>>());
    }
    
    public List<String> dfs(String s, List<String> wordDict, HashMap<String, LinkedList<String>> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        
        LinkedList<String> res = new LinkedList<>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        
        for (String word: wordDict) {
            if (s.startsWith(word)) {
                List<String> subList = dfs(s.substring(word.length()), wordDict, map);
                for (String sub: subList) {
                    res.add(word + (sub.isEmpty() ? "": " ") + sub);
                }
            }
        }
        map.put(s, res);
        return res;  
    }
}