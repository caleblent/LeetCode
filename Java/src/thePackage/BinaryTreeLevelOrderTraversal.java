package thePackage;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {


	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> treeList = new ArrayList<>();

		// if the root is null, return null
		if (root == null)
			return treeList;
		
		// this list/queue will keep track of all the entries
		List<TreeNode> list = new LinkedList<TreeNode>();
		
		list.add(root);
		while (list.size() > 0) {
            List<Integer> level = new ArrayList<Integer>();
            int levelNumber = list.size();

            for (int i = 0; i < levelNumber; i++) {
                TreeNode node = list.remove(0);
                level.add(node.val);
                if (node.left != null) {
                	list.add(node.left);
                }
                if (node.right != null) {
                	list.add(node.right);
                }
            }
            treeList.add(level);
        }
		
		return treeList;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(15);
		root.left = new TreeNode(10);
		root.right = new TreeNode(20);
		root.left.left = new TreeNode(8);
		root.left.right = new TreeNode(12);
		root.right.left = new TreeNode(16);
		root.right.right = new TreeNode(25);

		levelOrderTraversal2(root);
	}

	public static void levelOrderTraversal1(TreeNode root) {
		List<TreeNode> list = new LinkedList<TreeNode>();

		if (root == null)
			return;

		list.add(root);
		TreeNode curr;
		while (!list.isEmpty()) {
			curr = list.remove(0);
			
			System.out.print(curr.val + " ");
			
			if (curr.left != null)
				list.add(curr.left);
			if (curr.right != null)
				list.add(curr.right);
		}
	}
	
	public static void levelOrderTraversal2(TreeNode root) {
		List<TreeNode> list = new ArrayList<TreeNode>();

		if (root == null)
			return;

		list.add(root);
		TreeNode curr = new TreeNode();
		int index = 0;
		while (index < list.size()) {
			curr = list.get(index);
			
			System.out.print(curr.val + " ");
			
			if (curr.left != null)
				list.add(curr.left);
			if (curr.right != null)
				list.add(curr.right);
			
			index++;
		}
	}

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

	public static class TreeNode {
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
