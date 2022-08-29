package BST;

import java.util.Stack;

/*
 * Time Complexity: O(N), where N is the number of nodes in the tree.
 * Space Complexity: O(H), where H is the height of the tree. 
 */

/*
 * Given the root node of a binary search tree, return the sum of values of all nodes with value between L and 
 * R (inclusive).
 * 
 * The binary search tree is guaranteed to have unique values.
 * 
 * Example 1:
 * Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
 * Output: 32
 * 
 * Example 2:
 * Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
 * Output: 23
 */

public class RangeSumOfBST {

    public int rangeSumBST(TreeNode root, int L, int R) {
    	
    	//edge case
    	if(root == null)
    		return 0;
    	
        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            
            if (node != null) {
                if (node.val >= L && node.val <= R)
                    sum += node.val;
                
                if (node.val > L) //possible left candidate
                    stack.push(node.left);
                
                if (node.val < R) //possible right candidate
                    stack.push(node.right);
            }
        }
        return sum;
    }
    
    public int rangeSumBSTUsingRecursion(TreeNode root, int L, int R) {
    	// base case.
    	if (root == null) 
        	return 0; 
        
        if (root.val < L) 
        	return rangeSumBST(root.right, L, R); // left branch excluded.
        
        if (root.val > R) 
        	return rangeSumBST(root.left, L, R); // right branch excluded.
        
        // count in both children.
        return root.val + rangeSumBST(root.right, L, R) + rangeSumBST(root.left, L, R); 
    }
}
