package leetcode_hard_questions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Time complexity : in both serialization and deserialization functions, we visit each node exactly once, 
 * thus the time complexity is O(N), where N is the number of nodes, i.e. the size of tree.
 * 
 * Space complexity : in both serialization and deserialization functions, we keep the entire tree, either at 
 * the beginning or at the end, therefore, the space complexity is O(N).
 */

/*
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it 
 * can be stored in a file or memory buffer, or transmitted across a network connection link to be 
 * reconstructed later in the same or another computer environment.
 * 
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your 
 * serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be 
 * serialized to a string and this string can be deserialized to the original tree structure.
 * 
 * Example: 
 * You may serialize the following tree:
 *          1
 *         / \
 *        2   3
 *           / \
 *          4   5
 *          
 * as "[1,2,3,null,null,4,5]"
 * 
 * Clarification: The above format is the same as how LeetCode serializes a binary tree. You do not necessarily
 * need to follow this format, so please be creative and come up with different approaches yourself.
 * 
 * Note: Do not use class member/global/static variables to store states. Your serialize and deserialize 
 * algorithms should be stateless.
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

public class SerializeAndDeserializeBinaryTree {

    // Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		return serial(new StringBuilder(), root).toString();
	}
	
    //Generate PreOrder String
    public StringBuilder serial(StringBuilder sb, TreeNode root){
        if(root == null)
            return sb.append("$"); //'$' marks null
        
        //left recursive call. After returning from left recursive call need to append "," as we will go to
        //right node
        sb.append(root.val).append(",");
        serial(sb, root.left).append(",");
        serial(sb, root.right); //no need to append after right call because it is the last node we visit
        
        return sb;
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return deserial(new LinkedList<>(Arrays.asList(data.split(","))));
    }
    
    
    public TreeNode deserial(Queue<String> queue){
        String val = queue.poll();
        
        if(val.equals("$"))
            return null;
        
        TreeNode tnode = new TreeNode(Integer.parseInt(val));
        tnode.left = deserial(queue);
        tnode.right = deserial(queue);
        
        return tnode;
    }
}
