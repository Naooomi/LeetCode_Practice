/**
 * Description:
 * Given a linked list, determine if it has a cycle in it.
 */

public class hasCycle {
	public boolean has_Cycle(ListNode head) {

        if (head == null) return false;
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
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
