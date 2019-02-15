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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> inorderHash = new HashMap<Integer, Integer>();
        for (int i=0; i<inorder.length; i++) {
            inorderHash.put(inorder[i],i);
        }
        
        return helper(preorder, inorder, inorderHash, 0, 0, inorder.length-1);
    }
    
    public TreeNode helper(int[] preorder, int[] inorder, HashMap<Integer, Integer> hash, int next, int low, int high) {
        if (low > high) {
            return null;
        }
        
        TreeNode cur = new TreeNode(preorder[next]);
        int currInd = hash.get(preorder[next]);
        
        cur.left = helper(preorder, inorder, hash, next+1,low, currInd - 1);
        cur.right = helper(preorder, inorder, hash, next + (currInd - low) + 1, currInd + 1, high);
        
        return cur;
    }
}