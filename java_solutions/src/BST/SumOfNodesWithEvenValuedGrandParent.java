package BST;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Time Complexity = O(N)
 * Space Complexity = O(height)
 */

/*
 * Given a binary tree, return the sum of values of nodes with even-valued grandparent.  (A grandparent of a 
 * node is the parent of its parent, if it exists.)
 * If there are no nodes with an even-valued grandparent, return 0.
 * 
 * Example 1:
 * 
 *                                 6
 *                               /   \
 *                              7      8
 *                             / \    / \
 *                            2   7  1   3
 *                           /   / \      \
 *                          9   1   4      5  
 *                                
 * Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
 * Output: 18
 * Explanation: The red nodes are the nodes with even-value grandparent while the blue nodes are the even-value
 * grandparents.
 * 
 * Constraints:
 * The number of nodes in the tree is between 1 and 10^4.
 * The value of nodes is between 1 and 100.
 */

/*
 * Intuition : Let children know who their grandparent is.
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

public class SumOfNodesWithEvenValuedGrandParent {

	//Recursive Solution. DFS
    public int sumEvenGrandparent(TreeNode root) {
        return helper(root, 1, 1); //assume parent and grandParent for root as 1. It won't affect sum in any way
    }
    
    public int helper(TreeNode node, int parent, int grandParent){
        if(node == null)
            return 0;
        
        //For every node we collect answer from its left subtree + right subtree + its own value if grandparent
        //is even.
        //Draw the diagram and start dry running the solution. Logic will hit you immediately.
        return helper(node.left, node.val, parent) + helper(node.right, node.val, parent) + 
        		     (grandParent % 2 == 0 ? node.val : 0);
    }
    
    //Iterative BFS Solution
    public int sumEvenGrandparentBFS(TreeNode root) {
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        //LevelOrderTraversal
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node.left != null) {
                queue.add(node.left);
                if(node.val % 2 == 0) {
                    if(node.left.left != null) {
                        sum += node.left.left.val;
                    }
                    if(node.left.right != null) {
                        sum += node.left.right.val;
                    }
                }
            }

            if(node.right != null) {
                queue.add(node.right);
                if(node.val % 2 == 0) {
                    if(node.right.left != null) {
                        sum += node.right.left.val;
                    }
                    if(node.right.right != null) {
                        sum += node.right.right.val;
                    }
                }
            }
        }
        
        return sum;
    }
}
