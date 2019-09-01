class WordFilter {
    /*
    We are using Trie, so that accessing elements becomes easier. Trie is used to 
    save space as N becomes large. It gives O(L) find time. L is the length of
    maximum input string.
    N = number of words
    K = Maximum length of word
    Q = Number of queries
    WordFilter is effectively inserting words in the trie by doubling it for taking
    suffix into account. Hence it is O(NKK)
    Search of word with a certain prefix, suffix is O(QK)
    Space complexity would be size of the trie i.e. O(NKK)
    */
class TrieNode {
    TrieNode[] children;
    int weight;

    public TrieNode() {
        children = new TrieNode[27]; /* extra one memory for storing { */
        weight = 0;
    }
    
    public void insert(String word, int weight) {
        TrieNode cur = root;
        for (int i=0; i<word.length(); i++){
            if (cur.children[word.charAt(i) - 'a'] == null) {
                cur.children[word.charAt(i) - 'a'] = new TrieNode();
            }
            cur = cur.children[word.charAt(i) - 'a'];
            cur.weight = weight;
        }
    }
    
    public int startsWith(String prefix) {
        TrieNode cur = root;
        for (char c: prefix.toCharArray()) {
            TrieNode next = cur.children[c - 'a'];
            if (next == null) {
                return -1;
            }
            cur = next;
        }
        return cur.weight; // after it has reached end of the prefix string
    }
}
    
    TrieNode root;
    
    public WordFilter(String[] words) {
       root = new TrieNode();
        int len = words.length;
        for (int i=0; i<len; i++) {
            String s = words[i];
            // {apple, e{apple, le{apple, ple{apple, pple{apple, apple{apple
            for (int j=0; j<= s.length(); j++) {
                System.out.println(s.substring(j, s.length()) + '{' + s);
                root.insert(s.substring(j, s.length()) + '{' + s, i);
            }
        }
    }
    
    public int f(String prefix, String suffix) {
        return root.startsWith(suffix + '{' + prefix);
    }
    
}
    

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */