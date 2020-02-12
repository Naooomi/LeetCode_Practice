package Tree;

import java.util.ArrayList;
import java.util.List;

/**
	872. Leaf-Similar Trees
	
	Description:
	Consider all the leaves of a binary tree.  
	From left to right order, the values of those leaves form a leaf value sequence.
	
		    3
	      /   \
	    5      1
	   / \    / \
	  6   2  9   8
	     / \
	    7   4
	
	For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
	
	Two binary trees are considered leaf-similar if their leaf value sequence is the same.
	
	Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
	
	Note:
	
	Both of the given trees will have between 1 and 100 nodes.
	
 * */

/**
	Approach : Depth First Search
	
	Algorithm :
	
	Find the leaf value sequence for both given trees. 
	Afterwards, we can compare them to see if they are equal or not
	
	To find the leaf value sequence of a tree, use a dfs. 
	dfs function writes the node's value if it is a leaf, and then recursively explores each child. 
	This is guaranteed to visit each leaf in left-to-right order, as left-children are fully explored before right children.
	
	Complexity Analysis :
	Time Complexity : O(T1 + T2), where T1, T2 are lengths of the given trees.
	
	Space Complexity : O(T1+T2), space used in storing the leaf values.
	
 * */

public class leafSimilar {
	//Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
    public boolean leaf_Similar(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) return false;
    	
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        
        dfs(root1, list1);
        dfs(root2, list2);
        
    	return list1.equals(list2);
    }
    
    private void dfs(TreeNode node, List<Integer> list)
    {
    	if (node != null)
    	{
    		if (node.left == null && node.right == null)
    			list.add(node.val);
    		dfs(node.left, list);
    		dfs(node.right, list);
    	}
    }
	
}
