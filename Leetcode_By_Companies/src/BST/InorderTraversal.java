package BST;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/* Inorder = left, root, right
 * 
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * Example:
 * Input: [1,2,3,4,5,null,6]
 *          1
 *         / \
 *        2   3
 *       / \   \
 *      4   5   6
 * Output: [4,2,5,1,6,3]
 */

/*
 * Time complexity : O(n). Because the recursive function is T(n) = 2 . T(n/2) + 1
 * Space complexity : The worst case space required is O(n), and in the average case it's O(logn) where n is 
 * number of nodes.
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class InorderTraversal {
	public List<Integer> usingStack(TreeNode root) {
		List<Integer> resultList = new ArrayList<>();
		
		//edge case
		if(root == null)
			return resultList;
		
		Stack<TreeNode> stack = new Stack<>();
		TreeNode currentRoot = root;
		
		while(currentRoot != null || !stack.isEmpty()) {
			//move root to the left most child and put it on stack.
			while(currentRoot != null) {
				stack.push(currentRoot);
				currentRoot = currentRoot.left;
			}
			//once the currentRoot hits null while going down the left hand side, you add its parent node to the
			//list. Even the left most leaf node will have a left and right child, i.e, null.
			//So in this manner the stack will always have the left nodes on top and not the right nodes.
			//Since we are at 'null', we need to go back to the parent node and that we will get from the stack top
			currentRoot = stack.pop();
			resultList.add(currentRoot.val);
			//now traverse for the right hand side.
			currentRoot = currentRoot.right;
			//when we come across a 'null' root, our while checks stops adding these null on to the stack and 
			//instead pops the value on the current stack and shift the currentRoot appropirately.
		}
		
		return resultList;
    }
	
	public List<Integer> usingRecursion(TreeNode root) {
		List<Integer> resultList = new ArrayList<>();
		
		//edge case
		if(root == null)
			return resultList;
		
		return resultList;
	}
	
	public void helper(TreeNode root, List<Integer> resultList) {
		if(root != null) {
			//recurse for the left most side. Stop when you encounter null. When at null, call the parent and add
			//it to the list. Then recurse for the right most side. The recursion call will simulate the left, 
			//root and right.
			if(root.left != null)
				helper(root.left, resultList);
			
			//add to result list
			resultList.add(root.val);
			
			if(root.right != null)
				helper(root.right, resultList);
		}
	}
}
