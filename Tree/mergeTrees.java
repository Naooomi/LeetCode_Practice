package Tree;

import java.util.Stack;

/**
	617. Merge Two Binary Trees

	Description:
	Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.
	You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.
	
	Example 1:
	
	Input: 
		Tree 1                     Tree 2                  
	          1                         2                             
	         / \                       / \                            
	        3   2                     1   3                        
	       /                           \   \                      
	      5                             4   7                  
	
	Output: 
	Merged tree:
		     3
		    / \
		   4   5
		  / \   \ 
		 5   4   7
	 
	Note: The merging process must start from the root nodes of both trees.
	
 */

public class mergeTrees {
	//Definition for a binary tree node.
	public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}

/**
	Approach #1 Using Recursion 
	
	1. We can traverse both the given trees in a preorder fashion. 
		At every step, we check if the current node exists(isn't null) for both the trees. 
	2. If so, we add the values in the current nodes of both the trees and update the value in the current node of the first tree 
		to reflect this sum obtained. 
	3. At every step, we also call the original function mergeTrees() with the left children and then with the right children of the current nodes of the two trees. 
	4. If at any step, one of these children happens to be null, we return the child of the other tree(representing the corresponding child subtree) 
	to be added as a child subtree to the calling parent node in the first tree. At the end, the first tree will represent the required resultant merged binary tree.
	
	Complexity Analysis
	
	Time complexity: O(n). A total of n nodes need to be traversed. Here, n represents the minimum number of nodes from the two given trees.
	
	Space complexity: O(n). The depth of the recursion tree can go up to n in the case of a skewed tree. In average case, depth will be O(logn).
	
 * */
	public TreeNode merge_Trees(TreeNode t1, TreeNode t2) {
	    if (t1 == null)
	        return t2;
	    if (t2 == null)
	        return t1;
	    
	    t1.val += t2.val;
	    t1.left = merge_Trees(t1.left, t2.left);
	    t1.right = merge_Trees(t1.right, t2.right);
	    
	    return t1;
	}
	
	
/**
	Approach #2 Iterative Method
	
	In the current approach, we again traverse the two trees, but this time we make use of a stack to do so instead of making use of recursion. Each entry in the stack stores data 
	in the form [node_{tree1}, node_{tree2}][nodetree1,nodetree2]. 
	Here, nodetree1 and nodetree2 are the nodes of the first tree and the second tree respectively.
	
	1. We start off by pushing the root nodes of both the trees onto the stack. 
	2. Then, at every step, we remove a node pair from the top of the stack. 
	3. For every node pair removed, we add the values corresponding to the two nodes and update the value of the corresponding node in the first tree. 
	4. Then, if the left child of the first tree exists, we push the left child(pair) of both the trees onto the stack. If the left child of the first tree doesn't exist, we append the left child(subtree) of the second tree to the current node of the first tree. 
	5. We do the same for the right child pair as well.
	6. If, at any step, both the current nodes are null, we continue with popping the next nodes from the stack.

	Complexity Analysis:
	
	Time Complexity: O(n). We traverse over a total of n nodes. Here, n refers to the smaller of the number of nodes in the two trees
	
	Space Complexity: O(n). The depth of stack can grow up to n in case of a skewed tree.
	
 * */	
    public TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;
        
        Stack<TreeNode[]> stack = new Stack<>();
        stack.push(new TreeNode[] {t1, t2});
        
        while(!stack.isEmpty())
        {
            TreeNode[] t = stack.pop();
            if (t[0] == null || t[1] == null)
                continue;
            
            t[0].val += t[1].val;
            if (t[0].left == null)
                t[0].left = t[1].left;
            else
                stack.push(new TreeNode[] { t[0].left, t[1].left });
            
            if (t[0].right == null)
                t[0].right = t[1].right;
            else
                stack.push(new TreeNode[] { t[0].right, t[1].right });
        }
        
        return t1;
    }
}


