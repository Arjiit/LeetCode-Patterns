/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        HashMap<Node,Node> clone = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        
        while(!q.isEmpty()) {
            Node curr = q.poll();
            for(Node neighbor: curr.neighbors) {
                if (!clone.containsKey(neighbor)) {
                    List<Node> newList;
                    clone.put(neighbor, new Node(neighbor.val));
                    q.add(neighbor);
                }
                clone.get(curr).neighbors.add(clone.get(neighbor));
            }
        }
        return clone.get(node);
    }
}s