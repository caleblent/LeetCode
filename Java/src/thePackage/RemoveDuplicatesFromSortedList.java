package thePackage;

public class RemoveDuplicatesFromSortedList {
	
	// recursive
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null)
			return null;
		
		while (head.next != null && head.val == head.next.val) {
			head.next = head.next.next;
		}
		
		if (head.next == null)
			return head;
		else
			head.next = deleteDuplicates(head.next);
		
		return head;
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
