class Solution {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        /*
        We get all possible (worker,bikes) pairs for a particular distance and then 
        iterate through the distance to get the worker the bike has been assigned to.
        Next time when we encounter the worker/bike, we skip.
        */
        
        int[] res = new int[workers.length];
        
        Set<Integer> workerSet = new HashSet<Integer>();
        Set<Integer> bikesSet = new HashSet<Integer>();
        
        for(int i=0; i<workers.length; i++) {
            workerSet.add(i);
        }
        
        for(int i=0; i<bikes.length; i++) {
            bikesSet.add(i);
        }
        
        HashMap<Integer, List> hm = new HashMap<>();
        
        for (int i=0; i< workers.length; i++) {
            for (int j=0; j< bikes.length; j++) {
            int distance = Math.abs(workers[i][0] - bikes[j][0]) + Math.abs(workers[i][1] - bikes[j][1]);
            
            if (!hm.containsKey(distance)) {
                List<int[]> list = new ArrayList<int[]>();
                list.add(new int[]{i,j});
                hm.put(distance, list);
            } else {
                hm.get(distance).add(new int[]{i,j});
            }

            }
        }
    
        // iterating over all the distance
        // manhattan distance defined by Math.abs(p1x - p2x) + Math.abs(p1y - p2y) can be atmost 2000
        // as the first term can have max value of 1000 and same for the second term from the restricitons
        // given to us.
        
        for (int i=0; i<2000; i++) {
            if (hm.get(i) != null) {
                List<int[]> list = hm.get(i);
                for (int j=0; j<list.size(); j++) {
                    int[] pair = list.get(j);
                    if (workerSet.contains(pair[0]) && bikesSet.contains(pair[1])) {
                        res[pair[0]] = pair[1];
                        // we remove the bike and worker number from the hashset
                        // since we have assigned them
                        workerSet.remove(pair[0]);
                        bikesSet.remove(pair[1]);
                    }
                }
            }
        }
        return res;
    }
}