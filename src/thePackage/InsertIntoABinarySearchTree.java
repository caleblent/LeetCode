package thePackage;

public class InsertIntoABinarySearchTree {
	
	public TreeNode insertIntoBST(TreeNode root, int val) {
		if (root == null)
			return new TreeNode(val);
		
		if (val < root.val) {
			if (root.left == null) {
				root.left = new TreeNode(val);
			} else {
				root.left = insertIntoBST(root.left, val);
			}
		} else if (val > root.val) {
			if (root.right == null) {
				root.right = new TreeNode(val);
			} else {
				root.right = insertIntoBST(root.right, val);
			}
		}
		
		return root;
	}
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) {	this.val = val;	}
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
}
