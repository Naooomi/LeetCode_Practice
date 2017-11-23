/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/**
 * Description:
 * Remove all elements from a linked list of integers that have value val.
 */

class Solution {

    public ListNode removeElements(ListNode head, int val) {

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
}
