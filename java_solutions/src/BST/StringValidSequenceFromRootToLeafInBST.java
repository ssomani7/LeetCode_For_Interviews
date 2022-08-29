package BST;

import java.util.LinkedList;
import java.util.Queue;

/*
 * In Worst Case, each depth a number in arr corresponds to 2 options of TreeNodes.
 * Time Complexity = O(min(2 ^ m, n)), "m" = arr.length and "n" is total number of the nodes in binary tree.
 * Space Complexity = O(n), "n" is total number of the nodes in binary tree.
 */

/*
 * Given a binary tree where each path going from the root to any leaf form a valid sequence, check if a given
 * string is a valid sequence in such binary tree. 
 * We get the given string from the concatenation of an array of integers arr and the concatenation of all 
 * values of the nodes along a path results in a sequence in the given binary tree.
 * 
 * Example 1:
 * Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,1,0,1]
 *                          0
 *                         / \
 *                       1     0
 *                      / \   /
 *                     0   1  0
 *                      \  /\
 *                      1 0  0
 * Output: true
 * Explanation: 
 * The path 0 -> 1 -> 0 -> 1 is a valid sequence (green color in the figure). 
 * 
 * Example 2:
 * Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,0,1]
 *                          0
 *                         / \
 *                       1     0
 *                      / \   /
 *                     0   1  0
 *                      \  /\
 *                      1 0  0
 * Output: false 
 * Explanation: The path 0 -> 0 -> 1 does not exist, therefore it is not even a sequence.
 * 
 * Example 3:
 * Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,1,1]
 *                          0
 *                         / \
 *                       1     0
 *                      / \   /
 *                     0   1  0
 *                      \  /\
 *                      1 0  0
 * Output: false
 * Explanation: The path 0 -> 1 -> 1 is a sequence, but it is not a valid sequence.
 * 
 * Constraints:
 * 1 <= arr.length <= 5000
 * 0 <= arr[i] <= 9
 * Each node's value is between [0 - 9].
 */

public class StringValidSequenceFromRootToLeafInBST {
	public boolean isValidSequence(TreeNode root, int[] arr) {
		//Using BFS
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		
		/*
		 * We will use an index to iterate over the array and insert only the nodes into the queue which
		 * will match the array index values.
		 * Note that there can be multiple valid paths in the tree. So if the current node matches the array
		 * value, we check for its both children for the next array value and go down in same fashion.
		 * 
		 * Whenever the depth reaches the array length and the current node's left and right children are also
		 * null, that marks our success condition.
		 */
		
		for(int depth = 0; !queue.isEmpty() && depth < arr.length; depth++) {
			//Traversing level wise number of nodes
			for(int qSize = queue.size(); qSize > 0; qSize--) {
				TreeNode currentNode = queue.poll();
				//check if current node is not null & the array element matches the current node value
				if(currentNode != null && currentNode.val == arr[depth]) {
					//check if depth is equal to array length and the current node's left and right child are
					//null. If so, we have our success condition
					if(depth + 1 == arr.length && currentNode.left == null && currentNode.right == null)
						return true;
					
					queue.add(currentNode.left);
					queue.add(currentNode.right);
				}
			}
		}
		
		return false;
	}
}
