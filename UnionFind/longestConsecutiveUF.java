class Solution {
    /*
    Regarding consecutive numbers as a connected component, so we have to find the size of the largest component. 2 nodes are connected if they are consecutive. So, we union the indexes if the values of array are consecutive and keep a track of size. We return maximum value in size array.
    T.C-> O(n)
    */
    public int longestConsecutive(int[] nums) {
        UnionFind uf = new UnionFind(nums.length);
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for (int i=0; i< nums.length; i++) {
            if (hm.containsKey(nums[i])) {
                continue; // not allowing duplicate values
            }
            
            if (hm.containsKey(nums[i] - 1)) {
                uf.union(i, hm.get(nums[i] - 1)); // unioning the indexes of the array if the value contained is consecutive
            }
            
            if (hm.containsKey(nums[i] + 1)) {
                uf.union(i, hm.get(nums[i] + 1));
            }
            hm.put(nums[i], i);
        }
        return uf.getLargestComponentSize();
    }
}

class UnionFind {
    int[] parent;
    int[] size;
    
    public UnionFind(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i=0; i<n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }
    
    public void union(int x, int y) {
        int xParent = find(x);
        int yParent = find(y);
        
        if (xParent != yParent) {
            parent[xParent] = yParent; // making one as parent of other
            size[yParent] = size[yParent] + size[xParent]; // increasing the size array for it
        }
    }
    
    public int find(int x) {
        while (parent[x] != x) {
            x = parent[x];
        }
        return x;
    }
    
    public int getLargestComponentSize() {
        int maxSize = 0;
        for (int i=0; i<parent.length; i++) {
            if ((parent[i] == i)&&(size[i] > maxSize)) {
                maxSize = size[i];
            }
        }
        return maxSize;
    }
}