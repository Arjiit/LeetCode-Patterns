class Solution {
    /*
    Union Find will ensure that when 2 points in the edge have same parent, we won't be able
    to union them as they will create a cycle in graph. 
    Using union by rank and path compression O(N) can be reduced to O(logN).
    */
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        UnionFind uf = new UnionFind(n+1); // since edges start from 1, hence we use n+1.
        for (int[] e: edges) {
            if (!uf.union(e[0], e[1])) { // if we can't union, means they have same parent and we can't union because it will create a loop, hence this is redundant connection
                return e;
            }
        }
        return new int[0];
    }
}

class UnionFind {
    int parent[];
    int size[];
 
    
    public UnionFind(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i=0; i<n; i++) {
            parent[i] = i;
        }
    }
    
    public int find(int p) {
        while(p != parent[p]) {
            p = parent[p];
        }
        return p;
    }
    
    public boolean union(int p, int q) {
        int pParent = find(p);
        int qParent = find(q);
        
        if (pParent == qParent) { // means they are already in same set and cannot be unioned
            return false; //hence we return false, it means they have a circle
        }
        if (size[pParent] < size[qParent]) { // attaching smaller set to larger set
            parent[pParent] = qParent;
            size[qParent]++;
        } else {
            parent[qParent] = pParent;
            size[pParent]++;
        }
        return true; //if we can union them, we return true
    }
}