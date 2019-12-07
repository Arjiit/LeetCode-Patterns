class Solution {
    class TrieNode {
        char val;
        TrieNode[] children;
        
        public TrieNode() {
            children = new TrieNode[27];
        }
    }
    
    public void insert(String word, TrieNode node) {
            TrieNode cur = node;
            for (int i=0; i<word.length(); i++) {
                int char_no = word.charAt(i) - 'a';
                if (cur.children[char_no] == null) {
                    cur.val = word.charAt(i);
                    cur.children[char_no] = new TrieNode();
                }
                cur = cur.children[char_no];
            }
    }
    
    public String longestCommonPrefix(String[] strs) {
        TrieNode root = new TrieNode();
        int len = Integer.MAX_VALUE;
        for (String s: strs) {
            insert(s, root);
            len = Math.min(len, s.length());
            if (s.equals("")) return "";
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(root.children != null && i < len) {
            if (isOne(root.children)) {
                sb.append(root.val);
            } else {
                break;
            }
            i++;
            root = root.children[root.val - 'a'];
        }
        return sb.toString();
    }
    
    public boolean isOne(TrieNode[] arr) {
        int count = 0;
        for(int i=0; i<arr.length; i++) {
            if (count > 1) break;
            if (arr[i] != null) count++;
        }
        return count == 1 ? true:false;
    }
}