package thePackage;

public class MaximumDepthOfABinaryTree {
	
	public int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		
		return findGreater(1 + maxDepth(root.right), 1 + maxDepth(root.left));
	}
	
	public int findGreater(int a, int b) {
		return a > b ? a : b;
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
