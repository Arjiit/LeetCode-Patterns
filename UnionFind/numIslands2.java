class Solution {
    /*
    To represent a list of islands, we use trees. i.e., a list of parents. T
    This helps us find the identifier of an island faster. If parents[c] = p means the parent of node c is p, 
    we can climb up the parent chain to find out the identifier of an island, i.e., which island this point belongs to:
    Do root[root[roots[c]]]... until root[c] == c
    Union is only changing the root parent, so it is O(1).
    FIND operation is proportional to the depth of the tree. If N is the number of points added, the average running time is O(logN),
    and a sequence of 4N operations i.e. 4 directions whenever a new point is added takes O(NlogN). 
    If there is no balancing, the worse case could be O(N^2).
    
    */
    int[][] distance = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        if (m <= 0 || n <= 0) {
            return res;
        }
        int count = 0;
        int[][] grid = new int[m][n];
        int[] parents = new int[m*n];
        
        Arrays.fill(parents, -1);
        for (int[] p: positions) {
            int id = p[0]*n + p[1];
            
         if (parents[id] != -1) {    // duplicate position
                res.add(count);
                continue;
            }
            count++;
            parents[id] = id;
            
            for (int[] dir: distance) {
                int x = p[0] + dir[0];
                int y = p[1] + dir[1];
                int id2 = x*n + y;
                if (x <0 || y <0 || x >= m || y>= n || parents[id2] == -1) {
                    continue;
                }
                // unioning two islands
                int id2Parent = find(parents, id2);
                if (id != id2Parent) { // if neighbour is in another island
                    parents[id] = id2Parent;
                    id = id2Parent;
                    count--;
                }
                
            }
            res.add(count);
        }
        return res;
    }
    
    public int find(int[] parent, int p) {
        while(p != parent[p]) {
            parent[p] = parent[parent[p]]; //adding one line for path compression
            p = parent[p];
            
        }
        return p;
    }
    

}

