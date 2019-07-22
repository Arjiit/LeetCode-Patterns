class Solution {
    public int[][] kClosest(int[][] points, int K) {
        /*
        Insert in PriorityQueue (min heap with k elements) and then pop the points.
        So, a priorityqueue with int[] (points) as arguments sorted based on distance from
        origin.
        O(nlogK) solution since only K elements in the heap at any time.
        */
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1,p2) -> p2[0]*p2[0] + p2[1]*p2[1] - p1[0]*p1[0] - p1[1]*p1[1]);
        
        for (int[] p: points) {
            pq.offer(p);
            
        while(pq.size() > K) {
            pq.poll();
        }
        }

        
        int[][] res = new int[K][2]; // an array containing K array elements(or K points)
        while(K>0){
            res[--K] = pq.poll();
        }
        return res;
    }
}

/*
Can also be done by quick sort by finding a pivot.
*/