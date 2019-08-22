class Solution {
/*
    Same idea like validTree question, here we have to return the count,
    Also, we have to decrement the count, only when a new edge is compressed.
    Hence, we have to put a check that if parent of one node is not equals to 
    parent of other, then only we decrement the count.
    [0,1], [1,2] will make a graph with 0 as parent and 1 and 2 as child.
    So, when it encounters, [0,2] edge then, that is already been compressed/unioned
    hence, we need not decrement the count in such case. Hence a way to find out is 
    by checking the parent of the nodes.
*/
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int i=0; i<edges.length; i++) {
            uf.union(edges[i][0], edges[i][1]);
        }
        return uf.count;
    }
}

class UnionFind {
    int count;
    int[] parent;
    
    public UnionFind(int n) {
        this.count = n;
        parent = new int[n];
        
        for (int i=0; i<n; i++) {
            parent[i] = i;
        }
    }
    
    public int find(int p) {
        while (p != parent[p]) {
            p = parent[p];
        }
        return parent[p];
    }
    
    public void union(int p, int q) {
        int parentP = find(p);
        int parentQ = find(q);
        if (parentP != parentQ) {
            parent[parentQ] = parentP;
            count--;
        }
        
    }

}