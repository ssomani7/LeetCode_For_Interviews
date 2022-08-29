package BST;

import java.util.Stack;

/*
 * Time complexity : O(N). We visit each node exactly once, thus the time complexity is O(N), where 'N; is the 
 * number of nodes.
 * Space complexity : in the worst case, the tree is completely unbalanced, e.g. each node has only left child 
 * node, the recursion call would occur 'N' times (the height of the tree), therefore the storage to keep the 
 * call stack would be O(N). 
 * But in the best case (the tree is completely balanced), the height of the tree would be log(N). Therefore, the
 * space complexity in this case would be O(log(N)).
 */

/*
 * Given a binary tree, find its maximum depth. The maximum depth is the number of nodes along the longest path 
 * from the root node down to the farthest leaf node.
 * Note: A leaf is a node with no children.
 * Example:
 * Given binary tree [3,9,20,null,null,15,7],
 *               3
 *              / \
 *             9  20
 *                /\
 *              15  7
 * return its depth = 3.
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

public class MaxDepth {
	//prefer this
	public static int maxDepthByRecursion(TreeNode root) {
		//edge case and recursion end condition
		if(root == null)
			return 0;
		
		int left = maxDepthByRecursion(root.left);
		int right = maxDepthByRecursion(root.right);
		
		return Math.max(left, right) + 1;
	}
	
	public static int maxDepthByIteration(TreeNode root) {
		//edge case
		if(root == null)
			return 0;
		
		Stack<TreeNode> nodeStack = new Stack<>();
		Stack<Integer> depthStack = new Stack<>();
		
		//root is depth 1. add to both stacks
		nodeStack.push(root);
		depthStack.push(1);
		
		int maxDepth = 0;
		int currentDepth = 0;
		
		while(!nodeStack.isEmpty()) {
			TreeNode node = nodeStack.pop();
			currentDepth = depthStack.pop();
			
			if(node != null) {
				maxDepth = Math.max(maxDepth, currentDepth);
				//add children to node stack
				nodeStack.push(root.left);
				nodeStack.push(root.right);
				//currentDepth is for root, root.left and root.right are its children, depth put will be 
				//currentDepth + 1. Twice, one for left and other for right child
				depthStack.push(currentDepth + 1);
				depthStack.push(currentDepth + 1);
			}
		}
		return maxDepth;
	}
}
