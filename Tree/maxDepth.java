package Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
	559. Maximum Depth of N-ary Tree
	
	Description:
	Given a n-ary tree, find its maximum depth.
	The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
	Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).
	
	Example 1:
	
		  	   1
		    /  |  \
		   3   2   4
		  / \    
		 5   6   
	
	Input: root = [1,null,3,2,4,null,5,6]
	Output: 3
	
	Example 2:
	
			       1 
		    /   /     \    \
		   2    3      4    5
		       / \     |    / \
		      6   7    8   9  10
		          |    |   |
		          11   12  13
		          |
		          14   
	
	Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
	Output: 5
	
	Constraints:
	
	The depth of the n-ary tree is less than or equal to 1000.
	The total number of nodes is between [0, 10^4].
	
 * */
public class maxDepth {
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
	
	public int max_Depth(Node root)
	{
		// DFS Solution
		if (root == null)
			return 0;
		
		// if the root is not null and has no child, the height should be 1
		if (root.children.size() == 0) return 1;
		
		int max = Integer.MIN_VALUE;
		
		for (Node node : root.children)
		{
			// track the height
			// getMaxHeight(node) + 1 will calculate the depth recursively
			max = Math.max(max, max_Depth(node) + 1);
		}
		
		return max;
	}
	
	public int max_Depth2(Node root)
	{
		// BFS Solution
		if (root == null) return 0;
		
		Queue<Node> queue = new LinkedList<>();
		
		queue.add(root);
		int level = 0;
		
		while (!queue.isEmpty())
		{
			int size = queue.size();
			for (int i = 0; i < size; i++) 
			{
				Node head = queue.poll();
				if (head.children.size() != 0)
				{
					for (Node child : head.children)
						queue.add(child);
				}
			}
			level++;
		}
		
		return level;
	}
}
