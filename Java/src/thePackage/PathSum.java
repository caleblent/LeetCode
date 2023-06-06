package thePackage;

public class PathSum {
	
	public boolean hasPathSum(TreeNode root, int targetSum) {
		// if root is null
		if (root == null)
			 return false;
		
		// if root has no children
		if (root.left == null && root.right == null)
			if (root.val == targetSum)
				return true;
		
		
		boolean left = false, right = false;
		
		// if root has a left child
		if (root.left != null)
			left = hasPathSum(root.left, targetSum - root.val);
		
		// if root has a right child
		if (root.right != null)
			right = hasPathSum(root.right, targetSum - root.val);
		
		// return the disjunction
		return left || right;
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
