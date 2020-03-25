class Solution {
    /*  m - avg length of product, n - length of product array
        Sorting strings array - O(mnlogn)
        TC - O(mnlogn)
        Building trie - O(mn)
        Space - O(mn + Lm) L = length of word search. (as we are constructing L genrated sublists)
    */
    class TrieNode {
        TrieNode[] child;
        LinkedList<String> suggestion = new LinkedList<>();
        public TrieNode() {
            child = new TrieNode[26];
        }
    }
    
    public void insert(String word, TrieNode root) {
        TrieNode cur = root;
        for (int i=0; i<word.length(); i++) {
            if (cur.child[word.charAt(i) - 'a'] == null) {
                cur.child[word.charAt(i) - 'a'] = new TrieNode();
            }
            cur = cur.child[word.charAt(i) - 'a'];
            if (cur.suggestion.size() < 3) {
                cur.suggestion.add(word); // put products with same prefix in the suggestion list
            }
        }
    }
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products); // sorting products array of strings
        
        TrieNode root = new TrieNode();
        for (String p: products) {
            insert(p, root);
        }
        List<List<String>> res = new ArrayList<>();
        for (char c: searchWord.toCharArray()) {
            if (root != null) {
                root = root.child[c - 'a'];
            }
            res.add(root == null ? Arrays.asList(): root.suggestion);
        }
       return res; 
    }
}