class Solution {
    public int lastStoneWeight(int[] stones) {
    /*
        T.C. - O(nlogn)
        n inserts into queue one at time - O(nlogn)
        also removing n elements is - O(nlogn)
    */
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int a: stones) {
            pq.add(a);
        }
        while(pq.size() > 1) {
            pq.add(pq.poll() - pq.poll());
        }
        return pq.poll();
    }
}