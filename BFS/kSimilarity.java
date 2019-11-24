class Solution {
    public int kSimilarity(String A, String B) {
        if (A.equals(B)) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(A);
        int res = 0;
        while (!queue.isEmpty()) {
            int q_size = queue.size();
            for (int i=0; i<q_size; i++) {
                String poll_str = queue.poll();
                if (visited.contains(poll_str)) continue;
                visited.add(poll_str);
                if (poll_str.equals(B)) {
                    return res;
                }
                
                for (String s : getNeighbours(poll_str.toCharArray(), B.toCharArray())) {
                    if (!visited.contains(s)) {
                        queue.add(s);
                    }
                }
            }
            res++;
        }
       return res; 
    }
    /*
    check all the possibilities of swapping in a, so as to make it same characters in b.
    eg: a = "abaac", b = "aaabc"
    mismatch at index = 1, can be fixed by replacements in a. (1<->2)(aabac) and (1<->3)(aaabc)
    So these two become the neighbours of a and if not visited, we add in queue for further processing.
    We increment levels only when all neighbours is seen. Hence, this gives us minimum swaps to make it
    similar, since we are going breadth wise.
    */
    
    public List<String> getNeighbours(char a[], char[] b){
        int i=0;
        while (i < a.length && a[i] == b[i]) {
            i++;
        }
        List<String> neighbours = new ArrayList<>();
        if (i == a.length) {
            return neighbours; // to solve array out of exception
        }
        char expected = b[i];
        for (int k=i+1; k < a.length; k++){
            if (expected == a[k]) { //if at any position in a we get b[i], we swap
            swap(a, k, i);
            String new_str = new String(a);
            neighbours.add(new_str);
            swap(a, k, i);
            }
        }
        
        return neighbours;
    }
    public void swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}