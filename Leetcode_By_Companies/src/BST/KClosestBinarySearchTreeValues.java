package BST;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * Time Complexity: If the tree is balanced, the time cost will be amortized O(k), worst case it could be O(N)
 * 
 * This solution is much more optimal as it takes advantage of the input being a BST, especially if it is 
 * balanced or closer to being balanced! pushSmaller() and pushLarger() only store nodes surrounding the 
 * target. Also, they takes advantage of the BST by finding the surrounding nodes in log n time (for balanced 
 * trees). It's also nice that while trying to find k closest nodes, it only adds more nodes by 
 * makingpushSmaller() and pushLarger() calls again to check if needed.
 * 
 * If we actually follow the traversal of the nodes through this algorithm, the pushSmaller() and pushLarger()
 * never visits the same nodes again. In fact, it seems to continue off where it last left off after adding 
 * to the stacks and returning from them. Hence, technically at a birds eye view, the total number of work 
 * pushSmaller() and pushLarger() ever does is log n / h for balanced trees.
 * 
 * Space Complexity: Tree is Balanced then O(logN), but if the tree is not balanced, the worst space cost 
 * will be O(N)
 */

/*
 * Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the 
 * target.
 * 
 * Note:
 * Given target value is a floating point.
 * You may assume k is always valid, that is: k ≤ total nodes.
 * You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
 * 
 * Example:
 * Input: root = [4,2,5,1,3], target = 3.714286, and k = 2
 * 
 *          4
 *         / \
 *        2   5
 *       / \
 *      1   3
 *      
 * Output: [4,3]
 * 
 * Follow up:
 * Assume that the BST is balanced, could you solve it in less than O(n) runtime (where n = total nodes)?
 */

/*
 * Approach:
 * The idea of using two stacks as two iterators (smaller and larger), the smaller stack will pop the next 
 * available largest element that is smaller then target, and larger stack will pop the next available 
 * smallest element that is larger or equal to the target. Those two stacks will not need to store all the 
 * nodes, but only number of nodes proportional to the height of the tree.
 */

//  Definition for a binary tree node.
// class TreeNode {
//      int val;
//      TreeNode left;
//      TreeNode right;
//      TreeNode() {}
//      TreeNode(int val) { this.val = val; }
//      TreeNode(int val, TreeNode left, TreeNode right) {
//          this.val = val;
//          this.left = left;
//          this.right = right;
//      }
//  }

public class KClosestBinarySearchTreeValues {
	
	public List<Integer> closestKValues(TreeNode root, double target, int k) {
		Stack<TreeNode> smallerStack = new Stack<>();
		Stack<TreeNode> largerStack = new Stack<>();
		
		pushSmaller(root, target, smallerStack);
		pushLarger(root, target, largerStack);
		
		TreeNode curr = null;
		List<Integer> resultList = new ArrayList<>();
		
		while(resultList.size() < k) {
			if(smallerStack.isEmpty() || !largerStack.isEmpty() && largerStack.peek().val - target < 
					                                               target - smallerStack.peek().val) {
				curr = largerStack.pop(); //choose the non empty stack;
				resultList.add(curr.val);
				pushLarger(root.right, target, largerStack); //call the stack method from whom you popped
			} else {
				curr = smallerStack.pop();
				resultList.add(curr.val);
				pushSmaller(root.left, target, smallerStack);
			}
		}
		
		return resultList;
	}
	
	public void pushSmaller(TreeNode tnode, double target, Stack<TreeNode> smallerStack) {
		while(tnode != null) {
			if(tnode.val < target) {
				smallerStack.push(tnode);
				tnode = tnode.right; //we go in opposite direction so that we remain close to the target node as possible
			} else
				tnode = tnode.left;
		}
	}
	
	public void pushLarger(TreeNode tnode, double target, Stack<TreeNode> LargerStack) {
		while(tnode != null) {
			if(tnode.val >= target) {
				LargerStack.push(tnode);
				tnode = tnode.left; //we go in opposite direction so that we remain close to the target node as possible
			} else
				tnode = tnode.right;
		}
	}
	
}
