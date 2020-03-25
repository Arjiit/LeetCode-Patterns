class Solution {	
	class TreeNode {
		int data;
		Node left, right;
		public TreeNode(int data) {
			this.data = data;
			left = right = null;
		}
	}

	public List<Integer> boundaryTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		getBoundary(root, res, -1);
		getBoundary(root, res,  0);
		getBoundary(root, res,  1);

		return res;			
	}

	public void getBoundary(TreeNode root, List<Integer> res, int dir) {
		if (root == null) return;

		if (dir == -1) {
			if (root.left != null) {
				res.add(root.val);
				getBoundary(root.left, res, dir);
			} 
		} else if (dir == 0) {
			getBoundary(root.left, res, dir);
			if (root.left == null && root.right == null) {
				res.add(root.val);
			}
			getBoundary(root.right, res, dir);
		} else if (dir == 1) {
			if (root.right != null) {
				res.add(root.val);
				getBoundary(root.right, res, dir);
			}
		}
	}
}