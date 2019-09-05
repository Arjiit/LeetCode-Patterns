class Solution {
    /*
    we need an count map for all the characters in the string.
    Here we would want to keep the most frequent letter appended
    to the string first and since this involves finding out the
    frequency comparison, we use max heap.
    So, we will go through the string and for, k = 1 separation between
    same characters, we will run a loop and append the most frequent char
    first, keep a track that we used it and then if k was let's say 2. we 
    would append the second most character from the heap to the string. After 
    this, we would check for the strings appended, whether they still have the
    count > 0 from the frequency map and if they do, then put them back in the 
    heap.
    T.C. - O(NlogA) - since heapify takes O(log A) time and we are putting N elements
    in it. A is the size of the alphabet.
    Space - O(A).
    */
    public String reorganizeString(String S) {
        if (S.length() < 1) {
            return S;
        }
        // we could use either a hashmap or array, we use array as we know we'll use 26
        int[] map = new int[26];
        for (char c: S.toCharArray()) {
            map[c - 'a']++;
        }
        // maxheap or PriorityQueue since if the frequency are the same, we would want to sort lexicographically
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : b[1] - a[1]); // since we would be storing in the priority queue as an array, with first element as the alphabet ordering and second as the frequency
        for (int i=0; i< 26; i++) {
            if (map[i] > 0) {
                heap.offer(new int[] {i, map[i]});
            }
        }
        StringBuilder sb = new StringBuilder();
        
        while(heap.size() > 0) {
            List<Integer> list = new ArrayList<>(); // list will store indices of the characters used
            // now we try to append k characters here k = 1;
            for (int i=0; i<2; i++) {
                // polling from the heap
                int[] curr = heap.poll();
                sb.append((char) (curr[0] + 'a')); // since we have to convert it from int to char
                map[curr[0]]--; // decrementing the count from the map
                list.add(curr[0]);
                
                if (heap.size() == 0) {
                    if (i != 1 && sb.length() != S.length()) {
                        return "";
                    }
                    break;
                }
            }
            // we have to readd all the characters from the list to the heap back if they still have non-zero frequency count
            for (int l: list) {
                if (map[l] > 0) {
                    heap.offer(new int[] {l, map[l]});
                }
            }
        }
      return sb.toString();  
    }
}