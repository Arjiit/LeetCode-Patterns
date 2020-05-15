/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    /*
        We perform DFS to find the target and along the way add the child, parent pairs in hashmap.
        We then perform BFS starting the target value and check the child and parent to find the
        closest leaf.
    */
    public int findClosestLeaf(TreeNode root, int k) {
        HashMap<TreeNode, TreeNode> hm = new HashMap<>();
        TreeNode kNum = dfs(root, k, hm);
        Set<TreeNode> visited = new HashSet<>();
        visited.add(kNum);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(kNum);
        while(!q.isEmpty()) {
            TreeNode nodeOut = q.poll();
            System.out.println(nodeOut.val);
            if (nodeOut.left == null && nodeOut.right == null) {
                return nodeOut.val;
            }
            if (nodeOut.left != null && visited.add(nodeOut.left)) {
                q.add(nodeOut.left);
            }
            if (nodeOut.right != null && visited.add(nodeOut.right)) {
                q.add(nodeOut.right);
            }
            if (hm.containsKey(nodeOut) && visited.add(hm.get(nodeOut))) {
                q.add(hm.get(nodeOut));
            }
        }
        return -1;
    }
    
    public TreeNode dfs(TreeNode root, int k, HashMap<TreeNode, TreeNode> hm) {
        if (root.val == k) {
            return root;
        }
        if (root.left != null) {
            hm.put(root.left, root);
            TreeNode left = dfs(root.left, k, hm);
            if (left != null) return left;
        }
        if (root.right != null) {
            hm.put(root.right, root);
            TreeNode right = dfs(root.right, k, hm);
            if (right != null) return right;
        }
        return null;
    }
    
    
}