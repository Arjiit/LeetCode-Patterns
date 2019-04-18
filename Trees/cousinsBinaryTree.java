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
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()) {
            int s = q.size();
            HashMap<Integer, TreeNode> hm = new HashMap<>();
            for (int i=0; i<s; i++) {
                TreeNode p = q.remove();
                if (p.left != null) {
                    hm.put(p.left.val, p); // putting (value, parent)
                    q.add(p.left);
                }
                if (p.right != null) {
                    hm.put(p.right.val, p);
                    q.add(p.right);
                }
                if (hm.containsKey(x) && hm.containsKey(y)) {
                return (hm.get(x) != hm.get(y));
            }
            }

        }
        return false;
    }
}