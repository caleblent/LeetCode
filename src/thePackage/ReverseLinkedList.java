package thePackage;

import java.util.ArrayList;

public class ReverseLinkedList {
	
	public ListNode reverseList(ListNode head) {
		/* 1. copy linked list values into an ArrayList */
		ArrayList<Integer> vals = new ArrayList<Integer>();
		
		ListNode curr = head;
		while (curr != null) {
			vals.add(curr.val);
			curr = curr.next;
		}
		
		/* 2. copy ArrayList values into a new linked list in reverse order */
		ListNode dummy = new ListNode(Integer.MIN_VALUE);
		curr = dummy;
		for (int i = 0; i < vals.size(); i++) {
			curr.next = new ListNode(vals.get(vals.size() - i - 1));
			curr = curr.next;
		}
		
		/* 3. return the first node in the list */
        return dummy.next;
    }

	class ListNode {
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
