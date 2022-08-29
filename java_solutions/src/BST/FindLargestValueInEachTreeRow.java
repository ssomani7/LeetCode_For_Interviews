package BST;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * Time Complexity = O(N), N being the number of nodes in the tree
 * Space Complexity = Worst Case O(N), where each level has only one element, making it the largest for that
 * row.
 */

/*
 * You need to find the largest value in each row of a binary tree.
 * Example:
 * Input: 
 *           1
 *          / \
 *         3   2
 *        / \   \  
 *       5   3   9 
 *       
 * Output: [1, 3, 9]
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

public class FindLargestValueInEachTreeRow {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        //edge case
        if(root == null)
            return result;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while(!queue.isEmpty()){
            int qSize = queue.size();
            double maxNum = - Double.MAX_VALUE; //smallest numeric value possible in integer range.
            
            for(int i = 0; i < qSize; i++){
                TreeNode node = queue.poll();
                maxNum = Math.max(maxNum, node.val);
                
                if(node.left != null)
                    queue.offer(node.left);
                
                if(node.right != null)
                    queue.offer(node.right);
            }
            
            result.add((int)maxNum);
        }
        return result;
    }
}
