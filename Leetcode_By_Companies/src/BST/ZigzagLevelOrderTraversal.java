package BST;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * Time Complexity: O(N), where N is the number of nodes in the tree.
 * Space Complexity: O(N) where N is the number of nodes in the tree.
 */

/*
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right,
 * then right to left for the next level and alternate between).
 * 
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *            3
 *           / \
 *          9  20
 *            /  \
 *           15   7
 *           
 * return its zigzag level order traversal as:
 * [
 *  [3],
 *  [20,9],
 *  [15,7]
 * ]
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

public class ZigzagLevelOrderTraversal {
	
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        //edge case
        if(root == null)
            return result;
        
        //Level order traversal just flip the bits
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        //1 = left to right, -1 = right to left
        int flipDirection = 1;
        
        while(!queue.isEmpty()){
            int qSize = queue.size();
            List<Integer> levelList = new ArrayList<>();
            
            for(int i = 0; i < qSize; i++){
                TreeNode node = queue.poll();
                
                if(flipDirection == 1)
                    levelList.add(node.val);
                else
                    levelList.add(0, node.val); //reversing the list basically
                
                //We always add to the queue from left to right.
                //If direction is flipped, we just reverse the list.
                
                //Fancy way of doing the reversal is list.add(0, value)
                //This basically insert a new element at the start and pushes all the existing
                //elements one place to the right. This is basically what reversing the list is.
                if(node.left != null)
                    queue.offer(node.left);
                if(node.right != null)
                    queue.offer(node.right);
            }
            
            //add level to result
            result.add(levelList);
            //flip the direction
            flipDirection *= -1;
        }
        
        return result;
    }
}
