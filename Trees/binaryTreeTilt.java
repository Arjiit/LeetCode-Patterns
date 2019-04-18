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
    int tilt = 0;
    public int findTilt(TreeNode root) {
        sum(root);
        return tilt;
    }
    
    int sum(TreeNode root) {
        if (root == null)   return 0;
		
        int left = sum(root.left);
        int right = sum(root.right);
        tilt += Math.abs(left - right);
		
        return root.val + left + right;
    }
}