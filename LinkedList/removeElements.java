/**
	Description:
	Remove all elements from a linked list of integers that have value val.
 */

public class removeElements {
	public ListNode remove_Elements(ListNode head, int val) {

        ListNode current = head;

        while (current != null && current.next != null) {
            if (current.next.val == val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head.val == val ? head.next : head;
    }
	
	// Definition for singly-linked list.
	private class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) { val = x; }
	}
}
