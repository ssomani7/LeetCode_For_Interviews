	package BST;

/* Preorder Traversal = Root, left, right
 * Time Complexity = O(n)
 * Space Complexity = O(n)
 */

/*
 * Return the root node of a binary search tree that matches the given preorder traversal. (Recall that a binary 
 * search tree is a binary tree where for every node, any descendant of node.left has a value < node.val, and any
 * descendant of node.right has a value > node.val.  Also recall that a preorder traversal displays the value of 
 * the node first, then traverses node.left, then traverses node.right.)
 * 
 * It's guaranteed that for the given test cases there is always possible to find a binary search tree with the 
 * given requirements.
 * 
 * Example 1:
 * Input: [8,5,1,7,10,12]
 * Output: [8,5,10,1,7,null,12]
 * 
 *             8
 *           /   \
 *         5       10
 *       /   \    /   \
 *     1      7  null   12
 *    / \    / \         / \
 *null null null null null null
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class BSTFromPreorderTraversal {

	int index = 0;
	public TreeNode bstFromPreorder(int[] preorder) {
		//edge case
		if(preorder == null || preorder.length == 0)
			return null;
		return bst(preorder, Integer.MAX_VALUE);
	}
	
	public TreeNode bst(int[] preorder, int upperBound) {
		//recursion end case
		if(index == preorder.length || preorder[index] > upperBound)
			return null;
		//Root's left child will be always smaller than the root. So the upperBound for left child will be
		//Root's value itself.
		//Root's right child will be always greater than the root. So the upperBound for right child will be
		//the upperBound of its parent.
		//So if the element in the array is greater than its respective upperBound, we should return null.
		TreeNode root = new TreeNode(preorder[index]);
		index++;
		root.left = bst(preorder, root.val);
		root.right = bst(preorder, upperBound);
		
		return root;
	}
}
