/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */


public class Solution {
    /*
     * @param head: the first node of linked list.
     * @return: An integer
     */
    public int countNodes(ListNode head) {

        int count = 0;
        for (ListNode n = head; n != null; n = n.next) {
            count++;
        }
        return count;

    }
}
