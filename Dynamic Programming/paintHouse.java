class Solution {
    public int minCost(int[][] costs) {
        if (costs.length == 0) {
            return 0;
        }
        
        /*
        we have to find the minimum cost to paint all houses.
        So, we start with painting first house as red, blue or green.
        update the lower houses with their values.
        The last row will have values with all the houses above painted, so 
        we can iterate through last row and see which is the minimum.
        */
        
        for (int i=1; i<costs.length; i++) {
            costs[i][0] = costs[i][0] + Math.min(costs[i-1][1],costs[i-1][2]); //cost of painting next row as 0 will be its cost plus minimum of previous's row 1 and 2 cost.
            costs[i][1] = costs[i][1] + Math.min(costs[i-1][0], costs[i-1][2]);
            costs[i][2] = costs[i][2] + Math.min(costs[i-1][0], costs[i-1][1]);
        }
        int res = Integer.MAX_VALUE;
        for (int i=0; i<3; i++) {
            res = Math.min(res, costs[costs.length - 1][i]);
        }
        return res;
    }
}