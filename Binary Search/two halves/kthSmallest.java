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
    public int kthSmallest(TreeNode root, int k) {
        int n = getCount(root.left);
        
        if (n+1 == k) {
            return root.val;
        }
        
        else if (n+1 < k) {
            return kthSmallest(root.right, k - n- 1);
        } else {
            return kthSmallest(root.left, k);
        }
    }
    
    public int getCount(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        return 1 + getCount(root.left) + getCount(root.right);
    }
}