class Solution {
    public int twoCitySchedCost(int[][] costs) {
    /*
    since the question asks for 'minimum cost of flying (something) every person to a 
    city such that exactly N people arrive n each city (something)' fits the general
    greedy template of - "minimum no. of something to fit in some conditions", we apply
    greedy.

    Here we sorted the 2d array with the highest difference between the two elements first.
    So, that we choose minimum out of the two and avoid the large number. We maintain a
    counter for both the cities and when one reaches it's limit N, we use the other.
    */
        
       Comparator co = new Comparator<int[]>() {
           public int compare(int[] a, int[] b) { // want to return the difference in descending order
               return (Math.abs(b[0] - b[1]) - Math.abs(a[0] - a[1]));  // highest difference would come first hence using b first
           }
       };
        Arrays.sort(costs,co);
        int n = costs.length/2;
        int res = 0;
        int countA = 0;
        int countB = 0;
        
        for (int i=0; i<costs.length; i++) {
            if (countA < n && countB < n) {
                if (costs[i][0] < costs[i][1]) {
                    res = res + costs[i][0];
                    countA++;
                } else {
                    res = res + costs[i][1];
                    countB++;
                }
            } else if (countA < n) {
                res = res + costs[i][0];
                countA++;
            } else if (countB < n) {
                res = res + costs[i][1];
                countB++;
            }
        }
        
        return res;
    }
}