package BST;

import java.util.Stack;

/*
 * Time complexity : O(N) in the worst case when the tree is BST or the "bad" element is a rightmost leaf.
 * Space complexity : O(N) to keep stack.
 */

/*
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * Assume a BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * 
 * Example 1:
 * 
 *          2
 *         / \
 *        1   3
 *        
 * Input: [2,1,3]
 * Output: true
 * 
 * Example 2:
 * 
 *            5
 *           / \
 *          1   4
 *             / \
 *            3   6
 *            
 * Input: [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 */

public class ValidateBST {
	
    public boolean inorderTraversalUsingSortedArrayPropertyforBST(TreeNode root) {
        
        //edge case
        if(root == null)
            return true;
        
        Stack<TreeNode> stack = new Stack<>();
        double minimum = - Double.MAX_VALUE;
        
        while(!stack.isEmpty() || root != null){
            //fill the stack with left most values
            while(root != null){
                stack.push(root); //Only 1 right node will be pushed then all the left starts pushing
                root = root.left;
            }
            
            root = stack.pop();
            
            if(root.val <= minimum)
                return false;
            
            minimum = root.val;
            root = root.right;
        }
        return true;
    }
	
	public boolean usingInorderTraversal(TreeNode root) {
		/*
		 * Inorder = left, root, right.
		 * For a BST, all the elements to the left of the root should be smaller than the root and all the
		 * elements to the right should be greater than the root.
		 * 
		 * If we look from the left side perspective, root is to the right of it, and hence root is always
		 * greater than the left.
		 * Similarly, the right node is on the right hand side of root, so it is always greater.
		 * 
		 * pre = null then root = left
		 * pre = left, then root = root
		 * pre = root, then root = right
		 * So the universal condition of inorder check will be that Pre should be not NULL &&
		 * the value of Pre should not be >= root
		 * 
		 * With Inorder traversal, we will push root and then we will push left node on stack. So only
		 * when the left and root gets processed, the right child is pushed on stack, because the processing
		 * of the right child for that subtree marks the end of that subtree, hence we will have only 1
		 * right child at any point in the stack.
		 */
		
		//edge case
		if(root == null)
			return true;
		
		Stack<TreeNode> stack = new Stack<>();
	    TreeNode preNode = null;
		
	    while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            
            root = stack.pop();
            
            //Invalid BST condition
            if(preNode != null && preNode.val >= root.val)
                return false;
            
            preNode = root;
            root = root.right;
        } 
	     
		return true;
	}
	
	public boolean validationUsingRecursion(TreeNode root) {
		return helper(root, null, null);
	}
	
     public boolean helper(TreeNode root, Integer max, Integer min){
         if(root == null)
             return true;
         else if (max != null && root.val >= max || min != null && root.val <= min)
             return false;
         else 
             return helper(root.left, root.val, min) && helper(root.right, max, root.val);
     }
}
