package Tree;

/**

	104. Maximum Depth of Binary Tree
	
	Description
	Given a binary tree, find its maximum depth.
	The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
	
	Note: A leaf is a node with no children.
	
	Example:
	
	Given binary tree [3,9,20,null,null,15,7],
	
	    3
	   / \
	  9  20
	    /  \
	   15   7
	
	return its depth = 3.

 * */

public class maxDepth2 {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
    public int max_Depth2(TreeNode root) {
        if (root == null) return 0;
        
        // recursive call for right subtree to state its maximum depth possible
        int rightans = max_Depth2(root.right);
        // recursive call for left subtree to state its maximum depth possible
        int leftans = max_Depth2(root.left);
        
        // return the maximum of right and left subtree
        // add one for the current node contribution to depth(Very important step)
        return Math.max(rightans, leftans) + 1;
    }
}
