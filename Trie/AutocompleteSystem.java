class AutocompleteSystem {
    /*
     copies of complete sentences are stored at every TrieNode along its path down, which has pretty high memory overhead. 
     Instead, we should only "cache" the top 3 words in each Trie node. 
     Updating this every time is basically O(1) (only 3 items to look at/compare). 
     This both reduces the total memory used but also reduce the suggestion 
     running time to O(1) (excluding when encountering '#', which requires updating the Trie).

     here for example: "I love you", "I love leetcode", "island"
     First node "i" will have Map of sentence and count with it too - [("I love you", 5), ("I love leetcode", 2), ("island", 3)]
     then the node " " will have [("I love you", 5), ("I love leetcode", 2)], node "s" will have [("island", 3)].
     This is done, so that whenever an input is searched for, we add it to the prefix we are looking for and traverse
     to the last element of prefix node. Now at that node we just return the top 3 by inputting all elements of sentence, count
     map of that node in priorityqueue.
    */
    class TrieNode {
        Map<Character, TrieNode> children;
        Map<String, Integer> counts;
        boolean isWord;
        
        public TrieNode() {
            children = new HashMap<Character, TrieNode>();
            counts = new HashMap<String, Integer>();
            isWord = false;
        }
    }
    
    TrieNode root;
    String prefix;
    
    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        prefix = "";
        
        for (int i=0; i<sentences.length; i++) {
            addSentence(sentences[i], times[i]);
        }
                
    }
    
    public void addSentence(String s, int count) {
        TrieNode cur = root;
        for (char c: s.toCharArray()) {
            TrieNode next = cur.children.get(c); // will get the trienode corresponding to character c
            if (next == null) {
                next = new TrieNode();
                cur.children.put(c, next);
            }
            cur = next;
            // Every node in the trie stores a character from the sentence and also the complete sentence. Is it not a huge wastage of space? - We are making a tradeoff between the space and the time to search for words.

            cur.counts.put(s, cur.counts.getOrDefault(s,0) + count);
        }
        cur.isWord = true;
        
    }
    
    public List<String> input(char c) {
        // if we encounter # we know we have reached the end of sentence and we need to update it in our trie
        if (c == '#') {
            addSentence(prefix, 1);
            // resetting prefix for next inputs
            prefix = "";
            return new ArrayList<String>();
        }
        
        prefix = prefix + c;
        TrieNode curr = root;
        
        // move the pointer to the char being searched for
        for(char cc: prefix.toCharArray()) {
            TrieNode next = curr.children.get(cc);
            if (next == null) { // if there's nothing in memory with this character return empty list
                return new ArrayList<String>();
            }
            curr = next; // else just move to the last character of the sentence searched in the trie
        }
        // we need to have a priority queue since we have to return top 3 results and also, if the they occur same number of times, we need to compare using ASCII value. Hence, we will modify the priority queue.
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a,b) -> (a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey()):b.getValue() - a.getValue()));
        pq.addAll(curr.counts.entrySet());
        List<String> res = new ArrayList<>();
        int k = 3;
        while(!pq.isEmpty() && k> 0) {
            res.add((String)pq.poll().getKey());
            k--;
        }
        return res;
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */