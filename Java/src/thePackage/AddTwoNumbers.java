package thePackage;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class AddTwoNumbers {
	
	public static void main(String[] args) {
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		ListNode four = new ListNode(4);
		ListNode five = new ListNode(5);
		ListNode six = new ListNode(6);
		ListNode seven = new ListNode(7);
		
		seven.next = three;
		three.next = four;
		four.next = one;
		// 7 - 3 - 4 - 1 ~> 1437
		
		two.next = five;
		five.next = six;
		// 2 - 5 - 6 ~> 652
		
		// 1437 + 652 = 2089
		
//		addTwoNumbersStr(seven, two);
//		System.out.println();
		
//		addTwoNumbersStr(new ListNode(0), new ListNode(0));
//		System.out.println();
		
		// l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
		ListNode n0 = new ListNode(1);
		ListNode n1 = new ListNode(9);
		ListNode n2 = new ListNode(9);
		ListNode n3 = new ListNode(9);
		ListNode n4 = new ListNode(9);
		ListNode n5 = new ListNode(9);
		ListNode n6 = new ListNode(9);
		ListNode n7 = new ListNode(9);
		ListNode n8 = new ListNode(9);
		ListNode n9 = new ListNode(9);
		
		n0.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = n9;
		
		addTwoNumbersStr(n1, n4);
		System.out.println();
		
		printLinkedNodesInArray(n0);
		printLinkedNodesInArray(n9);
		addTwoNumbersStr(n0, n9);
		
		
		
	}
	
	public static ListNode addTwoNumbersStr(ListNode l1, ListNode l2) {
    	ListNode curr = l1;
        String result1 = "";
        
        while(curr != null) {
        	result1 += curr.val;
        	curr = curr.next;
        }
        
        curr = l2;
        String result2 = "";
        
        while(curr != null) {
        	result2 += curr.val;
        	curr = curr.next;
        }
        
        String result3 = addStrings(result1, result2);
        System.out.printf("result1: %16s%n", result1);
        System.out.printf("result2: %16s%n", result2);
        System.out.printf("result3: %16s%n", result3);
        
        ListNode head = new ListNode(Integer.parseInt(result3.charAt(0) + ""));
        curr = head;
        printLinkedNodesInArray(head);
        
        for (int i = 1; i < result3.length(); i++) {
        	curr.next = new ListNode(Integer.parseInt(result3.charAt(i) + ""));
        	curr = curr.next;
        	printLinkedNodesInArray(head);
        }
        
        printLinkedNodes(head);
    	
    	return curr;
    }
	
    private static String addStrings(String str1, String str2) {
    	boolean elOneLonger;
    	int length;
    	if (str1.length() > str2.length()) {
    		elOneLonger = true;
    		length = str2.length();
    	} else {
    		elOneLonger = false;
    		length = str1.length();
    	}
    	String ret = "";
    	int num1;
    	int num2;
    	int sum;
    	int remainder = 0;
    	
		for (int i = 0; i < length; i++) {
			num1 = Integer.parseInt(str1.charAt(i) + "");
			num2 = Integer.parseInt(str2.charAt(i) + "");
			sum = num1 + num2 + remainder;
			remainder = sum / 10;
			ret += sum % 10;
			System.out.printf(
				"num1:%d - num2:%d :: sum: %2d - remainder: %d :: %s%n", 
				num1, num2, sum, remainder, ret
			);
		}
		if (elOneLonger) {
			for (int i = length; i < str1.length(); i++) {
				num1 = Integer.parseInt(str1.charAt(i) + "");
				sum = num1 + remainder;
				remainder = sum / 10;
				ret += sum % 10;
				System.out.printf(
					"num1:%d - num2:_ :: sum: %2d - remainder: %d :: %s%n", 
					num1, sum, remainder, ret
				);
			}
		} else {
			for (int i = length; i < str2.length(); i++) {
				num2 = Integer.parseInt(str2.charAt(i) + "");
				sum = num2 + remainder;
				remainder = sum / 10;
				ret += sum % 10;
				System.out.printf(
					"num1:%d - num2:_ :: sum: %2d - remainder: %d :: %s%n", 
					num2, sum, remainder, ret
				);
			}
		}
		
		if (remainder != 0) {
			ret += remainder;
		}
		
		return ret;
	}

	public static ListNode addTwoNumbersLong(ListNode l1, ListNode l2) {
    	ListNode curr = l1;
        long result1 = 0;
        int index = 0;
        
        while(curr != null) {
        	result1 += curr.val * Math.pow(10, index);
        	index++;
        	curr = curr.next;
        }
        
        curr = l2;
        long result2 = 0;
        index = 0;
        
        while(curr != null) {
        	result2 += curr.val * Math.pow(10, index);
        	index++;
        	curr = curr.next;
        }
        
        long result3 = result1 + result2;
        System.out.printf("result1: %16d%n", result1);
        System.out.printf("result2: %16d%n", result2);
        System.out.printf("result3: %16d%n", result3);
        
        ListNode head = new ListNode((int) (result3 % 10));
        result3 /= 10;
        curr = head;
        printLinkedNodesInArray(head);
        
        while(result3 != 0) {
        	curr.next = new ListNode((int) result3 % 10);
        	curr = curr.next;
        	result3 /= 10;
        	printLinkedNodesInArray(head);
        }
        
        printLinkedNodes(head);
    	
    	return head;
    }
    
    public static void printLinkedNodes(ListNode node) {
    	while (node != null) {
    		System.out.print(node.val);
    		if (node.next != null)
    			System.out.print(" -> ");
    		node = node.next;
    	}
    	System.out.println();
    }
    
    public static void printLinkedNodesInArray(ListNode node) {
    	System.out.print("[");
    	while (node != null) {
    		System.out.print(node.val);
    		if (node.next != null)
    			System.out.print(",");
    		node = node.next;
    	}
    	System.out.print("]\n");
    }
}

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }