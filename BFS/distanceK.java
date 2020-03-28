/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 // T.C - O(M+N) = O(N), N = no of nodes in BT, S.C = O(N)
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        HashMap<TreeNode, TreeNode> hm = new HashMap<>();
        nodeParentMap(root, hm, null);// since root has no parent
        HashSet<TreeNode> seen = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        seen.add(target);
        int currentLayer = 0;
        while(!q.isEmpty()) {
            if (currentLayer == K) {
                return getLayerFromQueue(q);
            }
            // processing all nodes in the layer
            int layerSize = q.size();
            for(int i=0; i<layerSize; i++) {
                TreeNode curNode = q.poll();
                if (curNode.left != null && !seen.contains(curNode.left)) {
                    seen.add(curNode.left);
                    q.add(curNode.left);
                }
                if (curNode.right != null && !seen.contains(curNode.right)) {
                    seen.add(curNode.right);
                    q.add(curNode.right);
                }
                TreeNode parent = hm.get(curNode);
                if (parent != null && !seen.contains(parent)) {
                    seen.add(parent);
                    q.add(parent);
                }
            }
            currentLayer++;
            
        }
        return new ArrayList<>();
    }
    
    public void nodeParentMap(TreeNode root, HashMap<TreeNode, TreeNode> hm, TreeNode parent) {
        if (root == null) return;
        hm.put(root, parent);
        nodeParentMap(root.left, hm, root);
        nodeParentMap(root.right, hm, root);
    }
    
    public List<Integer> getLayerFromQueue(Queue<TreeNode> q) {
        List<Integer> extractedLayer = new ArrayList<>();
        for(TreeNode n: q) {
            extractedLayer.add(n.val);
        }
        return extractedLayer;
    }
}