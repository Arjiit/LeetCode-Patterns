/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int sum = 0;
    public int sumRootToLeaf(TreeNode root) {
        if (root== null) {
            return 0;
        }
        return getValue(root, "");
    }
    
    public int getValue(TreeNode root, String path) {
        if (root.left == null && root.right == null) {
            path = path + root.val; // finally we add value, when we see no childrens below
            sum = sum + Integer.parseInt(path,2); // takes stirng as first parameter
        }
        
        if (root.left != null) {
            getValue(root.left, path +root.val); // adding previous node value and not the left node value
        }
        
        if (root.right != null) {
            getValue(root.right, path + root.val);
        }
        
       return sum; 
    }
}