/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*

*/
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i=0; i< inorder.length; i++){
            hm.put(inorder[i],i);
        }
        return build(preorder, inorder, hm, 0, inorder.length - 1, 0);
    }
    
    public TreeNode build(int[] preorder, int[] inorder, HashMap<Integer, Integer> hm, int start, int end, int next) {
        if (start > end) 
        {
            return null;
        }
        TreeNode cur = new TreeNode(preorder[next]);
        int inorderIndex = hm.get(preorder[next]);
        cur.left = build(preorder, inorder, hm, start, inorderIndex - 1, next+1);
        cur.right = build(preorder, inorder, hm, inorderIndex + 1, end, next + (inorderIndex - start) + 1); // next for right is chosen such that it finds the right element for preorder[next]
        
        return cur;
    }
}