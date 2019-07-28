public class Solution {

    Map<String, PriorityQueue<String>> flights;
    LinkedList<String> path;
    /*
    Since the problem asks for lexical order smallest solution, we can put the neighbors in a min-heap.
    In this way, we always visit the smallest possible neighbor first in our trip
    T.C -> O(ElogE), E is the edges.  Because we offer each edge into queue once and then poll it out once. 
    Space complexity is O(E).
    */

    public List<String> findItinerary(String[][] tickets) {
        flights = new HashMap<>();
        path = new LinkedList<>();
        for (String[] ticket : tickets) {
            flights.putIfAbsent(ticket[0], new PriorityQueue<>());
        z    flights.get(ticket[0]).add(ticket[1]);
        }
        dfs("JFK", flights, path);
        return path;
    }
    
    public void dfs(String airport, Map<String, PriorityQueue<String>> map, List<String> res) {
        PriorityQueue<String> pq = map.get(airport);
        
        while(pq != null && !pq.isEmpty()) {
            dfs((String)pq.poll(), map, res);
        }
        res.add(0, airport);
    }
}