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
Type 2 recursion: Defining function first and then calling it later.
*/
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> curResult = new ArrayList<Integer>();
        List<List<Integer>> result = new ArrayList<>();
        getPathSum(root, sum, curResult, result);
        return result;
    }
    
    public void getPathSum(TreeNode root, int sum, List<Integer> curResult, List<List<Integer>> result) {
        
        if (root == null) {
            return;
        }

        curResult.add(root.val);
        if (root.left == null && root.right == null)
        {
            if (root.val == sum) {
                result.add(new ArrayList<>(curResult));
            }
            return;
        }
        if (root.left != null) {
            getPathSum(root.left, sum - root.val, curResult, result); // once we have seen if it evaluates to sum, we remove the last element, so that we can check for the right case.
            curResult.remove(curResult.size() - 1);
        }
        
        if (root.right != null) {
            getPathSum(root.right, sum - root.val, curResult, result);
            curResult.remove(curResult.size() - 1);
        }
    }
}