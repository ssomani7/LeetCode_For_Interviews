package BST;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Time Complexity: O(N), where N is the number of nodes in the binary tree. In the worst case, we might have 
 * to visit all the nodes of the binary tree. Similar to approach 1 this approach would also have a complexity 
 * of O(N) when the Node x and Node y are present at the last level of the binary tree. The algorithm would 
 * follow the standard BFS approach and end up in checking each node before discovering the desired nodes.
 * 
 * Space Complexity: O(N). In the worst case, we need to store all the nodes of the last level in the queue. 
 * The last level of a binary tree can have a maximum of N/2 nodes. Not to forget we would also need space for
 * N/4 null markers, one for each pair of siblings. That results in a space complexity of O(3N/4) = O(N) 
 * (You are right Big-O notation doesn't care about constants).
 */

/*
 * In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
 * Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
 * We are given the root of a binary tree with unique values, and the values x and y of two different nodes in 
 * the tree.
 * Return true if and only if the nodes corresponding to the values x and y are cousins.
 * 
 * Example 1:
 *            1
 *           / \
 *          2   3
 *         /
 *        4
 * Input: root = [1,2,3,4], x = 4, y = 3
 * Output: false
 * 
 * Example 2:
 *             1
 *            / \
 *           2   3
 *            \   \
 *             4   5
 * 
 * Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
 * Output: true
 * 
 * Example 3:
 *              1
 *             / \
 *            2   3
 *             \
 *              4
 * Input: root = [1,2,3,null,4], x = 2, y = 3
 * Output: false
 * 
 * Constraints:
 * The number of nodes in the tree will be between 2 and 100.
 * Each node has a unique integer value from 1 to 100.
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

public class CousinsInBinaryTree {

    public boolean isCousins(TreeNode root, int x, int y) {
        //edge case
        if(root == null)
            return false;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        boolean foundX = false;
        boolean foundY = false;
        
        while(!queue.isEmpty()){
            int qSize = queue.size();
            
            for(int i = 0; i < qSize; i++){
                TreeNode node = queue.poll();
                
                if(node.val == x)
                    foundX = true;
                
                if(node.val == y)
                    foundY = true;
                
                //checking for same parent
                if(node.left != null && node.right != null)
                    if((node.left.val == x && node.right.val == y) ||
                      (node.left.val == y && node.right.val == x))
                        return false;
                
                if(node.left != null){
                    queue.offer(node.left);
                }
                
                if(node.right != null)
                    queue.offer(node.right);
            }
            
            //both are found
            if(foundX && foundY)
                return true;
            else if(foundX || foundY)
                return false; //as only one was found
        }
        
        return false;
    }
}
