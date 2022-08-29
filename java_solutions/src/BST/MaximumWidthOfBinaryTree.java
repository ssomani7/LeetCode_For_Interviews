package BST;

import java.util.HashMap;
import java.util.Map;

/* Let N be the total number of nodes in the input tree.
 * 
 * Time Complexity = O(N). We visit each node once and only once in DFS traversal. 
 * And each visit takes a constant time to process as well.
 * 
 * Space Complexity: O(N). We used an additional table to keep the index for the first element per level. 
 * In the worst case where the tree is extremely skewed, there could be as many levels as the number of nodes. 
 * As a result, the space complexity of the table would be O(N).
 * 
 * Since we implement DFS traversal with recursion which would incur some additional memory consumption in the 
 * function call stack, we need to take this into account for the space complexity.
 * 
 * The consumption of function stack is proportional to the depth of recursion. Again, in the same worst case 
 * above, where the tree is extremely skewed, the depth of the recursion would be equal to the number of nodes 
 * in the tree. Therefore, the space complexity of the function stack would be O(N).
 * 
 * To sum up, the overall space complexity of the algorithm is O(N) + O(N) = O(N).
 */

/*
 * Given a binary tree, write a function to get the maximum width of the given tree. The width of a tree is the
 * maximum width among all levels. The binary tree has the same structure as a full binary tree, but some nodes
 * are null.
 * 
 * The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null
 * nodes in the level, where the null nodes between the end-nodes are also counted into the length calculation.
 * 
 * Example 1:
 * Input: 
 *         1
 *       /   \
 *      3     2
 *     / \     \  
 *    5   3     9 
 *    
 * Output: 4
 * Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
 * 
 * Example 2:
 * Input: 
 *        1
 *       /  
 *      3    
 *     / \       
 *    5   3     
 *    
 * Output: 2
 * Explanation: The maximum width existing in the third level with the length 2 (5,3).
 * 
 * Example 3:
 * Input: 
 *        1
 *       / \
 *      3   2 
 *     /        
 *    5      
 *    
 * Output: 2
 * Explanation: The maximum width existing in the second level with the length 2 (3,2).
 * 
 * Example 4:
 * Input: 
 *        1
 *       / \
 *      3   2
 *     /     \  
 *    5       9 
 *   /         \
 *  6           7
 *  
 * Output: 8
 * Explanation:The maximum width existing in the fourth level with the length 8 (6,null,null,null,null,null,null,7).
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

/*
 * Property of Binary Tree:
 * left child's index (position) is calculated as  = 2 x root's Index
 * right child's index (position) is calculated as = (2 x root's Index) + 1
 * 
 * Appraoch:
 * Imagine each level of the binary tree is an array. We need to calculate the difference between the
 * leftmost non-null node of this array and the rightmost non-null node of this array. That is basically
 * subtracting the rightmost non-null node's array index from leftmost non-null node's array index + 1.
 * +1 is for length calculation because array index starting from zero.
 * 
 * We will keep a hashmap, which will have the levels of binary tree as the key and the leftmost non-null
 * node array index as its value.
 * We then take the difference of each non-null node array index at a particular level with the leftmost
 * non-null array index at that level and update our max width.
 * 
 * Since we are using dfs, we will visit each node only once. Leftmost non-null nodes with root.left and
 * the rest non-null nodes with root.right
 */

public class MaximumWidthOfBinaryTree {

	int maxWidth = 0;
	Map<Integer, Integer> leftmostNonNullNodeIndexPerLevelMap = new HashMap<>();
	
    public int widthOfBinaryTree(TreeNode root) {
    	//edge case
    	if(root == null)
    		return maxWidth;
    	
    	dfs(root, 0, 0);
    	
    	return maxWidth;
    }
	
    
    //Assuming root's level to be zero
    public void dfs(TreeNode root, int level, int currentRootIndex) {
    	if(root == null)
    		return;
    	
    	if(!leftmostNonNullNodeIndexPerLevelMap.containsKey(level))
    		leftmostNonNullNodeIndexPerLevelMap.put(level, currentRootIndex);
    	
    	int leftMostIndexAtThatLevel = leftmostNonNullNodeIndexPerLevelMap.get(level);
    	
    	maxWidth = Math.max(maxWidth, currentRootIndex - leftMostIndexAtThatLevel + 1);
    	
        //important step is to recurse left first. This is because our hashmap will only store the
        //left most index at each level.
    	dfs(root.left, level + 1, 2 * currentRootIndex);
    	dfs(root.right, level + 1, 2 * currentRootIndex + 1);
    }
}
