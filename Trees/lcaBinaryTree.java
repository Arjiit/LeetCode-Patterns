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
    /*
    Search for either of the two nodes, any time any of the node is found,
    we return that node to it's parent else null. Anytime, it finds a not null
    from its left side and a not null from right side, it knows it is LCA
    and then it returns it's node value to it's parent.

    Time Complexity - O(n)
    */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        
        if (root == p || root == q) { // kind of base case as we are searching for left/right to become root.
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
            