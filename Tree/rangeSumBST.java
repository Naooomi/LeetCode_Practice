package Tree;

import java.util.Stack;

/**
	938. Range Sum of BST

	Description:
	Given the root node of a binary search tree, return the sum of values of all nodes with value between L and R (inclusive).
	The binary search tree is guaranteed to have unique values.
	
	Example 1:
	Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
	Output: 32
	
	Example 2:
	Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
	Output: 23
	 
	Note:
	The number of nodes in the tree is at most 10000.
	The final answer is guaranteed to be less than 2^31.
	
 * */
class rangeSumBST {
	/**
	 * Definition for a binary tree node.
	 */
	public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
	
	// Recursive Implementation
	int ans;
	
    public int rangeSum_BST(TreeNode root, int L, int R) {
        ans = 0;
    	dfs(root, L, R);
    	return ans;
    }
    
    public void dfs(TreeNode node, int L, int R)
    {
    	if (node != null)
    	{
    		if (L <= node.val && R >= node.val)
    			ans += node.val;
    		if (L < node.val)
    			dfs(node.left, L, R);
    		if (R > node.val)
    			dfs(node.right, L, R);
    	}
    }
    
    // Iterative Implementation
    public int rangeSum_BST2(TreeNode root, int L, int R)
    {
    	int ans2 = 0;
    	Stack<TreeNode> stack = new Stack();
    	stack.push(root);
    	
    	while(!stack.isEmpty())
    	{
    		TreeNode node = stack.pop();
    		if (node != null)
    		{
    			if (L <= node.val && node.val <= R)
    				ans2 += node.val;
    			if (L < node.val)
    				stack.push(node.left);
    			if (R > node.val)
    				stack.push(node.right);
    		}
    	}
    	
    	return ans2;
    }
}