package BST;

/*
 * Time Complexity: O(N), where NN is the total number of nodes in the given tree. We visit each node at most 
 * once.
 * Space Complexity: O(N). Even though we don't explicitly use any additional memory, the call stack of our 
 * recursion could be as large as the number of nodes in the worst case.
 */

/*
 * Given a binary search tree and the lowest and highest boundaries as L and R, trim the tree so that all its 
 * elements lies in [L, R] (R >= L). You might need to change the root of the tree, so the result should 
 * return the new root of the trimmed binary search tree.
 * 
 * Example 1:
 * Input: 
 * 
 *          1
 *         / \
 *        0   2
 *        
 * L = 1
 * R = 2
 * 
 * Output: 
 *         1
 *          \
 *           2
 *           
 * Example 2:
 * Input: 
 * 
 *           3
 *          / \
 *         0   4
 *          \
 *           2
 *          /
 *         1
 *         
 * L = 1
 * R = 3
 * 
 * Output:
 *          3 
 *         / 
 *        2   
 *       /
 *      1
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

public class TrimBST {

	public TreeNode trimBST(TreeNode root, int L, int R) {
		if(root == null)
			return null;
		
		//Only consider nodes to the right
		if(root.val < L)
			return trimBST(root.right, L, R);
		
		//only consider nodes to the left
		if(root.val > R)
			return trimBST(root.left, L, R);
		
		//Root value is in range of L annd R. Consider both left and right nodes.
		root.left = trimBST(root.left, L, R);
		root.right = trimBST(root.right, L, R);
		
		return root;
	}
	
}
