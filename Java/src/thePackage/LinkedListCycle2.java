package thePackage;

import java.util.HashMap;

public class LinkedListCycle2 {

	public ListNode detectCycle(ListNode head) {
		HashMap<ListNode, Integer> map = new HashMap<ListNode, Integer>();

		ListNode curr = head;

		while (curr != null) {
			if (map.containsKey(curr)) {
				return curr;
			}
			map.put(curr, 1);
			curr = curr.next;
		}

		return null;
    }




	class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { 
			this.val = val; this.next = next; 
		}
	}
}
