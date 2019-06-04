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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        
        if (root == p || root == q) {
            return root;
        }
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if (left != null && right != null) { // if both left and right returns not null then we have found the LCA i.e. root
            return root;
        }
        
        if (left == null && right == null) { // if both left and right return null
            // then we return null
            return null;
        }
        // else if any one is not null, then return that
        return left != null ? left:right;
    } 
}
            