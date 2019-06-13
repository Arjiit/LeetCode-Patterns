class Solution {
    /*
    We keep a track of elements used from the index of the string
    and also we check if the hashet already contains the possible
    combination or not.
    */
    
    public int numTilePossibilities(String tiles) {
        int len = tiles.length();
        Set<String> allPermutation = new HashSet<String>();
        boolean[] visited = new boolean[len];
        StringBuilder sb = new StringBuilder();
        dfs(sb,tiles,visited, allPermutation);
        return allPermutation.size();
    }
    
    public void dfs(StringBuilder sb, String tiles, boolean[] visited, Set<String> allPermutation){
        if(sb.length() > 0 && !allPermutation.contains(sb.toString()))
            allPermutation.add(sb.toString());
        if(sb.length() > tiles.length())
            return;
        
        for(int i=0;i<tiles.length();i++){
           if(!visited[i]){
               int len = sb.length();
               visited[i] = true;
               sb.append(tiles.charAt(i));
               dfs(sb,tiles,visited, allPermutation);
               visited[i] = false;
               sb.setLength(len);
           }
        }
    }
}
    