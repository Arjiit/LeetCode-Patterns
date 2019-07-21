class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> hm = new HashMap<>();
        List<String> result = new ArrayList<>();
        for (int i=0; i < words.length; i++) {
            String word = words[i];
            if (!hm.containsKey(word)) {
                hm.put(word, 1);
            } else {
                hm.put(word, hm.get(word) + 1);
            }
        }
        // putting each entry in priorityqueue as a hashmap entry
        // if the freq value is same i.e. a.getValue == b.getValue, then compare alphabetically.
        // else put higher count one first
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<> (
        (a,b) -> a.getValue() == b.getValue() ? b.getKey().compareTo(a.getKey()): a.getValue() - b.getValue()); //lambda expression
        /*
        (Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) -> a.getValue()==b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue()-b.getValue()
        
        or 

        class Cmp implements Comparator<Map.Entry<String, Integer>> {
            @Override
            public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
                if (a.getValue().equals(b.getValue())) {
                    return b.getKey().compareTo(a.getKey());
                }
                return a.getValue() - b.getValue();
            }
        }
        */
        
        // inserting into the priorityqueue
        for (Map.Entry<String, Integer> entry: hm.entrySet()) {
            pq.offer(entry);
            // maintaining only a priority queue only with k elements, so as to keep the time complexity O(nlogk)
            /*
            hm -> [(i,2), (love,2), (leetcode,1), (coding,1)]
            pq -> [(i,2)] -> [(love,2),(i,2)] -> [(leetcode,1),(love,2),(i,2)] -> popping as size > k which is 2 ->..so in the end pq will have [(love,2),(i,2)] i.e. k(2) most occuring elements.
            */
            if (pq.size() > k){
                pq.poll();
            }
        }
        
        while(!pq.isEmpty()) { //
            result.add(0,pq.poll().getKey());
        }
        return result;
    }
}


/*
Using Max heap - the complexity will be O(nlogn) as we build the heap by entering all the elements
inside the heap and then try to pop the top k elements.
 PriorityQueue<Map.Entry<String,Integer>> maxHeap = new PriorityQueue<>(k, (a,b) -> 
            a.getValue()==b.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue()-a.getValue()); 
        // if same frequency, then sort alphabetical .  
        
        for (Map.Entry<String,Integer> entry : map.entrySet() ) maxHeap.add(entry);
        
        List<String> res = new ArrayList<>();
        while (res.size() < k) res.add(maxHeap.poll().getKey());  //add top k
*/