/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*
case 1. Check if left child is equal to right child.
case 2. Check if child is equal to parent or not

Keep track of count using a global variable

*/
class Solution {
    private int count = 0;
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) {
            return 0;
        }
        isSame(root);
        return count;
    }
    
    public boolean isSame(TreeNode root) {
        if(root == null) {
            return true;
        }
        
        boolean left = isSame(root.left);
        boolean right = isSame(root.right);
        
        if (left && right) {
            if ((root.left != null && root.val 
                 != root.left.val) || (root.right != null && root.val != root.right.val)) {
                return false;
            } else {
                count++;
                return true;
            }
        }
        return false;
    } 
}