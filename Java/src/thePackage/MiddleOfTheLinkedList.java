package thePackage;

public class MiddleOfTheLinkedList {

	public ListNode middleNode(ListNode head) {
		/* 1. get size of the linked list */
        int listSize = getSize(head);
        System.out.println("listSize: " + listSize);
        
        /* 2. calculate the index of the middle node */
        int middle = listSize / 2;
        System.out.println("middle: " + middle);
        
        /* 3. return the middle node */
        return getNode(head, middle);
        
    }
	
	/* return the node based on the specified index */
	public ListNode getNode(ListNode head, int index) {
		ListNode curr = head;
		for (int i = 0; i < index; i++)
			curr = curr.next;
		return curr;
	}
	
	/* return the number of items in the linked list */
	public int getSize(ListNode node) {
		if (node == null)
			return 0;
		
		return 1 + getSize(node.next);
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
