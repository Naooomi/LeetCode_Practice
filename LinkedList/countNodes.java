public class countNodes {
    /*
     * @param head: the first node of linked list.
     * @return: An integer
     */
    public int count_Nodes(ListNode head) {

        int count = 0;
        for (ListNode n = head; n != null; n = n.next) {
            count++;
        }
        return count;

    }
    
    // Definition for ListNode.
    private class ListNode {
        @SuppressWarnings("unused")
		int val;
        ListNode next;
        @SuppressWarnings("unused")
		ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
}
