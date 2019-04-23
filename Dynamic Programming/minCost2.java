class Solution {
    public int minCostII(int[][] costs) {
        /*
        Here we want to find minimum of previous row excluding the index.
        so, we can have another function which returns the minimum from previous
        row.
        costs[i][j] = costs[i][j] + Minimum from i-1 row excluding the j index.
        */
    if (costs == null || costs.length == 0) {
        return 0;
    }
        for (int i=1; i<costs.length; i++) {
            for (int j=0; j<costs[0].length; j++) {
                costs[i][j] = costs[i][j] + prevRowMinimum(costs[i-1], j); // we want to skip the jth element
            }
        }
        return prevRowMinimum(costs[costs.length - 1], -1);
}
 public int prevRowMinimum(int[] row, int skip) {
    int min = Integer.MAX_VALUE;
     for (int i=0; i < row.length; i++) {
         if (i == skip) {
             continue;
         }
         
         min = Math.min(min, row[i]);
     }
     return min;
 }   
}