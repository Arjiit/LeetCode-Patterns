class Solution {
    public int findCircleNum(int[][] M) {
        /*
        Basically, the number of times DFS gets initiated, will give us the result.
        T.C -> O(n^2) as entire matrix has to be traversed.
        S.C -> O(n) as array is used.
        */
        int count = 0;
        int[] visited = new int[M.length]; // to keep track of visited nodes
        // each row representing the nodes
        for (int i=0; i < M.length; i++) {
            if (visited[i] == 0) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }
    
    public void dfs(int[][] M, int[] visited, int i) {
        for (int j=0; j <M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1; // that means we have visited that node
                // visiting it now and marking as its an undirected graph.
                dfs(M, visited, j);
            }
        }
    }
}