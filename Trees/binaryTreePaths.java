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
    /*
    recursively find the left part and add it after ->
    do the same for the right part.

    case i) root is null - then return empty list
    case 2) root.right and root.left both are null, then add the number to list and return the list.
    case 3) if (root.left != null) then add current value -> (values from the list i.e. result of the recursive call)
    case 4) if (root.right != null) then add current value -> (values from the list i.e. result of the recursive call)
    */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> slist = new LinkedList<String>();
        
        if (root == null) {
            return slist;
        }
        
        if(root.left == null && root.right == null) {
            slist.add(Integer.toString(root.val));
            return slist;
        }
        
        for (String s: binaryTreePaths(root.left)) {
            slist.add(Integer.toString(root.val) + "->" + s);
        }
        
        for (String s: binaryTreePaths(root.right)) {
            slist.add(Integer.toString(root.val) + "->" + s);
        }
        
        return slist;
    }
}