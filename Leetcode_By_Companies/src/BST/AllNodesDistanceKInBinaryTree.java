package BST;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
 * N = number of nodes in Binary Tree
 * 
 * Time Complexity = O(N) in worst case. In worst case, the tree is skewed to either left or right side, and our
 * target node is at the leaf, so our "find" method to populate the hashmap will run on all the nodes of the
 * tree and inn other scenario, where "k" is large enough to make our "dfs" visit each and every node in the
 * binary tree.
 *  
 * Space Complexity = O(N) in worst case, the tree is skewed to either left or right side and the target node
 * is the leaf node, so the HashMap will have all the nodes in the path, i.e from root to target node.
 */

/*
 * We are given a binary tree (with root node root), a target node, and an integer value K.
 * Return a list of the values of all nodes that have a distance K from the target node.  The answer can be 
 * returned in any order.
 * 
 * Example: root = 10, target = 7, K = 2
 *            
 *                 10
 *               /    \
 *              5      14
 *            /  \    /  \
 *           4    7  12   15
 *               / \
 *              6   9
 *                 /
 *                8
 *                
 *  Output = [10, 4, 8]
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

public class AllNodesDistanceKInBinaryTree {

	//This map will contain the nodes that will fall in the path of root to target node. Where the node is the
    //key and the value is the distance of that node from target node.
    Map<TreeNode, Integer> hmap = new HashMap<>();
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> resultList = new LinkedList<>();
        find(root, target);
        dfs(root, target, K, resultList, hmap.get(root));
        return resultList;
    }
    
    public int find(TreeNode root, TreeNode target){
        //recursion exit condition
        if(root == null)
            return -1;
        
        if(root == target){
            hmap.put(root, 0);
            return 0;
        }
        
        //One important thing to understand here is that, only 1 'if' block will be executed, that is either left or
        //right. Because our hashmap is storing the nodes that come in the path from root to leaf. So the nodes will
        //either lie on the left side or right side at each level.
        //Hence only 1 'if' block will be executed
        
        int left = find(root.left, target);
        
        if(left >= 0){
            hmap.put(root, left + 1);
            return left + 1; //left + 1, because the value is returned by the left child, & we need to take into
            //account the edge between the root & it's left child, so left + 1.
        }
        
        int right = find(root.right, target);
        
        if(right >= 0){
            hmap.put(root, right + 1);
            return right + 1; //same explanation as for the left child return value.
        }
        
        return -1; //Since we are recursing, we will go down the trees at nodes which don't lie in the path from
        //root to target, so, we return -1, to indicate the exclusion of those nodes.
    }
    
    
    //What we mean by 'k' exactly in this problem statement is, collect all nodes that are 'k' levels away from the
    //target node.
    
    //Levels are decided by the edges from the target node. Think from a BFS (Breadth First Search Approach) for
    //levels. Our method implements DFS (Depth First Search) to go down the tree and collect the nodes, but the 
    //principle behind the parameter "level" that is being passed in the dfs call is based on BFS.
    
    //Imagine you are at "target" node, now there can be maximum of 3 nodes at level 1, which are its left child,
    //right child, and its parent. Try to visualize the tree as a graph (A binary tree is basically a DAG (directed
    //Acyclic graph)
    
    //We are starting our DFS from root. For our root, we will give it the level that it is from the target node
    //which we obtain from hashmap. Our root is guranteed to be in HashMap, because our hashmap contains the nodes
    //that lie in the path of root to target node.
    
    //For root node the level will be same from the hashmap and the level that is being passed as parameter.
    //We check if the level is equal to 'k'. If so we add the root node to result.
    
    //Now we go deep into tree, so by DFS logic, the level is increased, i.e, '+1' for left and right child.
    //But as we mentioned before, we need to check for nodes in 3 directions, that is left child, right child and the
    //parent, we need to update the length for the particular node from the hashmap and the "level" parameter passed
    //to it in the DFS call.
    
    //For clear explanation, look at the input we have. Assume the target node is "7" & "k" = 2. So our hashmap will 
    //have nodes from root to path, that is 10, 5, 7. And each of this indicate how far they are from target. 
    //So, 10 -> 2, 5 -> 1, 7 -> 0.
    //But our actual answer will have nodes, 10, 4, and 8. But node 4 and 8 are not available in the hashmap. To get
    //these nodes we will be using the "level" parameter, which indicates the current node's distance from the target
    
    //Since we are doing a DFS, left and right child will have level + 1. So if the node is not in our hashmap, we
    //will utilize this "level" parameter from the DFS call and check if the level == k. If the node is in hashmap,
    //then we will directly compare it value with k.
    
    //So, in this manner, the "level" needs to be updated at every DFS call. It's very easy, if you just dry run the
    //code on paper once, following the above instructions.
    public void dfs(TreeNode root, TreeNode target, int K, List<Integer> resultList, int level){
        //recursion end condition
        if(root == null)
            return;
        
        if(hmap.containsKey(root))
            level = hmap.get(root);
        
        if(level == K)
            resultList.add(root.val);
        
        dfs(root.left, target, K, resultList, level + 1);
        dfs(root.right, target, K, resultList, level + 1);
    }
}
