class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
    /*
        We know that we can start from one station if and only if (gas[i] - cost[i] > 0).
        So, that can be our starting position. To end, we know that we have to loop around
        and check if total gas required for visiting all the stations should be greater than
        the total cost required to travel the stations. Hence we can take the sum of all those
        and subtract from sum of cost required to travel all.
        T.C. - O(n)
    */
        int n = gas.length;
        
        int total_tank = 0;
        int current_tank = 0;
        int starting_positon = 0;
        
        for (int i=0; i< n; i++) {
            total_tank = total_tank + (gas[i] - cost[i]);
            current_tank = current_tank + (gas[i] - cost[i]);
            if (current_tank < 0) {
                starting_positon = i + 1;
                current_tank = 0;
            }
        }
        return total_tank >= 0 ? starting_positon: -1;
    }
}