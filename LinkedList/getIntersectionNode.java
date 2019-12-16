/**
 * Description:
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 */

public class getIntersectionNode {
	public ListNode get_IntersectionNode(ListNode headA, ListNode headB) {

        int lenA = length(headA);
        int lenB = length(headB);

        // move headA and headB to the same start point
        while (lenA > lenB) {
            headA = headA.next;
            lenA--;
        }

        while (lenA < lenB) {
            headB = headB.next;
            lenB--;
        }

        // find the intersection until end
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    private int length (ListNode node) {
        int length = 0;
        while (node != null) {
            node = node.next;
            length++;
        }
        return length;
    }
    
	// Definition for singly-linked list.
	private class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) { val = x; }
	}
}
