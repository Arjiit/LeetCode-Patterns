class Solution {
    public int maximumSum(int[] arr) {
        int high = Integer.MIN_VALUE;
        for (int n: arr) {
            high = Math.max(high, n);
        }
        if (high < 0) return high;
        int sum = 0;
        int curMax = 0;
        int bestMax = 0;
        int[] forward = new int[arr.length];
    
        for (int i=0; i<arr.length; i++) {
            curMax = curMax + arr[i];
            curMax = Math.max(curMax, arr[i]);
            bestMax = Math.max(curMax, bestMax);
            forward[i] = curMax;
        }
        int[] backward = new int[arr.length];
        curMax = 0;
        bestMax = 0;
        for (int i=arr.length - 1; i>=0; i--) {
            curMax = curMax + arr[i];
            curMax = Math.max(curMax, arr[i]);
            bestMax = Math.max(curMax, bestMax);
            backward[i] = curMax;
        }
        
        for (int i= 1; i<arr.length - 1; i++) {
            bestMax = Math.max(bestMax, forward[i-1] + backward[i+1]);
        }
        return bestMax;
    }
}