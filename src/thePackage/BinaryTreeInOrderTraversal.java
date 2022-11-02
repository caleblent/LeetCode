package thePackage;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInOrderTraversal {

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		
		if (root == null)
			return list;
		
		if (root.left != null)
			list.addAll(inorderTraversal(root.left));
		
		list.add(root.val);
		
		if (root.right != null)
			list.addAll(inorderTraversal(root.right));
		
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
