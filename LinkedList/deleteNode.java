public class deleteNode {
	public void delete_Node(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

	// Definition for singly-linked list.
	private class ListNode {
	    int val;
	    ListNode next;
	    @SuppressWarnings("unused")
		ListNode(int x) { val = x; }
	}
}
