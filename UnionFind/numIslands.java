class Solution {
    /*
    This problem reduces to number of connected componenets with 1's as the components.
    */
    int[][] distance = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public int numIslands(char[][] grid) {
        
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        UnionFind uf = new UnionFind(grid);
        int row = grid.length;
        int col = grid[0].length;
        
        for (int i=0; i<row; i++) {
            for (int j=0; j< col; j++) {
                if (grid[i][j] == '1') {
                    for (int[] d: distance) {
                        int x = i + d[0];
                        int y = j + d[1];
                        if (x >= 0 && x < row && y >= 0 && y < col && grid[x][y] == '1') {
                            int id1 = i*col + j;
                            int id2 = x*col + y;
                            uf.union(id1, id2);
                        }
                    }
                }
            }
        }
        
        
        return uf.count;
    }
}

class UnionFind{
    int parent[];
    int m, n;
    int count;
    public UnionFind(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        parent = new int[m*n];
        
        for (int i=0; i<m; i++) {
            for (int j=0; j <n; j++) {
                if (grid[i][j] == '1') {
                    int id = i*n + j; //this forms the 'id' in sequential format only for cells that are 1
                    parent[id] = id;
                    count++;
                    
                }
            }
        }
    }
    
    public int find(int p) {
        while(parent[p] != p) {
            p = parent[p];
        }
        return p;
    }
    
    public void union(int p, int q) {
        int pParent = find(p);
        int qParent = find(q);
        if (pParent != qParent) {
            parent[qParent] = pParent;
            count--;
        }
    }
}