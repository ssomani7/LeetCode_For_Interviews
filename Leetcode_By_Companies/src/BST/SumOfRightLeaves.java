package BST;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Time Complexity = O(N)
 * Space Complexity = O(N), worst case when the tree is skewed on right side.
 */

/*
 * Find the sum of all left leaves in a given binary tree.
 * 
 * Example:
 * 
 *     3
 *    / \
 *   9  20
 *      /  \
 *     15   7
 *     
 * There is one right leaf in the binary tree, with value 7. Return 7.
 */

public class SumOfRightLeaves {

    public static int sumOfLeftLeaves(TreeNode root) {
        if(root == null || (root.left == null && root.right == null))
            return 0;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int sum = 0;
        
        while(!queue.isEmpty()){
            TreeNode tnode = queue.poll();
            
            if(tnode.right != null){//check possible right leaf node
                if(tnode.right.left == null && tnode.right.right == null)//confirm leaf node on right child
                    sum += tnode.right.val;
                else
                    queue.offer(tnode.right); //not a right leaf
            }
            
            if(tnode.left != null)
                queue.offer(tnode.left);
        }
        
        return sum;
    }
    
    //Recursion - Depth First Search Approach
    public static int sumOfLeftLeavesUsingDFS(TreeNode root) {
        return helper(root, false);
    }
    
    public static int helper(TreeNode root, boolean isRight) {
        if (root == null) 
        	return 0;
        
        if (root.left == null && root.right == null && isRight) {
            return root.val;
        }
        
        return helper(root.left, false) + helper(root.right, true);
    }
}
