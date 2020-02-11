package Tree;

import java.util.ArrayList;
import java.util.List;

/**
	897. Increasing Order Search Tree
	
	Description:
	Given a binary search tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree, and every node has no left child and only 1 right child.
	
	Example 1:
	Input: [5,3,6,2,4,null,8,1,null,null,null,7,9]
	
	       5
	      / \
	    3    6
	   / \    \
	  2   4    8
	 /        / \ 
	1        7   9
	
	Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
	
	 1
	  \
	   2
	    \
	     3
	      \
	       4
	        \
	         5
	          \
	           6
	            \
	             7
	              \
	               8
	                \
	                 9  
	Note:
	
	The number of nodes in the given tree will be between 1 and 100.
	Each node will have a unique integer value from 0 to 1000.
	
 * */

public class increasingBST {
	/**
	 * Definition for a binary tree node.
	 */
	public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
	
	/**
		Approach 1 : In-Order Traversal
		
		The definition of a binary search tree is that for every node, all the values of the left branch are less than the value at the root, 
		and all the values of the right branch are greater than the value at the root.
		
		Because of this, an in-order traversal of the nodes will yield all the values in increasing order. 
		
		Algorithm:
		Once we have traversal all the nodes in increasing order, we can construct new nodes using those values to form the answer.
		
		Complexity Analysis:
		
		Time Complexity : O(N), where N is the number of the nodes in the given tree.
		
		Space Complexity : O(N), the size of the answer.
		
	 * */
    public TreeNode increasing_BST(TreeNode root) {
    	List<Integer> vals = new ArrayList<>();
    	// 1. using inorder() to traverse (DFS)
    	// vals will be sorted after inorder()
    	inorderDFS(root, vals);
    	
    	// 2. Traverse vals list to create the new tree
    	TreeNode ans = new TreeNode(0);
    	TreeNode cur = ans;
    	
    	for (int val : vals)
    	{
    		cur.right = new TreeNode(val);
    		cur = cur.right;
    	}
    	
    	return ans.right;
    }
    
    private void inorderDFS(TreeNode node, List<Integer> vals)
    {
    	// output of this method
    	if (node == null) return;
    	// inorder --> node.left -> node -> node.right
    	inorderDFS(node.left, vals);
    	vals.add(node.val);
    	inorderDFS(node.right, vals);
    }
	

//-----------------------------------------------------------------------------------------------------------------------------------------
    /**
		Approach 2 : Traversal with Relinking
		
		Algorithm :
		We can perform the same in-order traversal as in Approach 1. 
		During the traversal, we'll construct the answer on the fly, reusing the nodes of the given tree by cutting their child and adjoining them to the answer
		
		Complexity Analysis : 
		
		Time Complexity : 
		O(N), where N is the number of nodes in the given tree
		
		Space Complexity :
		O(H) in additional space complexity, where H is the height of the given tree, and the size of the implicit call stack in our in-order traversal
		
     * */
    TreeNode pointer = new TreeNode(0);
    public TreeNode increasing_BST2(TreeNode root) {
    	TreeNode ans = new TreeNode(0);
    	pointer = ans;
    	inorder2(root);
    	return ans.right;
    }
	
    private void inorder2(TreeNode node)
	{
		if (node == null) return;
		inorder2(node.left);
		node.left = null;
		pointer.right = node;
		pointer = node;
		inorder2(node.right);
	}
    
}
