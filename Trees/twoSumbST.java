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
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> hs = new HashSet<>();
        return find(root, k, hs);
    }
    
    public boolean find(TreeNode root, int k, HashSet<Integer> hs) {
        if (root == null) {
            return false;
        }
        if (hs.contains(k - root.val)) {
            return true;
        }
        
        hs.add(root.val);
        
        
        return find(root.left, k, hs) || find(root.right, k, hs);
    }
}