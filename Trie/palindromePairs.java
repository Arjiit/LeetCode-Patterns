
class Solution {
/*
T.C. - O(NKK) as most time consuming function is when we search for palindrome after we have 
constructed a trie. Iterating over words of the list is O(N) followed by call to searchPalindromm
which traverses to length of word i.e. O(k) with another O(k) to check for isPalindrome section
Hence the T.C is O(NKK).
*/
    
class TrieNode {
    TrieNode[] next;
    int index;
    List<Integer> list;
    
    public TrieNode() {
        next = new TrieNode[26]; // to record next letter in the word
        index = -1; // if no word ends on this node return -1
        list = new ArrayList<>();
        
    }
}
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        TrieNode root = new TrieNode();
        
        // inserting words into  trie
        for (int i=0; i<words.length; i++) {
            addWord(root, words[i], i);
        }
        
        for (int i=0; i<words.length; i++) {
            searchPalindromm(words[i], res, root, i); // will search for palindrome and update res
        }
        return res;
    }
    private void searchPalindromm(String word, List<List<Integer>> res, TrieNode node, int indexWord) {
        /* if word is greater than word in trie, then check if it has matched all the
            letters in the trie and reached the end. So, check if it reaches end via the 
            index of the node of trie and check if the rest of the word is palindrome.

            If the word is shorter, this loop will match till the part of the trie and rest of the trie
            check is done after this which can be the end of the word itself or checking whether rest of 
            the trie is palindrome, the information is stored in the list of the node.
        */
        for (int j=0; j<word.length(); j++) {
            if (node.index != -1 && node.index != indexWord && isPalindrome(word, j, word.length() - 1)) {
                res.add(Arrays.asList(indexWord, node.index));
            }
            node = node.next[word.charAt(j) - 'a'];
            if (node == null) { // if the letters don't match return
                return;
            }
        }
        
        /*
        If the word is smaller then the word in trie, we will compare the letters till we reach the end of the letters of the word and then check if the rest of the trie is palindrome or not by checking the list. Also, if it is the last node in trienode, add to list.
        */
        if (node.index != -1) {
            if (indexWord != node.index) {
                res.add(Arrays.asList(indexWord, node.index));
            }
        }
        
        for (int k: node.list) {
            if (indexWord == k) {
                continue;
            }
            res.add(Arrays.asList(indexWord, k));
        }
        
        
    }
    private void addWord(TrieNode node, String word, int index) {
        // inserting words in reverse order, "abcd" would be inserted as d first and a last
        for (int i=word.length() - 1; i>= 0; i--) {
            int trieIndex = word.charAt(i) - 'a';
            if (node.next[trieIndex] == null) {
                node.next[trieIndex] = new TrieNode();
            }
            /* so if abcd is inserted and we have aabcd and ababcd too, so, when
            aabcd is inserted as dcba, the rest part i.e. 'a' is checked if it is 
            palindrome or not, it is, hence we add index of word 'aabcd' from the
            array in the node a's list. Also, we continue adding it to trie. This is 
            done so that when we search for palindrome and our word is smaller than 
            trie, then we check for rest of the trie if it is palindrome or not through
            the information stored in the list.
            */
            
            if(isPalindrome(word, 0, i)) { // if from this trienode to beginning of word is palindrome
                node.list.add(index);
            }
            node = node.next[trieIndex];
        }
        node.index = index; // after the word has been completely added, put it's index
    }
    
    private boolean isPalindrome(String word, int i, int j) {
        while( i < j) {
            if(word.charAt(i) != word.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}