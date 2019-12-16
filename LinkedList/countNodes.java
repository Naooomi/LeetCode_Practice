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
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
}
