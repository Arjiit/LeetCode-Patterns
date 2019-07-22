class Solution {
    public String frequencySort(String s) {
        /*
        Bucket sort to sort the elements by placing them in their frequency based index.
        O(n).
        If we had used PriorityQueue with Map entries in it then time taken would have been
        O(nlogm), here m = 26, since there are 26 alphabets, so overall T.C. would have been
        O(n) too.
        */
       List<Character>[] arr = new List[s.length()+1];
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            if (!hm.containsKey(s.charAt(i))) {
                hm.put(s.charAt(i), 1);
            } else {
                hm.put(s.charAt(i), hm.get(s.charAt(i))+1);
            }
        }
        for (Map.Entry<Character, Integer> entry: hm.entrySet()) {
            char key = entry.getKey();
            int val = entry.getValue();
            if (arr[val] == null) {
                arr[val] = new ArrayList<>();
            }
            
            arr[val].add(key);
        }
        StringBuilder sb = new StringBuilder();
        String res = "";
        for (int k=arr.length - 1; k >= 0; k--) {
            if (arr[k] != null) {
            for (char x : arr[k]) {
                for (int i=0; i<hm.get(x); i++) {
                    sb.append(x);
                }
            }
        }
        }
        return sb.toString();
    }
}

/*
using priority queue

PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        pq.addAll(map.entrySet());
                
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Map.Entry e = pq.poll();
            for (int i = 0; i < (int)e.getValue(); i++) 
                sb.append(e.getKey());
        }
        return sb.toString()
*/