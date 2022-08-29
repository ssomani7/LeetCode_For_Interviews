package BST;

import java.util.Queue;
import java.util.LinkedList;

//Also known as "Mirror Binary Tree"
//Use BFS and node swapping.

/*
 * Time Complexity = O(n), Since each node in the tree is visited/added to the queue only once, the time 
 * complexity is O(n), where 'n' is the number of nodes in the tree.
 * 
 * Space complexity = O(n), since in the worst case, the queue will contain all nodes in one level of the 
 * binary tree. For a full binary tree, the leaf level has ceil (n / 2) = O(n) leaves.
 */

/*
 * Invert a binary tree or Mirror a binary tree
 * 
 * Example:
 * Input:
 *        4
 *      /   \
 *     2     7
 *    / \   / \
 *   1   3 6   9
 *   
 *   Output:
 *         4
 *        /  \
 *      7     2
 *     / \   / \
 *    9   6 3   1
 */

public class InvertBinaryTree {
	
	//prefer this method
	public TreeNode mirrorBinaryTree(TreeNode root) {
		//edge case
		if(root == null)
			return null;
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		
		while(!queue.isEmpty()) {
			TreeNode currentNode = queue.poll();
			
			//Normal swapping of nodes just like any other integer values
			TreeNode temp = currentNode.left;
			currentNode.left = currentNode.right;
			currentNode.right = temp;
			
			//now the nodes are reversed. Add their non-null child in the queue and repeat the process.
			if(currentNode.left != null)
				queue.offer(currentNode.left);
			if(currentNode.right != null)
				queue.offer(currentNode.right);
		}
		return root;
	}
	
	public TreeNode mirrorUsingRecursion(TreeNode root) {
		//recursion end condition
		if(root == null)
			return null;
		
		TreeNode originalLeftChild = root.left;
		TreeNode originalRightChild = root.right;
		
		//interchange left and right. With recursion we are changing the node pointers for left and right child
		root.left = mirrorUsingRecursion(originalRightChild);
		root.right = mirrorUsingRecursion(originalLeftChild);
		
		return root;
	}
}
