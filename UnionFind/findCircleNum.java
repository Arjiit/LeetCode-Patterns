class Solution {
    /*
        union by rank
        path compression during find
        makes T.C. as O(1) for union/find operations
        
        and we are iterating through the array, hence O(n^2)*T.C.ofUnion = O(n^2)
    */
    class UF { // union find class
        private int[] parent;
        private int[] size;
        private int count;
        public UF(int n) { // constructor to initialize the arrays
            parent = new int[n];
            size = new int[n];
            count = n;
            for (int i=0; i<n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }
        
        public int find(int p) {
            // path compression
            while(p != parent[p]) {
                /* if we didn't do a path compression, then union would take O(logn) time.
                and now, it's amortized O(1) time for both union and find operations.
                */
                parent[p] = parent[parent[p]]; // we update the parent of p to parent of value inside p i.e. parent[parent[p]]
                // and then we update our p
                p = parent[p];
            }
            return p;
        }
        
        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            
            if (rootP == rootQ){
                return;
            } // if they have the same parent, then they already belong to same friend circle
            
            if (size[rootP] > size[rootQ]) {
                parent[rootQ] = rootP;
                size[rootP] = size[rootP] + size[rootQ];
            } else {
                parent[rootP] = rootQ;
                size[rootQ] = size[rootQ] + size[rootP];
            } // we union the two and reduce the count by 1.
            count--;
        }
        
        public int count(){
            return count;
        }
        
        
    }
    public int findCircleNum(int[][] M) {
        int n = M.length;
        UF uf = new UF(n); // creating a uf for 3 nodes 
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) { // basically iterating only half of the matrix as other half is replica and will have the same information
                if (M[i][j] == 1) {
                    uf.union(i,j);
                }
            }
        }
        return uf.count();
    }
}