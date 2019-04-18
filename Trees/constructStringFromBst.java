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
    public String tree2str(TreeNode t) {
        if (t==null) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        traverse(t,sb);
        return sb.toString();
    }
    
    public void traverse(TreeNode t, StringBuilder sb) {
                sb.append(t.val); // traverse current node
        if (t.left == null && t.right == null) {
            sb.append("");
            return;
        }

        if (t.left != null) { // traverse left
            sb.append("(");
            traverse(t.left, sb);
            sb.append(")");
        }
        
        if (t.right != null) { // traverse right
            if (t.left == null) {
                sb.append("()");
            }
            sb.append("(");
            traverse(t.right, sb);
            sb.append(")");
        }
    }
    
}