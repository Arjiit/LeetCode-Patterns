class WordDictionary {
    /*
    In theory you could construct a search string consisting only of '.' characters, and make the search string longer than any word in a trie. In this case every single node will be searched.
It would still be A LOT less then O(26^n) as it's imporbable that every node has a fully filled set of child nodes.
    */
    // Define what TrieNode would have (consisting itself as a node)
    class TrieNode {
        TrieNode[] child;
        boolean isWord;
    public TrieNode() { // constructor to initialize the node
        child = new TrieNode[26];
        isWord = false;
    }
  }

    TrieNode root;
    

    /** Initialize your data structure here. */
    public WordDictionary() { // constructor to initialize the class and set the root
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode cur = root;
        for (char c: word.toCharArray()) {
            int index = (int) (c - 'a');
            if (cur.child[index] == null) {
                cur.child[index] = new TrieNode(); // create a child TrieNode which will have TrieNode and isWord properties
            }
            cur = cur.child[index]; // move the current to the child node
        }
        cur.isWord = true; // once we have reached the end of the TrieNode, mark it as word
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return find(word, root, 0);
    }
    
    public boolean find(String word, TrieNode current, int index) {
        if (index == word.length()) {
            return current.isWord;
        }
        char c = word.charAt(index);
        if (c == '.') {
            for (int i=0; i<current.child.length; i++) { // looking at all the values in the children
                if (current.child[i] != null && find(word, current.child[i], index+1)) // once non-null value is found, recurse further too find the word
                    return true;
            }

                    return false;
        } else 
            return (current.child[c - 'a'] != null && find(word, current.child[c - 'a'], index+1));

    }
    
    
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */