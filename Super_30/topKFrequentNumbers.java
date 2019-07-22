class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        /*
        make a heap of always k elements, so that complexity is O(nlogk)
        Similar to Top K frequent elements
        */
        HashMap<Integer, Integer> hm = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for (int i=0; i<nums.length; i++) {
            if (!hm.containsKey(nums[i])) {
                hm.put(nums[i], 1);
            } else {
                hm.put(nums[i], hm.get(nums[i]) + 1);
            }
        }
        
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
        (Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b) -> a.getValue() - b.getValue());
        
        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            pq.offer(entry);
            
            if (pq.size() > k) {
                pq.poll();
            }
        }
        
        while(!pq.isEmpty()){
            res.add(0,pq.poll().getKey());
        }
    return res;
}
}

/*
Better way to solve it in O(n) time is to use bucket sort. After putting it in hashmap,
instead of putting it in priority queue, we can use an array of size of length of array 
plus 1 and store list of integers which occur as frequency of the index in the array.

List<Integer>[] bucket = new List[nums.length + 1]; (an array with its index representing the frequency)

    for (int key : frequencyMap.keySet()) {
        int frequency = frequencyMap.get(key);
        if (bucket[frequency] == null) {
            bucket[frequency] = new ArrayList<>(); // intitalize a list at that index position
        }
        bucket[frequency].add(key); // add element to the list located at the index element

    List<Integer> res = new ArrayList<>();

    // iterate from the end of bucket array, as the last indexes would be containing
    the most number of occuring elements in that array, keep doing it till 
    we find the all k elements.

    for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
        if (bucket[pos] != null) {
            res.addAll(bucket[pos]);
        }
    }
    return res;

*/