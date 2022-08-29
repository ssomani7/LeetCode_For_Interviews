package BST;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Time complexity : O(N), In the worst case for a balanced tree we need to visit all nodes level by level up to the 
 * tree height, that excludes the bottom level only. This way we visit N/2 nodes, and thus the time complexity 
 * is O(N).
 * Space complexity : O(N), Is the same as time complexity here O(N).
 */

/*
 * Given a binary tree, find its minimum depth. The minimum depth is the number of nodes along the shortest path
 * from the root node down to the nearest leaf node.
 * Note: A leaf is a node with no children.
 * Example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 
 *             3
 *            / \
 *           9  20
 *         /  \
 *        15   7
 * return its minimum depth = 2.
 */

public class MinimumDepth {

	 public int minDepth(TreeNode root) {
	        //edge case
	        if(root == null)
	            return 0;
	        
	        //Using BFS, level traversal. Any node that doesn't have left and right children, is our
	        //stopping point.
	        //BFS is beneficial over DFS here as it saves us against one sided tree worst case
	        //sitaution.
	        int level = 1; //root level is 1.
	        Queue<TreeNode> queue = new LinkedList<>();
	        //add root
	        queue.add(root);
	        
	        while(!queue.isEmpty()){
	            int nodesPerLevel = queue.size();
	            
	            for(int i = 0; i < nodesPerLevel; i++){
	                TreeNode node = queue.poll();
	                
	                if(node.left == null && node.right == null)
	                    return level;
	                
	                if(node.left != null)
	                    queue.add(node.left);
	                
	                if(node.right != null)
	                    queue.add(node.right);
	            }
	            level++;
	        }
	        return level;
	    }
}
