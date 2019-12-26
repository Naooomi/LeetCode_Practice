import java.util.LinkedList;

/**
	234. Palindrome Linked List
	
	Description: 
	Given a singly linked list, determine if it is a palindrome.
	
	Example 1:	
	Input: 1->2
	Output: false
	
	Example 2:
	Input: 1->2->2->1
	Output: true
	
	Follow up:
	Could you do it in O(n) time and O(1) space?
	
 */
/**
 * Definition for singly-linked list.
 */

public class isPalindrome {
	/**
	 * Solution One
	 * 
	 * 1. Find the Middle of the list
	 * 2. Reverse the second half
	 * 3. Run two pointers to compare every element from 1st and 2nd half
	 * 
	 * */
    public boolean is_Palindrome1(ListNode head) {
        if (head == null || head.next == null) return true;
        
        ListNode mid = findMiddle(head);
    	ListNode reverseHead = reverseList(mid);
    	
    	ListNode first = head;
    	ListNode second = reverseHead;
    	
    	while (first != null && second != null)
    	{
    		if (first.val != second.val) return false;
    		first = first.next;
    		second = second.next;
    	}
    	
    	return true;
    }
    
    public ListNode reverseList (ListNode secondHead)
    {
    	if (secondHead == null) return secondHead;
    	if (secondHead.next == null) return secondHead;
    	
    	ListNode prev = null;
    	ListNode cur = secondHead;
    	ListNode next = secondHead.next;
    	
    	while (cur != null)
    	{
    		cur.next = prev;
    		prev = cur;
    		cur = next;
    		if (cur == null) break;
    		next = next.next;
    	}
    	
    	return prev;
    }
    
    public ListNode findMiddle(ListNode head)
    {
    	ListNode slow = head;
    	ListNode fast = head;
    	
    	while (fast != null && fast.next != null)
    	{
    		slow = slow.next;
    		fast = fast.next.next;
    	}
    	
    	return slow;
    }
 
    /**
     * Solution Two
     * 
     * Using Stack and Queue
     * */
    public boolean is_Palindrome2(ListNode head)
    {
    	LinkedList<Integer> stack = new LinkedList<Integer>();
    	LinkedList<Integer> queue = new LinkedList<Integer>();
    	
    	while (head != null)
    	{
    		stack.push(head.val);
    		queue.add(head.val);
    		
    		head = head.next;
    	}
    	
    	while (!stack.isEmpty())
    	{
    		if (!stack.pop().equals(queue.removeFirst()))
    			return false;
    	}
    	
    	return true;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
