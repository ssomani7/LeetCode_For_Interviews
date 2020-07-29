package BST;

/*
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree
 * is the length of the longest path between any two nodes in a tree. This path may or may not pass through the
 * root.
 * Example:
 * Given a binary tree
 *           1
 *          / \
 *         2   3
 *        / \     
 *       4   5    
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 * Note: The length of path between two nodes is represented by the number of edges between them.
 */

/*
 * Time Complexity: O(N). We visit every node once.
 * Space Complexity: O(N), the size of our implicit call stack during our depth-first search.
 */


public class DiameterOfBinaryTree {

	static int max_edges_passing_through_node = 0;

	public static int getDiameterOfBinaryTree(TreeNode root) {
		//edge case
		if(root == null)
			return 0;
		
		helper(root);
		return max_edges_passing_through_node;
	}
	
	public static int helper(TreeNode root) {
		//recursion end condition
		if(root == null)
			return 0;
		
		int length_of_left_subTree = helper(root.left);
		int length_of_right_subTree = helper(root.right);
		
		max_edges_passing_through_node = Math.max(max_edges_passing_through_node, length_of_left_subTree +
				                                                                  length_of_right_subTree);
		
		return Math.max(length_of_left_subTree, length_of_right_subTree) + 1;
		//'+ 1' because we take into consideration the parent node also.
	}
}
