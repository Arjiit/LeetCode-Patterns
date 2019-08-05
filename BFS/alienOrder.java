class Solution {
    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }
        HashMap<Character, HashSet<Character>> graph = new HashMap<>();
        int[] inDegreeMap = new int[26]; //to keep a track of indegrees to a 
        // character
            /* according to given dictionary with specified order, traverse every pair of words,
         * then put each pair into graph map to build the graph, and then update inDegree map
         * for every "nextChar" (increase their inDegree by 1 every time) */
        for (String s: words) {
            for( char x: s.toCharArray()) {
                graph.putIfAbsent(x, new HashSet<>());
            }
        }
    for (int i=0; i< words.length - 1; i++) {
        String first = words[i];
        String second = words[i+1];
        int len = Math.min(first.length(), second.length());
        for (int j=0; j<len; j++) {
            if (first.charAt(j) != second.charAt(j)) {
                char f = first.charAt(j);
                char s = second.charAt(j);
                if (!graph.get(f).contains(s)) {
                    graph.get(f).add(s);
                    inDegreeMap[(int)(s - 'a')]++;
                }
            }
            break;
        }
    }
        // Doing a BFS but putting all starting nodes i.e ones with inDegree 0 in the queue
        // and then exploring their neighbours, if we get indegree 0, we add to queue to 
        // further evaluate.
        Queue<Character> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (char c: graph.keySet()) {
            if (inDegreeMap[(int)(c-'a')] == 0) {
                q.offer(c);
            }
        }
        
        while(!q.isEmpty()) {
            char out = q.poll();
            sb.append(out);
            if (graph.get(out) == null) {
                continue;
            }
            System.out.println(out);
            for (char neighbour: graph.get(out)) {
                inDegreeMap[(int)(neighbour -'a')]--;
                if (inDegreeMap[(int)(neighbour - 'a')] == 0) {
                    q.offer(neighbour);
                }
            } 
        }
        return sb.length() == graph.size() ? sb.toString() : "";
    }
}