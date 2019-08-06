class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        /*
        This is a dependency type question because inorder to complete a course, we need to complete it's 
        pre-requistes, hence we can apply topological sort here.
        We can initialize an array with index representing the courses and the value representing the number
        of pre-requistes to complete that particular course essentially representing a graph with nodes 
        directing inside it as the pre-requistes. We then apply BFS and if there are no-prerequistes left
        we add it to queue. In the end, we check if the inDegree array is empty or not. If it is not empty, 
        that means it course cannot be finished.
        T.C. - O(V+E), Space - O(V)
        */
        
        int[] inDegree = new int[numCourses];
        
        for (int i=0; i< prerequisites.length;i++) {
            inDegree[prerequisites[i][0]]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for (int j=0; j<inDegree.length; j++) {
            if (inDegree[j] == 0) {
                q.offer(j);
            }
        }
        while(!q.isEmpty()) {
            int out = q.poll();
            for (int i=0; i<prerequisites.length; i++) {
                if (prerequisites[i][1] == out) {
                    inDegree[prerequisites[i][0]]--;
                    if (inDegree[prerequisites[i][0]] == 0) {
                        q.offer(prerequisites[i][0]);
                    }
                }
            }
            
        }
        for (int i=0; i<inDegree.length; i++) {
            if (inDegree[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
