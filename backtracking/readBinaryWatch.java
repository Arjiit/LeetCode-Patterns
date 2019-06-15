class Solution {
    private int[] hours = {8, 4, 2, 1};
    private int[] minutes = {32, 16, 8, 4, 2, 1};
    List<String> ans;


        public List<String> readBinaryWatch(int num) {
            ans = new ArrayList<>();
            Set<Integer> hourSet = new HashSet<>();
            Set<Integer> minSet = new HashSet<>();
            backtrack(hourSet, minSet, 0, num);
            return ans;
        }
        
        private void backtrack(Set<Integer> hourSet, Set<Integer> minSet, int cur, int num) {
            if (hourSet.size() + minSet.size() == num) {
                      for (int x: hourSet) {
                    System.out.print("hoursET " + x);
                    System.out.println();
                }
                          
                String time = toTime(hourSet, minSet);
                if (time != null) {
                    ans.add(0,time);
                    System.out.println(Arrays.toString(ans.toArray()));
                }
                return;
            }
            System.out.println("this");
            int i;
            for (i = cur; i < 10; i++) {
                System.out.println("this is");
                Set<Integer> temp1 = new HashSet<>(hourSet);// [8]
                
                Set<Integer> temp2 = new HashSet<>(minSet);
                
               if (i < 4) {
                   temp1.add(hours[i]); // 8,4
               } else {
                   temp2.add(minutes[i-4]);
               }
                for (int x: temp1) {
                    System.out.print("hours " + x + i);
                    System.out.println();
                }
                
                
                for (int x: temp2) {
                    System.out.print("minutes " + x + i);
                    System.out.println();
                }
                backtrack(temp1, temp2, i+1, num);
            }
        }
        
        private String toTime(Set<Integer> hourSet, Set<Integer> minSet) {
            int hour = 0;
            for (Integer h: hourSet) {
                hour = hour + h;
            }
            
            if (hour > 11) {
                return null;
            }
            int min = 0;
            for (Integer m: minSet)
            {
                min = min + m;
            }       
            
            if (min > 59) {
                return null;
            }
            
            return hour + ":" + (min > 9 ? min : "0" + min);
    }
}

