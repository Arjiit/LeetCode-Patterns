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
Going inorder will give us the sorted value 
that we can iterate to get the minimum value.

 */
class Solution {
    public int minDiffInBST(TreeNode root) {
    List<Integer> res = new ArrayList<Integer>();
        inorder(root, res);
        int min = Integer.MAX_VALUE;
        for (int i=1; i < res.size(); i++) {
            min = Math.min(min, res.get(i) - res.get(i-1));
        }
        return min;
    }
    
    public void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }
}

/*
If we want to avoid using additional list.
Another way is to keep track of previous 
value while recursively iterating.

*/


int min = Integer.MAX_VALUE;
long prev = Long.MAX_VALUE;
public int minDiffInBST(TreeNode root) {
    if(root==null) return min;
    minDiffInBSTRec(root);
    return min;
    
}

public void minDiffInBSTRec(TreeNode root)
{
    if(root!=null){
        
        
        minDiffInBSTRec(root.left);
     
        if(min>Math.abs(prev-root.val)){
            min = (int) Math.abs(prev-root.val);
        }
        prev = root.val; // updating previous value before recursively moving to right
        
        minDiffInBSTRec(root.right);
        
        
        
    }
}