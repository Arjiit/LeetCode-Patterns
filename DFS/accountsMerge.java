class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        /*
        Here we have to make a graph and apply dfs on the nodes. Each node represents 
        email.
        */
        HashMap<String, Set<String>> graph = new HashMap<>();
        HashMap<String, String> emailToName = new HashMap<>();
        
        buildGraph(graph, emailToName, accounts);
        List<List<String>> res = new ArrayList<>(); // to store the results
        Set<String> visited = new HashSet<>(); // to check if a node is visited or not
        
        for (String mail: emailToName.keySet()) {
            if (visited.add(mail)) { // if it's not in the hashset, it's not visited
                List<String> list = new ArrayList<>();
                list.add(mail); // adding current node and then finding connected nodes
                dfs(graph, list, mail, visited);
                Collections.sort(list); // to sort the emails
                list.add(0, emailToName.get(mail)); // adding name at the start of the list
                res.add(list);
            }
        }
       return res;    
    }
    
    public void buildGraph(HashMap<String, Set<String>> graph, HashMap<String, String> emailToName,
                        List<List<String>> accounts) {
        for (List<String> acc: accounts) {
            String name = acc.get(0);
            for (int i=1; i<acc.size(); i++) {
                String mail = acc.get(i);
                emailToName.put(mail, name);
                if (!graph.containsKey(mail)) {
                    graph.put(mail, new HashSet<>());
                }
                
                if (i==1) {
                    continue;
                } else { // for the second email onwards
                    String prev = acc.get(i-1);
                    graph.get(mail).add(prev); // connect the prev email to current email
                    graph.get(prev).add(mail); // and vice-versa
                }
            }
        }
    }
    
    public void dfs(HashMap<String, Set<String>> graph, List<String> list, String mail, Set<String> visited) {
        if (graph.get(mail) == null || graph.get(mail).size() == 0) {
            return;
        }
        
        for (String neighbours: graph.get(mail)) {
            if (visited.add(neighbours)) { // if neighbour is not visited
                list.add(neighbours); // add the neghbour to the list
                dfs(graph, list, neighbours, visited); // do a dfs on the neighbour
            }
        }
    }
}