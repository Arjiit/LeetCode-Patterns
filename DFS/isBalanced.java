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
    public boolean isBalanced(TreeNode root) {
        
        return isHeight(root) == -1 ? false:true;
    }
    
    public int isHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int l = isHeight(root.left);
        int r = isHeight(root.right);
        
        if (l == -1 || r == -1 || Math.abs(l-r) > 1) {
            return -1;
        }
        
        return 1 + Math.max(l,r);
    }
}