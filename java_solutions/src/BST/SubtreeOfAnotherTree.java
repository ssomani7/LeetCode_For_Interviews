package BST;

/*
 * Time complexity : O(m∗n). In worst case(skewed tree) traverse function takes O(m∗n) time.
 * Space complexity : O(n). The depth of the recursion tree can go upto nn. nn refers to the number of nodes in
 * s.
 */


/*
 * Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node 
 * values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's 
 * descendants. The tree s could also be considered as a subtree of itself.
 * 
 * Example 1:
 * Given tree s:
 * 
 *    3
 *   / \
 *  4   5
 * / \
 *1   2
 *
 *Given tree t:
 *
 *   4 
 *  / \
 * 1   2
 * 
 * Return true, because t has the same structure and node values with a subtree of s.
 * 
 * Example 2:
 * Given tree s:
 *
 *       3
 *      / \
 *     4   5
 *    / \
 *   1   2
 *      /
 *     0
 *     
 * Given tree t:
 * 
 *    4
 *   / \
 *  1   2
 *  
 * Return false.
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

public class SubtreeOfAnotherTree {

    //2 recursions
    public boolean isSubtree(TreeNode s, TreeNode t) {
        //edge case
        if(s == null)
            return false;
        
        if(isSame(s, t))
            return true;
        
        //We shift are root downwards in 's' and start searching again from scratch.
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    
    public boolean isSame(TreeNode s, TreeNode t){
        //leaf nodes for both the cases
        if(s == null && t == null)
            return true;
        //means only one tree reached end while other still has children in it
        if(s == null || t == null)
            return false;
        //Actual start of the recursion code from here.
        //If values are same, then we start going down the path from this root.
        if(s.val == t.val)
            return isSame(s.left, t.left) && isSame(s.right, t.right);
        else
            return false;
    }
}
