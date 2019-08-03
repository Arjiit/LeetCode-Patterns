class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        if (A == null || A.length == 0 || B == null || B.length == 0) {
            return new int[][]{};
        }
        int a = 0;
        int b = 0;
        List<int[]> res = new ArrayList<>();
        int i=0;
        while(a < A.length && b < B.length) {
                
                int start = Math.max(A[a][0], B[b][0]);
                int end = Math.min(A[a][1], B[b][1]);
            if (end >= start) {
                res.add(new int[]{start, end});
            }
            
            if (A[a][1] == end) {
                a++;
            }
            
            if (B[b][1] == end) {
                b++;
            }
        }
       return res.toArray(new int[res.size()][2]);
    }
}