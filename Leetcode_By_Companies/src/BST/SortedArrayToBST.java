package BST;

/*
 * Time Complexity: O(N) since we still have to process each of the nodes in the linked list once and form 
 * corresponding BST nodes.
 * Space Complexity: O(logN) since now the only extra space is used by the recursion stack and since we are 
 * building a height balanced BST, the height is bounded by NlogN.
 */

/*
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two 
 * subtrees of every node never differ by more than 1.
 * 
 * Given the sorted linked list: [-10,-3,0,5,9],
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -10  5
     \   \
     -3   9
 
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

public class SortedArrayToBST {
	private int nodeValue;
    private int index = 0;
    
    public TreeNode sortedArrayToBST(int[] nums) {
        //edge case
        if(nums == null || nums.length == 0)
            return null;
        
        //at the head of the array.
        nodeValue = nums[index];
        
        return leafToRootBST(0, nums.length - 1, nums);
    }
    
    public TreeNode leafToRootBST(int start, int end, int[] nums){
        //recursion base condition end
        if(start > end)
            return null;
        
        //integer overflow avoid
        int mid = start + (end - start) / 2;
        
        //Inorder traversal + binary search
        
        /*
         * Since we are using In-order trversal => left, root, right.
         * The sorted array represents first element as the left most node. But programmatically the left most child
         * is 'null'. Using binary search along with inorder traversal, we first go to the
         * left most child, store that in a TreeNode object (we don't create one, we store what is already there). By
         * this approach, we then create a TreeNode object from the value that is being pointed by the 'nodeValue' in the
         * sorted array.
         * 
         * We now connect the 'left' treenode object we stored to the new treenode object we created.
         * Now increment the 'nodeValue' in the sorted linked list, as we only create a node after the left most leaf value
         * is discovered in the in-order traversal.
         * Now recurse for the right side with binary search technique. When you get the right side object, store it in
         * 'right' and then link it to the 'parent' treenode object we created.
         * 
         * If we look closely, the leaf node is also a 'root' node as its left and right child nodes are null.
         * Hence we only create the 'treenode' object once we come across the left most child.
         * After linking the right most child to the treenode created, return the treenode.
         * In this fashion, the treenode object we returned will act as a left or right child for the upcoming nodes
         * from the sorted array.
         * 
         * And we get our height balanced bst from leaf to root.
         */
        
        //left most child reach
        TreeNode left = leafToRootBST(start, mid - 1, nums);
        //create new treenode
        TreeNode tnode = new TreeNode(nodeValue);
        //link left most child for this treenode object
        tnode.left = left;
        //increase the node in the original array
        
        //important step, because we need to go till only nums.length - 1, i.e
        //the last index. So we need to have 'index < nums.length - 1'.
        //If we keep "index < nums.length" this will let our index to be increased to
        //"nums.length" when our index entered the 'if' loop on the state of "nums.length-1"
        //which will make us array out of bound exception.
        if(index < nums.length - 1){
            index++;
            nodeValue = nums[index];
        }
        //recurse right for the right most child of this treenode
        TreeNode right = leafToRootBST(mid + 1, end, nums);
        //link it to the treenode object
        tnode.right = right;
        
        return tnode;
    }
}
