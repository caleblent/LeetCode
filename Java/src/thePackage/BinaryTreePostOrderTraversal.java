package thePackage;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostOrderTraversal {
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		
		if (root == null)
			return list;
		
		if (root.left != null)
			list.addAll(postorderTraversal(root.left));
		
		if (root.right != null)
			list.addAll(postorderTraversal(root.right));
		
		list.add(root.val);
		
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
