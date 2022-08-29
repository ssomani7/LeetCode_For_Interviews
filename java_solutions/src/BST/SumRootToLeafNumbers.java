package BST;

/*
 * Time complexity: O(N) since one has to visit each node.
 * Space complexity: O(H) to keep the recursion stack, where H is a tree height.
 */

/*
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * Find the total sum of all root-to-leaf numbers.
 * Note: A leaf is a node with no children.
 * 
 * Example:
 * Input: [1,2,3]
 * 
 *     1
 *    / \
 *   2   3
 * Output: 25
 * 
 * Explanation:
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Therefore, sum = 12 + 13 = 25.
 * 
 * Example 2:
 * Input: [4,9,0,5,1]
 * 
 *          4
 *         / \
 *        9   0
 *       / \
 *      5   1
 *      
 * Output: 1026
 * 
 * Explanation:
 * The root-to-leaf path 4->9->5 represents the number 495.
 * The root-to-leaf path 4->9->1 represents the number 491.
 * The root-to-leaf path 4->0 represents the number 40.
 * Therefore, sum = 495 + 491 + 40 = 1026.
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

public class SumRootToLeafNumbers {

    int sum = 0;
    
    public int sumNumbers(TreeNode root) {
        //edge case
        if(root == null)
            return sum;
        
        helper(root, 0);
        
        return sum;
    }
    
    public void helper(TreeNode tnode, int num){
        if(tnode == null)
            return;
        
        num = num * 10 + tnode.val;
        
        //check if we are at the leaf node
        if(tnode.left == null && tnode.right == null){
            sum += num;
            return;
        }
        
        helper(tnode.left, num);
        helper(tnode.right, num);
    }
}
