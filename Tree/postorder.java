package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import Tree.preorder.Node;

/**
	590. N-ary Tree Postorder Traversal
	
	Description:

	Given an n-ary tree, return the postorder traversal of its nodes' values.
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
	Output: [5,6,3,2,4,1]
	
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
	Output: [2,6,14,11,7,3,12,8,4,13,9,10,5,1]
	
	Constraints:
	
	The height of the n-ary tree is less than or equal to 1000
	The total number of nodes is between [0, 10^4]
	
 * */

public class postorder {
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
	
    public List<Integer> post_order(Node root) {
    	List<Integer> result = new ArrayList<>();
    	Deque<Node> stack = new ArrayDeque<>();
    	
    	if (root == null)
    		return result;
    	
    	stack.offerFirst(root);
    	Node prev = null;
    	
    	while (!stack.isEmpty())
    	{
    		Node cur = stack.peekFirst();
    		// check if it is time to visit the stack's top
    		// only when it's children are all visited, or it has no children
    		if (cur.children.size() == 0 || prev == cur.children.get(cur.children.size() - 1))
    		{
    			// visit the stack's top element and update prev pointer
    			cur = stack.pollFirst();
    			result.add(cur.val);
    			prev = cur;
    		}
    		else
    		{
    			// put all the children of cur into stack
    			for (int i = cur.children.size() - 1; i >= 0; i--)
    				stack.offerFirst(cur.children.get(i));
    		}
    	}
    	
    	return result;
    }
}
