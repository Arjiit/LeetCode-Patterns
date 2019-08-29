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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        
        return getTree(nums, 0, nums.length - 1);
    }
    
    public TreeNode getTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        
        int maxIndex = getMax(nums, start, end);
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = getTree(nums, start, maxIndex - 1);
        root.right = getTree(nums, maxIndex + 1, end);
        return root;
    }
    
    public int getMax(int nums[], int start, int end) {
        int maxIndex = 0;
        int max = 0;
        for (int i=start; i<=end; i++) {
            if (nums[i] >= max) {
                maxIndex = i;
                max = nums[i];
            }            
        }
        return maxIndex;
    }
}