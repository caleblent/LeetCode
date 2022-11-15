package thePackage;

public class TwoSum4 {

	public boolean findTarget(TreeNode root, int k) {
		// if root is null
		if (root == null)
			return false;
		
		// search entire tree for 2nd value
		if (root.val * 2 != k) {
			if (searchBST(root, k - root.val))
				return true;
		}
		
		
//		boolean left = false, right = false;
//		
//		// try again with the left subtree (if it exists)
//		if (root.left != null)
//			left = findTarget(root.left, k);
//		
//		// try again with the right subtree (if it exists)
//		if (root.right != null)
//			right = findTarget(root.right, k);
		
		// return the disjunction -- because only 1 sum needs to be found
		return findTarget(root.left, k) || findTarget(root.right, k);
	}
	
	public boolean searchBST(TreeNode root, int val) {
		if (root == null)
			return false;
		
		if (val < root.val) {
			if (root.left != null) {
				return searchBST(root.left, val);
			} else {
				return false;
			}
		} else if (val > root.val) {
			if (root.right != null) {
				return searchBST(root.right, val);
			} else {
				return false;
			}
		} else {// val == root.val
			return true;
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
