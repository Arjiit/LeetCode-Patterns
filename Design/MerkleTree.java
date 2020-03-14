public class MerkleTree {

	/*
		Merkle trees allow for effecient and secure verification of large data structures. 
		With the structure of tree, we can easily identify map large amounts of data and
		easily identify where changes in the data occur.
	*/

	private static class Node {
		String data;
		Node left;
		Node right;
		Node(String value) {
			this.data = value;
		}

	}

	private Node root;

	public static void main(String[] args) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node("A"));
		q.add(new Node("B"));
		q.add(new Node("C"));
		q.add(new Node("D"));
		q.add(new Node("E"));
		MerkleTree mt = new MerkleTree();
		Node root1 = mt.buildTree(q);

		Queue<Node> q2 = new LinkedList<>();
		q2.add(new Node("AA")); // data changed here
		q2.add(new Node("B"));
		q2.add(new Node("C"));
		q2.add(new Node("D"));
		q2.add(new Node("E"));
		MerkleTree mt2 = new MerkleTree();
		Node root2 = mt.buildTree(q);

		if (mt.detectChange(root1, root2)) {
			 root1 = mt.mergeChange(root1, root2);
		}
			
	}


	public Node buildTree(Queue<Node> q) {
		if (q.pop() == null) {
			return;
		}
		Node new_node = q.pop();
		new_node.left = buildTree(q);
		new_node.right = buildTree(q);

		CRC32 crc = new CRC32();
		crc.update((new_node.left.data + (new_node.right != null) ? new_node.right.data : "").getBytes());
		Node root = new Node(crc.getValue() + "");
		return root;
	}

	public boolean detectChange(Node refNode, Node newNode) {
		if (refNode == null && new_node == null) return false; // no change, base check
		if (refNode == null || new_node == null) return true; // change detected, data added/deleted

		boolean leftChanged = detectChange(refNode.left, new_node.left);
		boolean rightChanged = detectChange(refNode.right, new_node.right);
		if (refNode.data != new_node.data) return true;

		return leftChanged || rightChanged;
	}


	public Node mergeChange(Node refNode, Node new_node) {
		if (refNode == null && new_node == null) return null;
		else if (refNode != null && new_node == null) {
			return null; //changed detected. Data deleted
		}

		else if (refNode == null && new_node != null) {
			return new_node; // change deteced. Data added
		}
		else if (refNode.data != new_node.data) {
			refNode.data = new_node.data;
		}
		refNode.left = mergeChange(refNode.left, new_node.left);
		refNode.right = mergeChange(refNode.right, new_node.right);

		return refNode;
	}


}