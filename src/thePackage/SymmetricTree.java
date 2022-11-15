package thePackage;

import java.util.ArrayList;
import java.util.List;

public class SymmetricTree {

	public boolean isSymmetric(TreeNode root) {
		// base NULL case
		if (root == null)
			return true;
			
		// traverse the tree in order, saving the nodes to a list
		List<TreeNode> treeList = inorderTraversal(root);
		
		// verify if the list is symmetric by evaluating opposite sides of the list
		for (int i = 0; i < treeList.size() / 2; i++) {
			if (!areEquivalent(treeList.get(i), treeList.get(treeList.size() - i - 1)))
				return false;
		}
		
		// if nothing has returned false, then they are symmetric
		return true;
	}
	
	public boolean areEquivalent(TreeNode x, TreeNode y) {
		// check the immediate values of each node
		if (x.val != y.val)
			return false;
		
		// ensure that x's left child and y's right child correspond correctly
		if (x.left == null) {
			if (y.right != null) {
				return false; // x has NO left child, but y DOES have a right child
			}
		} else {
			if (y.right == null) {
				return false; // x has a left child, but y DOES NOT have a right child
			}
		}
		
		// ensure that x's right child and y's left child correspond correctly
		if (x.right == null) {
			if (y.left != null) {
				return false; // x has NO right child, but y DOES have a left child
			}
		} else {
			if (y.left == null) {
				return false; // x has a right child, but y DOES NOT have a left child
			}
		}
		
		// check the values of the corresponding children
		if (x.left != null && y.right != null) {
			if (x.left.val != y.right.val)
				return false;
		}
		if (x.right != null && y.left != null) {
			if (x.right.val != y.left.val)
				return false;
		}
		
		return true;
	}
	
	public List<TreeNode> inorderTraversal(TreeNode root) {
		List<TreeNode> list = new ArrayList<TreeNode>();
		
		if (root == null)
			return list;
		
		if (root.left != null)
			list.addAll(inorderTraversal(root.left));
		
		list.add(root);
		
		if (root.right != null)
			list.addAll(inorderTraversal(root.right));
		
		return list;
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
