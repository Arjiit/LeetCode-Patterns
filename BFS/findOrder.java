class Solution {
/*
Same as course schedule, as an when we are done exploring for a node i.e when we insert the element in queue, when
we pop out, we add it to the result array.
*/
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        int[] res = new int[numCourses];
        for (int i=0; i< prerequisites.length;i++) {
            inDegree[prerequisites[i][0]]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for (int j=0; j<inDegree.length; j++) {
            if (inDegree[j] == 0) {
                q.offer(j);
            }
        }
        int k = 0;
        while(!q.isEmpty()) {
            int out = q.poll();
            res[k] = out;
            k++;
            for (int i=0; i<prerequisites.length; i++) {
                if (prerequisites[i][1] == out) {
                    inDegree[prerequisites[i][0]]--;
                    if (inDegree[prerequisites[i][0]] == 0) {
                        q.offer(prerequisites[i][0]);
                    }
                }
            }
            
        }
        return numCourses == k ? res: new int[]{};   
    }
}
