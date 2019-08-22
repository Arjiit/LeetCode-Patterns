class Solution {
    public boolean validTree(int n, int[][] edges) {
      /*
      Idea is to use union find to keep unioning the edges and decrementing the count of nodes, if at the end we encounter just one node, then there is no loop. If a new  edge is already connected i.e. they have same parents, then we can say that there is a cycle.
      */
        UnionFind uf = new UnionFind(n);
        for (int i=0; i < edges.length; i++) {
            if (uf.connected(edges[i][0], edges[i][1])) {
                return false;
            }
            uf.union(edges[i][0], edges[i][1]);
        }
        return uf.count == 1 ? true: false;
    }
    
}

class UnionFind {
    int parent[];
    int count;
    
    public UnionFind(int n) {
        this.count = n;
        parent = new int[n];
        for (int i=0; i<n; i++) {
            parent[i] = i;
        }
    }
    
    public int find(int p) { // finding the parent of a node
        while(p != parent[p]) {
            p = parent[p];
        }
        return parent[p];
    }
    
    public void union(int p, int q) {
        int pParent = find(p);
        int qParent = find(q);
        parent[qParent] = pParent;
        count--;
    }
    
    public boolean connected(int p, int q) {
        return find(p) == find(q); //checking if they have same parents
    }
        
}