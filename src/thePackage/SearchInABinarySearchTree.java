package thePackage;

public class SearchInABinarySearchTree {
	
	public TreeNode searchBST(TreeNode root, int val) {
		if (root == null)
			return null;
		
		if (val < root.val) {
			if (root.left != null) {
				return searchBST(root.left, val);
			} else {
				return null;
			}
		} else if (val > root.val) {
			if (root.right != null) {
				return searchBST(root.right, val);
			} else {
				return null;
			}
		} else {// val = root.val
			return root;
		}
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
