package thePackage;

import java.util.ArrayList;

public class RemoveLinkedListElements {
	
	public ListNode removeElements_dumbButPasses(ListNode head, int val) {
		
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

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
}
