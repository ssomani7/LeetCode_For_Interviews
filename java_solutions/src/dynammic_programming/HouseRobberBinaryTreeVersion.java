package dynammic_programming;

/* Approach: DFS, 1st root to leaf for LEFT side, then coming up again with recursion, then root to leaf for right
 * then coming up again with recursion.
 * 
 * Time Complexity: 
 * Worst Case = the binary tree degenerates to a linked list, the depth 'd' is essentially the same as n. 
 * Therefore, T(d) will be the same as T(n) in the worst case.
 * 
 * Best Case =  for a balanced tree the scaling is indeed "polynomial" but not O(N^2) as I thought. I figured 
 * there was a 4 way branching so 4^log(N)->N^2. Empirically I find ~O(N^1.68157) for a perfectly balanced tree.
 * 
 * I imagine the ~1.68157 corresponds to 1+log2(φ) (φ=(1+sqrt(5))/2) because the scaling of T(d) is 
 * φ^d=φ^log2(N)=2^(log2(N)log2(φ))=N^log2(φ). As the definition of T(d) was the number of calls per node at 
 * depth d we still have to multiply by N (half the nodes are at the leaves) to obtain N^(1+log2(φ))=N^(1.694...)
 * which my empirical result would hopefully converge to if I let it run longer.
 * 
 * The thief has found himself a new place for his thievery again. There is only one entrance to this area, 
 * called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart 
 * thief realized that "all houses in this place forms a binary tree". It will automatically contact the police 
 * if two directly-linked houses were broken into on the same night.
 * Determine the maximum amount of money the thief can rob tonight without alerting the police.
 * 
 * Input: [3,4,5,1,3,null,1]
 *            3
 *           / \
 *          4   5
 *         / \   \ 
 *        1   3   1
 *        
 * Output: 9
 * Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
 *        
 *        Input: [3,2,3,null,3,null,1]
 *                  3
 *                 / \
 *                2   3
 *                 \   \ 
 *                  3   1
 *                  
 * Output: 7 
 * Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 */

//Definition of binary tree node
class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	
	TreeNode(int val){
		this.val = val;
	}
}

public class HouseRobberBinaryTreeVersion {
	
	public int rob(TreeNode root) {
		//edge case
		if(root == null)
			return 0;
		int[] result = robSub(root);
		return Math.max(result[0], result[1]);
	}
	
	public int[] robSub(TreeNode root) {
		/* 2 cases for int[2], 1) Root is not robbed, 2) Root is robbed.
		 * Each node will have a int[2], 1st element = node, i.e, root is not robbed, so we can take into account
		 * the child node's maximum elements from left and right array and sum it up. Store this in root's 1st place
		 * which will signify the amount of money when root is not roobed.
		 * For the 2nd scenario where root is robbed, we take the root's value along with the child's array's first
		 * element from both left and right, as they signify the child's not being robbed aggregate.
		 * 
		 * We are building this array from leaf to root. So for each bottom leaf's left and right array will be empty
		 * as they are pointing to null. So the bottom leaf node has to be robbed.
		 * 
		 * And in this fashion, the parent root of bottom left and right leaf will have an left and right array built
		 * for it to compute for NOT robbing itself and robbing itself scenario.
		 * 
		 * Finally when we reach to the top from the bottom, the result array at the root node, will have both the
		 * aggregate when root is NOT robbed and root is robbed.
		 * 
		 * Choose the max and return.
		 */
		
		//recursion edge case
		if(root == null)
			return new int[2];
		
		/*
		 *                       [9,8]
		 *                         3
		 *                        / \
		 *                 [4,4] 4   5 [1,5]
		 *                      / \   \
		 *                     1   3   1
		 *                 [0,1] [0,3] [0,1]
		 */
		
		//left and right arrays will be pointing to child node's left and right final values. From this we compute
		//root's final value which is result array. In this recursive fashion we build from bottom to top.
		int[] left = robSub(root.left);
		int[] right = robSub(root.right);
		int[] result = new int[2];
		
		//Root is NOT robbed
		result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
		//Root is robbed
		result[1] = root.val + left[0] + right[0];
		
		return result;
	}
}
