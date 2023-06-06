package thePackage;

public class MergeTwoSortedLists {
	
	public static void main(String[] args) {
//		Input: list1 = [1,2,4], list2 = [1,3,4]
//		Output: [1,1,2,3,4,4]
		
		ListNode c = new ListNode(6);
		ListNode b = new ListNode(3, c);
		ListNode a = new ListNode(1, b);
		
		ListNode f = new ListNode(4);
		ListNode e = new ListNode(2, f);
		ListNode d = new ListNode(1, e);
		
		ListNode merged = mergeTwoLists(a, d);
		
		printListNodes(merged);
	}
	
	public static void printListNodes(ListNode node) {
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
		System.out.print("\n");
	}
	
	public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		if (list1 == null)
			return list2;
		else if (list2 == null)
			return list1;
		
		ListNode head = new ListNode(0);
		ListNode curr = head;
		
		while (list1 != null && list2 != null) {
			if (list1.val < list2.val) {
				curr.next = list1;
				list1 = list1.next;
			} else {
				curr.next = list2;
				list2 = list2.next;
			}
			curr = curr.next;
		}
		
		if (list1 == null) {
//			printListNodes(list2)
			curr.next = list2;
		} else { // list2 == null
//			printListNodes(list1);
			curr.next = list1;
		}

		return head.next;
	}

	// Definition for singly-linked list.
	public static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
}
