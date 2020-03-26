class Solution {
/*
    Trie solution to wrodbreak.
    We insert the words in reverse order in trie.
    While filling the dp values, for a particular length (i), we iterate from j = i to 0 and check
    if it is present in trie or not. Also, we check if dp[j-1] is true or not. Based on that 
    we update dp[i] value.
    dp[i] means whether that particular word(0,i) can be broken down with words in dictionary.
    eg: dict = ["leet","code"], word = leetcode -> l,le, lee, leet (leet) Now, trie will be visited
    with t,e,e,l and since trie consists this, it will return true and for empty string (j == 0 || dp[j-1]), it
    will be true as well, so we update dp[3] i.e. leet to be true. Next, when "leetcode" entire is 
    travesrsed, we start searching the trie for 'e', 'd', 'o', 'c', all of which is present along with
    dp[3], hence dp[7] will be true, which is our answer.

    Although this problem can be solved using memoization, Tries are particularly useful, let's say if we have
    a very large dictionary and hence we would want to call search multiple times. 

     DP with Trie.
 Time complexity is O(n + m) * k, where n is the length of the String s, m is the size of the wordDict, 
 and k is the maximum length of the word in wordDict. The Trie construction takes O(mk) time 
 and the check of whether s can be broken into the words in wordDict takes O(nk) time.
*/

    class TrieNode {
        boolean isWord;
        TrieNode[] child;
        
        public TrieNode() {
            isWord = false;
            child = new TrieNode[26];
        }
    }
        
        public void add(String word, TrieNode cur) {
            for (int i=word.length() - 1; i>=0; i--) {
                if (cur.child[word.charAt(i) - 'a'] == null) {
                    cur.child[word.charAt(i) - 'a'] = new TrieNode();
                }
                cur = cur.child[word.charAt(i)-'a'];
            }
            cur.isWord = true;
        }
        
        public TrieNode isPresent(TrieNode cur, Character ch) {
                if (cur == null || cur.child[ch - 'a'] == null) {
                    return null;
                } else {
                    return cur.child[ch - 'a'];
                }
            }
        
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) return false;
        boolean[] dp = new boolean[s.length()];

        TrieNode root = new TrieNode();
        for (String word: wordDict) add(word, root);
        
        for(int i=0; i<s.length();i++){
            TrieNode cur = root;
            for (int j=i; j>=0; j--){
                char ch = s.charAt(j);
                cur = isPresent(cur, ch); // getting the node, so as to prevent searching from root of trie again and again.
                if (cur == null) break;
                if (cur.isWord && (j == 0 || dp[j-1])){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()-1];
    }
}