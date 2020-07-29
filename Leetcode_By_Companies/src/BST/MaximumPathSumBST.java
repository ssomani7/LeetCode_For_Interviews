package BST;

/*
 * Time Complexity = O(N), we visit each node once, even though we do 3 variable processing at each node,
 * visiting node is only once, so O(n)
 * Space Complexity = O(log N), for recursion stack.
 */

/*
 * Approach: 3 cases to be checked for each node
 * Case 1 : Maximum Path Sum contains root and goes beyond it.
 * Case 1 = Math.max(Math.max(left, right) + currentRoot.value, currentRoot.value);
 * 
 * Case 2 : Maximum Path Sum's root is the currentRoot
 * Case 2 = Math.max(Case 1, left + right + currentRoot.value)
 * 
 * Case 3 = CurrentRoot has no involvement in the maximum path sum
 * Case 3 = Math.max(Case 2, result), where result is initialized with the lowest possible value of Integer.
 * MIN_VALUE in the beginning.
 * 
 * This sequential comparisons, compares the max out of 3 conditions for the currentRoot and sets the result.
 */

/*
 * Given a non-empty binary tree, find the maximum path sum. For this problem, a path is defined as any 
 * sequence of nodes from some starting node to any node in the tree along the parent-child connections. The 
 * path must contain at least one node and does not need to go through the root.
 * 
 * Example 1:
 * Input: [1,2,3]
 * 
 *     1
 *    / \
 *   2   3
 *   
 * Output: 6
 * 
 * Example 2:
 * Input: [-10,9,20,null,null,15,7]
 * 
 *       -10
 *        / \
 *       9  20
 *          /  \
 *         15   7
 *         
 * Output: 42
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

public class MaximumPathSumBST {
	
	int maximumPathSum = Integer.MIN_VALUE; //this variable represents Case 3 and the overall comparision as 
	//well.
	
	public int getMaximumPathSumInBST(TreeNode root) {
		//edge case
		if(root == null)
			return 0;
		
		//helper method
		compute_three_cases_and_return_sum_where_path_goes_beyond_root(root);
		
		return maximumPathSum;
	}
	
	
	//We need to return the sum value when the path contains root and goes beyond it because in olny this
	//case will our recusion will be able to build from bottom-up. For Case 2 and Case 3, the recursion
	//beyond root is non-existent and will give us wrong answers.
	public int compute_three_cases_and_return_sum_where_path_goes_beyond_root(TreeNode root) {
		//recursive end condition
		if(root == null)
			return 0;
		
		int left = compute_three_cases_and_return_sum_where_path_goes_beyond_root(root.left);
		int right = compute_three_cases_and_return_sum_where_path_goes_beyond_root(root.right);
		
		//Case 1
		int sum_where_path_contains_root_and_goes_beyond = Math.max(Math.max(left, right) + root.val, 
																    root.val);
		//Case 2
		int sum_where_path_root_is_root = Math.max(sum_where_path_contains_root_and_goes_beyond, 
													left + right + root.val);
		//Case 3
		maximumPathSum = Math.max(sum_where_path_root_is_root, maximumPathSum);
		
		return sum_where_path_contains_root_and_goes_beyond;
	}
	
}
