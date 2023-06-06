package thePackage;

import java.util.HashMap;

public class LinkedListCycle {

	public boolean hasCycle(ListNode head) {
		HashMap<ListNode, Integer> map = new HashMap<ListNode, Integer>();

		ListNode curr = head;

		while (curr != null) {
			if (map.containsKey(curr)) {
				return true;
			}
			map.put(curr, 1);
			curr = curr.next;
		}

		return false;
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
