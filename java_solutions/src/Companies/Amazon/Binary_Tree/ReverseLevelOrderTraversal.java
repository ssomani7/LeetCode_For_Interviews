package Companies.Amazon.Binary_Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * Time complexity: O(N) since each node is processed exactly once.
 * Space complexity: O(N) to keep the output structure which contains N node values.
 */

/*
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to 
 * right, level by level from leaf to root).
 * 
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *          3
 *         / \
 *        9  20
 *          /  \
 *         15   7
 *         
 * return its bottom-up level order traversal as:
 * [
 *  [15,7],
 *  [9,20],
 *  [3]
 * ]
 */


//  Definition for a binary tree node.
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }


public class ReverseLevelOrderTraversal {
	
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        
        //edge case
        if(root == null)
            return resultList;
        
        //BFS
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while(!queue.isEmpty()){
            int qSize = queue.size();
            List<Integer> levelList = new ArrayList<>();
            
            for(int i = 0; i < qSize; i++){
                TreeNode node = queue.poll();
                levelList.add(node.val);
                
                if(node.left != null)
                    queue.offer(node.left);
                if(node.right != null)
                    queue.offer(node.right);
            }
            
            resultList.add(0, levelList); //important step
        }
        return resultList;
    }
}
