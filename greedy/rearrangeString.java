class Solution {
    public String rearrangeString(String s, int k) {
        if (k == 0 || s.length() < k) {
            return s;
        }
        
        int[] map = new int[26];
        for (char c: s.toCharArray()) {
            map[c - 'a']++;
        }
        
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : b[1] - a[1]);
        for (int i=0; i<26; i++) {
            if (map[i] > 0) { // only add to heap if the count is non-zero
             heap.offer(new int[] {i, map[i]}); // position, count value   
            }
        }
        StringBuilder sb = new StringBuilder();
        while(heap.size() > 0) {
            List<Integer> list = new ArrayList<>();
            
            for (int i=0; i< k; i++) {
                int[] curr = heap.poll();
                sb.append((char)(curr[0] + 'a'));
                map[curr[0]]--;
                list.add(curr[0]);
                
                if (heap.size() == 0) {
                    if (i != k -1 && sb.length() != s.length()) {
                        return "";
                    }
                    break;
                }
            }
            for (int i: list) {
                if (map[i] > 0) {
                    heap.offer(new int[] {i, map[i]});
                }
            }
        }
        return sb.toString();
    }
}