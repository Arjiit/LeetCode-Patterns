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
    public int sumNumbers(TreeNode root) {
        return dfs(root,0);
    }
    
    public int dfs(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }
        
        int value = sum*10 + node.val;
        
        if (node.left == null && node.right == null) {
            return value;
        }
        
        return dfs(node.left,value) + dfs(node.right, value);
     }
}