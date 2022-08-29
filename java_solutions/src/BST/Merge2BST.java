package BST;

/*
 * Time complexity : O(m). A total of 'm' nodes need to be traversed. Here, 'm' represents the minimum number 
 * of nodes from the two given trees.
 * 
 * Space complexity : O(m). The depth of the recursion tree can go upto 'm' in the case of a skewed tree. In 
 * average case, depth will be O(logm).
 */

/*
 * Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two
 * trees are overlapped while the others are not.
 * 
 * You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node 
 * values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of 
 * new tree.
 * 
 * Example 1:
 * 
 * Input: 
 * 
 *     Tree 1                     Tree 2                  
 *        1                         2                             
 *       / \                       / \                            
 *      3   2                     1   3                        
 *     /                           \   \                      
 *    5                             4   7                  
 *    
 * Output: 
 * Merged tree
 * 
 *       3
 *      / \
 *     4   5
 *    / \   \ 
 *   5   4   7
 */

public class Merge2BST {

	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		//Using Recursion
		if(t1 == null && t2 == null)
			return null;
		
		//Root value sum. Code starts from here. 
		int newValue = (t1 == null ? 0 : t1.val) + (t2 == null ? 0 : t2.val);
		//Create New Root
		TreeNode newNode = new TreeNode(newValue);
		
		//recurse for left and then for right
		newNode.left = mergeTrees(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
		newNode.right = mergeTrees(t1 == null ? null : t1.right, t2 == null ? null : t2.right);
		
		return newNode;
	}
}
