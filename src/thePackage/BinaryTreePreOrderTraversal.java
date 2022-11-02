package thePackage;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreOrderTraversal {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		
		if (root == null)
			return list;
		
		list.add(root.val);
		
		if (root.left != null)
			list.addAll(preorderTraversal(root.left));
		
		if (root.right != null)
			list.addAll(preorderTraversal(root.right));
		
		return list;
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
