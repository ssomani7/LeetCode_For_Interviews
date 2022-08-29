package BST;

import java.util.ArrayList;
import java.util.List;

/*
 * Time Complexity : we visit each node exactly once, thus the time complexity is O(N), where N is the number 
 * of nodes.
 * 
 * Worst Case Time Complexity = O(NlogN)
 * Explanation = It is true that you need to visit every node atleast once, so that contributes O(n) to the 
 * total time complexity. But then at the same time when you reach the leaf, you need to generate the path and 
 * add it to the ans array, which will be O(logN) time in the case when tree has some leaves on both sides. 
 * And when the tree is somewhat balanced, you can take the number of leaves as half of the number of nodes 
 * in the tree, as an upper bound. So, that gives you O(n/2 + (n/2)logn) time which turns out to be O(nlogn).
 * 
 * Now consider the case where the tree is unbalanced. So, all nodes are on one side like a list. That will 
 * give you a height of O(n) but at the same time only one leaf will be present there. So it will give the 
 * time complexity as O(n-1 + n), which is O(n). So, the case which turns out to be the worst generally for 
 * most tree problems is not the worst case here.
 * 
 * By this we can conclude that as the number of leaves increase in the tree, the time complexity moves 
 * towards the worst side, as more paths will be generated. 
 * 
 * Space complexity : O(N). Here we use the space for a stack call and for a paths list to store the answer. 
 * Paths contains as many elements as leafs in the tree and hence couldn't be larger than logN for the trees
 * containing more than one element. Hence the space complexity is determined by a stack call. In the worst 
 * case, when the tree is completely unbalanced, e.g. each node has only one child node, the recursion call 
 * would occur N times (the height of the tree), therefore the storage to keep the call stack would be O(N). 
 * But in the best case (the tree is balanced), the height of the tree would be log(N). Therefore, the space 
 * complexity in this case would be O(log(N)).
 */

/*
 * Given a binary tree, return all root-to-leaf paths.
 * Note: A leaf is a node with no children.
 * 
 * Example:
 * Input:
 * 
 *        1
 *      /   \
 *     2     3
 *     \
 *      5
 *      
 * Output: ["1->2->5", "1->3"]
 * 
 * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
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

public class PrintAllRootToLeafPaths {

    List<String> resultList = new ArrayList<>();
    
    public List<String> binaryTreePaths(TreeNode root) {    
        //edge case
        if(root == null)
            return resultList;
        
        StringBuilder sb = new StringBuilder();
        helper(root, sb);
        
        return resultList;
    }
    
    public void helper(TreeNode root, StringBuilder sb){
        if(root == null)
            return;
        
        int len = sb.length(); //important step because of StringBuilder's mutability. We need to restore
        //the length of StringBuilder while coming back from recursion. Because StringBuilder is mutable the
        //state remains global through out, even after coming back from the recursion.
        
        //"StringBuilder" is a mutable object, it will hold its value after returning.Whereas String creates a 
        //copy in every recursion, so you don't need to worry about the "side-effect" when backtracking with String.
        
        sb.append(root.val);
        
        //leaf node, add to result
        if(root.left == null && root.right == null)
            resultList.add(sb.toString());
        else {
            sb.append("->");
            helper(root.left, sb);
            helper(root.right, sb);
        }
        
        sb.setLength(len); //restores the state of sb at that level once it comes back from the recursion.
    }
}
