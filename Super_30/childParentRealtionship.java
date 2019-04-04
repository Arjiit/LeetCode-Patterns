/*

Child Parent IsLeft 
15 20 true 
19 80 true 
17 20 false 
16 80 false 
80 50 false 
50 null false 
20 50 true 


You should return the following tree: 
50 
/ \ 
20 80 
/ \ / \ 
15 17 19 16 

*/

/*
O(n) solution, O(n) memory
*/
public class Relation {
	public Integer parent;
	public Integer child;
	public Integer isLeft;
}

public class Node{
	public Integer id;
	public Node left;
	public Node right;
}

/*
We can hash the list with key as the parent and value as a list of its children.
And then iteratively generating the tree. This solution would be O(n) time complexity and O(n) space complexity.

HashMap key as parent value.
HashMap value as List of Relations (contains information of child)
put it in Queue and build the tree.
*/

public Node buildTree(List<Relation> data) {
	if (data == null) {
		return new Node();
	}

	HashMap<Integer, List<Relation>> tree = new HashMap<Integer, List<Relation>>();
	for (Relation d: data) {
		if (d.parent == null) {
			root = new Node(d.child, null, null);
		} else {
			if (tree.contains(d.parent)) {
				List<Relation> value = tree.get(d.parent);
				value.add(d);
			} else {
				List<Relation> value = new ArrayList<Relation>();
				value.add(d);
				tree.put(d.parent, value);
			}
		}
	}


	if (root == null) {
		return root;
	}

	Queue<Node> q = new LinkedList<>();
	q.add(root);
	while(!q.isEmpty()) {
		Node x = q.poll();
		if (tree.containsKey(x.id)) {
			List<Relation> value = tree.get(x.id);
			for (Relation v: value) {
				Node child = new Node(v.child, null, null);
				q.add(child);
				if (v.isLeft) {
					x.left = child;
				} else {
					x.right = child;
				}
			}
		}
	}
	return root;

}