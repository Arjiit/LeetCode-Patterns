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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) { // if main tree is null
            return false;
        }
        
        if (t == null) {
            return true;
        }
        
        if (checkIdentical(s,t)) {
            return true;
        }
        
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    
    public boolean checkIdentical(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        
        if ((s != null) && (t != null)) {
            if ((s.val == t.val)&&checkIdentical(s.left, t.left)&&checkIdentical(s.right, t.right)) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}