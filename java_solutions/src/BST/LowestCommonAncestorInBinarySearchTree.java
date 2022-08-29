package BST;

/*
 * Time Complexity = O(H), H represents height of the binary search tree.
 * Space Complexity = O(H). Worst case O(N). This is because the maximum amount of space utilized by the 
 * recursion stack would be N since the height of a skewed BST could be N. 
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

public class LowestCommonAncestorInBinarySearchTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) 
        	return null;
        
        if (root.val > p.val && root.val > q.val) //search on left side of root
          return lowestCommonAncestor(root.left, p, q);
        else if (root.val < p.val && root.val < q.val) //search on right side of root
          return lowestCommonAncestor(root.right, p, q);
        else 
          return root;
    
    }
}
