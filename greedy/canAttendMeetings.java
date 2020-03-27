class Solution {
  // sorting my start time and then checking end time of prev and start time of next
    public boolean canAttendMeetings(int[][] intervals) {
       Arrays.sort(intervals, new Comparator<int[]>() {
           public int compare(int[] a, int[] b) {
               return a[0] - b[0];
           }
       }); 
        for (int i=0; i<intervals.length-1; i++) {
            if(intervals[i][1] > intervals[i+1][0]) {
                return false;
            }
        }
        return true;
    }
}