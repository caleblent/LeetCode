package thePackage;

public class ValidateBinarySearchTree {

	public boolean isValidBST(TreeNode root) {
		if (root == null)
			return true;

		if (root.left != null) {
			if (root.val <= root.left.val)
				return false;
		}

		if (root.right != null) {
			if (root.val >= root.right.val)
				return false;
		}
		
		return isValidBST(root.left, Long.MIN_VALUE, root.val) 
			&& isValidBST(root.right, root.val, Long.MAX_VALUE);
	}
	
	public boolean isValidBST(TreeNode root, long low, long high) {
		if (root == null)
			return true;

		if (root.val <= low || root.val >= high)
			return false;
		
		return isValidBST(root.left, low, root.val)
			&& isValidBST(root.right, root.val, high);
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
}
