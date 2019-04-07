/*
Given the sequence of keys visited by a postorder traversal of a binary search tree, reconstruct the tree.

For example, given the sequence 2, 4, 3, 8, 7, 5, you should construct the following tree:

*/

/*
O(n)
*/

class Node {
	int data;
	Node left, right;

	Node(int data) {
		this.data = data;
		left = right = null;
	}
}

	 class treeFromPostOrder {
		public static Node constructUtil(int[] post, int key, int index, int min, int max){

			if (index < 0) {
				return null;
			}

			Node root = null;

			if (key > min && key < max) {
				root = new Node(key);
				index--;
				System.out.println(index);
				if (index >= 0) {
					root.right = constructUtil(post, post[index], index, key, max);
					root.left = constructUtil(post, post[index], index, min, key);
				}
			}
			return root;
		}

	public static Node constructTree(int post[], int size)  
    {  
        int index = size - 1; 
        return constructUtil(post, post[index], index, 
                Integer.MIN_VALUE, Integer.MAX_VALUE); 
    } 
  

	public static void printInorder(Node node)  
    { 
        if (node == null) 
            return; 
        printInorder(node.left); 
        System.out.print(node.data + " "); 
        printInorder(node.right); 
    }

		public static void main(String[] args) {

			treeFromPostOrder  t = new treeFromPostOrder();
			int post[] = new int[]{1, 7, 5, 50, 40, 10};
			int size = post.length;

			Node root = constructTree(post, size);

			printInorder(root);

	}
	}

