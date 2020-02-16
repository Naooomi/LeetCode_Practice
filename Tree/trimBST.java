package Tree;

/**
	669. Trim a Binary Search Tree

	Description
	Given a binary search tree and the lowest and highest boundaries as L and R, trim the tree so that all its elements lies in [L, R] (R >= L). 
	You might need to change the root of the tree, so the result should return the new root of the trimmed binary search tree.
	
	Example 1:
	Input: 
	    1
	   / \
	  0   2
	
	  L = 1
	  R = 2
	
	Output: 
	    1
	      \
	       2
	
	Example 2:
	Input: 
	    3
	   / \
	  0   4
	   \
	    2
	   /
	  1
	
	  L = 1
	  R = 3
	
	Output: 
	      3
	     / 
	   2   
	  /
	 1
	 
 * */

public class trimBST {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	/**
	 * Approach #1 : Recursion
	 * 
	 *  Let trim(node) be the desired answer for the subtree at that node. We can construct the answer recursively
	 *  
	 *  Algorithm
	 *  
	 *  When node.val > R, we know that the trimmed binary tree must occur to the left of the node.
	 *  Similarly, when node.val < L, the trimmed binary tree occurs to the right node.
	 *  Otherwise, we will trim both sides of the tree.
	 * 
	 * */
	
    public TreeNode trim_BST(TreeNode root, int L, int R) {
        if (root == null) return root;
        if (root.val > R) return trim_BST(root.left, L, R);
        if (root.val < L) return trim_BST(root.right, L, R);
    	
        root.left = trim_BST(root.left, L, R);
        root.right = trim_BST(root.right, L, R);
    	
    	return root;
    }
}
