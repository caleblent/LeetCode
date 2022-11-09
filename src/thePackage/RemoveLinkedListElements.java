package thePackage;

import java.util.ArrayList;

public class RemoveLinkedListElements {
	
	public ListNode removeElements_recursive(ListNode head, int val) {
		if (head == null)
			return null;
		
		head.next = removeElements_recursive(head.next, val);
		
		if (head.val == val)
			return head.next;
		else
			return head;
	}
	
	public ListNode removeElements_dumbButWorks(ListNode head, int val) {
		
		/* 1. copy linked list values into an ArrayList */
		ArrayList<Integer> vals = new ArrayList<Integer>();
		
		ListNode curr = head;
		while (curr != null) {
			vals.add(curr.val);
			curr = curr.next;
		}
		
		/* 2. copy ArrayList values into a new linked list without the target value */
		ListNode sentinelHead = new ListNode(Integer.MIN_VALUE);
		curr = sentinelHead;
		for (int i = 0; i < vals.size(); i++) {
			if (vals.get(i) != val) {
				curr.next = new ListNode(vals.get(i));
				curr = curr.next;
			}
		}
		
		/* 3. return sentinelHead.next, which is the first in the list */
		return sentinelHead.next;
	}

	class ListNode {
		int val;
		ListNode next;
		
		ListNode() {}

		ListNode(int x) {
			val = x;
			next = null;
		}
		
		ListNode(int x, ListNode n) {
			val = x;
			next = n;
		}
	}
}
