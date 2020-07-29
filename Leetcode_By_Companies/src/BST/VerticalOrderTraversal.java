package BST;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/*
 * /*
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
 * Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom,
 * column by column).
 * 
 * If two nodes are in the same row and column, the order should be from left to right.
 * 
 * Examples 1:
 * Input: [3,9,20,null,null,15,7]
 *               
 *                  3
 *                 / \
 *                /   \
 *               9    20
 *                    /\
 *                   /  \
 *                  15   7 
 *                  
 * Output:[
 *         [9],
 *         [3,15],
 *         [20],
 *         [7]
 *        ]
 *        
 * Examples 2:
 * Input: [3,9,8,4,0,1,7]
 * 
 *              3
 *             /\
 *            /  \
 *            9   8
 *           /\  /\
 *          /  \/  \
 *          4  01   7 
 *          
 * Output:[
 *         [4],
 *         [9],
 *         [3,0,1],
 *         [8],
 *         [7]
 *        ]
 *        
 * Examples 3:
 * Input: [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5)
 * 
 *   
 *             3
 *            /\
 *           /  \
 *           9   8
 *           /\  /\
 *          /  \/  \
 *          4  01   7
 *             /\
 *            /  \
 *            5   2
 *            
 * Output:[
 *         [4],
 *         [9,5],
 *         [3,0,1],
 *         [8,2],
 *         [7]
 *        ]
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

//class QueuePack{
//    TreeNode tnode;
//    int horizontalDistance;
//    
//    QueuePack(int horizontalDistance, TreeNode tnode){
//        this.horizontalDistance = horizontalDistance;
//        this.tnode = tnode;
//    }
//}

public class VerticalOrderTraversal {

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        if(root == null)
            return result;
        
        TreeMap<Integer, List<Integer>> tmap = new TreeMap<>();
        Queue<QueuePack> queue = new LinkedList<>();
        
        queue.offer(new QueuePack(0, root));
        
        while(!queue.isEmpty()){
            QueuePack qPack = queue.poll();
            
            //extract the contents
            TreeNode tnode = qPack.tnode;
            int horizontalDistance = qPack.level;
            
            List<Integer> valueList = tmap.getOrDefault(horizontalDistance, new ArrayList<Integer>());
            valueList.add(tnode.val);
            tmap.put(horizontalDistance, valueList);
            
            if(tnode.left != null)
                queue.offer(new QueuePack(horizontalDistance - 1, tnode.left));
            
            if(tnode.right != null)
                queue.offer(new QueuePack(horizontalDistance + 1, tnode.right));
        }
        
        for(Map.Entry<Integer, List<Integer>> entry : tmap.entrySet())
            result.add(entry.getValue());
        
        return result;
    }
}
