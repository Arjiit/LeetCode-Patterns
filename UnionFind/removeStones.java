class Solution {
    public int removeStones(int[][] stones) {
        UnionFind uf = new UnionFind(stones.length);
        for (int i=0; i<stones.length; i++) { // comparing any two points from the stones array
            for (int j=i+1; j< stones.length; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) { // same row or same column for both the points
                    uf.union(i, j); //unioning the points
                }
            }
        }
        return stones.length - uf.count;
    }
}

class UnionFind {
    int count;
    int[] parent;
    int[] size; // used for union by rank for optimization
    
    public UnionFind(int n) {
        this.count = n;
        parent = new int[n];
        size = new int[n];
        
        for (int i=0; i<n; i++) {
            parent[i] = i;
        }
    }
    
    public int find(int x) {
        while (parent[x] != x) {
            x = parent[x];
        }
        return x;
    }
    
    public void union(int p, int q) {
        int pParent = find(p);
        int qParent = find(q);
        if (pParent == qParent) {
            return;
        }
        
        if (size[pParent] <= size[qParent]) { // union by rank, higher size ones becomes the overall parent for the smaller ones as well.
            parent[pParent] = qParent;
            size[qParent]++;
        } else {
            parent[qParent] = pParent;
            size[pParent]++;
        }
        count--; // every time we union, connected components decreases by 1
    }
}