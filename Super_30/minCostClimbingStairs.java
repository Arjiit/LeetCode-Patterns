class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] minCost = new int[cost.length];
        minCost[0] = cost[0];
        minCost[1] = cost[1];
        for (int i=2; i<cost.length; i++){
            minCost[i] = cost[i] + Math.min(minCost[i-2], minCost[i-1]);
        }
        return Math.min(minCost[cost.length-1], minCost[cost.length - 2]); // cost to reach final step will be previous step plus 1 or prev of prev step plus 2.
    }
}