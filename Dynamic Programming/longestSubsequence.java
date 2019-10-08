class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int[] dp = new int[arr.length];
        
        Arrays.fill(dp,1);
         int min = Integer.MIN_VALUE;
        for (int j=1;j<dp.length; j++) {
            for (int i=0; i<j; i++) {
                if (arr[j] == arr[i] + difference) {
                    dp[j] = dp[i] + 1;
                }
            }
            min = Math.max(min, dp[j]);
        }

        return min;
    }
}



class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        HashMap<Integer, Integer> dp = new HashMap<>();
        int max = 0;
        int count = 0;
        for (int i=0; i<arr.length; i++) {
            //int count = dp.getOrDefault(arr[i], 0) + 1;
            if (!dp.containsKey(arr[i])) {
                dp.put(arr[i], 0); // if number seen first time, put longest subsequencing ending till that number as 0
                 count = 1; // set count as 1 so that we can put it in arr[i] + diff endin number key.
            } else {
                 count = dp.get(arr[i]) + 1; // if number seen before, get the count which will be the longest sub sequence ending till that number and add 1.
            }
            
            if (count > max) { // keep track of max count
                max = count;
            }
            dp.put(arr[i] + difference, count); // For number (arr[i] + diff), put count as 1 + value of subsequence ending (arr[i])
        }
        return max;
    }
}