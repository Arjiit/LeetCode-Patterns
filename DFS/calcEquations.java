class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        /*
            Basically we have to create a graph with nodes as the string variables which are
            connected through directed edges. if a/b = 2.0 then node a has to be connected to
            node b with a weighted edge of 2 and node b is to be connected back with node a with
            an weighted edge of 1/2.
            After we construct a graph, we can run a DFS, to reach from start to end and keep an track
            of weight.

            O(E + Q*(V + E)) where E is the number of edges, note that E is also the number of equations here.
            1st, create the graph, i.e. construct the adjacency list, O(E) because we use the equations here
            2nd, DFS for each query, DFS of graph is O(V + E), V: the number of nodes, E: the number of edges/equations, so total O(Q*(V + E))
            So total O(E + Q*(V + E))
        */
        HashMap<String, ArrayList<String>> pairs = new HashMap<>();
        HashMap<String, ArrayList<Double>> valuesPair = new HashMap<>();
        
        for (int i=0; i< equations.size(); i++) {
            List<String> equation = equations.get(i);
            if (!pairs.containsKey(equation.get(0))) {
                pairs.put(equation.get(0), new ArrayList<>());
                valuesPair.put(equation.get(0), new ArrayList<>());
            }
            
            if (!pairs.containsKey(equation.get(1))) {
                pairs.put(equation.get(1), new ArrayList<>());
                valuesPair.put(equation.get(1), new ArrayList<>());
            }
            pairs.get(equation.get(0)).add(equation.get(1));
            pairs.get(equation.get(1)).add(equation.get(0));
            valuesPair.get(equation.get(0)).add(values[i]);
            valuesPair.get(equation.get(1)).add(1/values[i]);
        }
        
        double[] res = new double[queries.size()];
        for (int i=0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            HashSet<String> visitedSet = new HashSet<>();
            res[i] = dfs(query.get(0), query.get(1), pairs, valuesPair, visitedSet, 1.0);
            if (res[i] == 0.0) res[i] = -1.0;
        }
        return res;
    }
    
    public double dfs(String start, String end, HashMap<String, ArrayList<String>> pairs, HashMap<String, ArrayList<Double>> valuesPair, HashSet<String> visitedSet, double value) {
        if (visitedSet.contains(start)) {
            return 0.0;
        }
        if (!pairs.containsKey(start)) {
            return 0.0;
        }
        if (start.equals(end)) {
            return value;
        }
        
        visitedSet.add(start);
        
        ArrayList<String> strList = pairs.get(start);
        ArrayList<Double> valuesList = valuesPair.get(start);
        
        double tmp = 0.0;
        
        for (int i=0; i<strList.size(); i++) {
            tmp = dfs(strList.get(i), end, pairs, valuesPair, visitedSet, value*valuesList.get(i));
            if (tmp != 0.0) {
                break;
            }
        }
        return tmp;
    }
}