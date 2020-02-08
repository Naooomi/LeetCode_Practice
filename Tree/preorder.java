package Tree;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
	589. N-ary Tree Preorder Traversal
	
	Description:
	Given an n-ary tree, return the preorder traversal of its nodes' values.
	Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).
	
	Follow up:
	Recursive solution is trivial, could you do it iteratively?
	
	Example 1:
	
		      1
	       /  |  \  
	      3   2   4
	     / \
	    5   6
	
	Input: root = [1,null,3,2,4,null,5,6]
	Output: [1,3,5,6,2,4]
	
	Example 2:
	
			     1
	     /  /    |   \  
	    2	3    4    5
	       / \   |   / \
	      6   7  8  9  10
	          |  |  |
	          11 12 13
	          |  
	          14 
	
	Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
	Output: [1,2,3,6,7,11,14,4,8,12,5,9,13,10]
	
	Constraints:
	
	The height of the n-ary tree is less than or equal to 1000
	The total number of nodes is between [0, 10^4]
	
 * */

public class preorder {
	// Definition for a Node.
	class Node {
	    public int val;
	    public List<Node> children;

	    public Node() {}

	    public Node(int _val) {
	        val = _val;
	    }

	    public Node(int _val, List<Node> _children) {
	        val = _val;
	        children = _children;
	    }
	};
	
    public List<Integer> pre_order(Node root) {
        if (root == null) 
            return Collections.EMPTY_LIST;
        
        // the end of a list is the top of the stack
        List<Integer> result = new LinkedList<>();
        Deque<Node> deque = new LinkedList<>();
        
        deque.addFirst(root);  
        
        while (!deque.isEmpty())
        {
        	final Node processingNode = deque.pollFirst();
        	result.add(processingNode.val);
        	
        	final List<Node> children = processingNode.children;
        	if (children != null && children.size() != 0)
        	{
        		for (int i = children.size() - 1; i >= 0; i--)
        			deque.addFirst(children.get(i));
        	}
        }
        
        return result;
    }
}
