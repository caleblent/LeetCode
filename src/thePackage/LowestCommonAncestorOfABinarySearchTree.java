package thePackage;

import java.util.LinkedList;
//import java.util.Stack;

public class LowestCommonAncestorOfABinarySearchTree {
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		TreeNode curr = root;
        while(true) {
        	if (p.val < curr.val && q.val < curr.val) {
        		curr = curr.left;
        	} else if (p.val > curr.val && q.val > curr.val) {
        		curr = curr.right;
        	} else {
        		return curr;
        	}
        }
    }
	
	public static void main(String[] args) {
		TreeNode p = new TreeNode(2);
		TreeNode q = new TreeNode(4);
		TreeNode root = new TreeNode(6);
		root.left = p;
		root.right = new TreeNode(8);
		p.left = new TreeNode(0);
		p.right = q;
		q.left = new TreeNode(3);
		q.right = new TreeNode(5);
//		[6,2,8,0,4,7,9,null,null,3,5]
//		TreeNode[] test = {root,p,new TreeNode(8),new TreeNode(0),q,new TreeNode(7),new TreeNode(9),null,null,new TreeNode(3),new TreeNode(5)};
		
		TreeNode LCA = lowestCommonAncestor_queue(root, p, q);
		System.out.println("LCA = " + LCA);
		System.out.println("LCA.val = " + LCA.val);
	}
	
	// I think the logic here is sounds but I'm struggling with syntax issues
	// specifically the while loop needs to be changed
	public static TreeNode lowestCommonAncestor_queue(TreeNode root, TreeNode p, TreeNode q) {
		LinkedList<TreeNode> pQ = new LinkedList<TreeNode>();
		LinkedList<TreeNode> qQ = new LinkedList<TreeNode>();
		
		/* save the elements on the path from the root to p into the LinkedList pQ */
		TreeNode curr = root;
		while (curr != p) {
			pQ.push(curr);
			System.out.println("pQ: " + curr.val);
			if (curr.val > p.val)
				curr = curr.left;
			else
				curr = curr.right;
		}
		
		/* save the elements on the path from the root to q into the LinkedList qQ */
		curr = root;
		while (curr != q) {
			qQ.push(curr);
			System.out.println("qQ: " + curr.val);
			if (curr.val > q.val)
				curr = curr.left;
			else
				curr = curr.right;
		}
		
		/* go through both queues/LinkedLists item by item until the first discrepancy is found */
		/* the node before this first discrepancy is the lowest common ancestor */
		TreeNode LCA = new TreeNode(-77);
		while (pQ.peek() == qQ.peek()) {
			if (pQ.peek() == null || qQ.peek() == null)
				break;
			LCA = pQ.peek();
			pQ.remove();
			qQ.remove();
		}
		
		/* return the lowest common ancestor */
		return LCA;
	}
	
//	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//		Stack<TreeNode> pQ = new Stack<TreeNode>();
//		Stack<TreeNode> qQ = new Stack<TreeNode>();
//		
//		/* save the elements on the path from the root to p into the LinkedList pQ */
//		TreeNode curr = p;
//		while (curr != root) {
//			pQ.add(curr);
//			if (curr.val > p.val)
//				curr = curr.left;
//			else
//				curr = curr.right;
//		}
//		
//		/* save the elements on the path from the root to q into the LinkedList qQ */
//		curr = root;
//		while (curr != q) {
//			qQ.add(curr);
//			if (curr.val > q.val)
//				curr = curr.left;
//			else
//				curr = curr.right;
//		}
//		
//		/* go through both queues/LinkedLists item by item until the first discrepancy is found */
//		/* the node before this first discrepancy is the lowest common ancestor */
//		TreeNode LCA = new TreeNode();
//		while (pQ.peek() == qQ.peek()) {
//			LCA = pQ.pop();
//			qQ.pop();
//		}
//		
//		/* return the lowest common ancestor */
//		return LCA;
//	}
	
	
	
	public static class TreeNode {
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
