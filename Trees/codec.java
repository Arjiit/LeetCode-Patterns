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
        
        return getString(root);
    }
    
    public String getString(TreeNode root) {
    /*
    root's value is known, so serialize the left and right and then
    append to result.
    */
        if (root == null) { // base case
            return "X" + ",";
        }
        String leftSerialize = serialize(root.left);
        String rightSerialize = serialize(root.right);
        
        return root.val + "," + leftSerialize + rightSerialize;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        /*
        We use Queue so as to maintain the state since we can't use 
        class member/global/static variables to store state.
        Queue basically ensures that when node.right is called it has the
        correct node is present at the top of the queue.
        */
        String[] splitString = data.split(DELIMITER);
        Queue<String> nodesLeft = new LinkedList<>();
        for (int i=0; i< splitString.length; i++) {
            nodesLeft.add(splitString[i]);
        }
        return helper(nodesLeft);
    }
    
    public TreeNode helper(Queue<String> nodesLeft) {
        String valueOfNode = nodesLeft.poll();
        if (valueOfNode.equals(NULL_SYMBOL)) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(valueOfNode));
        node.left = helper(nodesLeft);
        node.right = helper(nodesLeft);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));