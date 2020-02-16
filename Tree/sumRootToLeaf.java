package Tree;

import java.util.Stack;

/**
	1022. Sum of Root To Leaf Binary Numbers
	
	Description
	Given a binary tree, each node has value 0 or 1.  
	Each root-to-leaf path represents a binary number starting with the most significant bit.  
	For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.
	For all leaves in the tree, consider the numbers represented by the path from the root to that leaf.
	Return the sum of these numbers.
	
	Example 1:
	
			   1
		     /   \
		    0     1
		   / \   / \    
		  0   1 0   1 
	
	Input: [1,0,1,0,1,0,1]
	Output: 22
	Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
	
	Note:
	
	The number of nodes in the tree is between 1 and 1000.
	node.val is 0 or 1.
	The answer will not exceed 2^31 - 1.
 
*/

public class sumRootToLeaf {
	//Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
    public int sum_RootToLeaf(TreeNode root) {
        if (root == null) return 0;
        
        int sum = 0;
        
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        Stack<Integer> prevSum = new Stack<Integer>();
    	nodeStack.push(root);
    	prevSum.push(root.val);
    	
    	while(!nodeStack.isEmpty())
    	{
    		TreeNode tempNode = nodeStack.pop();
    		Integer tempSum = prevSum.pop();
    		
    		if (tempNode.left == null && tempNode.right == null)
    			sum += tempSum;
    		
    		if (tempNode.left != null)
    		{
    			nodeStack.push(tempNode.left);
    			prevSum.push(tempSum*2 + tempNode.left.val);
    		}
    		
    		if (tempNode.right != null)
    		{
    			nodeStack.push(tempNode.right);
    			prevSum.push(tempSum*2 + tempNode.right.val);
    		}
    	}
    	
    	return sum;
    }
}
