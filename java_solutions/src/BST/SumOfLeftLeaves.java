package BST;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Time Complexity = O(N)
 * Space Complexity = O(N), worst case when the tree is skewed on left side.
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
 * There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
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

public class SumOfLeftLeaves {
	
	//BFS Approach
    public static int sumOfLeftLeaves(TreeNode root) {
        //edge case
        if(root == null || (root.left == null && root.right == null))
            return 0;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int sum = 0;
        
        while(!queue.isEmpty()){
            int qSize = queue.size();
            
            for(int i = 0; i < qSize; i++){
                TreeNode tnode = queue.poll();
                
                if(tnode.left != null){
                    if(tnode.left.left == null && tnode.left.right == null)
                        sum += tnode.left.val;
                    queue.offer(tnode.left);
                }
                
                if(tnode.right != null)
                    queue.offer(tnode.right);
            }
        }
        return sum;
    }
    
    //Recursion - Depth First Search Approach
    public static int sumOfLeftLeavesUsingDFS(TreeNode root) {
        return helper(root, false);
    }
    
    public static int helper(TreeNode root, boolean isLeft) {
        if (root == null) 
        	return 0;
        
        if (root.left == null && root.right == null && isLeft) {
            return root.val;
        }
        
        return helper(root.left, true) + helper(root.right, false);
    }
}
