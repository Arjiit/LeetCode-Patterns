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
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }
        
        return helper(root, L, R);     
    }

    /*
        Forming solution recursively using conditions and moving forward.

    */
    
    public int helper(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }
        if (root.val < L) {
            return helper(root.right, L, R);
        }
        
        else if (root.val > R) {
            return helper(root.left, L, R);
        } else {
            return root.val + helper(root.left, L,R) + helper(root.right, L,R);
        }
    }
}