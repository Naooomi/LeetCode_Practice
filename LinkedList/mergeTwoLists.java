/**

  Description:

  Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

*/

public class mergeTwoLists {
	public ListNode merge_TwoLists(ListNode l1, ListNode l2){
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		if(l1.val < l2.val){
			l1.next = merge_TwoLists(l1.next, l2);
			return l1;
		} else{
			l2.next = merge_TwoLists(l1, l2.next);
			return l2;
		}
    }
	
	// Definition for singly-linked list.
	private class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) { val = x; }
	}
}
