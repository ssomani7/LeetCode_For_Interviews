package BST;

/*
 * Time Complexity: O(N), where N is the number of nodes in the binary tree. In the worst case we might be 
 * visiting all the nodes of the binary tree.
 * 
 * Space Complexity: O(N). This is because the maximum amount of space utilized by the recursion stack would 
 * be N since the height of a skewed binary tree could be N.
 */

/*
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * 
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p
 * and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a 
 * descendant of itself).”
 * 
 * Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]
 *  
 *                                 3
 *                               /   \
 *                              5     1
 *                             / \   / \
 *                            6   2 0   8
 *                               / \
 *                              7   4
 * Example 1:
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 * 
 * Example 2:
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * Output: 5
 * 
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA
 * definition.
 * 
 * Note:
 * All of the nodes' values will be unique.
 * p and q are different and both values will exist in the binary tree.
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class LowestCommonAncestorBinaryTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;
        
        //if root is either of p or q, we return the root
        if(root == p || root == q)
            return root;
        
        //recurse left
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        //recurse right
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        //if we get not null values from both left and right recursion, means the p and q values are present
        //in the below part of the root. So we return the root as the common ancestor
        if(left != null && right != null)
            return root;
        
        //for the Leaf nodes which don't match, the left and right recursion returns null to the leaf
        //node.
        if(left == null && right == null)
            return null;
        
        //if we detect only one of the values among p or q on left or right node, we return that node to the 
        //root.
        return left != null ? left : right;
    }
    
}
