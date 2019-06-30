class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        /*
        This is a question which requires using the DP table to save the results
        and keep adding it to the final solutions once we find the arithmetic sequence.
        Since, we also need to consider indexes with equal distance on both sides of
        the number apart from the consecutive indexes numbers in the array, we use a
        2D array to store the results, with index j, i representing the last 2 elements.
        and we need to find the third element such that it forms arithmetic index.
        i.e. [k, j, i], so if we find a suitable k, we increase the result in dp[i][j] by
        1. (k = 2*A[j] - A[i]) Since we multiply the number, we have to take care of integer 
        overflow, hence we use Long. We use a Map to store the indexes of the element, so that
        we can retrieve the index when needed to update the DP table.
        */
        
        int n = A.length;
        int dp[][] = new int[n][n];
        Map<Long, List<Integer>> map = new HashMap<>();
        for (int i=0; i < A.length; i++){
            map.putIfAbsent((long) A[i], new ArrayList<>());
            map.get((long)A[i]).add(i);
        }
        
        int res = 0; // since summing up results in the dp will give us the answer
        
        for(int i=0; i< n; i++) {
            for (int j=0; j < i; j++){
                long target = 2*(long)A[j] - A[i]; // finding the first element of (target, j, i) pair
                if (map.containsKey(target)) {
                    for (int k : map.get(target)) {
                        if (k < j) {
                            dp[i][j] = dp[i][j] + (dp[j][k] + 1); // current value in the cell plus the value of dp[j][k] plus one.       
                        }
                    }
                }
                res = res + dp[i][j];
            }
        }
        return res;
    }
}