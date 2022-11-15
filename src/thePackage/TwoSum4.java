package thePackage;

import java.util.ArrayList;

public class TwoSum4 {
	
	ArrayList<Integer> nums = new ArrayList<Integer>();

	public boolean findTarget(TreeNode root, int k) {
		// if root is null
		if (root == null)
			return false;
		
		// add tree values to nums
		inorder(root);
		
		// search through  the nums ArrayList to see if there is a sum that adds up to k
		for (int i = 0; i < nums.size(); i++) {
			for (int j = i + 1; j < nums.size(); j++) {
				// if the sum of the 2 is k, return true
				if (nums.get(i) + nums.get(j) == k)
					return true;
				// if the sum is > k, start over with a different i
				if (nums.get(i) + nums.get(j) > k)
					break;
			}
		}
		
		// if it never returned true, that means there is NOT a sum that adds up to k
		return false;
	}
	
	public void inorder(TreeNode root) {
		if (root == null) 
			return;
		inorder(root.left);
		nums.add(root.val);
		inorder(root.right);
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
