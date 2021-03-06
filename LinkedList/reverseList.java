/**
	Description:
	Reverse a singly linked list.
 */

public class reverseList {
	public ListNode reverse_List(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode p = reverse_List(head.next);
        head.next.next = head;
        head.next = null;
        
        return p;
    }
	
	// Definition for singly-linked list.
	private class ListNode {
	    @SuppressWarnings("unused")
		int val;
	    ListNode next;
	    @SuppressWarnings("unused")
		ListNode(int x) { val = x; }
	}
}
