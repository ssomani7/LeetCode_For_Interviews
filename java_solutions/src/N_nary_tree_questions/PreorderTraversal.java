package N_nary_tree_questions;

import java.util.ArrayList;

/*
 * Time Complexity = O(n)
 * Space Complexity = O(n), worst case is when 2 levels only, first level contains only the root, all other 
 * nodes is the children who is in 2nd level. The max elements in stack is n - 1:
 */

/*
 * Given an n-ary tree, return the preorder traversal of its nodes' values. Nary-Tree input serialization is 
 * represented in their level order traversal, each group of children is separated by the null value 
 * (See examples).
 * 
 * Example 1:
 * Input: root = [1,null,3,2,4,null,5,6]
 * 
 *                                1
 *                              / | \
 *                             3  2  4
 *                            / \
 *                           5   6
 *                           
 * Output: [1,3,5,6,2,4]
 * 
 * Example 2:
 * Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * 
 *                                 1
 *                              / /  \  \
 *                             2  3   4  5
 *                               / \  |  | \
 *                              6  7  8  9  10
 *                                 |  |  |
 *                                 11 12 13
 *                                 |
 *                                 14 
 *                                 
 * Output: [1,2,3,6,7,11,14,4,8,12,5,9,13,10]
 */

import java.util.List;
import java.util.Stack;

//Definition for a Node.
class Node {
 public int val;
	 public List<Node> children;
	
	 public Node() {}
	
	 public Node(int _val) {
	     val = _val;
	 }
	
	 public Node(int _val, List<Node> _children) {
	     val = _val;
	     children = _children;
	 }
}


public class PreorderTraversal {
	
	List<Integer> resultListForRecursion = new ArrayList<>();
	
	public List<Integer> preorderUsingRecursion(Node root){
		if(root == null)
			return resultListForRecursion;
		
		//add the root's value to the list
		resultListForRecursion.add(root.val);
		
		//Now loop over the children array and call recursion for each node
		for(Node node : root.children)
			preorderUsingRecursion(node);
		
		return resultListForRecursion;
	}
	
	public List<Integer> preorderUsingIteration(Node root){
		List<Integer> resultList = new ArrayList<>();
		Stack<Node> stack = new Stack<>();
		
		//edge case
		if(root == null)
			return resultList;
		
		//add root to the stack
		stack.push(root);
		
		//Preorder is root, left and right;
		//So if we push  all the children from right to left into stack, it will give us left child first
		//before right when popping.
		
		while(!stack.isEmpty()) {
			//get the top most element
			Node node = stack.pop();
			//add to the list
			resultList.add(node.val);
			
			//Now loop over the children array and starting pushing into stack from right to left
			for(int i = root.children.size() - 1; i >= 0; i--)
				stack.push(root.children.get(i));
		}
		
		return resultList;
	}
}
