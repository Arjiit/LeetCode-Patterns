class Solution {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {
        if (words1.length != words2.length) {
            return false;
        }
        HashMap<String, HashSet<String>> graph = new HashMap<>();
        
        for (int i=0; i<pairs.size(); i++) {
            graph.putIfAbsent(pairs.get(i).get(0), new HashSet<>());
            graph.putIfAbsent(pairs.get(i).get(1), new HashSet<>());
            graph.get(pairs.get(i).get(0)).add(pairs.get(i).get(1));
            graph.get(pairs.get(i).get(1)).add(pairs.get(i).get(0));
        }
        
        for (int i=0; i< words1.length; i++) {
            if (words1[i].equals(words2[i])) {
                continue;
            }
            if (!graph.containsKey(words1[i])) {
                return false;
            }
            if (!dfs(words1[i], words2[i], graph, new HashSet<>())) {
                return false;
            }
        }
        return true;
    }
    
    public boolean dfs(String words1, String words2, HashMap<String, HashSet<String>> graph, Set<String> visited) {
        if (graph.get(words1).contains(words2)) {
            return true;
        }
        
        if (visited.add(words1)) { // mark the node as visited and explore neighbours
            for (String next: graph.get(words1)) {
                System.out.println(next);
                if (!visited.contains(next) && dfs(next, words2, graph, visited)) {
                    return true;
                } // if node is not in visited that means it's not visited yet
            }
        }
        return false;
    }
}