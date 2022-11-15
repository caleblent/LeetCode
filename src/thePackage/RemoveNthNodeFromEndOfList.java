package thePackage;

public class RemoveNthNodeFromEndOfList {
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
		
		// 1. find the size of the list
		ListNode curr = head;
		int size = 0;
		while (curr != null) {
			size++;
			curr = curr.next;
		}
		
		// 2. remove the (size - n)th node from the list
		ListNode sentinel = new ListNode(0, head);
		ListNode prev = sentinel;
		curr = head;
		int index = 0;
		// first, get to the node to delete
		while (index < size - n) {
			index++;
			prev = curr;
			curr = curr.next;
		}
		// now delete the curr node using the prev node;
		prev.next = curr.next;
		
		// 3. return the head of the node list
		return sentinel.next;
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
