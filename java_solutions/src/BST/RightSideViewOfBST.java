package BST;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Note: Run the method on LeetCode platform to test working.

/*
 * Input: [1,2,3,null,5,null,4]
 * Output: [1, 3, 4]
 * Explanation:
 * 
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
 */

/*
 * Time complexity : O(n)
 * Space complexity : O(n) Because breadth-first search visits the tree layer-by-layer, the queue will be at its 
 * largest immediately before visiting the largest layer. The size of this layer is 0.5n = O(n)0.5n=O(n) in the 
 * worst case (a complete binary tree).
 */

class TreeNode{
	TreeNode left;
	TreeNode right;
	int val;
	
	TreeNode(int val){
		this.val = val;
	}
}

public class RightSideViewOfBST {
	public static List<Integer> rightSideView(TreeNode root){
		List<Integer> result = new ArrayList<>();
        //edge case
        if(root == null)
            return result;
        
        //For right side view, we do level order traversal and the node at the end of the
        //queue will be visible on the right view. First add left node and then right nodes.
        Queue<TreeNode> queue = new LinkedList<>();
        
        //add root to the queue
        queue.add(root);
        
        while(!queue.isEmpty()){
            //get the size of the queue for level traversal
            int qSize = queue.size();
            
            for(int i = 0; i < qSize; i++){
                TreeNode tnode = queue.poll();
                //only add last node of the queue
                if(i == qSize - 1)
                    result.add(tnode.val);
                
                //add the left node first to the queue
                if(tnode.left != null)
                    queue.add(tnode.left);
                
                if(tnode.right != null)
                    queue.add(tnode.right);
            }
        }
        return result;
	}
}
