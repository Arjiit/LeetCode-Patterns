class Solution {
    public int findMinDifference(List<String> timePoints) {
        int dayMin = 1440;
        if (timePoints.size() > dayMin) { // since there are atleast one duplicate time points
            return 0;
        }
        
        int[] allTime = new int[timePoints.size()];
        int j = 0;
        for (String s: timePoints) {
            if (s == "00:00") {
                allTime[j] = dayMin;
                j++;
                continue;
            }
            String[] t = s.split(":");
            allTime[j] = Integer.valueOf(t[0])*60 + Integer.valueOf(t[1]); 
            j++;
        }
        
        
        Arrays.sort(allTime);
        int min = Integer.MAX_VALUE;
        for (int i=0; i<allTime.length - 1; i++) {
            if (min > (allTime[i+1] - allTime[i])) {
                min = allTime[i+1] - allTime[i];
            }
        }
        // this is done to take care of case when we have 1....1440, the smallest difference is 1 but if we only check the adjacent diff, we won't get 1
        int roundDiff = allTime[0] - allTime[allTime.length -1] + dayMin; 
        if (roundDiff > 0) {
            min = Math.min(roundDiff, min);
        }
        return min;
    }
}