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
    public int sum = 0;
    public TreeNode convertBST(TreeNode root) {
       if (root == null) {
           return null;
       }
        greaterTree(root);
        
        return root;
    }
    
    public void greaterTree(TreeNode root) {
        if (root == null) {
            return;
        } else {
            greaterTree(root.right);
            sum = sum + root.val;
            root.val = sum;
            greaterTree(root.left);
        }         
    }
}