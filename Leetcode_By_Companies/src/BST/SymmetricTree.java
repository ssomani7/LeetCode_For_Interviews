package BST;

/*
 * Time complexity : O(n). Because we traverse the entire input tree once, the total run time is O(n), where n
 * is the total number of nodes in the tree.
 * 
 * Space complexity : The number of recursive calls is bound by the height of the tree. In the worst case, the 
 * tree is linear and the height is in O(n). Therefore, space complexity due to recursive calls on the stack 
 * is O(n) in the worst case.
 */

/*
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * 
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 * 
 *                  1
 *                 / \
 *                2   2
 *               / \ / \
 *              3  4 4  3
 *              
 *              
 * But the following [1,2,2,null,3,null,3] is not:
 * 
 *                   1
 *                  / \
 *                 2   2
 *                  \   \
 *                  3    3
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

public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        //edge case
        if(root == null)
            return true;
        
        return helper(root.left, root.right);
    }
    
    public boolean helper(TreeNode leftRoot, TreeNode rightRoot){
        //recursion here
        if(leftRoot == null && rightRoot == null)
            return true;
        
        if(leftRoot == null || rightRoot == null)
            return false;
        
        if(leftRoot.val == rightRoot.val)
            return helper(leftRoot.left, rightRoot.right) && helper(leftRoot.right, rightRoot.left);
        else
            return false;
    }
}
