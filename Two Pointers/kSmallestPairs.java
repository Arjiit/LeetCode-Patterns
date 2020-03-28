class Solution {
// O(KlogK) solution
/*
    Putting all the elements combination from one array element to other and then
    traversing in second array to find other smallest pairs.
*/
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> finalRes = new ArrayList<>();
        if(nums1.length==0 || nums2.length==0 || k==0) return finalRes;
        int len1 = nums1.length;
        int len2 = nums2.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[0] + a[1]) - (b[0]+ b[1]));
        for (int i=0; i<len1&& i<k; i++){
            pq.offer(new int[]{nums1[i], nums2[0], 0}); //storing index of nums2 traversal
        }
        while(k-- > 0 && !pq.isEmpty()) {
            int[] cur = pq.poll();
            List<Integer> res = new ArrayList<>();
            res.add(cur[0]);
            res.add(cur[1]);
            finalRes.add(res);
            int num2index = cur[2];
            if(num2index + 1 < nums2.length){
                pq.offer(new int[]{cur[0],nums2[num2index+1], num2index+1});
            }
        }
        return finalRes;
    }
}