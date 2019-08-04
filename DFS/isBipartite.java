class Solution {
    public boolean isBipartite(int[][] graph) {
        /*
        we have to colour the nodes such that the next node is of different colour.
        basically index position in graph array is parent and the array elements is
        the neighbours. So, ith position we colour by 1 and its neighbour we try to
        colour differently. We note the colour in colours array.
        
        O(n) time complexity
        */
        int nodes = graph.length; // number of nodes
        int[] colours = new int[nodes]; // to keep track whether the node is coloured or not
        
        for (int i=0; i<graph.length; i++) {
            if ((colours[i] == 0) && (!dfs(graph, colours, 1, i)) ) { // if it's not coloured and we can't colour it.
                return false;
            }
        }
        return true;
    }
    // utility function which will tell if we can colour the node.
    public boolean dfs(int[][] graph, int[] colours, int colour, int node) {
        if (colours[node] != 0) { // if the node is already coloured
            return (colours[node] == colour); // check if it is of the colour we want.
        } else {
            colours[node] = colour; // colour the node with the colour
            for (int neighbour: graph[node]) { // try to colour it neighbours
             if (!dfs(graph, colours, -colour, neighbour)) { // if we can't colour the neighbour to opposite colour
                 return false; // return false if we can't colour it opposite.
             }   
            }
        }
        return true;
    }
}