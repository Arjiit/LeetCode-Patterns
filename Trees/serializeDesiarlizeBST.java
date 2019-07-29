/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    private static final String NULL_SYMBOL = "X";
    private static final String DELIMITER = ",";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return NULL_SYMBOL + DELIMITER;
        }
        
        String leftPart = serialize(root.left);
        String rightPart = serialize(root.right);
        
        return root.val + "," + leftPart + rightPart;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) { // data contains string stored in pre-order traversal
        // root, left, right
        // in a bst, all nodes in left subtree are less than root node
        if (data == NULL_SYMBOL) {
            return null;
        }
        String[] preOrder = data.split(",");
        return helper(preOrder, 0, preOrder.length - 1);
    }
    
    public TreeNode helper(String[] preOrder, int low, int high) {
        if (low > high) {
            return null;
        }
        
        TreeNode node = new TreeNode(Integer.valueOf(preOrder[low]));
        int divIndex = getDividingIndex(preOrder, node.val, low, high);
        node.left = helper(preOrder, low, divIndex -1);
        node.right = helper(preOrder, divIndex, high);
        
        return node;
    }
    
    public int getDividingIndex(String[] preOrder, int val, int low, int high) {
        int i;
        for (i=0; i<preOrder.length; i++) {
            if (Integer.valueOf(preOrder[i]) > val) {
                break;
            }
        }
        return i;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

/*
Time Complexity is O(n^2) as in worst case when the tree would not be evenly 
divided into left and right subtree, or it will be imbalanced then we would have a 
O(n^2) time complexity.
*/


public class Codec {
    private static final String SEP = ",";
    private static final String NULL = "null";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) return NULL;
        //traverse it recursively if you want to, I am doing it iteratively here
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while (!st.empty()) {
            root = st.pop();
            sb.append(root.val).append(SEP);
            if (root.right != null) st.push(root.right);
            if (root.left != null) st.push(root.left);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    // pre-order traversal
    public TreeNode deserialize(String data) {
        if (data.equals(NULL)) return null;
        String[] strs = data.split(SEP);
        Queue<Integer> q = new LinkedList<>();
        for (String e : strs) {
            q.offer(Integer.parseInt(e));
        }
        return getNode(q);
    }
    
    // some notes:
    //   5
    //  3 6
    // 2   7
    private TreeNode getNode(Queue<Integer> q) { //q: 5,3,2,6,7
        if (q.isEmpty()) return null;
        TreeNode root = new TreeNode(q.poll());//root (5)
        Queue<Integer> samllerQueue = new LinkedList<>();
        /*
        Using another queue called smallerQueue to store the numbers that are smaller
        than the current element.
        so that we can assign those elements to root.left
        */
        while (!q.isEmpty() && q.peek() < root.val) {
            samllerQueue.offer(q.poll());
        }
        //smallerQueue : 3,2   storing elements smaller than 5 (root)
        root.left = getNode(samllerQueue);
        //q: 6,7   storing elements bigger than 5 (root)
        root.right = getNode(q);
        return root;
    }
}