class Solution {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {
        /*
            N - length of words1 array
            P - Size of pairs array
            Total no. of operations= (N+P).
            Number of nodes = 2P
            Time Complexity = O((N+P)*alpha(P))
            alpha(P) - Inverse Ackerman function that grows very slowly and is < 4
            T.C - O(N+P), S.C. = O(P)
        */
        if (words1.length != words2.length) {
            return false;
        }
        
        HashMap<String, String> parent = new HashMap<>();
        
        for(List<String> pair: pairs) {
            String p1 = findParent(pair.get(0), parent);
            String p2 = findParent(pair.get(1), parent);
            // if p1 is not equal to p2, we need to set up relationship between that
            // hence we make one parent of other. p2 as parent of p1
            if (!p1.equals(p2)) {
                parent.put(p1, p2);
            }
        }
        
        // now we will loop through the words and see if relationship exists. Relationship would exist if they have same parent
        for (int i=0; i<words1.length; i++) {
            String p1 = findParent(words1[i], parent);
            String p2 = findParent(words2[i], parent);
            if (!p1.equals(p2)) {
                return false;
            }
        }
        return true;
    }
    
    public String findParent(String s, HashMap<String, String> parent) {
        if (parent.containsKey(s)) { // that means a entry with child s as key and value as parent exists, then we go on to find the parent of the value
            return findParent(parent.get(s), parent);
        }
        return s;
    }
    
}