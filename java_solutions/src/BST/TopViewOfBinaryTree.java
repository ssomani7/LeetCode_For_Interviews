package BST;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

/*
 * Time Complexity = O(n), because in level order traversal we go through each and every node.
 * Space Complexity = O(n)
 */

/*
 * Approach : Level Order Traversal + Vertical Order Traversal.
 * Horizontal Distance (Hd) for each node at each level.
 * Algorithm for calculating Horizontal Distance.
 * Step 1: for root Hd = 0
 * Step 2: for left child, current Hd = current Hd - 1
 * Step 3: for right child, current Hd = current Hd + 1
 */

/*
 *                        a(0)
 *                      /   \
 *                 (-1)b      c(1) 
 *                   / \     / \
 *              (-2)d   e(0)f(0)g(2)
 *                 /       / \
 *           (-3) l   (-1)h   i (1)
 *                             \
 *                              j (2)
 *                               \
 *                                k (3)
 *  
 *  Level Order Traversal = abcdefglhijk
 *  Horizontal Distance Table
 *  -3  -2  -1  0  1  2  3
 *   l   d   b  a  c  g  k
 *           h  e  i  j
 *              f
 *              
 *  choose all the first nodes. Same logic to any data type, int or char.
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

// this class' represents the items stored in queue (used for level order
// traversal). Objects will store the nodes and its level
class QueuePack {
	int level;
	TreeNode tnode;

	public QueuePack(int level, TreeNode tnode) {
		this.level = level;
		this.tnode = tnode;
	}
}

public class TopViewOfBinaryTree {
	
	public static TreeMap<Integer, Integer> tmap = new TreeMap<>();
	
	public void topView(TreeNode root, int level) {
		if (root == null)
			return;
		
		// create a queue for level order traversal
		Queue<QueuePack> queue = new LinkedList<>();
		
		// add root with level 0 (create a queue item pack)
		queue.add(new QueuePack(level, root));
		
		while (!queue.isEmpty()) {
			QueuePack q = queue.remove();
			
			// take out the items from the package
			TreeNode tnode = q.tnode;
			int lvl = q.level;

			// check if this is the first node you are visiting at the level
			if (tmap.containsKey(lvl)) {
				//Since we are only interested in the first node per horizontal distance, we don't put the
				//second values for the key.
			} else {// print it, its the first element at his level
				System.out.print(tnode.val + "   ");
				tmap.put(lvl, tnode.val);
			}

			// add the left and right children of visiting nodes to the queue
			if (tnode.left != null) {
				queue.add(new QueuePack(lvl - 1, tnode.left));
			}
			if (tnode.right != null) {
				queue.add(new QueuePack(lvl + 1, tnode.right));
			}
		}

	}
	
}
