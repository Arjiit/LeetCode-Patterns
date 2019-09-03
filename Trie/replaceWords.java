class TrieNode{
    /*
        T.C- O((number of words in sentences)*(avg length of word)) - effectively O(N)
        Query of a word in Trie is in linear time.
    */
        TrieNode[] children;
        String word; // we will store the node with word once it has reached the end letter of the word.
        
        public TrieNode() {
            children = new TrieNode[26];
        }
    }
    
class Solution {
    
    public String replaceWords(List<String> dict, String sentence) {
        
        TrieNode root = new TrieNode();
        for (String w: dict){
            TrieNode cur = root;
            for (char letter: w.toCharArray()) {
                if (cur.children[letter - 'a'] == null) {
                    cur.children[letter - 'a'] = new TrieNode();
                }
                cur = cur.children[letter - 'a'];
            }
            cur.word = w; // in the last letter node, add the word
        }
        
    StringBuilder ans = new StringBuilder();
        
        for(String words: sentence.split("\\s+")) { // iterating all words in the sentence
            
            TrieNode cur = root;
            for (char letter: words.toCharArray()) {
                if (cur.children[letter - 'a'] == null || cur.word != null) { // if we find a null node or we reach end of trie, we break
                    break;
                }
                cur = cur.children[letter - 'a'];
            }
            ans.append(cur.word != null ? cur.word:words);
            ans.append(" ");
        }
        return ans.toString().trim();
    }
}