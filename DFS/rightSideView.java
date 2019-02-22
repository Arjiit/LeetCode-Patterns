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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        getNodes(root, res, 0);
        return res;
    }
    
    public void getNodes(TreeNode root, List<Integer> res, int level) {
        if (root == null) {
            return;
        }
        if (res.size() == level) {
            res.add(root.val);
        }
        
        getNodes(root.right, res, level + 1);
        getNodes(root.left, res, level + 1);
    }
}