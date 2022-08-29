package BST;

/*
 * Time complexity : O(N), where N is a number of nodes in the tree, since one visits each node exactly once.
 * Space complexity : O(log(N)) in the best case of completely balanced tree and O(N) in the worst case of 
 * completely unbalanced tree, to keep a recursion stack.
 */

/*
 * Given two binary trees, write a function to check if they are the same or not. Two binary trees are 
 * considered the same if they are structurally identical and the nodes have the same value.
 * 
 * Example 1:
 * 
 * Input:     1         1
 *           / \       / \
 *          2   3     2   3
 *          
 * [1,2,3],   [1,2,3]
 * Output: true
 * 
 * Example 2:
 * 
 * Input:     1         1
 *           /           \
 *          2             2
 *          
 * [1,2],     [1,null,2]
 * Output: false
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

public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        //leaf nodes are same
        if(p == null && q == null)
            return true;
        
        //Only one leaf node is same
        if(p == null || q == null)
            return false;
        
        if(p.val == q.val)
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        else
            return false;
    }
}
