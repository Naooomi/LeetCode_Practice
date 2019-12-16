/**
	Description:
	Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.
	   You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 */

public class oddEvenList {
	public ListNode oddEven_List(ListNode head) {

        if (head == null) return null;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = odd.next;
        }
        odd.next = evenHead;
        return head;
    }
	
	// Definition for singly-linked list.
	private class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) { val = x; }
	}
}
